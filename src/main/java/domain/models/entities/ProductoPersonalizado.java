package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoPersonalizado {

    private Producto productoBase;
    private Set<Personalizacion> personalizaciones;
    private double precioFinal;

    public Producto getProductoBase() {
        return productoBase;
    }

    public void setProductoBase(Producto productoBase) {
        this.productoBase = productoBase;
    }

    public ProductoPersonalizado() {
        this.personalizaciones = new LinkedHashSet<>();
    }

    public Set<Personalizacion> getPersonalizaciones() {
        return personalizaciones;
    }

    public void agregarPersonalizacion(Personalizacion personalizacion) {
        this.personalizaciones.add(personalizacion);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal() {
        double sumaPrecios = personalizaciones.stream().mapToDouble(o -> o.getTipo().getPrecio()).sum();
        this.precioFinal = productoBase.getPrecioBase() + sumaPrecios;
    }
}
