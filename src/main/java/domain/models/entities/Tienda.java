package domain.models.entities;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private List<Publicacion> publicaciones;

    public Tienda() {
        this.publicaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }
}
