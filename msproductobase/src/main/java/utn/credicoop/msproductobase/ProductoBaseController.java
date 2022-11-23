package utn.credicoop.msproductobase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoBaseController {

    @GetMapping("/productobase/{productoId}")
    public String buscarProductoBasePorId(@PathVariable("productoId") String productoId) {
        return "NO";
    }

}
