package domain.app;

import domain.models.entities.PosiblePersonalizacion;
import domain.models.entities.ProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestController
public class PosiblePersonalizacionController {
/*
    @Autowired
    RepoPosiblePersonalizacionJPA repoPosiblePersonalizacion;

    @Transactional
    @PostMapping("/posiblePersonalizacion/{prodBase_id}/posiblePersonalizacion")
    public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
            @PathVariable("prodBase_id") Long prodBase_id){

        Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(prodBase_id);
        Optional<PosiblePersonalizacion> posiblePersonalizacionOptional = repoPosiblePersonalizacion.findById(prodBase_id);

        ProductoBase productoBase = productoBaseOptional.get();
        PosiblePersonalizacion posiblePersonalizacion = posiblePersonalizacionOptional.get();

        productoBase.agregarPosiblePersonalizacion(posiblePersonalizacion);

        return ResponseEntity.ok().build();
    }*/
}