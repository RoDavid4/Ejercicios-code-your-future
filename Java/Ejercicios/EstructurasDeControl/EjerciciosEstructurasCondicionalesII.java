package Java.Ejercicios.EstructurasDeControl;

import java.util.Scanner;

public class EjerciciosEstructurasCondicionalesII {
     /* En esta actividad, escribirás un programa que solicite al usuario ingresar un número del 1 al 7,
      que representará un día de la semana. Luego, el programa mostrará en pantalla el nombre correspondiente 
     a ese día. Utilizaremos la estructura "switch" para implementar este programa.*/
    public static void diasSemana(){
        int opcion = 0;
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Ingrese un número del 1 al 7");
        opcion = miScanner.nextInt();
        switch (opcion) {
            case 1:  
                System.out.println("Lunes");
                break;
            case 2: 
                System.out.println("Martes");
                break;
            case 3: 
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default: 
                System.out.println("El número ingresado no es válido");
                break;
        }
        miScanner.close();
        }

        public static void calificacion() {
            Scanner miScanner = new Scanner(System.in);

        System.out.println("Ingrese un numero del 1 al 5");

        int opcion=miScanner.nextInt();

        String calificacion = switch(opcion){
        case 1 -> "Muy deficiente";
        case 2 -> "Deficiente";
        case 3 -> "Suficiente";
        case 4 -> "Notable";
        case 5 -> "Sobresaliente";
        default -> "Opcion invalida";
        };

        miScanner.close();

        System.out.println("La calificacion es: " + calificacion);
        }
        
        public static void selecOpcion(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Por favor ingrese una opción del 1 al 3: ");
            int opcion = scanner.nextInt();
            String opcionUsuario = switch (opcion){
                case 1 -> "Guardar";
                case 2 -> "Cargar";
                case 3 -> "Salir";
                default -> "Opción no válida";
            };
            System.out.println("La opción seleccionada es: " + opcionUsuario);
            scanner.close();
        }

        public static void seleccionFiguraGeo(){
            Scanner input = new Scanner(System.in);
            System.out.println("Ingresa 1) Para Círculo, 2) para un Cuadrado o 3) para un triángulo: ");
            int seleccion = input.nextInt();
            double total = 0;

            switch (seleccion){
            case 1 -> {
                System.out.println("Ingresa el radio: ");
                double radio = input.nextDouble();
                total = Math.PI*(Math.pow(radio, 2));
            }
            case 2 -> {
                System.out.println("Ingresa un lado: ");
                double lado = input.nextDouble();
                total = Math.pow(lado, 2);
            }
            case 3 -> {
                System.out.println("Ingresa la base: ");
                double base = input.nextDouble();
                System.out.println("Ingresa la altura: ");
                double altura = input.nextDouble();
                total = (base * altura)/2;
            }
                default -> System.out.println("Ingresa una opción válida.");
            }
            input.close();
            System.out.println("El valor del área de la figura seleccionada es: " + total);
        }

        public static void ultimoComp(){
            Scanner input = new Scanner(System.in);

            System.out.println("""
            Menu
            1-circulo
            2-rectangulo
            Seleccione una opcion: """);

            int numero = input.nextInt();

            double resultado = switch(numero){
            case 1 -> {
                System.out.println("Ingrese el radio: ");
                double radio = input.nextDouble();
                yield CalculoCirculo(radio);
            }
            case 2 -> {
                System.out.println("Ingrese la base: ");
                double base = input.nextDouble();
                System.out.println("Ingrese la altura: ");
                double altura = input.nextDouble();
                yield CalculoRectangulo(base, altura);                
            }
            default -> -1;
            };
            System.out.println("El resultado es: " + resultado);
        }

        private static double CalculoRectangulo(double base, double altura){
            Scanner input = new Scanner(System.in);
            System.out.println("1-Area o 2-Perimetro:");
            int opcion = input.nextInt();
            double resultado = -1;
            switch (opcion) {
                case 1 -> resultado = base * altura;
                case 2 -> resultado = 2 * (base + altura);
            }
            input.close();
            return resultado;
        }

        private static double CalculoCirculo(double radio){
            Scanner input = new Scanner(System.in);
            System.out.println("1-Area o 2-Perimetro:");
            int opcion = input.nextInt();
            double resultado = -1;
            switch (opcion) {
            case 1:
                resultado = Math.PI*Math.pow(radio,2);
            break;
            case 2:
                resultado = 2*Math.PI*radio;
            break;
            }

            input.close();
            return resultado;
        }
        
}
