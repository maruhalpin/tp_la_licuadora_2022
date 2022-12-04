package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.Comprador;
import utn.credicoop.msventas.entities.Item;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompraDTO {

    private Comprador comprador;

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}
