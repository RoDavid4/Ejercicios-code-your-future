package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, String> {

}
