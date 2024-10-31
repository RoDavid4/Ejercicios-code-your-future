package Java.Ejercicios.Integradoras;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class IntegradoraV {

    public static void manipOrac() {
        /*
         * Actividad: Manipulando oraciones
         * Escribe un programa en Java que permita al usuario realizar diversas
         * operaciones con una oración. El programa debe cumplir con los siguientes
         * requisitos:
         * 
         * Muestra un menú de opciones al usuario donde podrá:
         * 
         * Crear oración o Borrar oración: Si la oración está vacía, mostrar el mensaje
         * "Crear oración". Si la oración tiene contenido, mostrar el mensaje
         * "Borrar oración".
         * 
         * Cantidad de caracteres de la oración: Calcular y mostrar la cantidad total de
         * caracteres en la oración (incluyendo espacios).
         * 
         * Cantidad de palabras de la oración: Calcular y mostrar la cantidad de
         * palabras en la oración.
         * 
         * Mostrar palabras ordenadas alfabéticamente: Mostrar las palabras de la
         * oración ordenadas alfabéticamente.
         * 
         * Ingresar un número y devolver la palabra correspondiente: Solicitar al
         * usuario ingresar un número y mostrar la palabra correspondiente a esa
         * posición en la oración. Si se ingresa un número fuera del rango de número de
         * palabras (la primera palabra corresponde al número 1), mostrar el mensaje
         * "Número inválido. Intente nuevamente".
         * 
         * Buscar palabra dentro de la oración: Solicitar al usuario ingresar una
         * palabra y verificar si esa palabra se encuentra en la oración. Mostrar un
         * mensaje indicando si la palabra fue encontrada y la posición en la que se
         * encuentra.
         * 
         * Modificar palabra dentro de la oración: Solicitar al usuario ingresar la
         * palabra que se quiere cambiar, mostrar un mensaje de error si no se encuentra
         * y volver a solicitar la palabra. Si la palabra es correcta, solicitar una
         * nueva palabra (o frase) y reemplazar la anterior. Mostrar la nueva oración
         * modificada (recordar validar que solo contenga letras y espacios).
         * 
         * Agregar contenido a la oración: Solicitar al usuario ingresar contenido y
         * agregar ese contenido al final de la oración.
         * 
         * Salir: Terminar el programa.
         * 
         * Después de realizar una operación, mostrar el menú de opciones nuevamente
         * para que el usuario pueda elegir otra acción, excepto cuando elija "Salir".
         * 
         * Realiza las validaciones que consideres necesarias.
         */

        Scanner scn = new Scanner(System.in);
        String oracion = "";
        mostrarMenu(oracion, scn);
        scn.close();
    }

    public static void mostrarMenu(String oracion, Scanner scn) {
        char eleccion;
        do {
            System.out.println("\033\143");
            System.out.println("""
                    Ingrese una opción de acuerdo al menú
                    1. Crear o borrar oración.
                    2. Cantidad de caracteres en la oración.
                    3. Cantidad de palabras de la oración.
                    4. Ordenar alfabéticamente.
                    5. Ingresar número y devolver la palabra correspondiente.
                    6. Buscar palabra dentro de la oración.
                    7. Modificar palabra dentro de la oración.
                    8. Agregar contenido a la oración.
                    9. Salir.
                    """);
            eleccion = scn.next().charAt(0);
            scn.nextLine();
            oracion = ejecutarEleccion(oracion, eleccion, scn);
        } while (eleccion != '9');
    }

    public static String ejecutarEleccion(String oracion, char opcion, Scanner scn) {
        switch (opcion) {
            case '1':
                oracion = crearOBorrar(oracion, scn);
                break;

            case '2':
                mostrarCantidadCaracteres(oracion, scn);
                break;

            case '3':
                contarPalabras(oracion, scn);
                break;

            case '4':
                oracion = ordenarAlfabeticamente(oracion, scn);
                break;

            case '5':
                devolverPalabra(oracion, scn);
                break;

            case '6':
                buscarPalabra(oracion, scn);
                break;

            case '7':
                oracion = modificarPalabra(oracion, scn);
                break;

            case '8':
                oracion = agregarContenido(oracion, scn);
                break;

            case '9':
                System.out.println("Adiós");
                break;

            default:
                System.out.println("Opción no válida, presione enter para continuar");
                scn.nextLine();
                break;
        }
        return oracion;
    }

    public static String crearOBorrar(String oracion, Scanner scn) {
        if (oracion.length() == 0) {
            System.out.print("Ingrese una nueva oración: ");
            oracion = scn.nextLine();
            System.out.println("La oracion es: " + oracion);
            scn.nextLine();
        } else {
            System.out.println("La oración actual es: " + oracion);
            System.out.print("¿Desea borrar la oración? (s/n): ");
            String respuesta = scn.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                oracion = "";
                System.out.println("Oración borrada.");
                scn.nextLine();
            }
        }
        return oracion;
    }

    public static void mostrarCantidadCaracteres(String oracion, Scanner scn) {
        System.out.println("Cantidad de caracteres en la oración: " + oracion.length());
        scn.nextLine();
    }

    public static void contarPalabras(String oracion, Scanner scn) {
        String[] palabras = oracion.split("\\s+");
        System.out.println("Cantidad de palabras en la oración: " + palabras.length);
        scn.nextLine();
    }

    public static String ordenarAlfabeticamente(String oracion, Scanner scn) {
        String[] palabras = oracion.split("\\s+");
        Arrays.sort(palabras);
        String ordenada = String.join(" ", palabras);
        System.out.println("la oracion ordenada alfabeticamente es de la forma: " + ordenada);
        scn.nextLine();
        return ordenada;
    }

    public static void devolverPalabra(String oracion, Scanner scn) {
        System.out.print("el numero de la palabra a buscar: ");
        int n = scn.nextInt();
        String[] palabras = oracion.split("\\s+");
        if (n > 0 && n <= palabras.length) {
            System.out.println("la palabra en la posicion " + n + " es: " + palabras[n - 1]);  
        } else {
            System.out.println("La palabra no existe.");
        }
        scn.nextLine();
        scn.nextLine();
    }

    public static void buscarPalabra(String oracion, Scanner scn) {
        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = scn.nextLine(); // Quiero saber si palabra se encuentra y en que POSICION
        String[] palabras = oracion.split("\\s+");
        int posicion = -1, contador = 0;
        boolean encontro = false;
        while (!encontro && contador < Array.getLength(palabras)) {
            if (palabras[contador].equals(palabra)) {
                encontro = true;
                posicion = contador + 1;
                System.out.println("La palabra se encuentra en la posición: " + posicion);    
            }         
            contador++;
        }
        if (encontro == false) {
            System.out.println("La palabra no se encuentra en la oracion.");
        }
        scn.nextLine();
    }

    public static String modificarPalabra(String oracion, Scanner scn) {
        /*
         * * Modificar palabra dentro de la oración: Solicitar al usuario ingresar la
         * palabra que se quiere cambiar, mostrar un mensaje de error si no se encuentra
         * y volver a solicitar la palabra. Si la palabra es correcta, solicitar una
         * nueva palabra (o frase) y reemplazar la anterior. Mostrar la nueva oración
         * modificada (recordar validar que solo contenga letras y espacios).
         */

        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = scn.nextLine();
        String[] palabras = oracion.split("\\s+");
        int contador = 0;
        boolean encontro = false;
        while (!encontro && contador < Array.getLength(palabras)) {
            if (palabras[contador].equals(palabra)) {
                System.out.print("Ingrese la nueva palabra: ");
                String nuevaPalabra = scn.nextLine();
                palabras[contador] = nuevaPalabra;
                oracion = String.join(" ", palabras);
                encontro = true;
                System.out.println("La oración modificada es: " + String.join(" ", palabras));
            }
            contador++;
        }
        if (encontro == false) {
            System.out.println("La palabra no se encuentra en la oracion.");
        }
        scn.nextLine();
        return oracion;
    }

    public static String agregarContenido(String oracion, Scanner scn) {
        System.out.print("Ingrese el contenido a agregar: ");
        String contenido = scn.nextLine();
        oracion += " " + contenido;
        System.out.println("Contenido agregado, nueva oracion: " + oracion);
        scn.nextLine();
        return oracion;
    }
}
