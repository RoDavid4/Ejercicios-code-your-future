package Java.Ejercicios.testing.actIntegradoraTesting.adivinandoNumero.src;


import java.util.Scanner;

public class AdivNumApp {

    public static void main(String[] args) {
        adivNum();
    }

    public static void adivNum() {
        /*
         * ✏️ Actividad: Adivinando un número
         * Escribe un programa que genere un número aleatorio entre 1 y 20, y muestra
         * por consola un mensaje pidiéndote que adivines ese número utilizando un bucle
         * do-while. El programa te indicará si el número que ingresas es mayor o menor
         * que el número aleatorio, y seguirá pidiéndote que adivines hasta que lo hagas
         * correctamente.
         */
        Scanner scanner = new Scanner(System.in);
        int min = 13, max = 35;
        int numeroAleatorio = numeroAleatorio(min, max);
        int numero;
        boolean flag = false; // las variables de tipo boolean toman valores true o false (verdadero o falso)
        System.out.println("\033\143");

        do {
            System.out.println("Adivina un número entre "+ min + " y "+ max);
            numero = scanner.nextInt();
            if (numero == numeroAleatorio) {
                System.out.println("¡Lo has adivinado!");
                flag = true;
            } else if (numero > numeroAleatorio) {
                System.out.println("El número que has introducido es mayor que el número aleatorio");
            } else {
                System.out.println("El número que has introducido es menor que el número aleatorio");
            }
        } while (!flag); // mientras flag es falso repite !flag -> flag == false

        scanner.close();
    }

    public static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

