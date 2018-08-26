package com.mercadolivre.mutant.controller;

import com.mercadolivre.mutant.repository.DnaVerifiedRepository;
import com.mercadolivre.mutant.service.HumanMutantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MutantDetectorController.class)
public class MutantDetectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanMutantService humanMutantServiceMock;

    @MockBean
    private DnaVerifiedRepository dnaVerifiedRepository;

    @Test
    void shouldReturn200WhenIsMutant() throws Exception {
        Mockito.when(this.humanMutantServiceMock.isMutant(Mockito.any())).thenReturn(true);

        String content = "{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";

        this.mockMvc.perform(post("/mutant")
                    .content(content)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn403WhenNotIsMutant() throws Exception {
        Mockito.when(this.humanMutantServiceMock.isMutant(Mockito.any())).thenReturn(false);

        String content = "{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CAACTA\",\"TCACTG\"]}";

        this.mockMvc.perform(post("/mutant")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}