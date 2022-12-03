package utn.credicoop.msventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msventas.entities.MedioDePago;

@RepositoryRestResource
public interface MedioDePagoJPA extends JpaRepository<MedioDePago,Long> {
}
