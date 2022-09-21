package test;

import domain.models.entities.Tipo;
import domain.models.entities.Zona;
import domain.models.entities.ZonaPersonalizable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestZona {

    @Test
    public void agregadosDosTipos(){
        Zona zona = new Zona();
        ZonaPersonalizable zonaPersonalizable = new ZonaPersonalizable();
        Tipo unTipo = new Tipo();
        Tipo otroTipo = new Tipo();

        zonaPersonalizable.setNombre("Espalda");
        zona.setZona(zonaPersonalizable);
        unTipo.setNombre("Frase");
        otroTipo.setNombre("Imagen");

        zona.agregarTipo(unTipo);
        zona.agregarTipo(otroTipo);

        zona.getTipos().forEach(t -> System.out.println(t.getNombre()));
        Assertions.assertEquals(2, zona.getTipos().size());
    }


}
