package pessanha.consultacep.entities.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RegiaoBrasilTest {
    @Test
    void testRegioesBrasil() {
        assertEquals(20.83, RegiaoBrasil.NORTE.getFrete());
        assertEquals(Arrays.asList("AC", "AM", "AP", "PA", "RO", "RR", "TO"), RegiaoBrasil.NORTE.getSiglasEstados());

        assertEquals(15.98, RegiaoBrasil.NORDESTE.getFrete());
        assertEquals(Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"), RegiaoBrasil.NORDESTE.getSiglasEstados());

        assertEquals(12.5, RegiaoBrasil.CENTRO_OESTE.getFrete());
        assertEquals(Arrays.asList("DF", "GO", "MS", "MT"), RegiaoBrasil.CENTRO_OESTE.getSiglasEstados());

        assertEquals(7.85, RegiaoBrasil.SUDESTE.getFrete());
        assertEquals(Arrays.asList("ES", "MG", "RJ", "SP"), RegiaoBrasil.SUDESTE.getSiglasEstados());

        assertEquals(17.3, RegiaoBrasil.SUL.getFrete());
        assertEquals(Arrays.asList("PR", "RS", "SC"), RegiaoBrasil.SUL.getSiglasEstados());


    }

}