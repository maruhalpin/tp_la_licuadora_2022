package utn.credicoop.msventas.app.dtos;

import java.util.LinkedHashSet;
import java.util.Set;

public class VendedorDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private Set<MedioDePagoDTO> mediosDePago;

    public VendedorDTO(){
        this.mediosDePago = new LinkedHashSet<>();
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

    public Set<MedioDePagoDTO> getMediosDePago() {
        return mediosDePago;
    }
    public void agregarMedioDePago(MedioDePagoDTO medioDePago) { this.mediosDePago.add(medioDePago);}
}
