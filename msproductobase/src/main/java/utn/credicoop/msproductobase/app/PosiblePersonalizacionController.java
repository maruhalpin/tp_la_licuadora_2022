package utn.credicoop.msproductobase.app;

import io.swagger.v3.oas.annotations.Operation;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utn.credicoop.msproductobase.app.dtos.PosiblePersonalizacionDTO;
import utn.credicoop.msproductobase.app.dtos.ProductoBaseDTO;
import utn.credicoop.msproductobase.db.PosiblePersonalizacionJPA;
import utn.credicoop.msproductobase.db.ProductoBaseJPA;
import utn.credicoop.msproductobase.entities.PosiblePersonalizacion;
import utn.credicoop.msproductobase.entities.ProductoBase;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class PosiblePersonalizacionController {

    @Autowired
    PosiblePersonalizacionJPA posiblePersonalizacionJPA;

    @Operation(summary = "Corrobora si la posible personalizacion existe")
    @GetMapping("/posiblepersonalizacion/{idPosiblePersonalizacion}/existe")
    public boolean existePosiblePersonalizacion(@PathVariable("idPosiblePersonalizacion") Long id){
        return posiblePersonalizacionJPA.existsById(id);
    }
}
