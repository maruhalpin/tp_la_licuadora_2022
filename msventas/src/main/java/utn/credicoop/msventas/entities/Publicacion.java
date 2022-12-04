package utn.credicoop.msventas.entities;

import utn.credicoop.msventas.app.dtos.PublicacionDTO;
import utn.credicoop.msventas.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="id_producto_personalizado")
    private Long idProductoPersonalizado;

    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoPublicacion estadoPublicacion;

    @Column(name="hora_de_subida")
    private LocalTime horaDeSubida;

    @Column(name="hora_de_baja")
    private LocalTime horaDeBaja;

    @Column(name="fecha_de_subida")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaDeSubida;

    @Column(name="fecha_de_baja")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaDeBaja;
/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tienda_id", referencedColumnName = "id")
    private Tienda tiendaAsociada;*/

    @Column(name="id_tienda_asociada")
    private Long idTiendaAsociada;

    public Publicacion(){ }

    public Publicacion(PublicacionDTO publicacionDTO){
        this.id = publicacionDTO.getId();
        this.idProductoPersonalizado = publicacionDTO.getIdProductoPersonalizado();
        this.estadoPublicacion = EstadoPublicacion.ACTIVA;
        this.horaDeSubida = publicacionDTO.getHoraActual();
        this.fechaDeSubida = publicacionDTO.getFechaActual();
        this.fechaDeBaja = null;
        this.horaDeBaja = null;
        this.idTiendaAsociada = this.getIdTiendaAsociada();
    }

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

    public Long getIdTiendaAsociada() {
        return idTiendaAsociada;
    }

    public void setIdTiendaAsociada(Long idTiendaAsociada) {
        this.idTiendaAsociada = idTiendaAsociada;
    }
}
