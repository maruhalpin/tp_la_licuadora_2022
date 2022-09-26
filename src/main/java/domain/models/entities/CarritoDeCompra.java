package domain.models.entities;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {
    private List<ProductoPersonalizado> productos;
    private double precioFinal;

    public CarritoDeCompra() {
        this.productos = new ArrayList<>();
    }

    public List<ProductoPersonalizado> getProductos() {
        return productos;
    }

    public void setProductos(ProductoPersonalizado producto) {
        this.productos.add(producto);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
