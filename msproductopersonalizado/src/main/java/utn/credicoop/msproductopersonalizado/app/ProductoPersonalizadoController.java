package utn.credicoop.msproductopersonalizado.app;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msproductopersonalizado.app.dtos.ProductoBaseDTO;
import utn.credicoop.msproductopersonalizado.app.dtos.ProductoPersonalizadoDTO;
import utn.credicoop.msproductopersonalizado.db.ProductoPersonalizadoJPA;
import utn.credicoop.msproductopersonalizado.entities.ProductoPersonalizado;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ProductoPersonalizadoController {

    @Autowired
    ProductoBaseProxy proxy;

    @Resource
    ProductoPersonalizadoJPA productoPersonalizadoJPA;

    @Transactional
    @PostMapping("/productopersonalizado/agregar")
    public @ResponseBody ResponseEntity<String> crearProductoPersonalizado(@RequestBody ProductoPersonalizadoDTO productoPersonalizadoDTO){
        if(!productoPersonalizadoJPA.existsById(productoPersonalizadoDTO.getId())){
            boolean existeProductoBase = proxy.existeProductoBase(productoPersonalizadoDTO.getIdProductoBase());
            if(existeProductoBase) {
                ProductoBaseDTO productoBaseAsociado = proxy.buscarPorId(productoPersonalizadoDTO.getIdProductoBase());

                ProductoPersonalizado producto = new ProductoPersonalizado(productoPersonalizadoDTO);
                producto.calcularPrecioFinal(productoBaseAsociado.getPrecioBase());
                productoPersonalizadoJPA.save(producto);
                return new ResponseEntity<>("Agregado el producto personalizado.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El producto base a asociar no existe." , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("ID Duplicado.", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/productoPersonalizado/{idProdPers}/buscar")
    public ProductoPersonalizadoDTO buscarPorId(@PathVariable("idProdPers") Long id){
        Optional<ProductoPersonalizado> productoPersonalizado = productoPersonalizadoJPA.findById(id);
        ProductoPersonalizadoDTO productoPersonalizadoDTO = new ProductoPersonalizadoDTO(productoPersonalizado);
        return productoPersonalizadoDTO;
    }

    @GetMapping("/productoPersonalizado/{idProdPers}/existe")
    public boolean existeProductoPersonalizado(@PathVariable("idProdPers") Long id){
        return productoPersonalizadoJPA.existsById(id);
    }

}




