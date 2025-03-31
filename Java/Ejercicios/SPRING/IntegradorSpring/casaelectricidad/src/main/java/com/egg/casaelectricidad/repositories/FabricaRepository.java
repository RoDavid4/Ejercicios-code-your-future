package com.egg.casaelectricidad.repositories;

import com.egg.casaelectricidad.entities.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, UUID> {
}
