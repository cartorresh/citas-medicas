package com.citasmedicas.service;

import com.citasmedicas.model.Cita;
import com.citasmedicas.repository.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class CitaServiceTest {

    private CitaRepository citaRepository;
    private CitaService citaService;

    @BeforeEach
    void setUp() {
        citaRepository = mock(CitaRepository.class);
        citaService = new CitaService(citaRepository);
    }

    @Test
    void testListarTodas() {
        Cita cita1 = new Cita();
        Cita cita2 = new Cita();
        when(citaRepository.findAll()).thenReturn(Arrays.asList(cita1, cita2));

        List<Cita> resultado = citaService.listarTodas();

        assertThat(resultado).hasSize(2);
        verify(citaRepository).findAll();
    }

    @Test
    void testGuardarCita() {
        Cita cita = new Cita();
        when(citaRepository.save(cita)).thenReturn(cita);

        Cita guardada = citaService.guardar(cita);

        assertThat(guardada).isEqualTo(cita);
        verify(citaRepository).save(cita);
    }

    @Test
    void testEliminarCita() {
        Long citaId = 1L;

        citaService.eliminar(citaId);

        verify(citaRepository).deleteById(citaId);
    }
}
