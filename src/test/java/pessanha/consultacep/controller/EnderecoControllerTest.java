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
    public void deve_retornar_endereco_regiao_sudeste() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("01524-000");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("01524-000"))
                .andExpect(jsonPath("rua").value("Rua da Independência"))
                .andExpect(jsonPath("complemento").value("lado par"))
                .andExpect(jsonPath("bairro").value("Cambuci"))
                .andExpect(jsonPath("cidade").value("São Paulo"))
                .andExpect(jsonPath("estado").value("SP"))
                .andExpect(jsonPath("frete").value(7.85));

    }

    @Test
    public void deve_retornar_endereco_regiao_sul() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("80215090");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("80215-090"))
                .andExpect(jsonPath("rua").value("Avenida Comendador Franco"))
                .andExpect(jsonPath("complemento").value("até 2129/2130"))
                .andExpect(jsonPath("bairro").value("Jardim Botânico"))
                .andExpect(jsonPath("cidade").value("Curitiba"))
                .andExpect(jsonPath("estado").value("PR"))
                .andExpect(jsonPath("frete").value(17.3));

    }

    @Test
    public void deve_retornar_endereco_regiao_centro_oeste() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("70150900");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("70150-900"))
                .andExpect(jsonPath("rua").value("Praça dos Três Poderes"))
                .andExpect(jsonPath("complemento").value(""))
                .andExpect(jsonPath("bairro").value("Zona Cívico-Administrativa"))
                .andExpect(jsonPath("cidade").value("Brasília"))
                .andExpect(jsonPath("estado").value("DF"))
                .andExpect(jsonPath("frete").value(12.5));

    }

    @Test
    public void deve_retornar_endereco_regiao_nordeste() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("40026-010");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("40026-010"))
                .andExpect(jsonPath("rua").value("Largo Terreiro de Jesus"))
                .andExpect(jsonPath("complemento").value(""))
                .andExpect(jsonPath("bairro").value("Centro Histórico"))
                .andExpect(jsonPath("cidade").value("Salvador"))
                .andExpect(jsonPath("estado").value("BA"))
                .andExpect(jsonPath("frete").value(15.98));

    }

    @Test
    public void deve_retornar_endereco_regiao_norte() throws Exception {

        CepRequestBody cepRequestBody = new CepRequestBody();
        cepRequestBody.setCep("69020011");

        ObjectMapper objectMapper = new ObjectMapper();
        String cepJson = objectMapper.writeValueAsString(cepRequestBody);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cepJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cep").value("69020-011"))
                .andExpect(jsonPath("rua").value("Avenida Getúlio Vargas"))
                .andExpect(jsonPath("complemento").value("de 721/722 ao fim"))
                .andExpect(jsonPath("bairro").value("Centro"))
                .andExpect(jsonPath("cidade").value("Manaus"))
                .andExpect(jsonPath("estado").value("AM"))
                .andExpect(jsonPath("frete").value(20.83));

    }
}