package Java.Ejercicios.testing.intro.comp1.src;

import java.util.Scanner;

public class EsPar {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {}

    public static Integer solicitarNumero(){
        return sc.nextInt();
    }

    public static boolean esPar(Integer num){
        return num % 2 == 0;
    }
}
