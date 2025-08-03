package InventarioDAL;

import java.time.LocalDate;

/**
 * Representa la vista de entregas en el inventario.
 */
public class EntregasVista {
    private int idEntregas;
    private int idInternacion;
    private int idProveedor;
    private int idMedicamento;
    private int idInsumo;
    private LocalDate fechaEntregas;
    private int cantidad;
    private String observacion;

    public EntregasVista(int idEntregas,
                        int idInternacion,
                        int idProveedor,
                        int idMedicamento,
                        int idInsumo,
                        LocalDate fechaEntregas,
                        int cantidad,
                        String observacion) {
        this.idEntregas     = idEntregas;
        this.idInternacion  = idInternacion;
        this.idProveedor    = idProveedor;
        this.idMedicamento  = idMedicamento;
        this.idInsumo       = idInsumo;
        this.fechaEntregas  = fechaEntregas;
        this.cantidad       = cantidad;
        this.observacion    = observacion;
    }

    public int getIdEntregas() {
        return idEntregas;
    }

    public void setIdEntregas(int idEntregas) {
        this.idEntregas = idEntregas;
    }

    public int getIdInternacion() {
        return idInternacion;
    }

    public void setIdInternacion(int idInternacion) {
        this.idInternacion = idInternacion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public LocalDate getFechaEntregas() {
        return fechaEntregas;
    }

    public void setFechaEntregas(LocalDate fechaEntregas) {
        this.fechaEntregas = fechaEntregas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
