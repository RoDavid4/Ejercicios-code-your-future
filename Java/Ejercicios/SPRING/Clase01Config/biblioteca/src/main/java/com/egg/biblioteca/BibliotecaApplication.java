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


	public static void main(String[] args) {

		SpringApplication.run(BibliotecaApplication.class, args);
	}

}