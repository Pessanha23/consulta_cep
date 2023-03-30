package pessanha.consultacep.entities.enums;

import java.util.Arrays;
import java.util.List;


public enum RegiaoBrasil {
    NORTE(20.0, Arrays.asList("AC", "AM", "AP", "PA", "RO", "RR", "TO")),
    NORDESTE(15.0, Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE")),
    CENTRO_OESTE(10.0, Arrays.asList("DF", "GO", "MS", "MT")),
    SUDESTE(8.0, Arrays.asList("ES", "MG", "RJ", "SP")),
    SUL(12.0, Arrays.asList("PR", "RS", "SC"));

    private final double frete;
    private final List<String> siglasEstados;

    private RegiaoBrasil(double frete, List<String> siglasEstados) {
        this.frete = frete;
        this.siglasEstados = siglasEstados;
    }

    public double getFrete() {
        return frete;
    }

    public List<String> getSiglasEstados() {
        return siglasEstados;
    }


}
