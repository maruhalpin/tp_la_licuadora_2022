package utn.credicoop.msventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.credicoop.msventas.app.dtos.ProductoPersonalizadoDTO;
import utn.credicoop.msventas.app.dtos.PublicacionDTO;
import utn.credicoop.msventas.db.PublicacionJPA;
import utn.credicoop.msventas.db.TiendaJPA;
import utn.credicoop.msventas.entities.Publicacion;
import utn.credicoop.msventas.entities.Tienda;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

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

                ProductoPersonalizadoDTO productoPersonalizadoDTO = proxy.buscarPorId(publicacionDTO.getIdProductoPersonalizado());

                publicacion.setIdTiendaAsociada(id);
                publicacion.setPrecio(productoPersonalizadoDTO.getPrecioFinal());

                publicacionJPA.save(publicacion);

                return new ResponseEntity<>("Publicación creada en " + tiendaJPA.findById(id).get().getNombre() + "." , HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se pudo crear la publicación, producto inexistente." , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No se pudo crear la publicación, tienda inexistente.", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @PostMapping("/publicacion/{idPublicacion}/bajar")
    public @ResponseBody ResponseEntity<String> bajarPublicacion(@PathVariable("idPublicacion") Long id){
        if(publicacionJPA.existsById(id)){
            Optional<Publicacion> publicacionOptional = publicacionJPA.findById(id);
            Publicacion publicacion = new Publicacion(publicacionOptional);
            publicacion.bajarPublicacion();
            publicacionJPA.save(publicacion);
            return new ResponseEntity<>("Publicación (ID " + publicacion.getId() + ") dada de baja." , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo dar de baja la publicación porque no existe.", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @PostMapping("/publicacion/{idPublicacion}/pausar")
    public @ResponseBody ResponseEntity<String> pausarPublicacion(@PathVariable("idPublicacion") Long id){
        if(publicacionJPA.existsById(id)){
            Optional<Publicacion> publicacionOptional = publicacionJPA.findById(id);
            Publicacion publicacion = new Publicacion(publicacionOptional);
            publicacion.pausarPublicacion();
            publicacionJPA.save(publicacion);
            return new ResponseEntity<>("Publicación (ID " + publicacion.getId() + ") pausada." , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo pausar la publicación porque no existe.", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @PostMapping("/publicacion/{idPublicacion}/activar")
    public @ResponseBody ResponseEntity<String> activarPublicacion(@PathVariable("idPublicacion") Long id){
        if(publicacionJPA.existsById(id)){
            Optional<Publicacion> publicacionOptional = publicacionJPA.findById(id);
            Publicacion publicacion = new Publicacion(publicacionOptional);
            publicacion.activarPublicacion();
            publicacionJPA.save(publicacion);
            return new ResponseEntity<>("Publicación (ID " + publicacion.getId() + ") activa." , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo pausar la publicación porque no existe.", HttpStatus.CONFLICT);
        }
    }

}
