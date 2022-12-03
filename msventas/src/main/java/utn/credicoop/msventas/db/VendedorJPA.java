package utn.credicoop.msventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msventas.entities.Vendedor;

@RepositoryRestResource
public interface VendedorJPA extends JpaRepository<Vendedor,Long> {
}
