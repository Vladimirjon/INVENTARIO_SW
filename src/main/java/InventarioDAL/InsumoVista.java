package InventarioDAL;

/**
 * Representa la vista de insumos en el inventario.
 */
public class InsumoVista {
    private int Id_Insumo;
    private int Id_Proveedor;
    private String CUDIM;
    private String Nombre_Generico;
    private String Nombre_Comercial;
    private int Cantidad;
    private String Especificacion_Tecnica;
    private String Especialidad;

    public InsumoVista(int Id_Insumo,
                       int Id_Proveedor,
                       String CUDIM,
                       String Nombre_Generico,
                       String Nombre_Comercial,
                       int Cantidad,
                       String Especificacion_Tecnica,
                       String Especialidad) {
        this.Id_Insumo = Id_Insumo;
        this.Id_Proveedor = Id_Proveedor;
        this.CUDIM = CUDIM;
        this.Nombre_Generico = Nombre_Generico;
        this.Nombre_Comercial = Nombre_Comercial;
        this.Cantidad = Cantidad;
        this.Especificacion_Tecnica = Especificacion_Tecnica;
        this.Especialidad = Especialidad;
    }

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int Id_Insumo) {
        this.Id_Insumo = Id_Insumo;
    }

    public int getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(int Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }

    public String getCUDIM() {
        return CUDIM;
    }

    public void setCUDIM(String CUDIM) {
        this.CUDIM = CUDIM;
    }

    public String getNombre_Generico() {
        return Nombre_Generico;
    }

    public void setNombre_Generico(String Nombre_Generico) {
        this.Nombre_Generico = Nombre_Generico;
    }

    public String getNombre_Comercial() {
        return Nombre_Comercial;
    }

    public void setNombre_Comercial(String Nombre_Comercial) {
        this.Nombre_Comercial = Nombre_Comercial;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getEspecificacion_Tecnica() {
        return Especificacion_Tecnica;
    }

    public void setEspecificacion_Tecnica(String Especificacion_Tecnica) {
        this.Especificacion_Tecnica = Especificacion_Tecnica;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
}
