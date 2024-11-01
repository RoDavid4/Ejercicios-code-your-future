package Java.Ejercicios.EstructurasIterativas;

import java.util.Scanner;

public class BuclesI {
    public static void impElem() {
        /*
         * ✏️ Actividad: Imprimiendo elementos
         * Escribe un programa que recorra un array de enteros y muestre cada elemento
         * en una línea separada. El tamaño, tipo de datos y la información a contener
         * pueden ser de tu elección.
         */
        int[] array = { 5, 6, 7, 8, 9 };

        System.out.println("\033\143");
        for (int i = 0; i < array.length; i++) {
            System.out.println("elemento en la posicion " + i + " : " + array[i]);
        }

    }

    public static void valMin() {
        /*
         * ✏️ Actividad: Encontrando el valor mínimo
         * Escribe un programa que recorra un array de enteros y encuentre el valor
         * mínimo presente en el array. El tamaño y los números a contener pueden ser de
         * tu elección.
         */
        System.out.println("\033\143");
        int[] array = { 20, 40, 5, 1 };
        int minimo = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minimo > array[i]) {
                minimo = array[i];
            }
        }

        System.out.println("El valor mínimo en el array es: " + minimo);
    }

    public static void impInverso() {
        /*
         * ✏️ Actividad: Imprimiendo elementos en orden inverso
         * Escribe un programa que recorra un array de enteros y los imprima en orden
         * inverso, comenzando desde el último elemento.. El tamaño y los números a
         * contener pueden ser de tu elección.
         */
        System.out.println("\033\143");
        int[] array = { 20, 40, 5, 1 };

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("El elemento en la posición " + i + " es : " + array[i]);
        }
    }

    /*
     * ✏️ Actividad: Ejercicios Complementarios
     * ✨ Estos ejercicios son de tipo complementario. Esto quiere decir que te
     * ayudará a avanzar en profundidad en el tema visto, pero no son obligatorios.
     * Te recomendamos intentar con tu equipo trabajar al menos uno de ellos.
     */

    public static void invArray() {
        /*
         * Invertir un array
         * 
         * Escribe un programa que recorra un array de enteros y lo invierta, es decir,
         * que el primer elemento se convierta en el último y viceversa, luego imprime
         * el array resultante por consola. El tamaño y los números a contener pueden
         * ser de tu elección.
         * 
         * IMPORTANTE: Debes invertir de forma permanente el orden de los elementos.
         * Analiza si necesitas hacer uso de elementos auxiliares para concluir el
         * ejercicio.
         */

        System.out.println("\033\143");
        int[] array = { 20, 40, 5, 1, 10, 50 }; // 0 1 2 3 0 < - > 3 1 lenght - 1 - i
        int aux;
        for (int i = 0; i <= ((array.length - 1) / 2); i++) {
            aux = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = aux;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("El elemento en la posición " + i + " es : " + array[i]);
        }
    }

    public static void sumAcum() {
        /*
         * Calcular suma acumulada:
         * 
         * Escribe un programa que recorra un array de enteros y calcule la suma
         * acumulada de los elementos, reemplazando cada elemento por la suma acumulada
         * hasta ese punto.El tamaño y los números a contener pueden ser de tu elección.
         */
        int[] arr = { 2, 4, 6, 8 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            arr[i] = sum;
            System.out.println(arr[i] + " ");
        }

    }

    public static void contarPares() {
        /*
         * ✏️ Actividad: Contando Elementos Pares
         * Escribe un programa que genere un array de 10 elementos de tipo entero.
         * Inicializa cada elemento con un número aleatorio menor a 100 y luego imprime
         * todos los elementos del array en una única línea. Posteriormente, recorre el
         * array para contar los elementos pares y muestra el total en la consola.
         */
        int[] array = new int[10];
        int pares = 0;

        System.out.println("\033\143");
        System.out.print("[");
        for (int elem : array) {
            elem = (int) (Math.random() * 100);
            System.out.print(" " + elem);
            if (elem % 2 == 0) {
                pares++;
            }
        }
        System.out.println("] \n Los pares encontrados en el array son: " + pares);
    }

    public static void prom() {
        /*
         * ✏️ Actividad: Calculando el promedio
         * Genera un array de 20 elementos de tipo float, inicializándolo con los
         * números de tu elección. Luego, suma todos los elementos del array y calcula
         * su promedio. Finalmente, muestra por consola tanto el resultado de la suma
         * como el promedio de los elementos.Te sugerimos implementar el uso de la
         * sintaxis de for-each.
         */
        float[] array = new float[20];
        float sum = 0;

        System.out.println("\033\143");
        System.out.print("{");
        for (float elem : array) {
            elem = (float) (Math.random() * 100);
            System.out.print(" " + elem);
            sum += elem;
        }
        System.out.println(" } \n la suma de los elementos es: " + sum + " y el promedio es: " + sum / 20);
    }

    public static void concatElem() {
        /*
         * ✏️ Actividad: Concatenando elementos
         * Crea un array del tamaño que prefieras que contenga elementos de tipo cadena.
         * Luego, concatena los elementos en una sola cadena, separados por espacios, e
         * imprime el resultado por consola.
         */

        System.out.println("\033\143");
        String[] array = { "El", "veloz", "murciélago", "hindú", "comía", "feliz", "cardillo", "y", "kiwi" };
        String resultado = "";
        for (String string : array) {
            resultado += string + " ";
        }
        System.out.println(resultado);
    }

    /*
     * ✏️ Actividad: Ejercicio Complementario
     * ✨ Este ejercicio es de tipo complementario. Esto quiere decir que te ayudará
     * a avanzar en profundidad en el tema visto, pero no es obligatorio.
     */

    public static void contarOcurr() {
        /*
         * Contar ocurrencias
         * 
         * Escribe un programa que cree un array de 50 elementos de tipo carácter,
         * inicializándolo con una frase elegida. Luego, solicita al usuario un carácter
         * objetivo y cuenta cuántas veces aparece ese carácter en el array. Finalmente,
         * imprime el resultado por consola.
         * 
         * Por ejemplo, si el array contiene la siguiente frase:
         * 
         * a p r e n d i e n d o j a v a
         * y el usuario ingresa el carácter 'd', el programa debería devolver la
         * siguiente salida:
         * 
         * El carácter "d" aparece 2 veces.
         * 
         * Si el usuario ingresa el carácter 'z', el programa debería devolver la
         * siguiente salida:
         * 
         * El carácter "z" no aparece en la frase.
         */
        System.out.println("\033\143");
        char[] arr = new char[50];
        System.out.println("Ingrese una frase");
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        for (int i = 0; i < 50; i++) {
            if (i < frase.length()) {
                arr[i] = frase.charAt(i);
            } else {
                arr[i] = ' ';
            }
        }
        System.out.println("Ingrese un caracter a buscar");
        char caracter = sc.next().charAt(0);
        int contador = 0;
        for (char c : arr) {
            if (c == caracter) {
                contador++;
            }
        }
        if (contador > 0) {
            System.out.println("El caracter '" + caracter + "' aparece " + contador + " veces");
        } else {
            System.out.println("El caracter '" + caracter + "' no aparece en la frase.");
        }
        sc.close();
        // es case sensitive
    }
}
