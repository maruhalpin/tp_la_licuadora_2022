package utn.credicoop.msventas.app.dtos;

public class ItemDTO {

    private Long id;
    private Long idProductoPersonalizado;
    private int cantidad;

    public ItemDTO(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProductoPersonalizado() {
        return idProductoPersonalizado;
    }

    public void setIdProductoPersonalizado(Long idProductoPersonalizado) {
        this.idProductoPersonalizado = idProductoPersonalizado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
