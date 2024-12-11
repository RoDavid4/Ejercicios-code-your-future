package Java.Ejercicios.pooAvanzado.geoAbstracta;

public class Rectangulo extends Figura implements Dibujable {
    private double base;
    private double altura;

    @Override
    public void dibujar() {
        System.out.println("Rectangulo");
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public double getBase() {
        return base;
    }

    public Rectangulo() {
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
