package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.VendedorDTO;
import utn.credicoop.msventas.db.CompraJPA;
import utn.credicoop.msventas.db.VendedorJPA;
import utn.credicoop.msventas.entities.Compra;
import utn.credicoop.msventas.entities.Tienda;
import utn.credicoop.msventas.entities.Vendedor;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
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

}
