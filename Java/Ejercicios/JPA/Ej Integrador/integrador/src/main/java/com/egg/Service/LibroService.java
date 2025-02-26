package com.egg.Service;

import com.egg.Entity.Libro;
import com.egg.Persistence.LibroDAO;
import java.util.List;

public class LibroService {
    private final LibroDAO libroDAO;

    public LibroService() {
        libroDAO = new LibroDAO();
    }

    public void guardarLibro(Libro libro) {
        try {
            validarCamposObligatorios(libro);
            if (esDuplicado(libro)) {
                throw new Exception("El libro ya existe.");
            }
            libroDAO.guardarLibro(libro);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void actualizarLibro(Libro libro) {
        try {
            validarCamposObligatorios(libro);
            libroDAO.actualizarLibro(libro);
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        try {
            libroDAO.eliminarLibro(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void darBajaLibro(int id) {
        try {
            libroDAO.darBajaLibro(id);
        } catch (Exception e) {
            System.out.println("Error al dar de baja: " + e.getMessage());
        }
    }

    public void darAltaLibro(int id) {
        try {
            libroDAO.darAltaLibro(id);
        } catch (Exception e) {
            System.out.println("Error al dar de alta: " + e.getMessage());
        }
    }

    public Libro buscarLibro(int id) {
        try {
            return libroDAO.buscarLibro(id);
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> obtenerListaLibros() {
        try {
            return libroDAO.obtenerListaLibros();
        } catch (Exception e) {
            System.out.println("Error al obtener: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> obtenerLibrosPorAutor(String nombre) {
        try {
            return libroDAO.obtenerLibrosPorAutor(nombre);
        } catch (Exception e) {
            System.out.println("Error al obtener libros por autor: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> obtenerLibrosPorEditorial(String nombre) {
        try {
            return libroDAO.obtenerLibrosPorEditorial(nombre);
        } catch (Exception e) {
            System.out.println("Error al obtener libros por editorial: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> obtenerLibrosPorTitulo(String titulo) {
        try {
            return libroDAO.obtenerLibrosPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println("Error al obtener libros por título: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> obtenerLibrosPorIsbn(Long isbn) {
        try {
            return libroDAO.obtenerLibrosPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println("Error al obtener libros por ISBN: " + e.getMessage());
            return null;
        }
    }

    private void validarCamposObligatorios(Libro libro) throws Exception {
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
            throw new Exception("El título del libro es obligatorio.");
        }
        if (libro.getAutor() == null) {
            throw new Exception("El autor del libro es obligatorio.");
        }
        if (libro.getIsbn() == null) {
            throw new Exception("El ISBN del libro es obligatorio.");
        }
    }

    private boolean esDuplicado(Libro libro) {
        List<Libro> librosExistentes = libroDAO.obtenerLibrosPorIsbn(libro.getIsbn());
        return !librosExistentes.isEmpty();
    }
}
