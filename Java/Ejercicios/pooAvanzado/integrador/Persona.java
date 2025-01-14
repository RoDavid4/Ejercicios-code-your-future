package Java.Ejercicios.pooAvanzado.integrador;

import java.util.ArrayList;

public class Persona {
    public String nombre;
    public String apellido;
    public ArrayList<Libro> librosPrestados;

    // Constructor
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosPrestados = new ArrayList<>();
    }

}
