package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.Publicacion;

public class ItemDTO {


    private int cantidad;


    public ItemDTO(){ }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
