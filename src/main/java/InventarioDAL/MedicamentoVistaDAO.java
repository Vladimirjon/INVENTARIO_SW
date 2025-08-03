package InventarioDAL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoVistaDAO {

    /**
     * Recupera todos los medicamentos de la tabla Medicamento
     * @return lista de MedicamentoVista
     */
    public List<MedicamentoVista> obtenerTodosLosMedicamentos() {
        List<MedicamentoVista> lista = new ArrayList<>();
        String sql = ""
            + "SELECT id_medicamento, id_proveedor, CUM, "
            + "       nombre_generico, nombre_comercial, cantidad, "
            + "       forma_farmaceutica, concentracion, presentacion "
            + "FROM dbo.Medicamento";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MedicamentoVista m = new MedicamentoVista(
                    rs.getInt   ("id_medicamento"),
                    rs.getInt   ("id_proveedor"),
                    rs.getString("CUM"),
                    rs.getString("nombre_generico"),
                    rs.getString("nombre_comercial"),
                    rs.getInt   ("cantidad"),
                    rs.getString("forma_farmaceutica"),
                    rs.getString("concentracion"),
                    rs.getString("presentacion")
                );
                lista.add(m);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar Medicamentos: " + e.getMessage());
        }

        return lista;
    }

    public List<MedicamentoInsumoVista> obtenerMedicamentosPorProveedor(int idProveedor) {
        List<MedicamentoInsumoVista> lista = new ArrayList<>();
        String sql = "SELECT id_medicamento, nombre_comercial FROM Medicamento WHERE id_proveedor = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new MedicamentoInsumoVista(rs.getInt("id_medicamento"), rs.getString("nombre_comercial"), "MEDICAMENTO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // En MedicamentoVistaDAO
public LocalDate obtenerFechaExpiracionMedicamento(int idMedicamento) {
    String sql = "SELECT fecha_expiracion FROM Medicamento WHERE id_medicamento = ?";
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idMedicamento);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDate("fecha_expiracion").toLocalDate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public BigDecimal obtenerValorUnitarioMedicamento(int idMedicamento) {
    String sql = "SELECT valor_unitario FROM Medicamento WHERE id_medicamento = ?";
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idMedicamento);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getBigDecimal("valor_unitario");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return BigDecimal.ZERO;
}
}
