package Java.Ejercicios.introMetodos;

import java.util.Arrays;
import java.util.Scanner;

public class MetodosII {
    public static Scanner pepe = new Scanner(System.in);

    /*
     * 1. Es par: Reemplaza la lógica de pedir un número por un método llamado
     * "solicitarNumero()" que no reciba parámetros y devuelva un entero. También
     * reemplaza la condición del if por un método llamado "esPar()" que reciba por
     * parámetro un entero y devuelva un booleano.
     * 
     * public static void main(String[] args) {
     * Scanner pepe = new Scanner(System.in);
     * Integer numero = null;
     * System.out.println("Por favor ingrese un número:");
     * do {
     * try {
     * numero = pepe.nextInt();
     * } catch (Exception e) {
     * pepe.nextLine();
     * System.out.println("No ingresó un número, intente nuevamente:");
     * }
     * } while (numero == null);
     * if (numero % 2 == 0) {
     * System.out.println("El "+numero+" es par");
     * }
     * }
     */

    public static void pedirEsPar() {
        System.out.println("\033\143");
        int numero = solicitarNumero();
        if (esPar(numero)) {
            System.out.println("El numero " + numero + " es par");
        } else {
            System.out.println("El número " + numero + " no es par.");
        }
        pepe.close();
    }

    public static int solicitarNumero() {
        Integer numero = null;
        System.out.println("Por favor ingrese un número:");
        do {
            try {
                numero = pepe.nextInt();
            } catch (Exception e) {
                pepe.nextLine();
                System.out.println("No ingresó un número, intente nuevamente:");
            }
        } while (numero == null);
        return numero;
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /*
     * Calculadora: el ejercicio de la calculadora, pero esta vez crea un método
     * llamado "menu()"
     * que no reciba ningún parámetro y se encargue de generar la lógica de mostrar
     * el menú de opciones y producir
     * el bucle para seguir mostrando el menú hasta seleccionar la opción de
     * "salir". Solicita dos números al
     * usuario y realiza la operación matemática seleccionada, teniendo en cuenta
     * las validaciones necesarias
     * como la división por cero.
     */

    static Scanner scanner = new Scanner(System.in);

    public static void calculadora() {
        System.out.println("\033\143");
        menu();
        scanner.close();
    }

    public static void menu() {
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarOperacion("Suma", '+');
                    break;
                case 2:
                    realizarOperacion("Resta", '-');
                    break;
                case 3:
                    realizarOperacion("Multiplicación", '*');
                    break;
                case 4:
                    realizarDivision();
                    break;
                case 5:
                    System.out.println("Saliendo de la calculadora.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void realizarOperacion(String operacion, char simbolo) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = calcularResultado(num1, num2, simbolo);

        System.out.println("\n" + operacion + ": " + num1 + " " + simbolo + " " + num2 + " = " + resultado);
    }

    public static void realizarDivision() {
        System.out.print("Ingrese el dividendo: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el divisor: ");
        double num2 = scanner.nextDouble();

        if (num2 != 0) {
            double resultado = num1 / num2;
            System.out.println("\nDivisión: " + num1 + " / " + num2 + " = " + resultado);
        } else {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }

    public static double calcularResultado(double num1, double num2, char simbolo) {
        switch (simbolo) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }

    /*
     * Actividad: ¡Manos a la obra 2.0!
     * 1. Generación de números aleatorios: Basándote en el ejercicio que ya has
     * realizado, crea un método "numeroAleatorio()" que no requiera parámetros y
     * devuelva un "int" dentro del rango especificado.
     * 
     * Ejercicio anterior: “Generando números aleatorios” Escribe un programa que
     * genere y muestre en pantalla un número aleatorio en el rango del 1 al 355
     * utilizando el método random() de la clase Math. Puedes utilizar el método
     * floor() para redondear el número aleatorio hacia abajo.
     */

    private static int numeroAleatorio() {
        /*
         * 3 Actividad: Generando números aleatorios
         * Escribe un programa que genere y muestre en pantalla un número aleatorio en
         * el rango del 1 al 355 utilizando el método random() de la clase Math. Puedes
         * utilizar el método floor() para redondear el número aleatorio hacia abajo.
         */
        double numeroRandom = Math.random() * 355 + 1;
        int numeroRedondeado = (int) Math.floor(numeroRandom);
        return +numeroRedondeado;
    }

    public static void numAleat() {
        System.out.println("\033\143");
        System.out.println("El numero aleatorio generado es: " + numeroAleatorio());
    }

    /*
     * Ejercicio de calificación: Basándote en el siguiente ejercicio que ya has
     * realizado, crea un método "obtenerNota()" que reciba por parámetro un "int" y
     * devuelva un "String". El método debe utilizar la estructura de control
     * "switch expression".
     */
    public static void obtNota() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.print("Ingresa tu calificación: ");
        int calificacion = leer.nextInt();
        System.out.println(obtenerNota(calificacion));
        leer.close();
    }

    private static String obtenerNota(int calificacion) {

        // Dividimos la calificación por 10 para simplificar el switch
        return switch (calificacion / 10) {

            case 10, 9 -> ("Tu calificación es A");

            case 8 -> ("Tu calificación es B");

            case 7 -> ("Tu calificación es C");

            case 6 -> ("Tu calificación es D");

            case 5, 4, 3, 2, 1, 0 -> ("Tu calificación es F");

            default -> ("Calificación no válida");

        };

    }

    /*
     * Imprimir array: Crea un programa que utilice un método
     * "imprimirArray(int[] array)" que se encargue de imprimir un array por
     * consola. El método debe recibir como parámetro un arreglo de tipo "int" y no
     * devolver nada. Luego, crea una sobrecarga del método para que acepte arrays
     * de tipo String y arreglos bidimensionales de tipo "int" y de tipo "String".
     */

    public static void imprimirArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void imprimirArray(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void imprimirArray(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void imprimirArray(String[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    /*
     * Validación de contraseña: Basándote en el ejercicio que ya has realizado,
     * crea un método "esSegura()" que reciba por parámetro un "String" y devuelva
     * un booleano para comprobar que la contraseña cumple con los criterios
     * establecidos. También, crea los métodos: "tieneLongitudCorrecta()",
     * "tieneMayuscula()", "tieneMinuscula()", "tieneNumero()" y
     * "tieneCaracterEspecial()", que reciban por parámetro un "String" y devuelvan
     * un "booleano".
     */

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

        if (esSegura(contraseña)) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña no cumple con los criterios de seguridad.");
        }
        sc.close();
    }

    private static boolean esSegura(String contraseña) {
        return tieneLongitudCorrecta(contraseña) && tieneMayuscula(contraseña) && tieneMinuscula(contraseña)
                && tieneNumero(contraseña) && tieneCaracterEspecial(contraseña);
    }

    private static boolean tieneLongitudCorrecta(String contraseña) {
        return contraseña.length() >= 8;
    }

    private static boolean tieneMayuscula(String contraseña) {
        return contraseña.matches(".*[A-Z].*");
    }

    private static boolean tieneMinuscula(String contraseña) {
        return contraseña.matches(".*[a-z].*");
    }

    private static boolean tieneNumero(String contraseña) {
        return contraseña.matches(".*[0-9].*");
    }

    private static boolean tieneCaracterEspecial(String contraseña) {
        return (contraseña.matches(".*[!-/].*") || (contraseña.matches(".*[:-@].*")));
    }

    /*
     * Adivinar el número: Basándose en el ejercicio que ya has realizado, crea un
     * método "numeroAleatorio()" que reciba por parámetro dos variables de tipo
     * "int": un número máximo y un número mínimo. El método debe generar y devolver
     * un número aleatorio dentro del rango especificado.
     */

    public static void rngAcotado() {
        /*
         * 1. Generando un número aleatorio entre dos límites
         * 
         * Escribe un programa que pida al usuario ingresar dos números enteros: un
         * límite inferior y un límite superior. Luego, utiliza el método random() de la
         * clase Math para generar y mostrar en pantalla un número aleatorio dentro del
         * rango especificado por los límites ingresados.
         */

        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el límite inferior: ");
        int inferior = sc.nextInt();
        System.out.println("ingresa el limite superior: ");
        int superior = sc.nextInt();
        System.out.println(
                "El número aleatorio entre " + inferior + " y " + superior + " es: " + rngAcotAux(inferior, superior));
        sc.close();
    }

    private static int rngAcotAux(int inf, int sup) {
        return (int) (Math.random() * (sup - inf + 1) + inf);
    }

    /*
     * Crear array aleatorio: Basándote en el ejercicio “Generación de números
     * aleatorios” de este paso, crea un programa que te permita generar un array de
     * tipo "int" de manera aleatoria. El programa debe solicitar al usuario el
     * tamaño del array y el rango de números posibles para rellenarlo.
     */

    public static void generarArregloRNG() {
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el tamaño del arreglo: ");
        int tam = sc.nextInt();
        System.out.println("Ingresa el límite inferior: ");
        int inf = sc.nextInt();
        System.out.println("Ingresa el límite superior: ");
        int sup = sc.nextInt();
        System.out.println("El arreglo de numeros aleatorios dentro del intervalo es: \n"
                + Arrays.toString(genArrRNGAux(tam, inf, sup)));
        sc.close();
    }

    private static int[] genArrRNGAux(int tam, int inf, int sup) {
        int[] arreglo = new int[tam];
        for (int i = 0; i < tam; i++) {
            arreglo[i] = rngAcotAux(inf, sup);
        }
        return arreglo;
    }

    /*
     * Rellenar un arreglo de manera personalizada:
     * 
     * Basándote en el ejercicio que ya has realizado, crea un método llamado
     * "rellenarArray(int[] array)" que recibirá como parámetro un arreglo de tipo
     * "int" y no devolverá ningún valor. Este método contendrá la lógica necesaria
     * para solicitar datos al usuario y completar el arreglo con ellos.
     */

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
        System.out.println("\033\143");
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamano = pepe.nextInt();
        int[] arreglo = new int[tamano];
        rellenarArray(arreglo);
        pepe.close();
    }

    private static void rellenarArray(int[] array) {
        int valor;
        int inicial = -1;
        int fin = 0;
        while (inicial < array.length - 1) {
            System.out.println("Ingrese el valor con el que desea rellenar el arreglo");
            valor = pepe.nextInt();
            do {
                System.out.print("Ingrese el índice hasta el cual quiere rellenar el arreglo con el valor anterior: ");
                fin = pepe.nextInt();
                if (fin <= inicial) {
                    System.out.println("El índice ingresado debe ser mayor que el último índice (" + inicial + ")");
                } else if (fin >= array.length) {
                    System.out
                            .println("El índice ingresado debe de ser menor que el tamaño (menor que " + array.length
                                    + ")");
                }
            } while ((fin <= inicial) || (fin >= array.length));
            inicial++;
            Arrays.fill(array, inicial, fin + 1, valor);
            inicial = fin;
        }
        System.out.println("El arreglo completo es: " + Arrays.toString(array));
    }

    /*
     * Figuras geométricas:
     * 
     * Crea un programa que calcule las áreas y los perímetros de un círculo, un
     * triángulo o un paralelogramo. Debe tener dos menús: uno para elegir la figura
     * geométrica y otro para elegir qué calcular.
     * 
     * En cada opción se deben solicitar los datos necesarios para aplicar la
     * fórmula correspondiente:
     */

    public static void calcularArea() {
        menufiguras();
    }

    private static void menufiguras() {
        System.out.println("\033\143");
        System.out.println("¿Qué figura geométrica desea calcular?");
        System.out.println("1. Círculo");
        System.out.println("2. Triángulo");
        System.out.println("3. Paralelogramo");
        int figura = pepe.nextInt();
        switch (figura) {
            case 1 -> menuCirculo();
            case 2 -> menuTriangulo();
            case 3 -> menuParalelogramo();
            default -> System.out.println("Opción no válida");
        }
    }

    private static void menuCirculo() {
        System.out.println("¿Qué desea calcular?");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int opcion = pepe.nextInt();
        switch (opcion) {
            case 1:
                areaCirculo();
                break;
            case 2:
                perimetroCirculo();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void areaCirculo() {
        System.out.println("Ingrese el radio del círculo");
        double radio = pepe.nextDouble();
        System.out.println("El área del círculo es: " + Math.PI * Math.pow(radio, 2));
    }

    private static void perimetroCirculo() {
        System.out.println("Ingrese el radio del círculo");
        double radio = pepe.nextDouble();
        System.out.println("El perímetro del círculo es: " + 2 * Math.PI * radio);
    }

    private static void menuTriangulo() {
        System.out.println("¿Qué desea calcular?");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int opcion = pepe.nextInt();
        switch (opcion) {
            case 1:
                areaTriangulo();
                break;
            case 2:
                perimetroTriangulo();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void areaTriangulo() {
        System.out.println("Ingrese la base del triángulo");
        double base = pepe.nextDouble();
        System.out.println("Ingrese la altura del triángulo");
        double altura = pepe.nextDouble();
        System.out.println("El área del triángulo es: " + (base * altura) / 2);
    }

    private static void perimetroTriangulo() {
        System.out.println("Ingrese la longitud del la primer lado del triángulo");
        double lado1 = pepe.nextDouble();
        System.out.println("Ingrese la longitud del segundo lado del triángulo");
        double lado2 = pepe.nextDouble();
        System.out.println("Ingrese la longitud del tercer lado del triángulo");
        double lado3 = pepe.nextDouble();
        System.out.println("El perímetro del triángulo es: " + (lado1 + lado2 + lado3));
    }

    private static void menuParalelogramo() {
        System.out.println("¿Qué desea calcular?");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int opcion = pepe.nextInt();
        switch (opcion) {
            case 1:
                areaParalelogramo();
                break;
            case 2:
                perimetroParalelogramo();
                break;
            default:
                System.out.println("Opción no válida");
        }

    }

    private static void areaParalelogramo() {
        System.out.println("Ingrese la base del paralelogramo");
        double base = pepe.nextDouble();
        System.out.println("Ingrese la altura del paralelogramo");
        double altura = pepe.nextDouble();
        System.out.println("El área del paralelogramo es: " + (base * altura));
    }

    private static void perimetroParalelogramo() {
        System.out.println("Ingrese la longitud del la primer lado del paralelogramo");
        double lado1 = pepe.nextDouble();
        System.out.println("Ingrese la longitud del segundo lado del paralelogramo");
        double lado2 = pepe.nextDouble();
        System.out.println("El perímetro del paralelogramo es: " + ((2 * lado1) + (2 * lado2)));
    }
}
