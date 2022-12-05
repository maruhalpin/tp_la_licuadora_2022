package utn.credicoop.msproductobase.app;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msproductobase.app.dtos.ProductoBaseDTO;
import utn.credicoop.msproductobase.db.ProductoBaseJPA;
import utn.credicoop.msproductobase.entities.PosiblePersonalizacion;
import utn.credicoop.msproductobase.entities.ProductoBase;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ProductoBaseController {

    @Value("${server.port}")
    private String puerto;

    @Autowired
    ProductoBaseJPA productoBaseJPA;

    @Operation(summary = "Genera un producto base")
    @Transactional
    @PostMapping("/productobase/agregar")
    public @ResponseBody ResponseEntity<String> agregarProductoBase(@RequestBody ProductoBaseDTO productoBaseDTO){
        if(!productoBaseJPA.existsById(productoBaseDTO.getId())){
            ProductoBase producto = new ProductoBase(productoBaseDTO);
            productoBaseJPA.save(producto);
            return new ResponseEntity<>("Agregado el producto: " + productoBaseDTO.getNombre() + " - (Puerto: " + puerto + ").", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID Duplicado", HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Busca y devuelve un producto base")
    @GetMapping("/productobase/{idProdBase}/buscar")
    public ProductoBaseDTO buscarPorId(@PathVariable("idProdBase") Long id){
        Optional<ProductoBase> productoBase = productoBaseJPA.findById(id);
        ProductoBaseDTO productoBaseDTO = new ProductoBaseDTO(productoBase);
        return productoBaseDTO;
    }

    @Operation(summary = "Corrobora si el producto base existe")
    @GetMapping("/productobase/{idProdBase}/existe")
    public boolean existeProductoBase(@PathVariable("idProdBase") Long id){
        return productoBaseJPA.existsById(id);
    }
}
