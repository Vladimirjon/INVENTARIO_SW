package InventarioDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la tabla Entregas.
 */
public class EntregasDAO {

    /**
     * Recupera todas las entregas de la tabla Entregas.
     * @return lista de EntregaVista
     */
    public List<EntregasVista> obtenerTodasLasEntregas() {
        List<EntregasVista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Entregas";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EntregasVista entrega = new EntregasVista(
                    rs.getInt("id_entregas"),
                    rs.getInt("id_internacion"),
                    rs.getInt("id_proveedor"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("id_insumo"),
                    rs.getDate("fecha_entregas").toLocalDate(),
                    rs.getInt("cantidad"),
                    rs.getString("observacion")
                );
                lista.add(entrega);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar Entregas: " + e.getMessage());
        }

        return lista;
    }
}
