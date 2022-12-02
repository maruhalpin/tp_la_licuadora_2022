package utn.credicoop.msproductopersonalizado.app.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import utn.credicoop.msproductopersonalizado.app.ProductoBaseProxy;
import utn.credicoop.msproductopersonalizado.app.dtos.PersonalizacionDTO;
import utn.credicoop.msproductopersonalizado.entities.Personalizacion;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoPersonalizadoDTO {

    private Long id;
    private Long idProductoBase;
    private Set<Personalizacion> personalizaciones;
    private double precioFinal;

    public ProductoPersonalizadoDTO(Long id, Long idProductoBase, Set<Personalizacion> personalizaciones, double precioFinal){
        this.id = id;
        this.idProductoBase = idProductoBase;
        this.personalizaciones = personalizaciones;
        this.precioFinal = precioFinal;
    }

    public ProductoPersonalizadoDTO() {
        this.personalizaciones = new LinkedHashSet<>();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProductoBase() {
        return idProductoBase;
    }
    public void setIdProductoBase(Long productoBase) {
        this.idProductoBase = productoBase;
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
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

}
