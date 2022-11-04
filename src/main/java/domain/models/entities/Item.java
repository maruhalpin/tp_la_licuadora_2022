package domain.models.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Item")
public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        private Long id;

        @ManyToOne
        @Column(name = "producto")
        private ProductoPersonalizado producto;

        @Column(name = "cantidad")
        private int cantidad;
}
