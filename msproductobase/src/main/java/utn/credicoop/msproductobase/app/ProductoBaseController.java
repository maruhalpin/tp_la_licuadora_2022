package utn.credicoop.msproductobase.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msproductobase.db.ProductoBaseJPA;
import utn.credicoop.msproductobase.entities.ProductoBase;

import javax.transaction.Transactional;

@RestController
public class ProductoBaseController {

    @Value("${server.port}")
    private String puerto;

    @Autowired
    ProductoBaseJPA productoBaseJPA;

    @Transactional
    @PostMapping("/productobase/agregar")
    public @ResponseBody ResponseEntity<String> agregarProductoBase(@RequestBody ProductoBaseDTO productoBaseDTO){
        if(!productoBaseJPA.existsById(productoBaseDTO.getId())){
            ProductoBase producto = new ProductoBase(productoBaseDTO);
            productoBaseJPA.save(producto);
            return new ResponseEntity<>("Agregado el producto: " + productoBaseDTO.getNombre(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID DUPLICADO", HttpStatus.CONFLICT);
        }
    }
/*
    @GetMapping("/productobase/{productoId}")
    public String buscarProductoBasePorId(@PathVariable("productoId") String productoId) {


        return "Ok " + puerto;

    }*/

}
