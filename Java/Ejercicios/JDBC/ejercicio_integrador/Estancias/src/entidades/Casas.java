package entidades;

import java.util.Date;

public class Casas {

  private int idCasa;
  private String calle;
  private int numero;
  private String codigoPostal;
  private String ciudad;
  private String pais;
  private Date fechaDesde;
  private Date fechaHasta;
  private int tiempoMinimo;
  private int tiempoMaximo;
  private double precioHabitacion;
  private String tipoVivienda;

  public Casas(
      int idCasa,
      String calle,
      int numero,
      String codigoPostal,
      String ciudad,
      String pais,
      Date fechaDesde,
      Date fechaHasta,
      int tiempoMinimo,
      int tiempoMaximo,
      double precioHabitacion,
      String tipoVivienda) {
    this.idCasa = idCasa;
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
    this.tiempoMinimo = tiempoMinimo;
    this.tiempoMaximo = tiempoMaximo;
    this.precioHabitacion = precioHabitacion;
    this.tipoVivienda = tipoVivienda;
  }

  public Casas(
      String calle,
      int numero,
      String codigoPostal,
      String ciudad,
      String pais,
      Date fechaDesde,
      Date fechaHasta,
      int tiempoMinimo,
      int tiempoMaximo,
      double precioHabitacion,
      String tipoVivienda) {
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.pais = pais;
    this.fechaDesde = fechaDesde;
    this.fechaHasta = fechaHasta;
    this.tiempoMinimo = tiempoMinimo;
    this.tiempoMaximo = tiempoMaximo;
    this.precioHabitacion = precioHabitacion;
    this.tipoVivienda = tipoVivienda;
  }

  public Casas() {}

  public int getIdCasa() {
    return idCasa;
  }

  public String getCalle() {
    return calle;
  }

  public int getNumero() {
    return numero;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getPais() {
    return pais;
  }

  public Date getFechaDesde() {
    return fechaDesde;
  }

  public Date getFechaHasta() {
    return fechaHasta;
  }

  public int getTiempoMinimo() {
    return tiempoMinimo;
  }

  public int getTiempoMaximo() {
    return tiempoMaximo;
  }

  public double getPrecioHabitacion() {
    return precioHabitacion;
  }

  public String getTipoVivienda() {
    return tipoVivienda;
  }

  public void setIdCasa(int idCasa) {
    this.idCasa = idCasa;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public void setFechaDesde(Date fechaDesde) {
    this.fechaDesde = fechaDesde;
  }

  public void setFechaHasta(Date fechaHasta) {
    this.fechaHasta = fechaHasta;
  }

  public void setTiempoMinimo(int tiempoMinimo) {
    this.tiempoMinimo = tiempoMinimo;
  }

  public void setTiempoMaximo(int tiempoMaximo) {
    this.tiempoMaximo = tiempoMaximo;
  }

  public void setPrecioHabitacion(double precioHabitacion) {
    this.precioHabitacion = precioHabitacion;
  }

  public void setTipoVivienda(String tipoVivienda) {
    this.tipoVivienda = tipoVivienda;
  }

  @Override
  public String toString() {
    return "Casas [IdCasa="
        + idCasa
        + ", calle="
        + calle
        + ", numero="
        + numero
        + ", codigoPostal="
        + codigoPostal
        + ", ciudad="
        + ciudad
        + ", pais="
        + pais
        + ", fechaDesde="
        + fechaDesde
        + ", fechaHasta="
        + fechaHasta
        + ", tiempoMinimo="
        + tiempoMinimo
        + ", tiempoMaximo="
        + tiempoMaximo
        + ", precioHabitacion="
        + precioHabitacion
        + ", tipoVivienda="
        + tipoVivienda
        + "]";
  }
}
