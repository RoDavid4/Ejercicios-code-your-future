package Java.Ejercicios.pooAvanzado.integrador;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido agregado al catálogo.");
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de libros:");
            for (Libro libro : catalogo) {
                libro.mostrarInformacion();
            }
        }
    }

    public boolean prestarLibro(String titulo) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isPrestado()) {
                    return false;
                } else {
                    libro.setPrestado(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean devolverLibro(String titulo) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isPrestado()) {
                    libro.setPrestado(false);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
}
