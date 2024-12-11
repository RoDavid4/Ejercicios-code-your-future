package Java.Ejercicios.pooAvanzado.exceptions.ej3.models;

public class CuentaBancaria {
    private Integer saldoInicial;

    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void retirar(int valor) throws SaldoInsuficienteException {
        if ((saldoInicial - valor) < 0) {
            throw new SaldoInsuficienteException("El monto a retirar es mayor al saldo disponible en la cuenta");
        } else {
            saldoInicial -= valor;
        }
    }

}
