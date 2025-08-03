package InventarioDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsumoDAO {
    /**
     * Recupera todos los insumos de la tabla Insumo
     * @return lista de InsumoVista
     */
    public List<InsumoVista> obtenerTodosLosInsumos() {
        List<InsumoVista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Insumo";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InsumoVista insumo = new InsumoVista(
                    rs.getInt("id_insumo"),
                    rs.getInt("id_proveedor"),
                    rs.getString("cudim"),
                    rs.getString("nombre_generico"),
                    rs.getString("nombre_comercial"),
                    rs.getInt("cantidad"),
                    rs.getString("especificacion_tecnica"),
                    rs.getString("especialidad")
                );
                lista.add(insumo);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar Insumos: " + e.getMessage());
        }

        return lista;
    }
    public List<MedicamentoInsumoVista> obtenerInsumosPorProveedor(int idProveedor) {
        List<MedicamentoInsumoVista> lista = new ArrayList<>();
        String sql = "SELECT id_insumo, nombre_comercial FROM Insumo WHERE id_proveedor = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new MedicamentoInsumoVista(rs.getInt("id_insumo"), rs.getString("nombre_comercial"), "INSUMO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
