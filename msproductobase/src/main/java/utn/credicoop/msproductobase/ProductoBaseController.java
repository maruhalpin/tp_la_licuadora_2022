package utn.credicoop.msproductobase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoBaseController {

    @Autowired
    ProductoPersonalizadoProxy proxy;

    @GetMapping("/productobase/{productoId}")
    public String buscarProductoBasePorId(@PathVariable("productoId") String productoId) {
        RtaProductoBaseDTO rta = proxy.buscarProductoPersonalizadoPorId(productoId);

        return "Ok" + rta.getStatus();

    }

}
