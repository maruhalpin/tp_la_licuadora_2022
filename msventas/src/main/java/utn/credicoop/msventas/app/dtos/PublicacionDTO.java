package utn.credicoop.msventas.app.dtos;

import utn.credicoop.msventas.converters.LocalDateAttributeConverter;
import utn.credicoop.msventas.entities.EstadoPublicacion;
import utn.credicoop.msventas.entities.Tienda;

import javax.persistence.Convert;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class PublicacionDTO {

    private Long id;
    private Long idProductoPersonalizado;
    private EstadoPublicacion estadoPublicacion;
   /*private LocalTime horaDeSubida;
    private LocalTime horaDeBaja;
    private LocalDate fechaDeSubida;
    private LocalDate fechaDeBaja;
    private Long idTiendaAsociada;*/

    public PublicacionDTO(){}

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

    public EstadoPublicacion getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public LocalDate getFechaActual(){
        return LocalDate.now();
    }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }

/*
    public LocalTime getHoraDeSubida() {
        return horaDeSubida;
    }

    public void setHoraDeSubida(LocalTime horaDeSubida) {
        this.horaDeSubida = horaDeSubida;
    }

    public LocalTime getHoraDeBaja() {
        return horaDeBaja;
    }

    public void setHoraDeBaja(LocalTime horaDeBaja) {
        this.horaDeBaja = horaDeBaja;
    }

    public LocalDate getFechaDeSubida() {
        return fechaDeSubida;
    }

    public void setFechaDeSubida(LocalDate fechaDeSubida) {
        this.fechaDeSubida = fechaDeSubida;
    }

    public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public Long getTiendaAsociada() {
        return idTiendaAsociada;
    }

    public void setTiendaAsociada(Long idTiendaAsociada) {
        this.idTiendaAsociada = idTiendaAsociada;
    }*/


}
