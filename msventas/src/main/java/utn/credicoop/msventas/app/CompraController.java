package utn.credicoop.msventas.app;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.db.*;
import utn.credicoop.msventas.entities.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import java.util.Optional;

@RestController
public class CompraController {

    @Resource
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Resource
    VendedorJPA vendedorJPA;

    @Resource
    CompraJPA compraJPA;

    @Resource
    MedioDePagoJPA medioDePagoJPA;

    @Resource
    TiendaJPA tiendaJPA;

    @Operation(summary = "El cliente va a comprar todos los items que se encuentren en el carrito")
    @Transactional
    @PostMapping("/carrito/{idCarrito}/mediodepago/{idMedioPago}/comprar")
    public @ResponseBody ResponseEntity<String> comprarCarrito(@PathVariable("idCarrito") Long idCarrito, @PathVariable("idMedioPago") Long idMedioPago){
        if(carritoDeCompraJPA.existsById(idCarrito)){
            if(medioDePagoJPA.existsById(idMedioPago)){
                Optional<MedioDePago> medioDePagoOptional = medioDePagoJPA.findById(idMedioPago);
                Optional<CarritoDeCompra> carritoDeCompraOptional = carritoDeCompraJPA.findById(idCarrito);
                Optional<Tienda> tiendaOptional = tiendaJPA.findById(carritoDeCompraOptional.get().getItems().get(0).getPublicacion().getIdTiendaAsociada());
                Optional<Vendedor> vendedorOptional = vendedorJPA.findById(tiendaOptional.get().getIdVendedor());

                if(vendedorOptional.get().getMediosDePago().contains(medioDePagoOptional.get())){
                    Compra compra = new Compra(carritoDeCompraOptional.get(), medioDePagoOptional.get(), vendedorOptional.get());
                    compraJPA.save(compra);
                    return new ResponseEntity<>("La compra fue realizada con éxito - [Monto: " + carritoDeCompraOptional.get().getPrecioFinal() +
                            " - Método de pago: " + medioDePagoOptional.get().getNombre() + "].", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("No se pudo realizar la operación de compra, el vendedor no acepta ese medio de pago.", HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("No se pudo realizar la operación de compra, no existe el medio de pago.", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No se pudo realizar la operación de compra, el carrito es inexistente.", HttpStatus.CONFLICT);
        }
    }

}
