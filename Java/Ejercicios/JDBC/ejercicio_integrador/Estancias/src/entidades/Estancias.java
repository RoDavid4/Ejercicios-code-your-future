package entidades;

import java.util.Date;

public class Estancias {
    private int idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;
    
    public Estancias() {
    }

    public Estancias(Date fechaDesde, Date fechaHasta, int idCasa, int idCliente, String nombreHuesped) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.idCasa = idCasa;
        this.idCliente = idCliente;
        this.nombreHuesped = nombreHuesped;
    }

    public Estancias(Date fechaDesde, Date fechaHasta, int idCasa, int idCliente, int idEstancia, String nombreHuesped) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.idCasa = idCasa;
        this.idCliente = idCliente;
        this.idEstancia = idEstancia;
        this.nombreHuesped = nombreHuesped;
    }

    public int getIdEstancia() {
        return idEstancia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Estancias [idEstancia=" + idEstancia + ", idCliente=" + idCliente + ", idCasa=" + idCasa
                + ", nombreHuesped=" + nombreHuesped + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta
                + "]";
    }

}
