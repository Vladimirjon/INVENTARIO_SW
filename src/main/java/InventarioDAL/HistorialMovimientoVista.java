package InventarioDAL;

import java.time.LocalDate;

/**
 * Representa la vista de los movimientos de historial en el inventario.
 */
public class HistorialMovimientoVista {
    private int idHistorial;
    private int idInternacion;
    private String tipoMovimiento;
    private int idProveedor;
    private int idMedicamento;
    private int idInsumo;
    private LocalDate fechaMovimiento;
    private int cantidad;
    private String observacion;

    public HistorialMovimientoVista(int idHistorial,
                                    int idInternacion,
                                    String tipoMovimiento,
                                    int idProveedor,
                                    int idMedicamento,
                                    int idInsumo,
                                    LocalDate fechaMovimiento,
                                    int cantidad,
                                    String observacion) {
        this.idHistorial = idHistorial;
        this.idInternacion = idInternacion;
        this.tipoMovimiento = tipoMovimiento;
        this.idProveedor = idProveedor;
        this.idMedicamento = idMedicamento;
        this.idInsumo = idInsumo;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidad = cantidad;
        this.observacion = observacion;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdInternacion() {
        return idInternacion;
    }

    public void setIdInternacion(int idInternacion) {
        this.idInternacion = idInternacion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
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
