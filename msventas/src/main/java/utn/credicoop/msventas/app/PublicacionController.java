package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.PublicacionDTO;
import utn.credicoop.msventas.db.PublicacionJPA;
import utn.credicoop.msventas.db.TiendaJPA;
import utn.credicoop.msventas.entities.Publicacion;
import utn.credicoop.msventas.entities.Tienda;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RestController
public class PublicacionController {

    @Autowired
    ProductoPersonalizadoProxy proxy;

    @Resource
    PublicacionJPA publicacionJPA;

    @Resource
    TiendaJPA tiendaJPA;

    @Transactional
    @PostMapping("/publicacion/generar/tienda/{idTienda}")
    public @ResponseBody ResponseEntity<String> crearPublicacion(@RequestBody PublicacionDTO publicacionDTO, @PathVariable("idTienda") Long id){
        if(tiendaJPA.existsById(id)){
            boolean existeProductoPersonalizado = proxy.existeProductoPersonalizado(publicacionDTO.getIdProductoPersonalizado());
            if(existeProductoPersonalizado) {
                Publicacion publicacion = new Publicacion(publicacionDTO);
                publicacion.setIdTiendaAsociada(id);
                publicacionJPA.save(publicacion);

                return new ResponseEntity<>("Publicación creada en " + tiendaJPA.findById(id).get().getNombre() + "." , HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se pudo crear la publicación, producto inexistente." , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No se pudo crear la publicación, tienda inexistente.", HttpStatus.CONFLICT);
        }
    }

}
