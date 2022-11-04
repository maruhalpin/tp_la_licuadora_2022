package domain.models.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="ProductoBase")
public class ProductoBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="precioBase")
    private double precioBase;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="tiempoEstimadoDeFabricacion")
    private int tiempoEstimadoDeFabricacion;

    @ManyToMany
    @Column(name="posiblesPersonalizaciones")
    private Set<PosiblePersonalizacion> posiblesPersonalizaciones;

    public ProductoBase() {
        this.posiblesPersonalizaciones = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getTiempoEstimadoDeFabricacion() { return tiempoEstimadoDeFabricacion; }
    public void setTiempoEstimadoDeFabricacion(int tiempoEstimadoDeFabricacion) { this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion; }

    public Set<PosiblePersonalizacion> getPosiblesPersonalizaciones() {
        return posiblesPersonalizaciones;
    }
    public void agregarPosiblePersonalizacion(PosiblePersonalizacion posiblePersonalizacion) { this.posiblesPersonalizaciones.add(posiblePersonalizacion); }
}
