package inventarioBLL;

import java.util.List;

import InventarioDAL.HistorialDAO;
import InventarioDAL.HistorialMovimientoVista;

/**
 * Servicio de negocio para HistorialMovimientoVista.
 */
public class HistorialService {

    private HistorialDAO dao;

    public HistorialService() {
        dao = new HistorialDAO();
    }

    /**
     * Obtiene todos los movimientos del historial desde la capa de datos.
     * @return lista de HistorialMovimientoVista
     */
    public List<HistorialMovimientoVista> obtenerTodosLosMovimientos() {
        return dao.obtenerTodosLosMovimientos();
    }

    // Aquí puedes agregar más lógica de negocio, validaciones o filtros si lo necesitas.
}
