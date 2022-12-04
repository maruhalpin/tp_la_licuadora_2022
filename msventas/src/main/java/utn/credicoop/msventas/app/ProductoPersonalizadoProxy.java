package utn.credicoop.msventas.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import utn.credicoop.msventas.app.dtos.ProductoPersonalizadoDTO;

import java.util.Optional;

@FeignClient(name = "productopersonalizado")
public interface ProductoPersonalizadoProxy {

    @GetMapping("/productoPersonalizado/{idProdPers}/buscar")
    ProductoPersonalizadoDTO buscarPorId(@PathVariable("idProdPers") Long id);

    @GetMapping("/productoPersonalizado/{idProdPers}/existe")
    boolean existeProductoPersonalizado(@PathVariable("idProdPers") Long id);
}
