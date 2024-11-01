package Java.Ejercicios.Introductorios;

import java.util.Scanner;

public class IntroArrays {

    public static void sumaElem() {

        /*
         * ✏️ Actividad: Sumando elementos
         * Escribe un programa en el cual se cree una variable de tipo array que
         * contenga tres elementos de tipo entero. El programa debe sumar los tres
         * elementos de forma manual e imprimir por consola el resultado utilizando
         * solamente las herramientas adquiridas hasta el momento.
         */
        int[] arreglo = new int[3];
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer numero ");
        arreglo[0] = sc.nextInt();
        System.out.print("Ingrese el segundo numero ");
        arreglo[1] = sc.nextInt();
        System.out.print("Ingrese el tercer numero ");
        arreglo[2] = sc.nextInt();
        System.out.println("La suma de los tres elementos es: " + (arreglo[0] + arreglo[1] + arreglo[2]));
        sc.close();
    }

    public static void promElem() {
        /*
         * ✏️ Actividad: Promediando elementos
         * Escribe un programa en el cual se cree una variable de tipo array que
         * contenga cuatro elementos de tipo entero. Estos elementos deben ser
         * ingresados por el usuario. El programa debe sumar y promediar los cuatro
         * elementos de forma manual e imprimir por consola el resultado, utilizando
         * solamente las herramientas adquiridas hasta el momento.
         */

        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Por favor ingrese 4 numeros enteros. ");
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();

        sc.close();
        int suma = arr[0] + arr[1] + arr[2] + arr[3];
        double promedio = (double) suma / 4;
        System.out.println("la suma de tu array es " + suma + " y el promedio es " + promedio);
    }

    public static void maxElem() {
        /*
         * ✏️ Actividad: Encontrando el máximo
         * Escribe un programa en el cual se cree una variable de tipo array que
         * contenga cinco elementos de tipo entero, ingresados por el usuario. El
         * programa debe buscar el máximo e imprimir por consola el resultado utilizando
         * solamente las herramientas adquiridas hasta el momento.
         */

        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Por favor ingrese 5 numeros enteros. ");
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        sc.close();
        int max = arr[0];
        if (arr[1] > max) {
            max = arr[1];
        }
        if (arr[2] > max) {
            max = arr[2];
        }
        if (arr[3] > max) {
            max = arr[3];
        }
        if (arr[4] > max) {
            max = arr[4];
        }
        System.out.println("El valor maximo de tu array es " + max + ".");
    }

    public static void buscElem() {
        /*
         * ✏️ Actividad: Buscando un elemento
         * El programa debe crear un array de tamaño 3 que almacene números enteros.
         * Luego, solicita un número al usuario y muestra por consola si ese número está
         * presente en el array o no. Es importante utilizar únicamente las herramientas
         * aprendidas hasta el momento, sin emplear bucles en el proceso.
         */
        int[] arr = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Por favor ingrese 3 numeros enteros. ");
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        System.out.println("Por favor ingrese un numero para buscar en el array: ");
        int num = sc.nextInt();
        sc.close();
        boolean flag = false;
        int pos = -1;
        if (arr[0] == num) {
            flag = true;
            pos = 0;
        } else if (arr[1] == num) {
            flag = true;
            pos = 1;
        } else if (arr[2] == num) {
            flag = true;
            pos = 2;
        }
        if (flag) {
            System.out.println("El numero " + num + " se encuentra en la posicion " + pos);
        } else {
            System.out.println("El numero " + num + " no se encuentra en el array");
        }

    }

    public static void copElem() {
        /*
         * ✏️ Actividad: Copiando elementos
         * Desarrolla un programa que inicie creando un array de 3 enteros, con valores
         * predeterminados. Posteriormente, genera una copia del mismo con una extensión
         * de 2 elementos adicionales.
         *
         * Solicita al usuario que ingrese dos números para ser almacenados en las
         * nuevas posiciones del array.
         * 
         * Finalmente, muestra por consola el contenido del nuevo array.
         * 
         * Es esencial emplear exclusivamente las herramientas aprendidas hasta el
         * momento, evitando el uso de bucles en el proceso.
         */
        int[] arr = { 4, 7, 9 };
        int[] arr2 = new int[arr.length + 2];
        Scanner sc = new Scanner(System.in);
        arr2[0] = arr[0];
        arr2[1] = arr[1];
        arr2[2] = arr[2];
        System.out.println("\033\143");
        System.out.println("Por favor ingrese 2 numeros enteros: ");
        arr2[3] = sc.nextInt();
        arr2[4] = sc.nextInt();
        System.out.println("El arreglo inicial era: [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "]");
        System.out.println("El arreglo modificado es: [" + arr2[0] + ", " + arr2[1] + ", " +
                arr2[2] + ", " + arr2[3] + ", " + arr2[4] + "]");
        sc.close();
    }

