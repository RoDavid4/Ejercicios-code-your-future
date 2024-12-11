package Java.Ejercicios.pooAvanzado.enums.ejerDiaSemana;
import java.util.Random;
import Java.Ejercicios.pooAvanzado.enums.ejerDiaSemana.enums.DiaSemana;

public class Application {
    /* 
     * Actividad: Días de la semana
     * 
     * Crea el enum "DiaSemana" que represente los días de la semana, definiendo las
     * constantes correspondientes a los días: LUNES, MARTES, MIÉRCOLES, JUEVES,
     * VIERNES, SÁBADO y DOMINGO.
     * 
     * En la clase "DiaSemana", agrega un método llamado "esDiaLaboral()" que
     * devuelva un valor booleano indicando si el día es laboral o no. Para esto,
     * los días SÁBADO y DOMINGO no serán considerados días laborales.
     * 
     * En la clase "Application", crea un arreglo de objetos "DiaSemana" con 10 días
     * de la semana generados al azar, esto es para evitar la entrada manual de
     * datos.
     * 
     * Implementa un método llamado "imprimirDiaLaboral()" en la clase "Application"
     * que tome como parámetro un objeto de tipo "DiaSemana" y utilice el método
     * "esDiaLaboral()" para determinar si el día es laboral o no. Este método
     * devolverá un mensaje indicando si es "Día laboral" o "No es día laboral",
     * según corresponda al día proporcionado.
     */
    public static void main(String[] args) {
        DiaSemana[] dias = new DiaSemana[10];
        System.out.println("\033\143");

        for (int i = 0; i < dias.length; i++) {
            dias[i] = DiaSemana.values()[new Random().nextInt(DiaSemana.values().length)];
        }

        for (DiaSemana diaSemana : dias) {
            System.out.println("El día " + diaSemana);
            imprimirDiaLaboral(diaSemana); 
        }

    }

    private static void imprimirDiaLaboral(DiaSemana dia) {
        if (dia.esDiaLaboral()) {
            System.out.println("Es un día laboral");
        } else {
            System.out.println("No es un día laboral");
        }
    }
}
