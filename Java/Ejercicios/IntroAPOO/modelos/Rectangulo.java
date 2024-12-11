package Java.Ejercicios.IntroAPOO.modelos;

public class Rectangulo {
    private double ancho;
    private double largo;
    public static int contadorRectangulos = 0;

    public Rectangulo(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
        contadorRectangulos++;
    }

    public double area() {
        return this.ancho * this.largo;
    }

    public double perimetro() {
        return 2 * (this.ancho + this.largo);
    }

    public void imprimirArea() {
        System.out.println("El área del rectángulo es: " + this.area());
    }

    public void imprimirPerimetro() {
        System.out.println("El perímetro del rectángulo es: " + this.perimetro());
    }

    public static int getCantidadRectangulos() {
        return contadorRectangulos;
    }
}
