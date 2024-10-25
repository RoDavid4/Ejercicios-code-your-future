package Java.Ejercicios.IntroClases;

import java.util.Scanner;
import java.util.Arrays;

public class ClaseArrays {

    public static void ordDesc() {
        /*
         * ✏️ Actividad: Ordenar en forma descendente
         * Escribe un programa en el que declares una variable de tipo array que
         * contenga 10 elementos de tipo entero. Inicializa el arreglo con valores
         * aleatorios entre 1 y 100, imprime por consola el arreglo inicial y luego
         * ordenalo en forma descendente utilizando el método Arrays.sort(). Finalmente,
         * imprime los elementos ordenados en la consola.
         */
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = (int) (Math.random() * 100 + 1);
        }

        System.out.println(Arrays.toString(numeros));

        Arrays.sort(numeros);
        for (int i = (numeros.length - 1); i >= 0; i--) {

            System.out.print(numeros[i] + " ");
        }

    }

    public static void binBusq() {
        /*
         * ✏️ Actividad: Búsqueda binaria
         * La búsqueda binaria es un algoritmo eficiente para encontrar un elemento en
         * una lista ordenada de elementos. La clase Arrays ya incluye su implementación
         * mediante el método binarySearch(). Escribe un programa que realice una
         * búsqueda binaria en un arreglo ordenado de enteros utilizando el método
         * Arrays.binarySearch(). El programa debe imprimir el arreglo generado
         * originalmente, solicitar al usuario el valor buscado e imprimir el índice del
         * valor buscado si está presente en el arreglo.
         */
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100 + 1);
        }
        Arrays.sort(numeros);
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Arreglo original: ");
        System.out.println(Arrays.toString(numeros));
        System.out.println("Ingrese un valor a buscar: ");
        int valorBuscado = sc.nextInt();
        int indice = Arrays.binarySearch(numeros, valorBuscado);
        System.out.println(indice);
        if (indice < 0) { // No lo encontro
            System.out.println("El valor no se encuentra en el arreglo");
        } else {
            System.out.println("El valor se encuentra en el indice: " + indice);
        }
        sc.close();
    }

    public static void compArr() {
        /*
         * ✏️ Actividad: Comparando arreglos
         * Escribe un programa que compare dos arreglos de enteros utilizando el método
         * Arrays.equals(). El programa debe imprimir si los arreglos son iguales o no.
         */

        int[] numeros = new int[10];
        int[] otrosNumeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100 + 1);
            otrosNumeros[i] = (int) (Math.random() * 100 + 1);
        }

        int[] iguales = Arrays.copyOf(numeros, 10);
        System.out.println("\033\143");
        System.out.println("arreglo aleatorio 1: " + Arrays.toString(numeros));
        System.out.println("arreglo aleatorio 2: " + Arrays.toString(otrosNumeros));
        if (Arrays.equals(numeros, otrosNumeros)) {
            System.out.println("Los arreglos son iguales");
        } else {
            System.out.println("Los arreglos son diferentes");
        }
        System.out.println("en el caso de los clones");
        if (Arrays.equals(numeros, iguales)) {
            System.out.println("Los arreglos son iguales");
        } else {
            System.out.println("Los arreglos son diferentes");
        }
    }

    public static void partialCopy() {
        /*
         * ✏️ Actividad: Copiando parte de un arreglo.
         * Crea un programa en Java que declare y muestre un arreglo de enteros junto
         * con sus índices. Luego, solicita al usuario dos índices: un índice inicial y
         * un índice final. Con estos dos índices, copia la parte del arreglo original
         * comprendida entre ellos (inclusive) en un nuevo arreglo utilizando el método
         * Arrays.copyOfRange(). Asegúrate de incluir validaciones para confirmar que el
         * índice inicial es menor que el índice final y que ambos índices están dentro
         * del rango válido del arreglo original. Finalmente, imprime el nuevo arreglo
         * por consola.
         */
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[15];
        int[] copia = new int[15];
        System.out.println("\033\143");
        System.out.print("arreglo: ¨{");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100 + 1);
            System.out.print(" " + " [" + i + "]" + numeros[i]);
        }
        System.out.println(" }");
        System.out.println("Ingrese el índice inicial: ");
        int inicio = sc.nextInt();
        System.out.println("Ingrese el índice final: ");
        int fin = sc.nextInt();
        if (inicio < 0 || fin > numeros.length - 1 || inicio > fin) {
            System.out.println("Error: los índices deben ser válidos");
        } else {
            copia = Arrays.copyOfRange(numeros, inicio, fin + 1);
        }
        System.out.println("arreglo original: " + Arrays.toString(numeros));
        System.err.println("arreglo desde " + inicio + " hasta " + fin + " : " + Arrays.toString(copia));
        sc.close();
    }

    public static void rellenArray() {
        /*
         * ✏️ Actividad: Rellenando un arreglo
         * El método fill() de la clase Arrays cambia todos los elementos en un arreglo
         * por un valor estático, desde el
         * índice start (por defecto 0) hasta el
         * índice end (por defecto array.length) y devuelve el arreglo modificado. Vamos
         * a escribir un programa que solicite al usuario el tamaño para un arreglo y un
         * número entero con el que quiera rellenarlo. Luego crea el arreglo y utiliza
         * Arrays.fill(). Finalmente, imprime el arreglo resultante.
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("\033\143");
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamano = sc.nextInt();
        int[] arreglo = new int[tamano];
        System.out.print("Ingrese el valor para rellenar el arreglo: ");
        int valor = sc.nextInt();
        Arrays.fill(arreglo, valor);
        System.out.println("arreglo rellenado: " + Arrays.toString(arreglo));
    }

    public static void ejComp() {
        /*
         * ✏️ Actividad: Ejercicio Complementario
         * ✨ Este ejercicio es de tipo complementario. Esto quiere decir que te ayudará
         * a avanzar en profundidad en el tema visto, pero no es obligatorio.
         * 
         * Rellenando un arreglo de manera personalizada
         * Escribe un programa en Java que realice lo siguiente:
         * 
         * Solicita al usuario un tamaño para un arreglo.
         * Luego, pídele que ingrese un número con el que desea rellenar el array.
         * Solicita el índice hasta el cual quiere rellenar el array con el número
         * anterior.
         * El array deberá ser rellenado con el número proporcionado hasta el índice
         * ingresado por el usuario.
         * 
         * Asegúrate de validar lo siguiente:
         * La primera vez que se pide al usuario un número para rellenar el arreglo, el
         * índice inicial debe ser 0.
         * Si el índice ingresado no es el índice del último elemento del arreglo, el
         * programa debe continuar pidiendo al usuario nuevos números e índices para
         * rellenar el arreglo.
         * El índice siempre debe ser menor que el tamaño total del arreglo.
         * Cada vez que se solicita un nuevo número para rellenar el arreglo, el índice
         * ingresado debe ser mayor que el último índice ingresado; a su vez, se debe
         * rellenar el array con el nuevo número desde el índice anterior hasta el nuevo
         * índice.
         * 
         * Por último, el programa debe imprimir por consola el arreglo completo.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamano = sc.nextInt();
        int[] arreglo = new int[tamano];
        int valor;
        int inicial = -1;
        int fin = 0;
        while (inicial < tamano -1) {
            System.out.println("Ingrese el valor con el que desea rellenar el arreglo");
            valor = sc.nextInt();
            do {
                System.out.print("Ingrese el índice hasta el cual quiere rellenar el arreglo con el valor anterior: ");
                fin = sc.nextInt();
                if (fin <= inicial) {
                    System.out.println("El índice ingresado debe ser mayor que el último índice (" + inicial+")");
                } else if (fin >= tamano) {System.out.println("El índice ingresado debe de ser menor que el tamaño (menor que "+tamano+")");}
            } while ((fin <= inicial)||(fin>=tamano));
            inicial++;
            Arrays.fill(arreglo, inicial, fin+1, valor);
            inicial = fin;
        }
        System.out.println("El arreglo completo es: " + Arrays.toString(arreglo));
        sc.close();
    }
}
