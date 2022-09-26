package domain.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Publicacion {
    private ProductoPersonalizado productoPersonalizado;
    private Estado estado;
    private LocalTime horaDeSubida;
    private LocalTime horaDeBaja;
    private LocalDate fechaDeSubida;
    private LocalDate fechaDeBaja;
}
