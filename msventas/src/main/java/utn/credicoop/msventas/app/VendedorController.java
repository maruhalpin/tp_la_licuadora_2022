package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.FacturaDTO;
import utn.credicoop.msventas.app.dtos.VendedorDTO;
import utn.credicoop.msventas.db.CompraJPA;
import utn.credicoop.msventas.db.VendedorJPA;
import utn.credicoop.msventas.entities.Compra;
import utn.credicoop.msventas.entities.EstadoCompra;
import utn.credicoop.msventas.entities.Tienda;
import utn.credicoop.msventas.entities.Vendedor;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VendedorController {

    @Resource
    VendedorJPA vendedorJPA;

    @Resource
    CompraJPA compraJPA;

    @Transactional
    @PostMapping("/vendedor/generar")
    public @ResponseBody ResponseEntity<String> generarVendedor(@RequestBody VendedorDTO vendedorDTO){
        Vendedor vendedor = new Vendedor(vendedorDTO);
        vendedorJPA.save(vendedor);
        return new ResponseEntity<>("Vendedor/a " + vendedor.getNombre() + " " + vendedor.getApellido() + " - ID: " + vendedor.getId() + " dado de alta.", HttpStatus.OK);
    }

    @GetMapping("/vendedor/{idVendedor}/vercompras")
    public @ResponseBody ResponseEntity<String> verComprasAVendedor(@PathVariable("idVendedor") Long id){
        if(vendedorJPA.existsById(id)){
            List<Compra> compras = compraJPA.findAll();
            List<Compra> comprasAlVendedor = compras.stream().filter(e -> e.getVendedor().getId().equals(id)).collect(Collectors.toList());
            return new ResponseEntity<>(comprasAlVendedor.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo realizar la operación de compra, el vendedor no acepta ese medio de pago.", HttpStatus.OK);
        }
    }

    @PostMapping("/vendedor/compra/{idCompra}/generarfactura")
    public @ResponseBody FacturaDTO generarFactura(@PathVariable("idCompra") Long id) throws Exception {
        if(compraJPA.existsById(id)){
            Optional<Compra> compraOptional = compraJPA.findById(id);
            Compra compra = new Compra(compraOptional);
            compra.generarFactura();
            compraJPA.save(compra);
            FacturaDTO facturaDTO = new FacturaDTO(compraOptional.get().getCarritoDeCompra().getPrecioFinal(), compraOptional.get().getCarritoDeCompra(), compraOptional.get().getFormaDePago(), compraOptional.get().getCarritoDeCompra().getComprador());
            return facturaDTO;
        } else {
            throw new Exception("No existe el id compra (" + id + ") para generar factura.");
        }
    }

}
