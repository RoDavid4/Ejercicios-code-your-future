package entidades;

public class Empleado {
    private int idEmpleado;
    private int codigoEmpleado;
    private String nombre;
    private String apellido;
    private String extension;
    private String email;
    private int idOficina;
    private int idJefe;
    private String puesto;

    public Empleado(int idEmpleado, int codigoEmpleado, String nombre, String apellido, String extension, String email,
            int idOficina, int idJefe, String puesto) {
        this.idEmpleado = idEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.extension = extension;
        this.email = email;
        this.idOficina = idOficina;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    public Empleado(int codigoEmpleado, String nombre, String apellido, String extension, String email, int idOficina,
            int idJefe, String puesto) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.extension = extension;
        this.email = email;
        this.idOficina = idOficina;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre
                + ", apellido=" + apellido + ", extension=" + extension + ", email=" + email + ", idOficina="
                + idOficina + ", idJefe=" + idJefe + ", puesto=" + puesto + "]";
    }
    
}
