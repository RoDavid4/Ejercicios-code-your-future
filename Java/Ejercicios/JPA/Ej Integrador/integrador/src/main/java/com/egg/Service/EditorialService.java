package com.egg.Service;

import java.util.List;

import com.egg.Entity.Editorial;
import com.egg.Persistence.EditorialDAO;

public class EditorialService {
    private final EditorialDAO EditorialDAO;

    public EditorialService() {
        this.EditorialDAO = new EditorialDAO();
    }

    public void guardarEditorial(Editorial editorial) {
        try {
            validarCamposObligatorios(editorial);
            if (esDuplicado(editorial)) {
                throw new Exception("La editorial ya existe.");
            }
            EditorialDAO.guardarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void actualizarEditorial(Editorial editorial) {
        try {
            validarCamposObligatorios(editorial);
            EditorialDAO.actualizarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public Editorial buscarEditorial(int id) {
        try {
            return EditorialDAO.buscarEditorial(id);
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
            return null;
        }
    }

    public List<Editorial> obtenerEditoriales() {
        try {
            return EditorialDAO.obtenerListaEditoriales();
        } catch (Exception e) {
            System.out.println("Error al obtener: " + e.getMessage());
            return null;
        }
    }

    public void darAltaEditorial(int id) {
        try {
            Editorial a = EditorialDAO.buscarEditorial(id);
            a.setAlta(true);
            EditorialDAO.actualizarEditorial(a);
        } catch (Exception e) {
            System.out.println("Error al dar de alta: " + e.getMessage());
        }
    }

    public void darBajaEditorial(int id) {
        try {
            Editorial a = EditorialDAO.buscarEditorial(id);
            a.setAlta(false);
            EditorialDAO.actualizarEditorial(a);
        } catch (Exception e) {
            System.out.println("Error al dar de baja: " + e.getMessage());
        }
    }

    public void eliminarEditorial(int id) {
        try {
            EditorialDAO.eliminarEditorial(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void imprimirListaEditoriales() {
        try {
            List<Editorial> Editoriales = EditorialDAO.obtenerListaEditoriales();
            for (Editorial Editorial : Editoriales) {
                System.out.println(Editorial.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al imprimir lista: " + e.getMessage());
        }
    }

    public List<Editorial> buscarEditorialPorNombre(String nombre) {
        return EditorialDAO.buscarEditorialPorNombre(nombre);
    }

    private void validarCamposObligatorios(Editorial editorial) throws Exception {
        if (editorial.getNombre() == null || editorial.getNombre().isEmpty()) {
            throw new Exception("El nombre de la editorial es obligatorio.");
        }
    }

    private boolean esDuplicado(Editorial editorial) {
        List<Editorial> editorialesExistentes = EditorialDAO.buscarEditorialPorNombre(editorial.getNombre());
        return !editorialesExistentes.isEmpty();
    }
}

