package Java.Ejercicios.EstructurasDeControl;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Condicionales3BloqueTryCatch {

    public static void divSegura() {
        Scanner pepe = new Scanner(System.in);
        int numero1, numero2;
        double resultado;

        try {
            System.out.print("Ingrese el primer número: ");
            numero1 = pepe.nextInt();
            System.out.println("Ingrese el segundo numero: ");
            numero2 = pepe.nextInt();
            resultado = (double) numero1 / (double) numero2;
            // Posible división por cero
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No es posible dividir por 0.");
        } catch (InputMismatchException e) {
            System.out.println(
                    "Error: Se ingreso un tipo de dato no valido. Se esperaba int y se ingreso otro tipo de dato");
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
        System.out.println("¡Gracias! ");
        pepe.close();
    }

    public static void restaSegura() {
        Scanner pepe = new Scanner(System.in);
        double numero1, numero2;
        double resultado;

        try {
            System.out.print("Ingrese el primer número: ");
            numero1 = pepe.nextDouble();
            System.out.print("Ingrese el segundo numero: ");
            numero2 = pepe.nextDouble();
            resultado = numero1 - numero2;
            System.out.println("El resultado es: " + resultado);
        } catch (InputMismatchException e) {
            System.out.println(
                    "Error: el tipo de dato ingresado no es correcto");
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
        System.out.println("¡Gracias! ");
        pepe.close();
    }

    public static void convertirAString() {
        Scanner pepe = new Scanner(System.in);
        String numero = "";
        int convertido;

        try {
            System.out.print("Ingrese una cadena de caracteres que represente un número: ");
            numero = pepe.nextLine();
            convertido = Integer.parseInt(numero);
            System.out.print("Se realizo la conversion del numero " + convertido + " con exito");
        } catch (NumberFormatException e) {
            System.out.println(
                    "Error: Un caracter ingresado no es valido");
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
        System.out.println("¡Gracias! ");
        pepe.close();
    }
}
