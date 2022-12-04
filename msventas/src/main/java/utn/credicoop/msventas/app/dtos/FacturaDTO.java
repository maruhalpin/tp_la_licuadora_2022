package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.CarritoDeCompra;
import utn.credicoop.msventas.entities.Compra;
import utn.credicoop.msventas.entities.Comprador;
import utn.credicoop.msventas.entities.MedioDePago;

public class FacturaDTO {

    public String status;
    public double importe;
    public Comprador datosComprador;
    public CarritoDeCompra carrito;
    public MedioDePago medioDePago;

    public FacturaDTO() {
    }

    public FacturaDTO(String status, double importe, CarritoDeCompra carrito, MedioDePago medioDePago, Comprador datosComprador) {
        this.status = status;
        this.importe = importe;
        this.carrito = carrito;
        this.medioDePago = medioDePago;
        this.datosComprador = datosComprador;
    }

    public FacturaDTO(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public CarritoDeCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompra carrito) {
        this.carrito = carrito;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }
}
