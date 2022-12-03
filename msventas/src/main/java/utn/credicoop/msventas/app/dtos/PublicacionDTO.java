package utn.credicoop.msventas.app.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class PublicacionDTO {

    private Long id;

    private Long idProductoPersonalizado;

    private EstadoPublicacionDTO estadoPublicacion;

    private LocalTime horaDeSubida;

    private LocalTime horaDeBaja;

    private LocalDate fechaDeSubida;

    private LocalDate fechaDeBaja;
}
