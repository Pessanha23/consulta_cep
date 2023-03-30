package pessanha.consultacep.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoServiceTest {

    @Test
    public void deve_formatar_cep_se_estiver_com_espaco_em_branco(){
        EnderecoService enderecoService = new EnderecoService();
        String cepTeste = enderecoService.formataCep(" 0 15 24 000");

        Assertions.assertEquals("01524000", cepTeste);

    }
    @Test
    public void deve_formatar_cep_se_estiver_com_mascara(){
        EnderecoService enderecoService = new EnderecoService();
        String cepTeste = enderecoService.formataCep("01524-000");

        Assertions.assertEquals("01524000", cepTeste);

    }
    @Test
    public void deve_formatar_cep_se_estiver_sem_mascara(){
        EnderecoService enderecoService = new EnderecoService();
        String cepTeste = enderecoService.formataCep("01524000");

        Assertions.assertEquals("01524000", cepTeste);

    }
}