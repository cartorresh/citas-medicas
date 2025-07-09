package com.citasmedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasmedicas.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
