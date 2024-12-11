package Java.Ejercicios.pooAvanzado.geoAbstracta;

public class Main {
    public static void main(String[] args) {
        Figura[] array = new Figura[3];
        array[0] = new Circulo(3);
        array[1] = new Triangulo(2, 3, 4, 1);
        array[2] = new Rectangulo(4, 5);

        for (Figura figura : array) {
            if (figura instanceof Circulo c) {
                c.dibujar();
            }
            if (figura instanceof Triangulo t) {
                t.dibujar();
            }
            if (figura instanceof Rectangulo r) {
                r.dibujar();
            }
            System.out.println("Area: " + figura.calcularArea());
            System.out.println("Perimetro: " + figura.calcularPerimetro());
        }
    }

}
