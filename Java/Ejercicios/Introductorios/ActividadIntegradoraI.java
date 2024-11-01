package Java.Ejercicios.Introductorios;

import java.util.Scanner;

public class ActividadIntegradoraI {

    public static void parOImpar() {
        int parImpar = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese un numero entero ojo entero:");
        parImpar = reader.nextInt();
        System.out.println((parImpar % 2 == 0) ? "es par" : "es impar");
        reader.close();
    }

}
