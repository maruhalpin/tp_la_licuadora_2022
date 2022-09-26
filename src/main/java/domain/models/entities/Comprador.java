package domain.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comprador {
    private int id;
    private CarritoDeCompra carritoDeCompra;
}
