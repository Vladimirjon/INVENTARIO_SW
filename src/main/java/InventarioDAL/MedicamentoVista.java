/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventarioDAL;

/**
 *
 * @author Johann
 */
public class MedicamentoVista {
    
    private int Id_Medicamento;
    private String CUM;
    public int id_proveedor;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setProveedor(int proveedor) {
        id_proveedor = proveedor;
    }

    private String Nombre_Generico;
    public String getNombre_Generico() {
        return Nombre_Generico;
    }

    public void setNombre_Generico(String nombre_Generico) {
        Nombre_Generico = nombre_Generico;
    }

    private String Nombre_Comercial;
    public String getNombre_Comercial() {
        return Nombre_Comercial;
    }

    public void setNombre_Comercial(String nombre_Comercial) {
        Nombre_Comercial = nombre_Comercial;
    }

    private int Cantidad;
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    private String FormaFarmaceutica;
    public String getFormaFarmaceutica() {
        return FormaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        FormaFarmaceutica = formaFarmaceutica;
    }

    private String Concentracion;
    public String getConcentracion() {
        return Concentracion;
    }

    public void setConcentracion(String concentracion) {
        Concentracion = concentracion;
    }

    private String Presentacion;


    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        Presentacion = presentacion;
    }

    public MedicamentoVista(int Id_Medicamento, int id_proveedor, String CUM, String Nombre_Generico, String Nombre_Comercial,
                           int Cantidad, String FormaFarmaceutica, String Concentracion, String Presentacion) {
        
        this.Id_Medicamento = Id_Medicamento;
        this.id_proveedor = id_proveedor;
        this.CUM = CUM;
        this.id_proveedor = id_proveedor;
        this.Nombre_Generico = Nombre_Generico;
        this.Nombre_Comercial = Nombre_Comercial;
        this.Cantidad = Cantidad;
        this.FormaFarmaceutica = FormaFarmaceutica;
        this.Concentracion = Concentracion;
        this.Presentacion = Presentacion;
    }
    
    public int getId_Medicamento() {
        return Id_Medicamento;
    }

    public void setId_Medicamento(int id_Medicamento) {
        Id_Medicamento = id_Medicamento;
    }
    public String getCUM() {
        return CUM;
    }

    public void setCUM(String cUM) {
        CUM = cUM;
    }
    
    
    
}
