package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO daoGamaProducto;

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionHtml, String descripcionTexto, String gama, String imagen) {

        try {
            GamaProducto gP = new GamaProducto();
            gP.setDescripcionHtml(descripcionHtml);
            gP.setDescripcionTexto(descripcionTexto);
            gP.setGama(gama);
            gP.setImagen(imagen);

            daoGamaProducto.guardarGamaProduto(gP);
            
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva gamaProducto de manera correcta");
        }

    }

}
