package Java.Ejercicios.Introductorios;

import java.util.Scanner;

public class ActividadIntegradoraII {
    public static void calculadoraSwitch(){
        float numero1= 0f, numero2 =0f, resultado = 0f;
        int opcion = 0;
        System.out.println("Calculadora");
        Scanner scaner = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        numero1 = scaner.nextFloat();
        System.out.println("Ingrese otro numero");
        numero2 = scaner.nextFloat();

        System.out.println("Que operacion quiere usar: \n1. Sumar \n2. Restar \n3. Multiplicar \n4. Dividir" );
        opcion = scaner.nextInt();

        resultado = (opcion == 1) ? (numero1 + numero2) :
        (opcion == 2) ? (numero1 - numero2) :
        (opcion == 3) ? (numero1 * numero2) :
        (opcion == 4) ? (numero2 != 0 ? (numero1 / numero2) : 0) : 0;

        System.out.println((opcion >= 1 && opcion <= 4) ? "El resultado es: " + resultado : "Opción inválida");
    }

    public static void calculadora(){
        float numero1 = 0f,numero2 = 0f;
        int option = 0;
        Scanner reader = new Scanner(System.in);

        System.out.print("Ingrese numero uno:");
        numero1 = reader.nextFloat();

        System.out.print("Ingrese numero dos:");
        numero2 = reader.nextFloat();

        System.out.print("Que tipo de oparcion quieres realizar \n 1.multiplicar \n 2.dividir \n 3.sumar \n 4.restar \n option:");
        option = reader.nextInt();
        switch (option){
            case 1:
                System.out.println(numero2 * numero1);
                break;
            case 2:
                System.out.println(numero1!=0? numero2 / numero1:"Division por zero mal mal");
                break;
            case 3:
                System.out.println(numero2 + numero1);
                break;
            case 4:
                System.out.println(numero2 - numero1);
                break;
            default:
                System.out.println("opcion no disponible");
                break;
        }
    }
}
