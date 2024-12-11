package Java.Ejercicios.pooAvanzado.enums.ejerColor.modelos;

import Java.Ejercicios.pooAvanzado.enums.ejerColor.enums.Color;

public class ConvertidorColor {

    public static Color convertirHexadecimal(String valorHexadecimal) {
        for (Color color : Color.values()) {
            if (color.getValorHexadecimal().equals(valorHexadecimal)) {
                return color;
            }
        }
        return null;
    }
}
