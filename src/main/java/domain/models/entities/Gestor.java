package domain.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gestor {
    private String nombre;
    private String mail;
    private String usuario;
    private String password;

    // public void cargarProducto(); REVISAR SI HAY QUE HACER CLASE PLATAFORMA O CON PERSISTIRLO ALCANZA.

}
