package pessanha.consultacep.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pessanha.consultacep.entities.CepRequestBody;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EnderecoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "/v1/consulta-endereco";

    @Test
    public void deve_retornar_usuario_criado_quando_preenchido_corretamente() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("01524-000");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("01524000"))
                .andExpect(jsonPath("rua").value("Praça da Sé"))
                .andExpect(jsonPath("complemento").value("lado ímpar"))
                .andExpect(jsonPath("bairro").value("Sé"))
                .andExpect(jsonPath("cidade").value("São Paulo"))
                .andExpect(jsonPath("estado").value("SP"))
                .andExpect(jsonPath("frete").value(7.85));

    }

}