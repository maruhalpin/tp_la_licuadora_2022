package utn.credicoop.msproductobase.app;

import utn.credicoop.msproductobase.entities.PosiblePersonalizacion;
import utn.credicoop.msproductobase.entities.ProductoBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoBaseDTO {

    private Long id;
    private String nombre;
    private double precioBase;
    private String descripcion;
    private int tiempoEstimadoDeFabricacion;
    private Set<PosiblePersonalizacion> posiblesPersonalizaciones;

    public ProductoBaseDTO() {}

    public ProductoBaseDTO(Long id, String nombre, double precioBase, String descripcion, int tiempoEstimadoDeFabricacion, Set<PosiblePersonalizacion> posiblesPersonalizaciones) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
        this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion;
        this.posiblesPersonalizaciones = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoEstimadoDeFabricacion() {
        return tiempoEstimadoDeFabricacion;
    }

    public void setTiempoEstimadoDeFabricacion(int tiempoEstimadoDeFabricacion) {
        this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion;
    }

    public Set<PosiblePersonalizacion> getPosiblesPersonalizaciones() {
        return posiblesPersonalizaciones;
    }

    public void setPosiblesPersonalizaciones(Set<PosiblePersonalizacion> posiblesPersonalizaciones) {
        this.posiblesPersonalizaciones = posiblesPersonalizaciones;
    }

    public void agregarPosiblesPersonalizaciones(PosiblePersonalizacion posiblePersonalizacion) {
        this.posiblesPersonalizaciones.add(posiblePersonalizacion);
    }

}
