package utn.credicoop.msproductopersonalizado.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    //@Autowired
    @Autowired
    ProductoBaseProxy proxy;

    @Resource
    ProductoPersonalizadoJPA productoPersonalizadoJPA;

    @Transactional
    @PostMapping("/productopersonalizado/agregar")
    public @ResponseBody ResponseEntity<String> crearProductoPersonalizado(@RequestBody ProductoPersonalizadoDTO productoPersonalizadoDTO){
        if(!productoPersonalizadoJPA.existsById(productoPersonalizadoDTO.getId())){
            //productoPersonalizadoDTO.getPosiblesPersonalizaciones().forEach(e -> e.getZona().getNombre());
            ProductoBaseDTO productoBaseAsociado = proxy.buscarPorId(productoPersonalizadoDTO.getIdProductoBase());
            ProductoPersonalizado producto = new ProductoPersonalizado(productoPersonalizadoDTO);
            producto.calcularPrecioFinal(productoBaseAsociado.getPrecioBase());
            productoPersonalizadoJPA.save(producto);

            return new ResponseEntity<>("Agregado el producto personalizado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ID Duplicado", HttpStatus.CONFLICT);
        }
    }



}
