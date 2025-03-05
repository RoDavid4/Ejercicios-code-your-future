package com.egg.biblioteca;

import com.egg.biblioteca.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.egg.biblioteca.entities.*;

import java.util.List;

@SpringBootApplication
public class BibliotecaApplication {
	@Autowired
	private EditorialService eS;
	@Autowired
	private AutorService aS;
	@Autowired
	private LibroService lS;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@PostConstruct
	public void run() {
		List<Editorial> editoriales = eS.listarEditoriales();
		List<Autor> autores = aS.listarAutores();
		List<Libro> libros = lS.listarLibros();
		editoriales.forEach(editorial -> System.out.println(editorial.toString()));
		autores.forEach(autor -> System.out.println(autor.toString()));
		libros.forEach(libro -> System.out.println(libro.toString()));
	}
}