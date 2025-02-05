package entidades;

public class DetallePedido {
    private int idDetallePedido;
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private int precioUnidad;
    private int numeroLinea;
    
    public DetallePedido(int idDetallePedido, int idPedido, int idProducto, int cantidad, int precioUnidad,
            int numeroLinea) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    public DetallePedido(int idPedido, int idProducto, int cantidad, int precioUnidad, int numeroLinea) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    public DetallePedido() {
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return "DetallePedido [idDetallePedido=" + idDetallePedido + ", idPedido=" + idPedido + ", idProducto="
                + idProducto + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", numeroLinea="
                + numeroLinea + "]";
    }
}