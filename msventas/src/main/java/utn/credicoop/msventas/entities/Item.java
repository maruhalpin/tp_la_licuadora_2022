package utn.credicoop.msventas.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

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

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getIdProductoPersonalizado() {
                return idProductoPersonalizado;
        }

        public void setIdProductoPersonalizado(Long idProductoPersonalizado) {
                this.idProductoPersonalizado = idProductoPersonalizado;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }
}
