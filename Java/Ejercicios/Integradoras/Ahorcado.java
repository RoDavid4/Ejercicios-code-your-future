package Java.Ejercicios.Integradoras;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    private Scanner scan;
    private List<String> palabras; // Listado de palabras definidas
    private int vidas; // Vidas restantes
    private String palabra; // Palabra seleccionada
    private int pistasUsadas; // Cantidad de pistas utilizadas
    private char[] pista;   // Pista (Se va formando)

    public Ahorcado() {
        this.scan = new Scanner(System.in);
        this.vidas = 3;
        this.pistasUsadas = 0;
        this.generarLista(); // Inicializa la lista de palabras
        this.elegirPalabra(); // Genera la palabra inicial del juego
        this.generarPista(); // Genera el arreglo que sirve como Pistas en el juego
    }

    private void reiniciarJuego() {
        this.vidas = 3;
        this.pistasUsadas = 0;
        this.generarLista(); // Inicializa la lista de palabras
        this.elegirPalabra(); // Genera la palabra inicial del juego
        this.generarPista(); // Genera el arreglo que sirve como Pistas en el juego
    }

    public void correr() {
        boolean win = false;
        char menu, menuGral;
        do {
            this.reiniciarJuego();
            System.out.println("\033\143"); // Limpia la pantalla
            System.out.println("Ahorcado");
            System.out.println("\n1. Jugar \t \t 2. Salir");
            System.out.print("\nIngrese una opción: ");
            menuGral = this.scan.next().charAt(0);
            switch (menuGral) {
                case '1' -> {
                    do {
                        this.scan.nextLine();
                        System.out.println("\033\143"); // Limpia la pantalla
                        System.out.println(
                                "Pista : " + new String(this.pista) + "\t pistas utilizadas: " + this.pistasUsadas
                                        + " de 3" + "\t vidas restantes: " + this.vidas);
                        System.out.print(
                                "\n 1 Para pedir pista \n 2 Para arriesgar letra \n 3 Para arriesgar palabra \n 4 Para Salir \n \n ->  ");
                        menu = this.scan.nextLine().charAt(0);
                        switch (menu) {
                            case '1' -> this.getPista();
                            case '2' -> {
                                this.arriesgarLetra();
                                if (new String(pista).equals(palabra)) {
                                    this.vidas = 99; // Si al arriezgar letra se encontro la palabra completa
                                    System.out.println(
                                            "\n Felicidades, acertaste la palabra, ganaste!, presiona enter para continuar");
                                    scan.nextLine();
                                }
                            }
                            case '3' -> this.arriesgarPalabra();
                            case '4' -> this.vidas = -1;
                            default -> {
                                System.out.println("\n Opcion incorrecta, presiona enter para continuar.");
                                scan.nextLine();
                            }
                        }

                        switch (vidas) {
                            case 99 -> win = true;
                            case 0 ->
                                System.out.println("Sin vidas restantes, has perdido, la palabra era: " + palabra);
                        }

                    } while (!win && vidas > 0);
                }
                case '2' -> {
                    System.out.println("\n\nGracias por jugar, hasta luego!");
                }
                default -> {
                    System.out.println("\n Opcion incorrecta, presiona enter para continuar.");
                    this.scan.nextLine();
                }
            }
        } while (menuGral != '2');
        scan.close();
    }

    private void generarLista() {
        String[] palabras = { "casa", "perro", "gato", "palo", "murcielago", "castillo", "programacion", "variable",
                "constante", "bucle", "datos" };
        this.palabras = List.of(palabras); // transforma el arreglo de palabras en una lista
    }

    private void elegirPalabra() {

        // Crear una instancia de Random
        Random random = new Random();

        // Obtener un índice aleatorio dentro del rango de la lista
        int indiceAleatorio = random.nextInt(palabras.size());

        // Obtener el elemento en el índice aleatorio
        this.palabra = palabras.get(indiceAleatorio);
    }

    private void generarPista() { // Genera un arreglo de '_' para empezar a llevar la pista
        char[] letras = new char[this.palabra.length()];
        for (int i = 0; i < this.palabra.length(); i++) {
            letras[i] = '_';
        }
        this.pista = letras;
    }

    private void getPista() {
        char letra;
        boolean menu = false;
        switch (this.pistasUsadas) {
            case 0: // hay 3 pistas como maximo, la 1ra es pedir vocal, la 2da consonante y la 3ra cualquier letra
                do {
                    System.out.print("\n Elige una vocal ->  ");
                    letra = this.scan.nextLine().toLowerCase().charAt(0);
                    if (this.esVocal(letra)) {
                        menu = true;
                        if (!this.buscarLetra(letra)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            this.scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una vocal, presiona enter para continuar");
                        this.scan.nextLine();
                    }
                } while (!menu);
                this.pistasUsadas++;
                break;
            case 1:
                do {
                    System.out.print("\n Elige una consonante ->  ");
                    letra = this.scan.nextLine().toLowerCase().charAt(0);
                    if (this.esConsonante(letra)) {
                        menu = true;
                        if (!this.buscarLetra(letra)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            this.scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una consonante, presiona enter para continuar");
                        this.scan.nextLine();
                    }
                } while (!menu);
                this.pistasUsadas++;
                break;
            case 2:
                do {
                    System.out.print("\n Elige una letra ->  ");
                    letra = this.scan.nextLine().toLowerCase().charAt(0);
                    if (this.esLetra(letra)) {
                        menu = true;
                        if (!this.buscarLetra(letra)) {
                            System.out.println(
                                    "\n La letra no se encuentra, perdio una pista, presiona enter para contuinuar");
                            this.scan.nextLine();
                        }
                    } else {
                        System.out.println("\n No es una letra, presiona enter para continuar");
                        this.scan.nextLine();
                    }
                } while (!menu);
                this.pistasUsadas++;
                break;
            default:
                System.out.println("\n No hay más pistas, presiona enter para continuar");
                this.scan.nextLine();
                break;
        }
    }

    private boolean esVocal(char letra) {
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }

    private boolean esConsonante(char letra) {
        // Comprueba que la letra esté en minúsculas
        if (!Character.isLowerCase(letra)) {
            return false; // No es una letra minúscula (puede ser numero o caracter especial)
        }

        // Verifica si es una vocal
        if (this.esVocal(letra)) {
            return false; // Es una vocal
        } else {
            return true; // Es una consonante
        }

    }

    private boolean esLetra(char letra) { // Si es vocal o consonante es letra
        return (this.esVocal(letra) || this.esConsonante(letra));
    }

    private boolean buscarLetra(char letra) {
        boolean encontro = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (this.palabra.charAt(i) == letra) {
                encontro = true;
                this.pista[i] = letra;
            }
        }
        return encontro;
    }

    private void arriesgarLetra() {
        char letra;
        boolean flag = false; // controlo que lo ingresado sea una letra
        do {
            System.out.print("\n Elige una letra ->  ");
            letra = scan.nextLine().toLowerCase().charAt(0);
            if (esLetra(letra)) {
                flag = true;
                if (!this.buscarLetra(letra)) {
                    this.vidas--;
                    System.out.println(
                            "\n La letra no se encuentra, perdio una vida, presiona enter para continuar");
                    this.scan.nextLine();
                } else {
                    System.out.println("\n La letra se encuentra, felicidades!, presiona enter para continuar");
                    this.scan.nextLine();
                }
            } else {
                System.out.println("\n No es una letra, presiona enter para continuar");
                this.scan.nextLine();
            }
        } while (!flag);
    }

    private void arriesgarPalabra() {
        System.out.print("\n Ingrese la palabra que quiere arriezgar ->  ");
        String respuesta = scan.nextLine().toLowerCase();
        if (respuesta.equals(palabra)) {
            System.out.println("\n Felicidades, acertaste la palabra, ganaste!, presiona enter para continuar");
            this.scan.nextLine();
            this.vidas = 99;
        } else {
            System.out.println("\n La palabra no es correcta, perdio una vida, presiona enter para continuar");
            this.scan.nextLine();
            this.vidas--;
        }
    }
}
