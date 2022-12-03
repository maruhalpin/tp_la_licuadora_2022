package utn.credicoop.msventas.entities;

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

/*      @ManyToOne
        @JoinColumn(name = "producto_id", referencedColumnName = "id")*/
        @Column(name="id_producto_personalizado")
        private Long idProductoPersonalizado;

        @Column(name = "cantidad")
        private int cantidad;
}
