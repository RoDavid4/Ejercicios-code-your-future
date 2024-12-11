package Java.Ejercicios.IntroAPOO.modelos;

import java.util.Scanner;

public class FiguraTest {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\033\143"); // Limpia la pantalla
        menuPrincipal();
    }

    public static void menuPrincipal() {
        char opcion;
        do {
            System.out.println("\n\nMenú Principal");
            System.out.println("1. Trabajar con Rectángulo");
            System.out.println("2. Trabajar con Triángulo");
            System.out.println("3. Trabajar con Círculo");
            System.out.println("4. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = scan.next().charAt(0);
            switch (opcion) {
                case '1' -> menuRectangulo();
                case '2' -> menuTriangulo();
                case '3' -> menuCirculo();
                case '4' -> System.out.println("\nSaliendo...");
                default -> System.out.println("\nOpción inválida");
            }
        } while (opcion != '4');
    }

    public static void menuRectangulo() {
        char opcion;
        Rectangulo[] rectangulos = new Rectangulo[10];
        do {
            System.out.println("\n\nMenú Rectángulo");
            System.out.println("1. Crear un rectángulo");
            System.out.println("2. Mostrar cantidad de rectángulos");
            System.out.println("3. Calcular el área del rectángulo");
            System.out.println("4. Calcular el perímetro del rectángulo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("\nIngrese una opción: ");
            opcion = scan.next().charAt(0);
            switch (opcion) {
                case '1' -> {
                    if (Rectangulo.getCantidadRectangulos() > 9) {
                        System.out.println("\nNo se pueden crear más rectángulos");
                    } else {
                        System.out.print("\nIngrese la longitud del lado A: ");
                        double ladoA = scan.nextDouble();
                        System.out.print("\nIngrese la longitud del lado B: ");
                        double ladoB = scan.nextDouble();
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
                case '5' -> System.out.println("\nVolviendo al Menú Principal...");
                default -> System.out.println("\nOpción inválida");
            }
        } while (opcion != '5');
    }

    public static void menuTriangulo() {
        char opcion;
        Triangulo[] triangulos = new Triangulo[10];
        do {
            System.out.println("\n\nMenú Triángulo");
            System.out.println("1. Crear un triángulo");
            System.out.println("2. Mostrar cantidad de triángulos");
            System.out.println("3. Calcular el área del triángulo");
            System.out.println("4. Calcular el perímetro del triángulo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("\nIngrese una opción: ");
            opcion = scan.next().charAt(0);
            switch (opcion) {
                case '1' -> {
                    if (Triangulo.getCantidadTriangulos() > 9) {
                        System.out.println("\nNo se pueden crear más triángulos");
                    } else {
                        System.out.print("\nIngrese la longitud de la base: ");
                        double base = scan.nextDouble();
                        System.out.print("\nIngrese la altura: ");
                        double altura = scan.nextDouble();
                        System.out.print("\nIngrese la longitud del lado 1: ");
                        double lado1 = scan.nextDouble();
                        System.out.print("\nIngrese la longitud del lado 2: ");
                        double lado2 = scan.nextDouble();
                        System.out.print("\nIngrese la longitud del lado 3: ");
                        double lado3 = scan.nextDouble();
                        triangulos[Triangulo.getCantidadTriangulos()] = new Triangulo(base, altura, lado1, lado2, lado3);
                    }
                }
                case '2' -> System.out.println("\nCantidad de triángulos: " + Triangulo.getCantidadTriangulos());
                case '3' -> {
                    for (int i = 0; i < Triangulo.getCantidadTriangulos(); i++) {
                        System.out.println("\nRespecto del triángulo: " + (i + 1) + " es: ");
                        triangulos[i].imprimirArea();
                    }
                }
                case '4' -> {
                    for (int i = 0; i < Triangulo.getCantidadTriangulos(); i++) {
                        System.out.println("\nRespecto del triángulo: " + (i + 1) + " es: ");
                        triangulos[i].imprimirPerimetro();
                    }
                }
                case '5' -> System.out.println("\nVolviendo al Menú Principal...");
                default -> System.out.println("\nOpción inválida");
            }
        } while (opcion != '5');
    }

    public static void menuCirculo() {
        char opcion;
        Circulo[] circulos = new Circulo[10];
        do {
            System.out.println("\n\nMenú Círculo");
            System.out.println("1. Crear un círculo");
            System.out.println("2. Mostrar cantidad de círculos");
            System.out.println("3. Calcular el área del círculo");
            System.out.println("4. Calcular la circunferencia del círculo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("\nIngrese una opción: ");
            opcion = scan.next().charAt(0);
            switch (opcion) {
                case '1' -> {
                    if (Circulo.getCantidadCirculos() > 9) {
                        System.out.println("\nNo se pueden crear más círculos");
                    } else {
                        System.out.print("\nIngrese el radio del círculo: ");
                        double radio = scan.nextDouble();
                        circulos[Circulo.getCantidadCirculos()] = new Circulo(radio);
                    }
                }
                case '2' -> System.out.println("\nCantidad de círculos: " + Circulo.getCantidadCirculos());
                case '3' -> {
                    for (int i = 0; i < Circulo.getCantidadCirculos(); i++) {
                        System.out.println("\nRespecto del círculo: " + (i + 1) + " es: ");
                        circulos[i].imprimirArea();
                    }
                }
                case '4' -> {
                    for (int i = 0; i < Circulo.getCantidadCirculos(); i++) {
                        System.out.println("\nRespecto del círculo: " + (i + 1) + " es: ");
                        circulos[i].imprimirCircunferencia();
                    }
                }
                case '5' -> System.out.println("\nVolviendo al Menú Principal...");
                default -> System.out.println("\nOpción inválida");
            }
        } while (opcion != '5');
    }
}
