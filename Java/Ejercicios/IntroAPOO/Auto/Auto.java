package Java.Ejercicios.IntroAPOO.Auto;

/* Actividad: Usando los constructores
El propósito de esta actividad es implementar el uso de constructores.


Crea una clase llamada Auto

Define 3 atributos para la clase: marca, modelo y anio. 

Crea los siguientes constructores:

Constructor que inicialice marca, modelo y anio

Constructor que inicialice marca y modelo 

Constructor que inicialice solamente la marca

Constructor sin parámetros

Escribe el método “imprimirDatos” dentro de la clase “Auto”, que al ser 
invocado imprima en consola su marca, modelo y anio. Teniendo en cuenta que algunos atributos 
pueden no ser inicializados, el método “print” debe detectar e imprimir sólo aquellos atributos 
con valor asignado o mostrar un mensaje en el caso de haber sido inicializado con el constructor sin parámetros. 

Crea al menos 4 objetos para poder probar todos los constructores de la clase, con 
diferentes valores y muestra sus atributos en la consola.

 */

public class Auto {
    private String marca;
    private String modelo;
    private int anio;

    public Auto(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Auto(String marca) {
        this.marca = marca;
    }

    public Auto() {
    }

    public void imprimirDatos() {
        if (marca != null || modelo != null || anio != 0) {
            if (marca != null) {
                System.out.println("Marca: " + marca);
            }
            if (modelo != null) {
                System.out.println("Modelo: " + modelo);
            }
            if (anio != 0) {
                System.out.println("anio: " + anio);
            }
        } else {
            System.out.println("No hay datos para mostrar");
        }
    }

}
