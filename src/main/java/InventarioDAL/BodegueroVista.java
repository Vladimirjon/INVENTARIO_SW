// Archivo: InventarioDAL/BodegueroVista.java
package InventarioDAL;

/**
 * Representa la vista de un Bodeguero.
 */
public class BodegueroVista {
    private String Cedula;
    private String Nombres;
    private String Apellidos;
    private String Contrasena;

    public BodegueroVista(String Cedula, String Nombres, String Apellidos, String Contrasena) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Contrasena = Contrasena;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
}
