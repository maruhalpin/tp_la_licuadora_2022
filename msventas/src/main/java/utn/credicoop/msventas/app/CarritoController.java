package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.CarritoDeCompraDTO;
import utn.credicoop.msventas.app.dtos.CompraDTO;
import utn.credicoop.msventas.app.dtos.PublicacionDTO;
import utn.credicoop.msventas.app.dtos.VendedorDTO;
import utn.credicoop.msventas.db.CarritoDeCompraJPA;
import utn.credicoop.msventas.db.CompradorJPA;
import utn.credicoop.msventas.entities.CarritoDeCompra;
import utn.credicoop.msventas.entities.Comprador;
import utn.credicoop.msventas.entities.Publicacion;
import utn.credicoop.msventas.entities.Vendedor;

import javax.transaction.Transactional;

@RestController
public class CarritoController {

    @Autowired
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Transactional
    @PostMapping("/carrito/generar")
    public @ResponseBody ResponseEntity<String> generarCarrito(@RequestBody CarritoDeCompraDTO carritoDeCompraDTO){
        CarritoDeCompra carritoDeCompra = new CarritoDeCompra(carritoDeCompraDTO);
        carritoDeCompraJPA.save(carritoDeCompra);
        return new ResponseEntity<>("Se generó el carrito de compra.", HttpStatus.OK);
    }

}
