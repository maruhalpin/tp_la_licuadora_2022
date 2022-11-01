package test;

import domain.models.entities.Tipo;
import domain.models.entities.PosiblePersonalizacion;
import domain.models.entities.Zona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPosiblePersonalizacion {

    @Test
    public void agregadosDosTipos(){
        PosiblePersonalizacion posiblePersonalizacion = new PosiblePersonalizacion();
        Zona zona = new Zona();
        Tipo unTipo = new Tipo();
        Tipo otroTipo = new Tipo();

        zona.setNombre("Espalda");
        posiblePersonalizacion.setZona(zona);
        unTipo.setNombre("Frase");
        otroTipo.setNombre("Imagen");

        posiblePersonalizacion.agregarTipo(unTipo);
        posiblePersonalizacion.agregarTipo(otroTipo);

        posiblePersonalizacion.getTipos().forEach(t -> System.out.println(t.getNombre()));
        Assertions.assertEquals(2, posiblePersonalizacion.getTipos().size());
    }


}
