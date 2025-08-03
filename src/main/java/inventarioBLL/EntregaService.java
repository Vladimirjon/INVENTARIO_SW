package inventarioBLL;

import java.util.List;

import InventarioDAL.EntregasDAO;
import InventarioDAL.EntregasVista;


/**
 * Servicio de negocio para EntregaVista.
 */
public class EntregaService {

    private EntregasDAO dao;

    public EntregaService() {
        dao = new EntregasDAO();
    }

    /**
     * Obtiene todas las entregas desde la capa de acceso a datos.
     * @return lista de EntregaVista
     */
    public List<EntregasVista> obtenerTodasLasEntregas() {
        return dao.obtenerTodasLasEntregas();
    }

    // Aquí puedes agregar más lógica de negocio, validaciones, filtros, etc.
}
