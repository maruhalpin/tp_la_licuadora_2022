package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.CarritoDeCompraDTO;
import utn.credicoop.msventas.app.dtos.ItemDTO;
import utn.credicoop.msventas.app.dtos.PublicacionDTO;
import utn.credicoop.msventas.db.CarritoDeCompraJPA;
import utn.credicoop.msventas.db.ItemJPA;
import utn.credicoop.msventas.db.PublicacionJPA;
import utn.credicoop.msventas.entities.CarritoDeCompra;
import utn.credicoop.msventas.entities.Item;
import utn.credicoop.msventas.entities.Publicacion;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ItemController {

    @Resource
    ItemJPA itemJPA;

    @Resource
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Resource
    PublicacionJPA publicacionJPA;

    @Transactional
    @PostMapping("/item/agregaracarrito/{idCarrito}/publicacion/{idPublicacion}")
    public @ResponseBody ResponseEntity<String> agregarACarrito(@RequestBody ItemDTO itemDTO,
                @PathVariable("idCarrito") Long idCarrito, @PathVariable("idPublicacion") Long idPublicacion){
        if(carritoDeCompraJPA.existsById(idCarrito)){
            if(publicacionJPA.existsById(idPublicacion)){
                Optional<Publicacion> optionalPublicacion = publicacionJPA.findById(idPublicacion);
                if(optionalPublicacion.get().sePuedeComprar()){
                    Item item = new Item(itemDTO);

                    Publicacion publicacion = new Publicacion(optionalPublicacion);

                    item.setPublicacion(publicacion);

                    Optional<CarritoDeCompra> optionalCarritoDeCompra = carritoDeCompraJPA.findById(idCarrito);
                    CarritoDeCompra carritoDeCompra = new CarritoDeCompra(optionalCarritoDeCompra);

                    item.calcularPrecioFinal(optionalPublicacion.get().getPrecio());
                    itemJPA.save(item);

                    carritoDeCompra.agregarItem(item);

                    carritoDeCompraJPA.save(carritoDeCompra);
                    return new ResponseEntity<>("Se agregó el item al carrito de " + carritoDeCompra.getComprador().getNombre() + " " + carritoDeCompra.getComprador().getApellido() + ".", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("La publicación no se encuentra activa - (Estado actual: " + optionalPublicacion.get().getEstadoPublicacion() + ").", HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("No se pudo cargar el item, publicación inexistente.", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No se pudo cargar el item, carrito inexistente.", HttpStatus.CONFLICT);
        }

    }
}
