package com.citasmedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citasmedicas.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
