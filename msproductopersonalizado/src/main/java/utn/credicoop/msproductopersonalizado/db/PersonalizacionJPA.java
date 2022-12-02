package utn.credicoop.msproductopersonalizado.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msproductopersonalizado.entities.Personalizacion;

@RepositoryRestResource(path = "personalizacion")
public interface PersonalizacionJPA extends JpaRepository<Personalizacion, Long> {

}
