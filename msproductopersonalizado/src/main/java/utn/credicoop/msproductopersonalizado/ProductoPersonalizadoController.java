package utn.credicoop.msproductopersonalizado;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoPersonalizadoController {

    @GetMapping("/productopersonalizado/{productoId}")
    public String buscarProductoPersonalizadoPorId(@PathVariable("productoId") String productoId) {
        return "ID Personalizado: " + productoId;
    }
}