    public static void RNGCantPares() {
        /*
         * Generando un número aleatorio entre dos límites
         * 
         * Escribe un programa en el que se cree una variable de tipo array que contenga
         * seis elementos de tipo entero. El programa debe contar la cantidad de
         * elementos pares presentes en el array y mostrar el resultado por consola
         * utilizando solo las herramientas aprendidas hasta el momento.
         */
        int[] arr = new int[6];
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese cota inferior");
        int min = sc.nextInt();
        System.out.println("ingrese cota superior");
        int max = sc.nextInt(); // Math.random() * (max - min) + min;
        sc.close();
        arr[0] = (int) (Math.random() * (max - min) + min);
        arr[1] = (int) (Math.random() * (max - min) + min);
        arr[2] = (int) (Math.random() * (max - min) + min);
        arr[3] = (int) (Math.random() * (max - min) + min);
        arr[4] = (int) (Math.random() * (max - min) + min);
        arr[5] = (int) (Math.random() * (max - min) + min);
        int cont = 0;

        if (arr[0] % 2 == 0) {
            cont++;
        }
        if (arr[1] % 2 == 0) {
            cont++;
        }
        if (arr[2] % 2 == 0) {
            cont++;
        }
        if (arr[3] % 2 == 0) {
            cont++;
        }
        if (arr[4] % 2 == 0) {
            cont++;
        }
        if (arr[5] % 2 == 0) {
            cont++;
        }
        System.out.println(
                "[" + arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3] + ", " + arr[4] + ", " + arr[5] + "]");
        System.out.println("La cantidad de elementos pares en el array es: " + cont);

    }

    public static void sumaPares() {
        /*
         * Sumando elementos en posiciones pares
         * 
         * Desarrolla un programa que cree un array de tamaño 5 que almacene números
         * enteros. Luego, suma los elementos ubicados en las posiciones pares del array
         * (es decir, las posiciones 0, 2 y 4) y muestra por consola el resultado de la
         * suma. Utiliza exclusivamente las herramientas aprendidas hasta el momento.
         */
        int[] arr = new int[5];
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese 5 numeros");
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        sc.close();
        int suma = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
        System.out.println("La suma de los elementos en posiciones pares es: " + suma);

    }

    public static void ordAlfa() {
        /*
         * Ordenando Nombres Alfabéticamente
         * 
         * Desarrolla un programa que pida al usuario ingresar 4 nombres. Estos nombres
         * serán ordenados alfabéticamente y posteriormente impresos en la consola. Es
         * esencial emplear exclusivamente las herramientas aprendidas hasta el momento.
         */
        Scanner sc = new Scanner(System.in);
        String[] nom = new String[4];
        System.out.println("\033\143");
        System.out.println("ingrese 4 nombres");
        nom[0] = sc.nextLine();
        nom[1] = sc.nextLine();
        nom[2] = sc.nextLine();
        nom[3] = sc.nextLine();
        sc.close();
        String[] ord = new String[4];
        String min = nom[0];
        int pos = 0;
        System.out.println("El arreglo original es de la forma : [" + nom[0] + ", " + nom[1] + ", " + nom[2] + ", "
                + nom[3] + "]");
        if (nom[1].compareToIgnoreCase(min) < 0) {
            min = nom[1];
            pos = 1;
        }
        if (nom[2].compareToIgnoreCase(min) < 0) {
            min = nom[2];
            pos = 2;
        }
        if (nom[3].compareToIgnoreCase(min) < 0) {
            min = nom[3];
            pos = 3;
        }
        ord[0] = min;
        nom[pos] = "ZZZZZZZZZZZZZZZZZ";
        min = nom[0];
        pos = 0;
        if (nom[1].compareToIgnoreCase(min) < 0) {
            min = nom[1];
            pos = 1;
        }
        if (nom[2].compareToIgnoreCase(min) < 0) {
            min = nom[2];
            pos = 2;
        }
        if (nom[3].compareToIgnoreCase(min) < 0) {
            min = nom[3];
            pos = 3;
        }
        ord[1] = min;
        nom[pos] = "ZZZZZZZZZZZZZZZZZ";
        min = nom[0];
        pos = 0;
        if (nom[1].compareToIgnoreCase(min) < 0) {
            min = nom[1];
            pos = 1;
        }
        if (nom[2].compareToIgnoreCase(min) < 0) {
            min = nom[2];
            pos = 2;
        }
        if (nom[3].compareToIgnoreCase(min) < 0) {
            min = nom[3];
            pos = 3;
        }
        ord[2] = min;
        nom[pos] = "ZZZZZZZZZZZZZZZZZ";
        min = nom[0];
        pos = 0;
        if (nom[1].compareToIgnoreCase(min) < 0) {
            min = nom[1];
            pos = 1;
        }
        if (nom[2].compareToIgnoreCase(min) < 0) {
            min = nom[2];
            pos = 2;
        }
        if (nom[3].compareToIgnoreCase(min) < 0) {
            min = nom[3];
            pos = 3;
        }
        ord[3] = min;
        System.out.println("El arreglo ordenado es de la forma : [" + ord[0] + ", " + ord[1] + ", " + ord[2] + ", "
                + ord[3] + "]");
    }
}
