package br.com.zup.lojavirtual;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCadastrarCliente() throws Exception {
        String json = "{\"nome\":\"Rodrigo Vaz\", \"cpf\":\"88149807055\",\"email\":\"rodrigo@zup.combr\"}";
        this.mockMvc.perform(post("/clientes/")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
                content()
                .json(json)
        );
    }

    @Test
    public void testBuscarClientePorCpf() throws Exception {
        String json = "{\"nome\":\"Rodrigo Vaz\", \"cpf\":\"93733187059\",\"email\":\"rodrigo.vaz@zup.combr\"}";
        this.mockMvc.perform(post("/clientes/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content()
                                .json(json)
                );

        this.mockMvc.perform(get("/clientes/93733187059/"))
        .andExpect(status().isOk())
        .andExpect(content().json(json));

    }

}
