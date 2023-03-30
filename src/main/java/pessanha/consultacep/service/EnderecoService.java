package pessanha.consultacep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pessanha.consultacep.entities.EnderecoJson;
import pessanha.consultacep.entities.ViaCepJson;
import pessanha.consultacep.entities.enums.RegiaoBrasil;
import pessanha.consultacep.exception.NotFoundException;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;

    public EnderecoJson consultarCep(String cep){

        String cepFormatado = formataCep(cep);

        EnderecoJson enderecoJson = new EnderecoJson();
        String url = "https://viacep.com.br/ws/{cep}/json/";

        try {
            ViaCepJson viaCepJson = restTemplate.getForObject(url, ViaCepJson.class, cepFormatado);
            enderecoJson.setCep(viaCepJson.getCep());
            enderecoJson.setRua(viaCepJson.getLogradouro());
            enderecoJson.setComplemento(viaCepJson.getComplemento());
            enderecoJson.setBairro(viaCepJson.getBairro());
            enderecoJson.setCidade(viaCepJson.getLocalidade());
            enderecoJson.setEstado(viaCepJson.getUf());

            for (RegiaoBrasil regiao : RegiaoBrasil.values()) {
                if (regiao.getSiglasEstados().contains(viaCepJson.getUf().toUpperCase())) {
                    enderecoJson.setFrete(regiao.getFrete());
                }
            }
            return enderecoJson;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    public String formataCep(String cep){
        String cepFormatado = cep;
        cepFormatado = cepFormatado.replace("-", "");
        cepFormatado = cepFormatado.replaceAll(" ", "");
        return cepFormatado;
    }
}
