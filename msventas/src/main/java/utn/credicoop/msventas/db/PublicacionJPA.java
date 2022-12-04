package utn.credicoop.msventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msventas.entities.Publicacion;

@RepositoryRestResource(path = "publicacion")
public interface PublicacionJPA extends JpaRepository<Publicacion,Long> {
}
