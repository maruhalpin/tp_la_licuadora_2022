package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Vendedor {
    private String nombre;
    private String apellido;
    private Set<MedioDePago> mediosDePago;

    public Vendedor(){
        this.mediosDePago = new LinkedHashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }

    public void setMediosDePago(MedioDePago medioDePago) {
        this.mediosDePago.add(medioDePago);
    }
}
