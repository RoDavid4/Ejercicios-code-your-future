package Java.Ejercicios.introMetodos;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MetodosIII {

    public static Scanner scan = new Scanner(System.in);
    /*
     * Actividad: Fibonacci y recursividad
     * Reorganiza el código extrayendo la lógica en métodos sin alterar su
     * funcionamiento. Después, intenta modificar la lógica para resolverlo de forma
     * recursiva.
     */

    public static void fibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("De que numero se quiere calcular el Fibonacci?");
        int n = sc.nextInt();
        System.out.println("El fibonacci de " + n + " es: " + fiboAux(n));
        sc.close();
    }

    private static int fiboAux(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fiboAux(num - 1) + fiboAux(num - 2);
        }
    }

    /*
     * Actividad: Factorial y recursividad
     * Crea un método llamado "factorial()" que tome un parámetro de tipo "int" y
     * devuelva un valor entero que corresponda al cálculo del factorial del número
     * proporcionado. Posteriormente, intenta modificar la lógica para resolverlo de
     * manera recursiva.
     */

    public static void factorial() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el numero del que quiere el factorial");
        int num = scan.nextInt();

        int resultado = factorialRecursivo(num);
        System.out.println("El factorial de " + num + " es " + resultado);

        scan.close();
    }

    private static int factorialRecursivo(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorialRecursivo(num - 1);
        }
    }

    /*
     * Actividad: Números primos y recursividad
     * Crea un método llamado "esPrimo()" que reciba por parámetro un "int" y
     * devuelva un valor booleano que verifique si el número es primo o no. Luego,
     * intenta modificar la lógica para resolverlo utilizando recursividad.
     */

    public static void esPrimo(int numero) {
        boolean esPrimo = esPrimoRec(numero, 2);
        System.out.println("¿Es " + numero + " un número primo? " + esPrimo);
    }

    private static boolean esPrimoRec(int numero, int divisor) {
        // Caso base: si el número es menor o igual a 2, solo 2 es primo
        if (numero <= 2) {
            return (numero == 2);
        }
        // Si el número es divisible por el divisor actual, no es primo
        if (numero % divisor == 0) {
            return false;
        }
        // Si el divisor llega a la raíz cuadrada del número, entonces es primo
        if (divisor * divisor > numero) {
            return true;
        }
        // Llamada recursiva
        return esPrimoRec(numero, divisor + 1);
    }

    /*
     * Actividad: Manipular oraciones
     * Crea un método para generar el menú y otro método separado para resolver cada
     * opción. Si es necesario, puedes crear más métodos adicionales para mejorar la
     * modularidad y claridad del código.
     */

    // Ejercicio resuelto de esta manera en
    // Ejercicios.Integradoras.IntegradoraV.java

    /*
     * Juego de Adivinar Palabra:
     * 
     * Escribe un programa que implemente un juego en el que el usuario debe
     * adivinar una palabra aleatoria. El programa elegirá una palabra al azar de
     * una lista predefinida y mostrará una pista de la longitud de la palabra. El
     * usuario tendrá un número limitado de intentos para adivinar la palabra.
     * Después de cada intento, el programa mostrará cuántas letras ha adivinado
     * correctamente y en qué posición se encuentran.
     * 
     * El programa debe tener las siguientes características:
     * 
     * Utiliza un array de Strings para almacenar una lista de palabras
     * predefinidas.
     * 
     * Utiliza el método Math.random() para seleccionar una palabra aleatoria del
     * array.
     * 
     * Implementa un método para obtener una pista de la palabra seleccionada. Por
     * ejemplo, si la palabra es "casa", la pista podría ser "_ _ _ _" (cuatro
     * guiones bajos).
     * 
     * Implementa un método para comprobar si una letra ingresada por el usuario
     * está presente en la palabra seleccionada y en qué posición se encuentra.
     * 
     * Utiliza un bucle para permitir al usuario ingresar sus intentos hasta que
     * adivine la palabra o se agoten los intentos.
     * 
     * Muestra un mensaje al usuario al final del juego indicando si adivinó la
     * palabra correctamente o no, y muestra la palabra completa.
     */

    public static void ahorcado() {
        String[] palabras = { "casa", "perro", "gato", "palo", "murcielago", "castillo", "programacion", "variable",
                "constante", "bucle", "datos" };
        int intentos = 3, pistas = 0;
        String palabra = randomizarPalabra(palabras);
        char[] pista = generarPista(palabra);
        boolean win = false;
        char menu;
        do {
            System.out.println("\033\143"); // Limpia la pantalla
            System.out.println("Pista : " + new String(pista) + "\t pistas utilizadas: " + pistas
                    + " de 3" + "\t vidas restantes: " + intentos);
            System.out.print(
                    "\n 1 Para pedir pista \n 2 Para arriezgar letra \n 3 Para arriezgar palabra \n 4 Para Salir \n \n ->  ");
            menu = scan.nextLine().charAt(0);
            switch (menu) {
                case '1' -> pistas = getPista(pistas, palabra, pista);
                case '2' -> {
                    intentos = arriezgarLetra(pista, palabra, intentos);
                    if (new String(pista).equals(palabra)) {
                        intentos = 99; // Si al arriezgar letra se encontro la palabra completa
                        System.out.println(
                                "\n Felicidades, acertaste la palabra, ganaste!, presiona enter para continuar");
                        scan.nextLine();
                    }
                }
                case '3' -> intentos = arriezgarPalabra(palabra, intentos);
                case '4' -> intentos = -1;
                default -> {
                    System.out.println("\n Opcion incorrecta, presiona enter para continuar.");
                    scan.nextLine();
                }
            }

            switch (intentos) {
                case 99 -> win = true;
                case 0 -> System.out.println("Sin vidas restantes, has perdido, la palabra era: " + palabra);
            }

        } while (!win && intentos > 0);
        scan.close();
    }

    private static String randomizarPalabra(String[] palabras) {
        return palabras[(int) (Math.random() * palabras.length)];
    }

    private static char[] generarPista(String palabra) {
        char[] letras = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = '_';
        }
        return letras;
    }

    private static int getPista(int pistas, String palabra, char[] pista) {
        char letra;
        boolean menu = false;
        switch (pistas) {
            case 0:
                do {
                    System.out.print("\n Elige una vocal ->  ");
                    letra = scan.nextLine().toLowerCase().charAt(0);
                    if (esVocal(letra)) {
                        menu = true;
                        if (!buscarLetra(palabra, letra, pista)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una vocal, presiona enter para continuar");
                        scan.nextLine();
                    }
                } while (!menu);
                pistas++;
                break;
            case 1:
                do {
                    System.out.print("\n Elige una consonante ->  ");
                    letra = scan.nextLine().toLowerCase().charAt(0);
                    if (esConsonante(letra)) {
                        menu = true;
                        if (!buscarLetra(palabra, letra, pista)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una consonante, presiona enter para continuar");
                        scan.nextLine();
                    }
                } while (!menu);
                pistas++;
                break;
            case 2:
                do {
                    System.out.print("\n Elige una letra ->  ");
                    letra = scan.nextLine().toLowerCase().charAt(0);
                    if (esLetra(letra)) {
                        menu = true;
                        if (!buscarLetra(palabra, letra, pista)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una letra, presiona enter para continuar");
                        scan.nextLine();
                    }
                } while (!menu);
                pistas++;
                break;
            default:
                System.out.println("\n No hay más pistas, presiona enter para continuar");
                scan.nextLine();
                break;
        }
        return pistas;
    }

    private static boolean esVocal(char letra) {
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }

    private static boolean esConsonante(char letra) {
        // Comprueba que la letra esté en minúsculas
        if (!Character.isLowerCase(letra)) {
            return false; // No es una letra minúscula (puede ser numero o caracter especial)
        }

        // Verifica si es una vocal
        if (esVocal(letra)) {
            return false; // Es una vocal
        } else {
            return true; // Es una consonante
        }

    }

    private static boolean esLetra(char letra) {
        return (esVocal(letra) || esConsonante(letra));
    }

    private static boolean buscarLetra(String palabra, char letra, char[] pista) {
        boolean encontro = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                encontro = true;
                pista[i] = letra;
            }
        }
        return encontro;
    }

    private static int arriezgarLetra(char[] pistas, String palabra, int intentos) {
        char letra;
        boolean flag = false; // controlo que lo ingresado sea una letra
        do {
            System.out.print("\n Elige una letra ->  ");
            letra = scan.nextLine().toLowerCase().charAt(0);
            if (esLetra(letra)) {
                flag = true;
                if (!buscarLetra(palabra, letra, pistas)) {
                    intentos--;
                    System.out.println(
                            "\n La letra no se encuentra, perdio una vida, presiona enter para continuar");
                    scan.nextLine();
                } else {
                    System.out.println("\n La letra se encuentra, felicidades!, presiona enter para continuar");
                    scan.nextLine();
                }
            } else {
                System.out.println("\n No es una letra, presiona enter para continuar");
                scan.nextLine();
            }
        } while (!flag);

        return intentos;
    }

    private static int arriezgarPalabra(String palabra, int intentos) {
        System.out.print("\n Ingrese la palabra que quiere arriezgar ->  ");
        String respuesta = scan.nextLine().toLowerCase();
        if (respuesta.equals(palabra)) {
            System.out.println("\n Felicidades, acertaste la palabra, ganaste!, presiona enter para continuar");
            scan.nextLine();
            intentos = 99;
        } else {
            System.out.println("\n La palabra no es correcta, perdio una vida, presiona enter para continuar");
            scan.nextLine();
            intentos = intentos - 1;
        }
        return intentos;
    }

}
