package utn.credicoop.msventas.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @ManyToMany
    @Column(name="mediosDePago")
    private Set<MedioDePago> mediosDePago;

    public Vendedor(){
        this.mediosDePago = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }
    public void agregarMedioDePago(MedioDePago medioDePago) { this.mediosDePago.add(medioDePago);}
}
