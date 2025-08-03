package InventarioDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la tabla Historial_Movimientos.
 */
public class HistorialDAO {

    /**
     * Recupera todos los registros del historial de movimientos.
     * @return lista de HistorialMovimientoVista
     */
    public List<HistorialMovimientoVista> obtenerTodosLosMovimientos() {
        List<HistorialMovimientoVista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Historial_Movimientos";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HistorialMovimientoVista mov = new HistorialMovimientoVista(
                    rs.getInt("id_historial"),
                    rs.getInt("id_internacion"),
                    rs.getString("tipo_movimiento"),
                    rs.getInt("id_proveedor"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("id_insumo"),
                    rs.getDate("fecha_movimiento").toLocalDate(),
                    rs.getInt("cantidad"),
                    rs.getString("observacion")
                );
                lista.add(mov);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar historial de movimientos: " + e.getMessage());
        }

        return lista;
    }
}
