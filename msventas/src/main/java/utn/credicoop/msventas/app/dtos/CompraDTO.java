package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.entities.EstadoCompra;
import utn.credicoop.msventas.entities.Item;
import utn.credicoop.msventas.entities.MedioDePago;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompraDTO {

    private MedioDePago formaDePago;
    private List<Item> items;

    public CompraDTO (){

    }

    public MedioDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(MedioDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public LocalDate getFechaActual(){ return LocalDate.now(); }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) { this.items = items; }
    public void agregarItems(Item item) {
        this.items.add(item);
    }

/*
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
    }*/
}
