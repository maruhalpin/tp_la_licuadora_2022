package utn.credicoop.msventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msventas.entities.Compra;

@RepositoryRestResource
public interface CompraJPA extends JpaRepository<Compra, Long> {
}
