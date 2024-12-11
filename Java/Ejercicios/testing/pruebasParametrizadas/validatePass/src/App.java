package Java.Ejercicios.testing.pruebasParametrizadas.validatePass.src;

public class App {
    public static void main(String[] args) {}

    public static boolean esPasswordSegura(String password) {
        return tieneMinimo8Caracteres(password) &&
                tieneMayusculaYMinuscula(password) &&
                tieneNumero(password) &&
                tieneCaracterEspecial(password);
    }

    private static boolean tieneMinimo8Caracteres(String password) {
        return password.length() >= 8;
    }

    private static boolean tieneMayusculaYMinuscula(String password) {
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            }

            if(tieneMayuscula && tieneMinuscula){
                break;
            }
        }

        return tieneMayuscula && tieneMinuscula;
    }

    private static boolean tieneNumero(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tieneCaracterEspecial(String password) {
        String caracteresEspeciales = "!@#$%^&*()-+=<>?/[]{}|";
        for (char c : password.toCharArray()) {
            if (caracteresEspeciales.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

}
