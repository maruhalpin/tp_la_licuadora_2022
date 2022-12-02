package utn.credicoop.msproductobase.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msproductobase.app.dtos.ProductoBaseDTO;
import utn.credicoop.msproductobase.db.ProductoBaseJPA;
import utn.credicoop.msproductobase.entities.ProductoBase;

import javax.transaction.Transactional;
import java.util.Optional;

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
            return new ResponseEntity<>("ID Duplicado", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/productobase/proxy/{idProdBase}")
    public ProductoBaseDTO buscarPorId(@PathVariable("idProdBase") Long id){
        Optional<ProductoBase> productoBase = productoBaseJPA.findById(id);
        ProductoBaseDTO productoBaseDTO = new ProductoBaseDTO(productoBase);
        return productoBaseDTO;
    }


}
