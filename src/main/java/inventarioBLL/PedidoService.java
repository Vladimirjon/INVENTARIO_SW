package inventarioBLL;

import java.util.List;

import InventarioDAL.PedidoDAO;
import InventarioDAL.PedidoVista;

/**
 * Servicio de negocio para PedidoVista.
 */
public class PedidoService {

    private PedidoDAO dao;

    public PedidoService() {
        dao = new PedidoDAO();
    }

    /**
     * Obtiene todos los pedidos desde la capa de acceso a datos.
     * @return lista de PedidoVista
     */
    public List<PedidoVista> obtenerTodosLosPedidos() {
        return dao.obtenerTodosLosPedidos();
    }

    // Aquí puedes agregar más lógica de negocio, validaciones, filtros, etc.
}
