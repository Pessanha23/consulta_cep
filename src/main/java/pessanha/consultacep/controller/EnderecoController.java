package pessanha.consultacep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pessanha.consultacep.entities.CepRequestBody;
import pessanha.consultacep.entities.EnderecoJson;

@RestController
@RequestMapping(value = "/v1/consulta-endereco")
public class EnderecoController {

    @PostMapping
    public ResponseEntity<EnderecoJson> consultaResponseEntity(@RequestBody CepRequestBody cepRequestBody) {
        String cep = cepRequestBody.getCep();
        cep = cep.replace("-","");

        EnderecoJson enderecoJson = new EnderecoJson();

        enderecoJson.setCep(cep);
        enderecoJson.setRua("Praça da Sé");
        enderecoJson.setComplemento("lado ímpar");
        enderecoJson.setBairro("Sé");
        enderecoJson.setCidade("São Paulo");
        enderecoJson.setEstado("SP");
        enderecoJson.setFrete(7.85);

        return ResponseEntity.ok().body(enderecoJson);
    }

}
