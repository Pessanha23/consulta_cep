package pessanha.consultacep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pessanha.consultacep.entities.EnderecoJson;
import pessanha.consultacep.entities.ViaCepJson;
import pessanha.consultacep.exception.NotFoundException;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;

    public EnderecoJson capturaBancodeDados(String cep){

        EnderecoJson enderecoJson = new EnderecoJson();
        String url = "https://viacep.com.br/ws/{cep}/json/";

        try {
            ViaCepJson viaCepJson = restTemplate.getForObject(url, ViaCepJson.class, cep);
            enderecoJson.setCep(viaCepJson.getCep());
            enderecoJson.setRua(viaCepJson.getLogradouro());
            enderecoJson.setComplemento(viaCepJson.getComplemento());
            enderecoJson.setBairro(viaCepJson.getBairro());
            enderecoJson.setCidade(viaCepJson.getLocalidade());
            enderecoJson.setEstado(viaCepJson.getUf());
            enderecoJson.setFrete(7.85);
            return enderecoJson;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
