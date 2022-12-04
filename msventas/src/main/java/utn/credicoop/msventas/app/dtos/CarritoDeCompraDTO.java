package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.Comprador;
import utn.credicoop.msventas.entities.Item;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompraDTO {

    private Long id;
    private CompradorDTO comprador;
    private List<ItemDTO> items;
    private double precioFinal;

    public CarritoDeCompraDTO(){
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }
    public void setItems(List<ItemDTO> items) { this.items = items; }
    public void agregarItems(ItemDTO item) {
        this.items.add(item);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
