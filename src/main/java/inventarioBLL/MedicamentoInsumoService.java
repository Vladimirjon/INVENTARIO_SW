package inventarioBLL;

import java.util.*;
import InventarioDAL.*;

public class MedicamentoInsumoService {
    private MedicamentoVistaDAO medicamentoDAO = new MedicamentoVistaDAO();
    private InsumoDAO insumoDAO = new InsumoDAO();

    public List<MedicamentoInsumoVista> obtenerMedicamentosEInsumosPorProveedor(int idProveedor) {
        List<MedicamentoInsumoVista> lista = new ArrayList<>();
        lista.addAll(medicamentoDAO.obtenerMedicamentosPorProveedor(idProveedor));
        lista.addAll(insumoDAO.obtenerInsumosPorProveedor(idProveedor));
        return lista;
    }
}