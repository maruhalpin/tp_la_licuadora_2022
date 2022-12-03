package utn.credicoop.msventas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name="Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

/*  @ManyToOne
    @JoinColumn(name = "productoPersonalizado_id", referencedColumnName = "id") */

    @Column(name="id_producto_personalizado")
    private Long idProductoPersonalizado;

    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoPublicacion estadoPublicacion;

    @Column(name="horaDeSubida")
    private LocalTime horaDeSubida;

    @Column(name="horaDeBaja")
    private LocalTime horaDeBaja;

    @Column(name="fechaDeSubida")
    private LocalDate fechaDeSubida;

    @Column(name="fechaDeBaja")
    private LocalDate fechaDeBaja;
}
