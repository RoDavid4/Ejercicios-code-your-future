package Java.Ejercicios.pooAvanzado.enums.ejerColor;

import Java.Ejercicios.pooAvanzado.enums.ejerColor.enums.Color;
import Java.Ejercicios.pooAvanzado.enums.ejerColor.modelos.ConvertidorColor;

public class Application {

    public static void main(String[] args) {
        String[] colores = { "#FF0000", "#FFFF00", "#0000FF", "#FF00FF", "#00FFFF" };
        for (String color : colores) {
            Color colorEnum = ConvertidorColor.convertirHexadecimal(color);
            if (colorEnum != null) {
                System.out.println(colorEnum);
            } else {
                System.out.println("No es un color primario");
            }
        }
    }

}
