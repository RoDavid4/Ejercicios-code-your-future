package Java.Ejercicios.pooAvanzado.exceptions.ej1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numerador = sc.nextInt();

        try {
            System.out.println(numerador / obtenerDenominador(sc));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Programa finalizado");
        }
    }

    public static int obtenerDenominador(Scanner sc) throws ArithmeticException {

        int denominador = sc.nextInt();
        if (denominador == 0) {
            throw new ArithmeticException("No se puede elegir 0 como divisor ");
        }

        return denominador;
    }
}
