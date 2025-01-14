package Java.Ejercicios.pooAvanzado.enums.ejerColor.enums;

public enum Color {
    ROJO("#FF0000"),
    AZUL("#0000FF"),
    AMARILLO("#FFFF00");

    private String valorHexadecimal;

    Color(String valorHexadecimal) {
        this.valorHexadecimal = valorHexadecimal;
    }

    public String getValorHexadecimal() {
        return valorHexadecimal;
    }
}
