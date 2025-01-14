package Java.Ejercicios.pooAvanzado.integrador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("\033\143");
        do {
            System.out.println("---- Menú de Biblioteca ----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar catálogo");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Número de páginas: ");
                    int numeroDePaginas = scanner.nextInt();
                    System.out.println("¿Está prestado el libro? (S/N)");
                    String prestado = scanner.nextLine();

                    if (prestado.equalsIgnoreCase("S")) {
                        biblioteca.agregarLibro(new Libro(titulo, autor, numeroDePaginas, true));
                    } else {
                        biblioteca.agregarLibro(new Libro(titulo, autor, numeroDePaginas, false));
                    }
                    break;

                case 2:
                    biblioteca.mostrarCatalogo();
                    break;

                case 3:
                    System.out.print("Ingrese el título del libro que desea pedir: ");
                    String nombreLibro = scanner.nextLine();
                    if (biblioteca.prestarLibro(nombreLibro)) {
                        System.out.println("El libro ha sido prestado con éxito.");
                    } else {
                        System.out.println("El libro no existe en el catálogo.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el título del libro que desea devolver: ");
                    String nombreLibroDevolver = scanner.nextLine();
                    if (biblioteca.devolverLibro(nombreLibroDevolver)) {
                        System.out.println("El libro ha sido devuelto con éxito.");
                    } else {
                        System.out.println("El libro no existe en el catálogo.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();
    }

}