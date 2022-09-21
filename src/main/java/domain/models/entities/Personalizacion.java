package domain.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personalizacion {
    private String nombre;
    private ZonaPersonalizable zonaPersonalizable;
    private TipoPersonalizable tipo;
}
