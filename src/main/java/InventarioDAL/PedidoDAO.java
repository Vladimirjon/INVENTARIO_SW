package InventarioDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    rs.getDate("fecha_expiracion").toLocalDate(),
                    rs.getInt("cantidad"),
                    rs.getBigDecimal("valor_unitario"),
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
}
