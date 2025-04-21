package com.egg.libreriaapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
    
    @Query("SELECT a FROM Autor a WHERE a.autorActivo = :activo")
  List<Autor> autorActivo(@Param("activo") Boolean activo);
}
