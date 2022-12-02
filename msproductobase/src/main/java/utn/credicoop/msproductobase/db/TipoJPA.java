package utn.credicoop.msproductobase.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msproductobase.entities.Tipo;

@RepositoryRestResource(path = "tipo")
public interface TipoJPA extends JpaRepository<Tipo, Long>  {

}
