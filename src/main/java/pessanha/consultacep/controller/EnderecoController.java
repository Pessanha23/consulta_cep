package pessanha.consultacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pessanha.consultacep.entities.CepRequestBody;
import pessanha.consultacep.entities.EnderecoJson;
import pessanha.consultacep.service.EnderecoService;

@RestController
@RequestMapping(value = "/v1/consulta-endereco")
public class EnderecoController {
    @Autowired
    public EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoJson> consultaResponseEntity(@RequestBody CepRequestBody cepRequestBody) {
        String cep = cepRequestBody.getCep();
        cep = cep.replace("-", "");

        EnderecoJson responseEndereco = enderecoService.capturaBancodeDados(cep);


        return ResponseEntity.ok().body(responseEndereco);
    }

}
