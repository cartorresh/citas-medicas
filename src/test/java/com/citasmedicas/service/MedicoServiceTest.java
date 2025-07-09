package com.citasmedicas.service;
import com.citasmedicas.model.Medico;
import com.citasmedicas.repository.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class MedicoServiceTest {

    private MedicoRepository medicoRepository;
    private MedicoService medicoService;

    @BeforeEach
    void setUp() {
        medicoRepository = mock(MedicoRepository.class);
        medicoService = new MedicoService(medicoRepository);
    }

    @Test
    void testListarTodos() {
        Medico m1 = new Medico();
        Medico m2 = new Medico();
        when(medicoRepository.findAll()).thenReturn(Arrays.asList(m1, m2));

        List<Medico> resultado = medicoService.listarTodos();

        assertThat(resultado).hasSize(2);
        verify(medicoRepository).findAll();
    }

    @Test
    void testGuardar() {
        Medico medico = new Medico();
        when(medicoRepository.save(medico)).thenReturn(medico);

        Medico guardado = medicoService.guardar(medico);

        assertThat(guardado).isEqualTo(medico);
        verify(medicoRepository).save(medico);
    }

    @Test
    void testEliminar() {
        Long id = 10L;

        medicoService.eliminar(id);

        verify(medicoRepository).deleteById(id);
    }
}
