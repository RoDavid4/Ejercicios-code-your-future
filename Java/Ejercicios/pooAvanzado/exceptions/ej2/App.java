package Java.Ejercicios.pooAvanzado.exceptions.ej2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("El nombre es " + obtenerNombre(sc));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }

    public static String obtenerNombre(Scanner sc) throws Exception {

        System.out.println("ingrese el nombre");
        String nombre = sc.nextLine();
        if (nombre.length() < 2) {
            throw new Exception("El nombre es muy corto ");
        }

        return nombre;

    }
}
