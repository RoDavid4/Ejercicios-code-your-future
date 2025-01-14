package Java.Ejercicios.IntroAPOO.Rectangulo;

import java.util.Scanner;

public class RectanguloTest {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\033\143"); // Limpia la pantalla
        menu();
    }

    /*
     * Desarrolla un menú interactivo que permita al usuario crear instancias de
     * 'Rectangulo' y acceder a sus métodos para obtener información relevante.
     */
    public static void menu() {
        char opcion;
        Rectangulo[] rectangulos = new Rectangulo[10];
        do {
            System.out.println("\n\nMenú de opciones");
            System.out.println("1. Crear un rectángulo");
            System.out.println("2. Mostrar cantidad de rectángulos");
            System.out.println("3. Calcular el área del rectángulo");
            System.out.println("4. Calcular el perímetro del rectángulo");
            System.out.println("5. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = scan.next().charAt(0);
            switch (opcion) {
                case '1' -> {
                    if (Rectangulo.getCantidadRectangulos() > 9) {
                        System.out.println("\nNo se pueden crear más rectángulos");
                    } else {
                        System.out.print("\nIngrese la longitud del lado A: ");
                        int ladoA = scan.nextInt();
                        System.out.print("\nIngrese la longitud del lado B: ");
                        int ladoB = scan.nextInt();
                        rectangulos[Rectangulo.getCantidadRectangulos()] = new Rectangulo(ladoA, ladoB);
                    }
                }
                case '2' -> System.out.println("\nCantidad de rectángulos: " + Rectangulo.getCantidadRectangulos());
                case '3' -> {
                    for (int i = 0; i < Rectangulo.getCantidadRectangulos(); i++) {
                        System.out.println("\nRespecto del rectángulo: " + (i + 1) + " es: ");
                        rectangulos[i].imprimirArea();
                    }
                }
                case '4' -> {
                    for (int i = 0; i < Rectangulo.getCantidadRectangulos(); i++) {
                        System.out.println("\nRespecto del rectángulo: " + (i + 1) + " es: ");
                        rectangulos[i].imprimirPerimetro();
                    }
                }
                case '5' -> System.out.println("\nSaliendo...");
                default -> System.out.println("\nOpción inválida");
            }
        } while (opcion != '5');
    }
}
