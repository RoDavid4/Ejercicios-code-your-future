package servicios;

import entidades.Familias;
import persistencia.FamiliasDAO;
import java.util.List;

public class FamiliasServicio {
    FamiliasDAO familiasDAO;
    
public FamiliasServicio() {
        familiasDAO = new FamiliasDAO();
    }

    public List<Familias> listarMinHijosEdadesMaximas(int cantidadHijos, int edadMaxima) throws Exception {
        validarListarMinHijosEdadesMaximas(cantidadHijos, edadMaxima);
        return familiasDAO.listarMinHijosEdadesMaximas(cantidadHijos, edadMaxima);
    }

    private void validarListarMinHijosEdadesMaximas(int cantidadHijos, int edadMaxima) throws Exception {
        if (cantidadHijos < 0 || edadMaxima < 0) {
            throw new Exception("Cantidad de hijos y edad máxima no pueden ser negativos");
        }
    }
}
