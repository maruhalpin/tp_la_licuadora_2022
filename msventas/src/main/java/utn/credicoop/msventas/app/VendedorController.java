package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utn.credicoop.msventas.app.dtos.VendedorDTO;
import utn.credicoop.msventas.db.VendedorJPA;
import utn.credicoop.msventas.entities.Tienda;
import utn.credicoop.msventas.entities.Vendedor;

import javax.transaction.Transactional;

@RestController
public class VendedorController {

    @Autowired
    VendedorJPA vendedorJPA;

    @Transactional
    @PostMapping("/vendedor/generar")
    public @ResponseBody ResponseEntity<String> generarVendedor(@RequestBody VendedorDTO vendedorDTO){
        Vendedor vendedor = new Vendedor(vendedorDTO);
        vendedorJPA.save(vendedor);
        return new ResponseEntity<>("Vendedor/a " + vendedor.getNombre() + " " + vendedor.getApellido() + " - ID: " + vendedor.getId() + " dado de alta.", HttpStatus.OK);

    }
}
