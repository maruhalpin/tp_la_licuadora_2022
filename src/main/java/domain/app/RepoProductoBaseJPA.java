package domain.app;

import domain.models.entities.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productosBase")
public interface RepoProductoBaseJPA extends JpaRepository<ProductoBase, Long> {

    ProductoBase findByNombre(String nombre);

}
