package domain.models.entities;

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

    @ManyToOne
    @Column(name="zona")
    private Zona zona;

    @ManyToOne
    @Column(name="tipo")
    private Tipo tipo;

}
