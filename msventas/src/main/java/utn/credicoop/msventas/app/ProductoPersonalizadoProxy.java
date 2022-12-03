package utn.credicoop.msventas.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productopersonalizado")
public interface ProductoPersonalizadoProxy {

}
