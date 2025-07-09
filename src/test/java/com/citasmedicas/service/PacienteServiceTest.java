package com.citasmedicas.service;

import com.citasmedicas.model.Paciente;
import com.citasmedicas.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class PacienteServiceTest {

    private PacienteRepository pacienteRepository;
    private PacienteService pacienteService;

    @BeforeEach
    void setUp() {
        pacienteRepository = mock(PacienteRepository.class);
        pacienteService = new PacienteService(pacienteRepository); // ✅ usando el constructor
    }

    @Test
    void testListarTodos() {
        Paciente p1 = new Paciente();
        Paciente p2 = new Paciente();
        when(pacienteRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Paciente> resultado = pacienteService.listarTodos();

        assertThat(resultado).hasSize(2);
        verify(pacienteRepository).findAll();
    }

    @Test
    void testObtenerPorId() {
        Long id = 1L;
        Paciente paciente = new Paciente();
        when(pacienteRepository.findById(id)).thenReturn(Optional.of(paciente));

        Optional<Paciente> resultado = pacienteService.obtenerPorId(id);

        assertThat(resultado).isPresent().contains(paciente);
        verify(pacienteRepository).findById(id);
    }

    @Test
    void testGuardar() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente guardado = pacienteService.guardar(paciente);

        assertThat(guardado).isEqualTo(paciente);
        verify(pacienteRepository).save(paciente);
    }

    @Test
    void testEliminar() {
        Long id = 99L;

        pacienteService.eliminar(id);

        verify(pacienteRepository).deleteById(id);
    }
}
