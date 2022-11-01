package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoPersonalizado {

    private ProductoBase productoBase;
    private Set<Personalizacion> personalizaciones;
    private double precioFinal;

    public ProductoBase getProductoBase() {
        return productoBase;
    }

    public void setProductoBase(ProductoBase productoBase) {
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
        double sumaPrecios = personalizaciones.stream().mapToDouble(o -> o.getPrecio()).sum();
        this.precioFinal = productoBase.getPrecioBase() + sumaPrecios;
        //TODO - Ahí creo que estaría la funcion pero revisemosla, tuve que cambiarla porque al cambiar las clases cambió
    }
}
