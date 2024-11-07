package Java.Ejercicios;

import Java.Ejercicios.Integradoras.*;
import Java.Ejercicios.Introductorios.IntroActividad1;
import Java.Ejercicios.introMetodos.*;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ahorcado();
    }

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
                case 0 -> System.out.println("Sin vidas restantes, has perdido");
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
                            "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
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
