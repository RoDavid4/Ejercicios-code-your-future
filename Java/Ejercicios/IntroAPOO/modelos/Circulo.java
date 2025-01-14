package Java.Ejercicios.IntroAPOO.modelos;

public class Circulo {
    private double radio;
    public static int contadorCirculos = 0;

    public Circulo(double radio) {
        this.radio = radio;
        contadorCirculos++;
    }

    public double area() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    public double circunferencia() {
        return 2 * Math.PI * this.radio;
    }

    public void imprimirArea() {
        System.out.println("El área del círculo es: " + this.area());
    }

    public void imprimirCircunferencia() {
        System.out.println("La circunferencia del círculo es: " + this.circunferencia());
    }

    public static int getCantidadCirculos() {
        return contadorCirculos;
    }
}


