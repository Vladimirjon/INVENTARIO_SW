package inventarioBLL;

import java.util.List;

import InventarioDAL.InsumoDAO;
import InventarioDAL.InsumoVista;

/**
 * Servicio de negocio para InsumoVista.
 */
public class InsumoService {

    private InsumoDAO dao;

    public InsumoService() {
        dao = new InsumoDAO();
    }

    /**
     * Obtiene todos los insumos desde la capa de acceso a datos.
     * @return lista de InsumoVista
     */
    public List<InsumoVista> obtenerTodosLosInsumos() {
        return dao.obtenerTodosLosInsumos();
    }

    // Aquí puedes agregar más lógica de negocio, validaciones, filtros, etc.
}
