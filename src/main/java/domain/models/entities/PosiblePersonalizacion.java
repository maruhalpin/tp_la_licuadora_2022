package domain.models.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class PosiblePersonalizacion {
    private Zona zona;
    private Tipo tipo;

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Tipo getTipo() { return tipo; }

    public void setTipo(Tipo tipo) { this.tipo=tipo; }

}
