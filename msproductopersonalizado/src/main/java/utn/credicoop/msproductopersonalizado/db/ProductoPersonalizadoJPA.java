package utn.credicoop.msproductopersonalizado.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import utn.credicoop.msproductopersonalizado.entities.ProductoPersonalizado;

@RepositoryRestResource(path = "productopersonalizado")
public interface ProductoPersonalizadoJPA extends JpaRepository<ProductoPersonalizado, Long> {

}
