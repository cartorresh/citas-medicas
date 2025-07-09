package com.citasmedicas.controller;

import com.citasmedicas.service.PacienteService;
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

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @Test
    public void testListarTodos() throws Exception {
        Mockito.when(pacienteService.listarTodos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/pacientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGuardar() throws Exception {
        String pacienteJson = """
            {
              "nombre": "Carlos Torres",
              "dni": "1234567890",
              "telefono": "0987654321"
            }
        """;

        mockMvc.perform(post("/api/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacienteJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testEliminar() throws Exception {
        mockMvc.perform(delete("/api/pacientes/1"))
                .andExpect(status().isOk());
    }
}
