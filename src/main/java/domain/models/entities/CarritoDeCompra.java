package domain.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @Column(name = "comprador")
    private Comprador comprador;

    @ManyToMany
    @Column(name = "items")
    private List<Item> items;

    @Column(name = "precioFinal")
    private double precioFinal;

    public CarritoDeCompra(){
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }
    public void agregarItems(Item item) {
        this.items.add(item);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
