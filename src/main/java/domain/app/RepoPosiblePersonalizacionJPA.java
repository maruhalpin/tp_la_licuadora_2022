package domain.app;

import domain.entities.PosiblePersonalizacion;
import domain.entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "posibles_personalizaciones")
public interface RepoPosiblePersonalizacionJPA  extends JpaRepository<PosiblePersonalizacion, Long> {

    PosiblePersonalizacion findByZona(Zona zona);

}
