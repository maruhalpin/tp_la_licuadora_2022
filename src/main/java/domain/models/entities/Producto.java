package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Producto {
    private String nombre;
    private double precioBase;
    private String descripcion;
    private int tiempoEstimadoDeFabricacion;
    private Set<Zona> areasDePersonalizacion;

    public Producto () {
        this.areasDePersonalizacion = new LinkedHashSet<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getTiempoEstimadoDeFabricacion() { return tiempoEstimadoDeFabricacion; }
    public void setTiempoEstimadoDeFabricacion(int tiempoEstimadoDeFabricacion) { this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion; }

    public Set<Zona> getAreasDePersonalizacion() {
        return areasDePersonalizacion;
    }

    public void agregarAreaDePersonalizacion(Zona zona) {
        this.areasDePersonalizacion.add(zona);
    }

}
