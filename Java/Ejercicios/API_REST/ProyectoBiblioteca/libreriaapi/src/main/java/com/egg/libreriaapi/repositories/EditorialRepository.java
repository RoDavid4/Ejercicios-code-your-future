package com.egg.libreriaapi.repositories;

import com.egg.libreriaapi.entities.Editorial;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, UUID> {

  @Query("SELECT e FROM Editorial e WHERE e.editorialActiva = :activa")
  List<Editorial> editorialActiva(@Param("activa") Boolean activa);
  
}
