package Java.Ejercicios.IntroAPOO.modelos;

public class Triangulo {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    public static int contadorTriangulos = 0;

    public Triangulo(double base, double altura, double lado1, double lado2, double lado3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        contadorTriangulos++;
    }

    public double area() {
        return (this.base * this.altura) / 2;
    }

    public double perimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }

    public void imprimirArea() {
        System.out.println("El área del triángulo es: " + this.area());
    }

    public void imprimirPerimetro() {
        System.out.println("El perímetro del triángulo es: " + this.perimetro());
    }

    public static int getCantidadTriangulos() {
        return contadorTriangulos;
    }
}

