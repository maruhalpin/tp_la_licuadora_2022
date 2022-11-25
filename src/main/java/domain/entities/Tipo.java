package domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="Tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre; //Ejemplo: texto, imagenes, emojis

    public Tipo(){ }

    public Tipo(String nombre){
        this.nombre = nombre;
    }
}
