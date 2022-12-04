package utn.credicoop.msventas.entities;

import utn.credicoop.msventas.app.dtos.CompraDTO;
import utn.credicoop.msventas.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="Compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private CarritoDeCompra carritoDeCompra;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forma_de_pago_id", referencedColumnName = "id")
    private MedioDePago formaDePago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCompra estado;

    @Column(name = "fecha_cambio_estado")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaCambioEstado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id")
    private Vendedor vendedor;

    public Compra (){ }

    public Compra (CarritoDeCompra carritoDeCompraOptional, MedioDePago nombre, Vendedor vendedor) {
        this.formaDePago = nombre;
        this.fecha = this.getFechaActual();
        this.hora = this.getHoraActual();
        this.carritoDeCompra = carritoDeCompraOptional;
        this.estado = EstadoCompra.PENDIENTE;
        this.fechaCambioEstado = this.getFechaActual();
        this.vendedor = vendedor;
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


    public MedioDePago getFormaDePago() {
        return formaDePago;
    }
    public void setFormaDePago(MedioDePago formaDePago) {
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDate getFechaActual(){ return LocalDate.now(); }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }

    public CarritoDeCompra getCarritoDeCompra() {
        return carritoDeCompra;
    }

    public void setCarritoDeCompra(CarritoDeCompra carritoDeCompra) {
        this.carritoDeCompra = carritoDeCompra;
    }
}
