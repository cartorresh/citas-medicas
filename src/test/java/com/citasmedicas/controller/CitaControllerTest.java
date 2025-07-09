package com.citasmedicas.controller;

import com.citasmedicas.model.Cita;
import com.citasmedicas.service.CitaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CitaController.class)
public class CitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitaService citaService;

    @Test
    public void testListarTodas() throws Exception {
        Mockito.when(citaService.listarTodas()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/citas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGuardar() throws Exception {
        String citaJson = """
                {
                    "fecha":"2025-07-10",
                    "hora":"10:00",
                    "paciente":{"id":1},
                    "medico":{"id":1}
                }
                """;

        mockMvc.perform(post("/api/citas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(citaJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testEliminar() throws Exception {
        Long citaId = 1L;

        mockMvc.perform(delete("/api/citas/{id}", citaId))
                .andExpect(status().isOk());
    }
}
