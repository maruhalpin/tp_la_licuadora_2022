package utn.credicoop.msventas.app.dtos;

public class MedioDePagoDTO {

    private Long id;
    private String nombre;

    public MedioDePagoDTO(){ }

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
}
