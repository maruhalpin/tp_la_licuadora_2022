package domain.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="PosiblePersonalizacion")
public class PosiblePersonalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "prueba")
    private String prueba;

    @ManyToOne
    @JoinColumn(name = "zona_id", referencedColumnName = "id")
    private Zona zona;

    @ManyToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private Tipo tipo;

    public PosiblePersonalizacion(Zona zona) {
        this.zona = zona;
    }

    public PosiblePersonalizacion() { }

    public PosiblePersonalizacion(Zona zona, Tipo tipo) {
        this.zona = zona;
        this.tipo = tipo;

    }
}
