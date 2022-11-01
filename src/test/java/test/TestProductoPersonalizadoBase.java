package test;

import domain.models.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProductoPersonalizadoBase {
    @Test
    public void agregarDosPersonalizaciones() {
        ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();

        Personalizacion unaPersonalizacion = new Personalizacion();
        unaPersonalizacion.setNombre("Imagen en espalda");

        Personalizacion otraPersonalizacion = new Personalizacion();
        otraPersonalizacion.setNombre("Frase en hombro");

        productoPersonalizado.agregarPersonalizacion(unaPersonalizacion);
        productoPersonalizado.agregarPersonalizacion(otraPersonalizacion);

        productoPersonalizado.getPersonalizaciones().forEach(t -> System.out.println(t.getNombre()));
        Assertions.assertEquals(2, productoPersonalizado.getPersonalizaciones().size());
    }

    @Test
    public void calcularPrecioFinal() {
        ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
        ProductoBase unProductoBase = new ProductoBase();
        unProductoBase.setPrecioBase(10.6);

        Personalizacion unaPersonalizacion = new Personalizacion();
        TipoPersonalizable unTipoPersonalizable = new TipoPersonalizable();
        unTipoPersonalizable.setPrecio(60);
        unaPersonalizacion.setTipo(unTipoPersonalizable);

        Personalizacion otraPersonalizacion = new Personalizacion();
        TipoPersonalizable otroTipoPersonalizable = new TipoPersonalizable();
        otroTipoPersonalizable.setPrecio(50.4);
        otraPersonalizacion.setTipo(otroTipoPersonalizable);

        productoPersonalizado.setProductoBase(unProductoBase);
        productoPersonalizado.agregarPersonalizacion(unaPersonalizacion);
        productoPersonalizado.agregarPersonalizacion(otraPersonalizacion);

        productoPersonalizado.setPrecioFinal();
        Assertions.assertEquals(121, productoPersonalizado.getPrecioFinal());
    }
}
