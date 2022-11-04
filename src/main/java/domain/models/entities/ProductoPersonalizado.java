package domain.models.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ProductoPersonalizado")
public class ProductoPersonalizado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @Column(name = "productoBase")
    private ProductoBase productoBase;

    @ManyToMany
    @Column(name = "personalizaciones")
    private Set<Personalizacion> personalizaciones;

    @Column(name = "precioFinal")
    private double precioFinal;

    public ProductoPersonalizado() {
        this.personalizaciones = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public ProductoBase getProductoBase() {
        return productoBase;
    }
    public void setProductoBase(ProductoBase productoBase) {
        this.productoBase = productoBase;
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
