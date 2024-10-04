import java.util.Scanner;


public class IntroAClaseScannerYOperadoresEnJava { 
    public static void nombreYEdad() {
        String nombre;
        int edad;
        Scanner miScanner = new Scanner(System.in); // Se CREA una INSTANCIA de la Clase Scanner <-------

        System.out.println("Ingrese su nombre");
        nombre = miScanner.nextLine();
        System.out.println("Ingrese su edad");
        edad = miScanner.nextInt();
        miScanner.close();               // Se cierra la instancia de Clase Scanner, se libera la memoria
        System.out.println("Su nombre es: " + nombre + ", usted tiene: " + edad + " años");
    }

    public static void operacionesYComparaciones() {
        int a,b, resultado;
        
        Scanner miScanner = new Scanner(System.in); // Se CREA una INSTANCIA de la Clase Scanner <-------
        System.out.println("Ingrese a");
        a = miScanner.nextInt();
        System.out.println("Ingrese b");
        b = miScanner.nextInt();
        resultado = a - b;
        System.out.println("La suma de a y b es: " + (a + b));
        System.out.println("La resta de a - b es : " + resultado);
        System.out.println("a  es mayor que b? "+ (a > b));
        miScanner.close();               // Se cierra la instancia de Clase Scanner, se libera la memoria
    }

/*1. Verificación de Edad

Pide al usuario que ingrese su año de nacimiento y almacena el dato en una variable previamente declarada llamada añoNacimiento.

Declara una variable del tipo Constante llamado ANIOACTUAL con el año actual.

Calcula la edad actual del usuario, considerando que la cuenta sería ANIOACTUAL - añoNacimiento. Almacena el dato en una variable llamada calculoEdad.

Determina si el usuario es mayor de edad (tener 18 años o más) y muestra un mensaje apropiado. */
    public static void verificMayEdad(){    
        final int ANIO_ACTUAL = 2024;
        int anioNacimiento;
        String mensaje;
        Scanner miScanner = new Scanner(System.in); // Se CREA una INSTANCIA de la Clase Scanner <-------

        System.out.println("Ingrese su año de nacimiento");
        anioNacimiento = miScanner.nextInt();
        miScanner.close();               // Se cierra la instancia de Clase Scanner, se libera la memoria
        mensaje = (ANIO_ACTUAL - anioNacimiento >= 18) ? "SI es mayor de edad" : "No es mayor de edad";
        System.out.println(mensaje);
    }
    public static void main(String[] args)  {   
        verificMayEdad();
    }
}
