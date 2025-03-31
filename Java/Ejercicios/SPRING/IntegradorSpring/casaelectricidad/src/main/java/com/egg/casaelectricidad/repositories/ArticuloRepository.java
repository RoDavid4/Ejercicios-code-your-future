package com.egg.casaelectricidad.repositories;

import com.egg.casaelectricidad.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, UUID> {

    @Query("SELECT MAX(a.nroArticulo) FROM Articulo a")
    Optional<Integer> findMaxNroArticulo();

    @Query("SELECT a FROM Articulo a WHERE a.nroArticulo = :nroArticulo")
    Optional<Articulo> findByNroArticulo(@Param("nroArticulo") Integer nroArticulo);

}
