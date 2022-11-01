package domain.models.entities;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {

    private Comprador comprador;
    private List<Item> items;
    private double precioFinal;

    public CarritoDeCompra() {
        this.items = new ArrayList<>();
    }

    public List<Item> getProductos() {
        return items;
    }

    public void setProductos(Item item) {
        this.items.add(item);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
