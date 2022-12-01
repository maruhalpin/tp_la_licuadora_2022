package utn.credicoop.msproductobase.db;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.credicoop.msproductobase.entities.ProductoBase;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productobase")
public interface ProductoBaseJPA extends JpaRepository<ProductoBase, Long> {

}