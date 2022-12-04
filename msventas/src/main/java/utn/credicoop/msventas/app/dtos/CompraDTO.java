package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.EstadoCompra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CompraDTO {

    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private List<ItemDTO> items;
    private MedioDePagoDTO formaDePago;
    private EstadoCompra estado;
    private LocalDate fechaCambioEstado;

    public CompraDTO (){
        this.items = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<ItemDTO> getItems() {
        return items;
    }
    public void setItems(List<ItemDTO> items) { this.items = items; }
    public void agregarItems(ItemDTO item) {
        this.items.add(item);
    }

    public MedioDePagoDTO getFormaDePago() {
        return formaDePago;
    }
    public void setFormaDePago(MedioDePagoDTO formaDePago) {
        this.formaDePago = formaDePago;
    }

    public EstadoCompra getEstado() {
        return estado;
    }
    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCambioEstado() {
        return fechaCambioEstado;
    }
    public void setFechaCambioEstado(LocalDate fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
