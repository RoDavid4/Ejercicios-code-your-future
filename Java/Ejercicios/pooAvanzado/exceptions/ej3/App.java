package Java.Ejercicios.pooAvanzado.exceptions.ej3;

import Java.Ejercicios.pooAvanzado.exceptions.ej3.models.CuentaBancaria;
import Java.Ejercicios.pooAvanzado.exceptions.ej3.models.SaldoInsuficienteException;

public class App {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        try {
            cuenta.retirar(500);
            System.out.println("Retiro exitoso");
            cuenta.retirar(2000);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
