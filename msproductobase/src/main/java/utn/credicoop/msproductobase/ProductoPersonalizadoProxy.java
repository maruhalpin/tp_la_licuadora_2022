package utn.credicoop.msproductobase;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productopersonalizado", url = "localhost:8090")
public interface ProductoPersonalizadoProxy {

    @GetMapping("/productopersonalizado/{productoId}")
    RtaProductoBaseDTO buscarProductoPersonalizadoPorId(@PathVariable("productoId") String productoId);
}
