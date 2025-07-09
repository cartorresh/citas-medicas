package com.citasmedicas.controller;

import com.citasmedicas.service.MedicoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MedicoController.class)
public class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicoService medicoService;

    @Test
    public void testListarTodos() throws Exception {
        Mockito.when(medicoService.listarTodos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/medicos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGuardar() throws Exception {
        String medicoJson = """
            {
              "nombre": "Dr. House",
              "especialidad": "Diagnóstico"
            }
        """;

        mockMvc.perform(post("/api/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(medicoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testEliminar() throws Exception {
        mockMvc.perform(delete("/api/medicos/1"))
                .andExpect(status().isOk());
    }
}
