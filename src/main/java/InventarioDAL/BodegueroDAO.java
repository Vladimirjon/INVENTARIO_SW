// Archivo: InventarioDAL/BodegueroDAO.java
package InventarioDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BodegueroDAO {

    /** Recupera todos los bodegueros */
    public List<BodegueroVista> obtenerTodosLosBodegueros() {
        List<BodegueroVista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Bodeguero";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new BodegueroVista(
                    rs.getString("Cedula"),
                    rs.getString("Nombres"),
                    rs.getString("Apellidos"),
                    rs.getString("Contrasena")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar bodegueros: " + e.getMessage());
        }

        return lista;
    }

public BodegueroVista autenticarPorNombre(String nombreCompleto, String contrasena) {
    String sql =
        "SELECT Cedula, Nombres, Apellidos, Contrasena " +
        "FROM polisalud.dbo.Bodeguero " +
        "WHERE CONCAT(Nombres,' ',Apellidos) = ? " +
        "  AND Contrasena = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombreCompleto);
        ps.setString(2, contrasena);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new BodegueroVista(
                    rs.getString("Cedula"),
                    rs.getString("Nombres"),
                    rs.getString("Apellidos"),
                    rs.getString("Contrasena")
                );
            }
        }

    } catch (SQLException e) {
        System.err.println("Error en autenticarPorNombre(): " + e.getMessage());
    }
    return null;
}


}
