package utn.credicoop.msventas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msventas.entities.CarritoDeCompra;
import utn.credicoop.msventas.entities.Comprador;

@RepositoryRestResource(path = "comprador")
public interface CompradorJPA extends JpaRepository<Comprador, Long>{
}
