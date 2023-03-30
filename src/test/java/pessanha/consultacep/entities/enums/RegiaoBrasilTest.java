package pessanha.consultacep.entities.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RegiaoBrasilTest {
    @Test
    void testRegioesBrasil() {
        assertEquals(20.0, RegiaoBrasil.NORTE.getFrete());
        assertEquals(Arrays.asList("AC", "AM", "AP", "PA", "RO", "RR", "TO"), RegiaoBrasil.NORTE.getSiglasEstados());

        assertEquals(15.0, RegiaoBrasil.NORDESTE.getFrete());
        assertEquals(Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"), RegiaoBrasil.NORDESTE.getSiglasEstados());

        assertEquals(10.0, RegiaoBrasil.CENTRO_OESTE.getFrete());
        assertEquals(Arrays.asList("DF", "GO", "MS", "MT"), RegiaoBrasil.CENTRO_OESTE.getSiglasEstados());

        assertEquals(8.0, RegiaoBrasil.SUDESTE.getFrete());
        assertEquals(Arrays.asList("ES", "MG", "RJ", "SP"), RegiaoBrasil.SUDESTE.getSiglasEstados());

        assertEquals(12.0, RegiaoBrasil.SUL.getFrete());
        assertEquals(Arrays.asList("PR", "RS", "SC"), RegiaoBrasil.SUL.getSiglasEstados());


    }

}