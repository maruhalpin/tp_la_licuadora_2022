package domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Personalizacion")
public class Personalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="precio")
    private double precio;

    @OneToOne
    @JoinColumn(name = "posiblePerzonalizacion_id", referencedColumnName = "id")
    private PosiblePersonalizacion posiblePerzonalizacion;

    @Column(name="contenido")
    private String contenido;
}
