package Java.Ejercicios.IntroClases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegradoraII {

    public static void convUnidades() {
        /*
         * Actividad: Conversión de unidades de temperatura
         * Escribe un programa que cumpla con las siguientes condiciones:
         * 
         * 1. Solicita al usuario ingresar una temperatura y una unidad de medida:
         * Celsius (C) o Fahrenheit (F).
         * 
         * 2. Convierte la temperatura a la otra unidad de medida y muestra el resultado
         * en pantalla.
         * 
         * De Celsius a Fahrenheit De Fahrenheit a Celsius
         * [°F] = ([°C] × 9 ⁄ 5) + 32 [°C] = ([°F] − 32) × 5 ⁄ 9
         * 3. El programa debe manejar al menos las siguientes situaciones:
         * 
         * Si ingresa una unidad de medida inválida, mostrará un mensaje de error.
         * 
         * Si ingresa una temperatura no válida, mostrará un mensaje de error.
         */
        System.out.println("\033\143");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese la témperatura: ");
            double temp = sc.nextDouble();
            System.out.println("Ingrese la unidad de medida: F o C");
            char unidad = sc.next().charAt(0);
            switch (unidad) {
                case 'F' -> System.out.println(temp + "° Fahrenheit equivale a " + (temp - 32) * 5 / 9 + "° Celcius");
                case 'C' -> System.out.println(temp + "° Celcius equivale a " + (temp * 9 / 5 + 32) + "° Fahrenheit");
                default -> System.out.println("La unidad de medida ingresada es incorrecta");
            }
            sc.close();
        } catch (InputMismatchException e) {
            System.out.println("El tipo de dato ingresado es incorrecto");
        }
    }

    public static void validContra() {
        /*
         * Actividad:Validación de contraseña
         * Escribe un programa que solicite al usuario que ingrese una contraseña y
         * verifique si cumple con los siguientes criterios para considerarse segura:
         * 
         * La contraseña debe tener al menos 8 caracteres.
         * 
         * La contraseña debe contener al menos una letra mayúscula y una letra
         * minúscula.
         * 
         * La contraseña debe contener al menos un número.
         * 
         * La contraseña debe contener al menos un carácter especial (por ejemplo, !, @,
         * #, $).
         * 
         * El programa debe mostrar un mensaje indicando si la contraseña es segura o
         * no, según los criterios establecidos. Puedes utilizar métodos de la clase
         * String para verificar cada uno de los criterios.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Ingrese una contraseña:");
        String contraseña = sc.nextLine();
        if (contraseña.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
        } else {
            if (contraseña.matches(".*[A-Z].*") && contraseña.matches(".*[a-z].*") &&
                    contraseña.matches(".*[0-9].*") && contraseña.matches(".*[!-~].*")) {
                System.out.println("La contraseña es segura.");
            } else {
                System.out.println("La contraseña no cumple con los criterios de seguridad.");
            }
        } // Casa123! .*C.* .*a.* .*s.* .*a.* .*1.* .*2.* .*3.* .*!.*
        sc.close();
    }

    public static void validContra2() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa una contraseña: ");
        String pw = sc.next();
        boolean correcta = true;

        if (pw.length() < 8) {
            System.out.println("Ingresaste menos de 8 caracteres");
            correcta = false;
        }

        String aux = pw.toLowerCase();
        if (pw.equals(aux)) {
            System.out.println("No ingresaste una mayúscula");
            correcta = false;
        }

        aux = pw.toUpperCase();
        if (pw.equals(aux)) {
            System.out.println("No ingresaste una minúscula");
            correcta = false;
        }

        aux = pw.replaceAll("[0-9]", " ");
        if (pw.equals(aux)) {
            System.out.println("No ingresaste un número");
            correcta = false;
        }

        aux = pw.replaceAll("[a-zA-Z0-9]", "");
        if (aux.length() == 0) {
            System.out.println("No ingresaste un carácter especial");
            correcta = false;
        }

        if (correcta) {
            System.out.println("Ingresaste una contraseña segura");
        } else {
            System.out.println("Ingresaste una contraseña insegura");
        }
        sc.close();
    }
}
