package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Zona {
    private ZonaPersonalizable zona;
    private Set<Tipo> tipos;

    public Zona() {
        this.tipos = new LinkedHashSet<>();
    }

    public ZonaPersonalizable getZona() {
        return zona;
    }

    public void setZona(ZonaPersonalizable zona) {
        this.zona = zona;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void agregarTipo(Tipo tipo) {
        this.tipos.add(tipo);
    }

}
