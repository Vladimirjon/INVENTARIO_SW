package InventarioDAL;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa la vista de pedidos en el inventario.
 */
public class PedidoVista {
    private int        idPedido;
    private int        idProveedor;
    private int        idMedicamento;
    private int        idInsumo;
    private LocalDate  fechaExpiracion;    // <-- cambio aquí
    private int        cantidad;
    private BigDecimal valorUnitario;
    private LocalDate  fechaPedido;        // <-- aquí también
    private String     observacion;

    public PedidoVista(int idPedido,
                       int idProveedor,
                       int idMedicamento,
                       int idInsumo,
                       LocalDate fechaExpiracion,
                       int cantidad,
                       BigDecimal valorUnitario,
                       LocalDate fechaPedido,
                       String observacion) {
        this.idPedido        = idPedido;
        this.idProveedor     = idProveedor;
        this.idMedicamento   = idMedicamento;
        this.idInsumo        = idInsumo;
        this.fechaExpiracion = fechaExpiracion;
        this.cantidad        = cantidad;
        this.valorUnitario   = valorUnitario;
        this.fechaPedido     = fechaPedido;
        this.observacion     = observacion;
    }

    // getters / setters en lowerCamelCase…
    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int v) { idPedido = v; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int v) { idProveedor = v; }

    public int getIdMedicamento() { return idMedicamento; }
    public void setIdMedicamento(int v) { idMedicamento = v; }

    public int getIdInsumo() { return idInsumo; }
    public void setIdInsumo(int v) { idInsumo = v; }

    public LocalDate getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(LocalDate d) { fechaExpiracion = d; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int v) { cantidad = v; }

    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal v) { valorUnitario = v; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate d) { fechaPedido = d; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String s) { observacion = s; }
}
