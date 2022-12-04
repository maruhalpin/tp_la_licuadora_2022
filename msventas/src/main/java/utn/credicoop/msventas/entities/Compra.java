package utn.credicoop.msventas.entities;

import utn.credicoop.msventas.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items; // Cambiar por carrito

    @ManyToOne
    @JoinColumn(name = "forma_de_pago_id", referencedColumnName = "id")
    private MedioDePago formaDePago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCompra estado;

    @Column(name = "fecha_cambio_estado")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaCambioEstado;

    public Compra (){
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

    public List<Item> getItems() {
        return items;
    }
    public void agregarItems(Item item) {
        this.items.add(item);
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
}
