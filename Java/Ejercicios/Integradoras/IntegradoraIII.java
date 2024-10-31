package Java.Ejercicios.Integradoras;

import java.util.Arrays;
import java.util.Scanner;

public class IntegradoraIII {

    public static void genPass() {
        /*
         * Actividad: Generando contraseñas
         * Vas a desarrollar un programa en Java que genere una contraseña aleatoria.
         * Esta contraseña estará compuesta por una mezcla de letras mayúsculas, letras
         * minúsculas y dígitos. La contraseña será almacenada en un arreglo de
         * caracteres.
         * 
         * Para generar la contraseña, utilizarás un bucle for que repetirá la operación
         * tantas veces como la longitud de la contraseña especificada por el usuario.
         * 
         * Para asegurarte de que la contraseña generada contenga al menos una letra
         * mayúscula, una letra minúscula y un dígito, usaré bucles do-while y while
         * junto con los métodos isUpperCase, isLowerCase e isDigit de la clase
         * Character.
         * 
         * Finalmente, convertirás el arreglo de caracteres en un String con un bucle
         * for y luego imprimirás la contraseña generada en la consola.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        int longitud;

        do { // Si la contraseña fuera menor a 3 no podria incluir una MAY una min y un NUM
            System.out.print(
                    "Ingrese la longitud de la contraseña, la misma debe de ser de al menos 3 (tres) caracteres ");
            longitud = sc.nextInt();
        } while (longitud < 3);

        char[] pass = new char[longitud];
        int mayusculas, minusculas, digitos;
        int cont;
        String password;

        do {
            mayusculas = 0;
            minusculas = 0;
            digitos = 0;
            password = "";
            char c;
            for (int i = 0; i < longitud; i++) {
                do {
                    c = (char) (Math.random() * 74 + 48);
                } while ((c <= 96 && c >= 91) || (c <= 64 && c >= 58));
                pass[i] = c;
            }

            /*
             * for (int i = 0; i < longitud; i++) { // De testeo
             * password += pass[i];
             * }
             * System.out.println("La contraseña tentativa generada es: " + password);
             * password = "";
             */

            cont = 0;
            while ((mayusculas == 0 || minusculas == 0 || digitos == 0) && cont < longitud) {
                if (Character.isUpperCase(pass[cont])) {
                    mayusculas++;
                } else if (Character.isLowerCase(pass[cont])) {
                    minusculas++;
                } else if (Character.isDigit(pass[cont])) {
                    digitos++;
                }
                cont++;
            }
        } while (mayusculas == 0 || minusculas == 0 || digitos == 0);
        sc.close();
        for (int i = 0; i < longitud; i++) {
            password += pass[i];
        }
        System.out.println("La contraseña generada es: " + password);
    }

    public static void estadCalif() {
        /*
         * Actividad: Estadísticas de calificaciones
         * Vas a desarrollar un programa en Java que genere un arreglo de calificaciones
         * de manera aleatoria. Estas calificaciones se almacenarán en un arreglo de
         * Strings.
         * 
         * Una vez generado el arreglo, el programa deberá generar 3 arreglos nuevos,
         * separando las calificaciones entre desaprobado (< 4), aprobado (>= 4), y
         * excelente (>=10). Necesitarás convertir los String a double para lograrlo.
         * 
         * Luego calcula el promedio del arreglo original y de cada uno de los nuevos
         * arreglos.
         * 
         * Por último, imprimiré los resultados en consola.
         * 
         * ¡Que te diviertas resolviendo este desafío!
         */
        System.out.println("\033\143");
        int longitud = 20;
        String[] original = new String[longitud];
        double[] desaprobado = new double[longitud];
        double[] aprobado = new double[longitud];
        double[] excelente = new double[longitud];
        double[] promedios = new double[4];
        double[] cantidades = { 0, 0, 0 };
        double[] sumas = { 0, 0, 0, 0 };

        for (int i = 0; i < longitud; i++) {
            double calif = (int) (Math.random() * 11);
            original[i] = String.valueOf(calif);
        }

        for (int i = 0; i < longitud; i++) {
            sumas[0] += Double.parseDouble(original[i]);
            if (Double.parseDouble(original[i]) < 4) {
                desaprobado[(int) cantidades[0]] = Double.parseDouble(original[i]);
                cantidades[0]++;
                sumas[1] += Double.parseDouble(original[i]);
            } else if (Double.parseDouble(original[i]) < 10) {
                aprobado[(int) cantidades[1]] = Double.parseDouble(original[i]);
                cantidades[1]++;
                sumas[2] += Double.parseDouble(original[i]);
            } else {
                excelente[(int) cantidades[2]] = Double.parseDouble(original[i]);
                cantidades[2]++;
                sumas[3] += Double.parseDouble(original[i]);
            }
        }
        promedios[0] = sumas[0] / longitud;
        promedios[1] = sumas[1] / cantidades[0];
        promedios[2] = sumas[2] / cantidades[1];
        promedios[3] = sumas[3] / cantidades[2];
        System.out.println("Lista original " + Arrays.toString(original));
        System.out.println("Lista desaprobados " + Arrays.toString(desaprobado));
        System.out.println("Lista aprobados " + Arrays.toString(aprobado));
        System.out.println("Lista excelentes " + Arrays.toString(excelente));
        System.out.println("Promedio de la lista original: " + promedios[0]);
        System.out.println("Promedio de la lista desaprobado: " + promedios[1]);
        System.out.println("Promedio de la lista aprobado: " + promedios[2]);
        System.out.println("Promedio de la lista excelente: " + promedios[3]);
    }

    public static void fibbo() {
        /*
         * Actividad:Fibonacci
         * Escribe un programa que imprima los primeros 8 términos de la serie de
         * Fibonacci utilizando un bucle while. La serie de Fibonacci es una secuencia
         * en la que cada número es la suma de los dos anteriores.
         * 
         * La serie de Fibonacci comienza de la siguiente manera:
         * 
         * Posición 0: 0
         * 
         * Posición 1: 1
         * 
         * Posición 2: 1 (la suma de la posición 0 y la posición 1, 0 + 1 = 1)
         * 
         * Posición 3: 2 (la suma de la posición 1 y la posición 2, 1 + 1 = 2)
         * 
         * Posición 4: 3 (la suma de la posición 2 y la posición 3, 1 + 2 = 3)
         * 
         * Entonces, los primeros 5 términos (considerando el índice inicial 0) de la
         * serie de Fibonacci son: 0, 1, 1, 2, 3.
         */
        System.out.println("\033\143");
        int a = 0, b = 1, i = 0;
        while (i <= 8) {
            System.out.println(a);
            int aux = a; // primer valor
            a = b;
            b = aux + b;
            i++;
        }
    }

    public static void numPrimos() {
        /*
         * Actividad: Números primos
         * Escribe un programa que solicite al usuario que introduzca un número y
         * verifique si es un número primo utilizando un bucle do-while. Si el número no
         * es primo, pedir al usuario que introduzca otro número hasta que introduzca un
         * número primo. Finalizar el programa cuando ingrese 0 (cero).
         * 
         * Un número es primo si solo tiene dos divisores: 1 y él mismo.
         */
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        int num, i;
        boolean primo;
        do {
            primo = true;
            System.out.println("Ingrese un número o 0 para salir: ");
            num = sc.nextInt();
            if (num == 0) {
                System.out.println("El programa ha finalizado");
            } else if (num < 2) {
                System.out.println("El número no es primo");
                primo = false;
            } else {
                i = 2;
                while (i < num && primo == true) {
                    if (num % i == 0) {
                        System.out.println("El número no es primo");
                        primo = false;
                    }
                    i++;
                }
                if (primo == true) {
                    System.out.println("El número es primo, el programa ha finalizado");
                }
            }
        } while (num != 0 && primo == false);
        sc.close();
    }
}
