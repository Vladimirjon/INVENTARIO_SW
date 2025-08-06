// Archivo: inventarioBLL/BodegueroService.java
package inventarioBLL;

import java.util.List;

import InventarioDAL.BodegueroDAO;
import InventarioDAL.BodegueroVista;

/**
 * Servicio de negocio para BodegueroVista.
 */
public class BodegueroService {

    private BodegueroDAO dao;

    public BodegueroService() {
        dao = new BodegueroDAO();
    }

    /** Obtiene todos los bodegueros */
    public List<BodegueroVista> obtenerTodosLosBodegueros() {
        return dao.obtenerTodosLosBodegueros();
    }

    public BodegueroVista autenticarUsuarioPorNombre(String nombreCompleto, String contrasena) {
        return dao.autenticarPorNombre(nombreCompleto, contrasena);
    }

}
