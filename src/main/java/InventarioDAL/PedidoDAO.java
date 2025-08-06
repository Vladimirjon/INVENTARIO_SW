// PedidoDAO.java
package InventarioDAL;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la tabla Pedidos.
 */
public class PedidoDAO {

    /**
     * Recupera todos los pedidos de la tabla Pedidos.
     * @return lista de PedidoVista
     */
    public List<PedidoVista> obtenerTodosLosPedidos() {
        List<PedidoVista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Pedidos";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PedidoVista pedido = new PedidoVista(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_proveedor"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("id_insumo"),
                    rs.getInt("cantidad"),
                    rs.getDate("fecha_pedido").toLocalDate(),
                    rs.getString("observacion")
                );
                lista.add(pedido);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar Pedidos: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Inserta un nuevo pedido usando el stored procedure sp_InsertarPedido.
     * @return el nuevo id_pedido generado, o -1 si hubo error
     */
public int insertarPedido(int idProveedor, Integer idMedicamento, Integer idInsumo, int cantidad, LocalDate fechaPedido, String observacion) {
    int newIdPedido = -1;
    String sql = "{call sp_InsertarPedido(?, ?, ?, ?, ?, ?)}";
    try (Connection conn = ConexionBD.conectar();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setInt(1, idProveedor);

        if (idMedicamento != null) {
            stmt.setInt(2, idMedicamento);
        } else {
            stmt.setNull(2, java.sql.Types.INTEGER);
        }

        if (idInsumo != null) {
            stmt.setInt(3, idInsumo);
        } else {
            stmt.setNull(3, java.sql.Types.INTEGER);
        }

        stmt.setInt(4, cantidad);
        stmt.setDate(5, java.sql.Date.valueOf(fechaPedido));
        stmt.setString(6, observacion);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            newIdPedido = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return newIdPedido;
}

public List<PedidoVista> filtrarPedidos(Integer idPedido, Integer idMedicamento, Integer idInsumo) {
    List<PedidoVista> lista = new ArrayList<>();
    
    StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Pedidos WHERE 1=1");

    // Filtros opcionales
    if (idPedido != null) {
        sql.append(" AND id_pedido = ?");
    }
    if (idMedicamento != null) {
        sql.append(" AND id_medicamento = ?");
    }
    if (idInsumo != null) {
        sql.append(" AND id_insumo = ?");
    }

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql.toString())) {

        int paramIndex = 1;

        // Set parameters
        if (idPedido != null) {
            ps.setInt(paramIndex++, idPedido);
        }
        if (idMedicamento != null) {
            ps.setInt(paramIndex++, idMedicamento);
        }
        if (idInsumo != null) {
            ps.setInt(paramIndex++, idInsumo);
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PedidoVista pedido = new PedidoVista(
                rs.getInt("id_pedido"),
                rs.getInt("id_proveedor"),
                rs.getInt("id_medicamento"),
                rs.getInt("id_insumo"),
                rs.getInt("cantidad"),
                rs.getDate("fecha_pedido").toLocalDate(),
                rs.getString("observacion")
            );
            lista.add(pedido);
        }

    } catch (SQLException e) {
        System.err.println("Error al filtrar los pedidos: " + e.getMessage());
    }

    return lista;
}

}