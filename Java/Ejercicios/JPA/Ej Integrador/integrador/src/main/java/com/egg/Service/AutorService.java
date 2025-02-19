package com.egg.Service;

import com.egg.Entity.Autor;
import com.egg.Persistence.AutorDAO;

import java.util.List;

public class AutorService {
    private final AutorDAO autorDAO;

    public AutorService() {
        this.autorDAO = new AutorDAO();
    }

    public void guardarAutor(Autor autor) {
        try {
            validarCamposObligatorios(autor);
            if (esDuplicado(autor)) {
                throw new Exception("El autor ya existe.");
            }
            autorDAO.guardarAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void actualizarAutor(Autor autor) {
        try {
            validarCamposObligatorios(autor);
            autorDAO.actualizarAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public Autor buscarAutor(int id) {
        try {
            return autorDAO.buscarAutor(id);
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
            return null;
        }
    }

    public List<Autor> obtenerAutores() {
        try {
            return autorDAO.obtenerListaAutores();
        } catch (Exception e) {
            System.out.println("Error al obtener: " + e.getMessage());
            return null;
        }
    }

    public void darAltaAutor(int id) {
        try {
            Autor a = autorDAO.buscarAutor(id);
            a.setAlta(true);
            autorDAO.actualizarAutor(a);
        } catch (Exception e) {
            System.out.println("Error al dar de alta: " + e.getMessage());
        }
    }

    public void darBajaAutor(int id) {
        try {
            Autor a = autorDAO.buscarAutor(id);
            a.setAlta(false);
            autorDAO.actualizarAutor(a);
        } catch (Exception e) {
            System.out.println("Error al dar de baja: " + e.getMessage());
        }
    }

    public void eliminarAutor(int id) {
        try {
            autorDAO.eliminarAutor(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void imprimirListaAutores() {
        try {
            List<Autor> autores = autorDAO.obtenerListaAutores();
            for (Autor autor : autores) {
                System.out.println(autor.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al imprimir lista: " + e.getMessage());
        }
    }

    private void validarCamposObligatorios(Autor autor) throws Exception {
        if (autor.getNombre() == null || autor.getNombre().isEmpty()) {
            throw new Exception("El nombre del autor es obligatorio.");
        }
        
    }

    private boolean esDuplicado(Autor autor) {
        Autor autoresExistentes = autorDAO.buscarAutor(autor.getId());
        return !(autoresExistentes == null);
    }
}
