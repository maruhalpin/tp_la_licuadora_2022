package domain.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Compra {
    private LocalDate fecha;
    private LocalTime hora;
    private List<Item> items;
    private MedioDePago formaDePago;
    private Estado estado;
    private LocalDate fechaCambioEstado;


}
