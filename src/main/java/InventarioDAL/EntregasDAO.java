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

    public int insertarEntrega(
        int idInternacion,
        int idProveedor,
        Integer idMedicamento,
        Integer idInsumo,
        java.time.LocalDate fechaEntregas,
        int cantidad,
        String observacion
) {
    int newIdEntrega = -1;
    String sql = "{call sp_InsertarEntrega(?, ?, ?, ?, ?, ?, ?)}";
    try (Connection conn = ConexionBD.conectar();
         java.sql.CallableStatement stmt = conn.prepareCall(sql)) {

        //stmt.setInt(1, idInternacion); -- DADO QUE NOSOTROS NO MANEJAMOS EL ID DE INTERNACION
        stmt.setNull(1, java.sql.Types.INTEGER);
        stmt.setInt(2, idProveedor);

        if (idMedicamento != null) {
            stmt.setInt(3, idMedicamento);
        } else {
            stmt.setNull(3, java.sql.Types.INTEGER);
        }

        if (idInsumo != null) {
            stmt.setInt(4, idInsumo);
        } else {
            stmt.setNull(4, java.sql.Types.INTEGER);
        }

        stmt.setDate(5, java.sql.Date.valueOf(fechaEntregas));
        stmt.setInt(6, cantidad);
        stmt.setString(7, observacion);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            newIdEntrega = rs.getInt(1); // O usa rs.getInt("NewIdEntrega") si tu SP lo devuelve con alias
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return newIdEntrega;
}
    
    public List<EntregasVista> filtrarEntregasPorProveedor(Integer idProveedor) {
    List<EntregasVista> lista = new ArrayList<>();
    String sql = "SELECT * FROM dbo.Entregas WHERE id_proveedor = ?";  // Solo filtrar por id_proveedor

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Establecer el parámetro del proveedor
        ps.setInt(1, idProveedor);

        ResultSet rs = ps.executeQuery();

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
        System.err.println("Error al consultar las entregas filtradas por proveedor: " + e.getMessage());
    }

    return lista;
}

}
