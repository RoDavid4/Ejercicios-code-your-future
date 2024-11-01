package Java.Ejercicios.EstructurasDeControl;

import java.util.Scanner;

public class EjerciciosEstucturasCondicionales {

    public static void posNegCero() {
        Scanner miScanner = new Scanner(System.in);
        int miNumero = 0;

        System.out.println("Ingrese un número para verificar si es negativo, positivo o 0");
        // al utilizar (int) se esta transformando el numero de tipo float a int
        miNumero = (int) (miScanner.nextFloat()); // Se trunca el numero con punto flotante a entero
        System.out.println("El numero truncado es: " + miNumero);
        if (miNumero < 0) {
            System.out.println("El número ingresado es negativo");
        } else if (miNumero > 0) {
            System.out.println("El número ingresado es positivo");
        } else {
            System.out.println("El número ingresado es 0");
        }
        miScanner.close();
    }

    public void Calificacion() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresa tu calificación: ");
        int calificacion = leer.nextInt();

        if (calificacion >= 90 && calificacion <= 100) {
            System.out.println("Tu calificación es A");
        } else if (calificacion >= 80 && calificacion < 90) {
            System.out.println("Tu calificación es B");
        } else if (calificacion >= 70 && calificacion < 80) {
            System.out.println("Tu calificación es C");
        } else if (calificacion >= 60 && calificacion < 70) {
            System.out.println("Tu calificación es D");
        } else if (calificacion >= 0 && calificacion < 60) {
            System.out.println("Tu calificación es F");
        } else {
            System.out.println("Calificación no válida");
        }
        leer.close();
    }

    public static void Divisibilidad() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int numero = entrada.nextInt();
        if (numero % 5 == 0 && numero % 3 == 0) {
            System.out.println("El numero es divisible por 3 y por 5");
        } else if (numero % 3 == 0) {
            System.out.println("El numero es divisible por 3");
        } else if (numero % 5 == 0) {
            System.out.println("El numero es divisible por 5");
        } else {
            System.out.println("El numero no es divisible ni por 3 ni por 5");
        }
        entrada.close();
    }

    // Desarrollarás un programa que solicitará al usuario el precio de un producto
    // y determinará si tiene derecho a un descuento.
    // Si el precio es igual o mayor a $100, se aplicará un descuento del 10% y se
    // mostrará el nuevo precio con descuento.
    // De lo contrario, se mostrará el precio original sin descuento.
    public static void descuento() {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa el precio del producto: ");
        float precioLista = leer.nextFloat();

        if (precioLista >= 100) {
            precioLista *= 0.9;
        }

        System.out.println("El precio final del producto es: " + precioLista);

        leer.close();
    }

    // Desarrollarás un programa que solicite al usuario su edad y determine en qué
    // categoría se encuentra.
    // Las categorías son las siguientes:
    // Si la edad es menor de 18 años, mostrar el mensaje "Eres menor de edad".
    // Si la edad está entre 18 y 64 años (inclusive), mostrar el mensaje "Eres
    // adulto".
    // Si la edad es igual o mayor a 65 años, mostrar el mensaje "Eres un adulto
    // mayor".
    // El programa deberá mostrar el mensaje correspondiente según la categoría de
    // edad en la que se encuentre el usuario.

    public static void edades() {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresa tu edad");
        int edad = leer.nextInt();

        if (edad >= 0) {
            if (edad < 18) {
                System.out.println("Eres menor de edad");
            } else if (edad <= 64) {
                System.out.println("Eres adulto");
            } else {
                System.out.println("Eres un adulto mayor");
            }
        } else {
            System.out.println("la edad ingresada no es valida");
        }

        leer.close();
    }
}
