package utn.credicoop.msproductopersonalizado.app;

import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msproductopersonalizado.app.dtos.PosiblePersonalizacionDTO;
import utn.credicoop.msproductopersonalizado.app.dtos.ProductoBaseDTO;
import utn.credicoop.msproductopersonalizado.app.dtos.ProductoPersonalizadoDTO;
import utn.credicoop.msproductopersonalizado.db.ProductoPersonalizadoJPA;
import utn.credicoop.msproductopersonalizado.entities.ProductoPersonalizado;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProductoPersonalizadoController {

    @Autowired
    ProductoBaseProxy proxy;

    @Resource
    ProductoPersonalizadoJPA productoPersonalizadoJPA;

    @Operation(summary = "Genera un producto personalizado")
    @Transactional
    @PostMapping("/productopersonalizado/agregar")
    public @ResponseBody ResponseEntity<String> crearProductoPersonalizado(@RequestBody ProductoPersonalizadoDTO productoPersonalizadoDTO){
        if(!productoPersonalizadoJPA.existsById(productoPersonalizadoDTO.getId())){
            boolean existeProductoBase = proxy.existeProductoBase(productoPersonalizadoDTO.getIdProductoBase());
            if(existeProductoBase) {
                ProductoBaseDTO productoBaseAsociado = proxy.buscarPorId(productoPersonalizadoDTO.getIdProductoBase());
                boolean sePuedePersonalizar = productoPersonalizadoDTO.getPersonalizaciones().stream().allMatch(e -> proxy.existePosiblePersonalizacion(e.getIdPosiblePersonalizacion()));
                if(sePuedePersonalizar){
                    ProductoPersonalizado producto = new ProductoPersonalizado(productoPersonalizadoDTO);
                    producto.calcularPrecioFinal(productoBaseAsociado.getPrecioBase());
                    productoPersonalizadoJPA.save(producto);
                    return new ResponseEntity<>("Agregado el producto personalizado - (ID: " + productoPersonalizadoDTO.getId() + ").", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("La personalización (ID: " + productoPersonalizadoDTO.getId() + ") no es posible." , HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("El producto base a asociar no existe." , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("ID Duplicado.", HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Busca y devuelve un producto personalizado")
    @GetMapping("/productoPersonalizado/{idProdPers}/buscar")
    public ProductoPersonalizadoDTO buscarPorId(@PathVariable("idProdPers") Long id){
        Optional<ProductoPersonalizado> productoPersonalizado = productoPersonalizadoJPA.findById(id);
        ProductoPersonalizadoDTO productoPersonalizadoDTO = new ProductoPersonalizadoDTO(productoPersonalizado);
        return productoPersonalizadoDTO;
    }

    @Operation(summary = "Corrobora si existe un producto personalizado")
    @GetMapping("/productoPersonalizado/{idProdPers}/existe")
    public boolean existeProductoPersonalizado(@PathVariable("idProdPers") Long id){
        return productoPersonalizadoJPA.existsById(id);
    }

}




