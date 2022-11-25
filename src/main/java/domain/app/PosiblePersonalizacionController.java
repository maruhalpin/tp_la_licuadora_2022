package domain.app;

import org.springframework.data.rest.webmvc.RepositoryRestController;

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
