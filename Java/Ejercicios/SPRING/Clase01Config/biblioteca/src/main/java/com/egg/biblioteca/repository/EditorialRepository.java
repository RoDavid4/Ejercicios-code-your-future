package com.egg.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.biblioteca.entities.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, String> {

}
