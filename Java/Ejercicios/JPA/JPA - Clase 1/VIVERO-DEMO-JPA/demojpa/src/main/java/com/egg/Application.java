package com.egg;


import com.egg.servicios.GamaProductoServicio;

public class Application {

    public static void main(String[] args) {
        // Instanciar la clase OficinaServicio para acceder a sus métodos
        GamaProductoServicio gMP = new GamaProductoServicio();

        // Llamar al método del servicio para crear una nueva oficina
        gMP.crearGamaProducto("Nueva GAMA", "Gama de ejemplo testeo", "Gama Ejemplo", "Metadata imagen ejemplo");
                
    }
}

