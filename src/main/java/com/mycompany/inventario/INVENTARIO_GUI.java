/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.inventario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import InventarioDAL.EntregasDAO;
import InventarioDAL.EntregasVista;
import InventarioDAL.HistorialMovimientoVista;
import InventarioDAL.InsumoVista;
import InventarioDAL.MedicamentoInsumoVista;
import InventarioDAL.MedicamentoVista;
import InventarioDAL.PedidoDAO;
import InventarioDAL.PedidoVista;
import InventarioDAL.ProveedorVista;
import inventarioBLL.ConductorVistaService;
import inventarioBLL.EntregaService;
import inventarioBLL.HistorialService;
import inventarioBLL.InsumoService;
import inventarioBLL.MedicamentoInsumoService;
import inventarioBLL.PedidoService;
import inventarioBLL.ProveedorVistaService;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 
 */
public class INVENTARIO_GUI implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarIdsDePedidos();  
        cargarIdsDeEntregas();
        
        // Medicamento
        colcodIdMedicamento.setCellValueFactory(new PropertyValueFactory<>("Id_Medicamento"));
        colcodCUM.setCellValueFactory(new PropertyValueFactory<>("CUM"));
        colProveedor.setCellValueFactory(new PropertyValueFactory<>("id_proveedor"));
        colNombreGenerico.setCellValueFactory(new PropertyValueFactory<>("Nombre_Generico"));
        colNombreComercial.setCellValueFactory(new PropertyValueFactory<>("Nombre_Comercial"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colFormaFarmaceutica.setCellValueFactory(new PropertyValueFactory<>("FormaFarmaceutica"));
        colConcentracion.setCellValueFactory(new PropertyValueFactory<>("Concentracion"));
        colPresentacion.setCellValueFactory(new PropertyValueFactory<>("Presentacion"));

//        // Proveedor
        colcodProveedor.setCellValueFactory(new PropertyValueFactory("idProveedor"));
        colNombreProveedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRUC.setCellValueFactory(new PropertyValueFactory<>("ruc"));

        // Insumos
        colIdInsumo              .setCellValueFactory(new PropertyValueFactory<>("Id_Insumo"));
        colIdProveedorInsumo     .setCellValueFactory(new PropertyValueFactory<>("Id_Proveedor"));
        colCUDIM                 .setCellValueFactory(new PropertyValueFactory<>("CUDIM"));
        colNombreGenericoInsumo  .setCellValueFactory(new PropertyValueFactory<>("Nombre_Generico"));
        colNombreComercialInsumo .setCellValueFactory(new PropertyValueFactory<>("Nombre_Comercial"));
        colCantidadInsumo        .setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        colEspecificacionTecnica .setCellValueFactory(new PropertyValueFactory<>("Especificacion_Tecnica"));
        colEspecialidad          .setCellValueFactory(new PropertyValueFactory<>("Especialidad"));


        // Pedidos
        colIdPedido            .setCellValueFactory(new PropertyValueFactory<>("idPedido"));
colIdProveedorPedido   .setCellValueFactory(new PropertyValueFactory<>("idProveedor"));
colIdMedicamentoPedido .setCellValueFactory(new PropertyValueFactory<>("idMedicamento"));
colIdInsumoPedido      .setCellValueFactory(new PropertyValueFactory<>("idInsumo"));
colCantidadPedido      .setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
colFechaPedido         .setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
colObservacion         .setCellValueFactory(new PropertyValueFactory<>("Observacion"));
// Entregas 
colIdEntregas      .setCellValueFactory(new PropertyValueFactory<>("idEntregas"));
colIdInternacion   .setCellValueFactory(new PropertyValueFactory<>("idInternacion"));
colIdProveedorEnt  .setCellValueFactory(new PropertyValueFactory<>("idProveedor"));
colIdMedicamentoEnt.setCellValueFactory(new PropertyValueFactory<>("idMedicamento"));
colIdInsumoEnt     .setCellValueFactory(new PropertyValueFactory<>("idInsumo"));
colFechaEntregas   .setCellValueFactory(new PropertyValueFactory<>("fechaEntregas"));
colCantidadEnt     .setCellValueFactory(new PropertyValueFactory<>("cantidad"));
colObservacionEnt  .setCellValueFactory(new PropertyValueFactory<>("observacion"));

// Historial
colIdHistorial     .setCellValueFactory(new PropertyValueFactory<>("idHistorial"));
colIdInternacionHist.setCellValueFactory(new PropertyValueFactory<>("idInternacion"));
colTipoMovimiento  .setCellValueFactory(new PropertyValueFactory<>("tipoMovimiento"));
colIdProveedorHist .setCellValueFactory(new PropertyValueFactory<>("idProveedor"));
colIdMedicamentoHist.setCellValueFactory(new PropertyValueFactory<>("idMedicamento"));
colIdInsumoHist    .setCellValueFactory(new PropertyValueFactory<>("idInsumo"));
colFechaMovimiento .setCellValueFactory(new PropertyValueFactory<>("fechaMovimiento"));
colCantidadHist    .setCellValueFactory(new PropertyValueFactory<>("cantidad"));
colObservacionHist .setCellValueFactory(new PropertyValueFactory<>("observacion"));


                // Listener: cada vez que cambie la pestaña seleccionada…
        tabPane.getSelectionModel().selectedItemProperty().addListener(this::onTabChanged);

        // Llamada inicial para que la visibilidad se ajuste al tab por defecto
        onTabChanged(null, null, tabPane.getSelectionModel().getSelectedItem());
      
        
    }    
    
    @FXML private Button btnSalir;
    @FXML private Button btnAñadirPedido;
    @FXML private Button btnAñadirEntrega;
    @FXML private TabPane tabPane;
    @FXML private Tab tabMedicamentos, tabProveedores, tabPedidos, tabEntregas, tabHistorial;
    

    // Tabla Medicamentos
    @FXML private TableView<MedicamentoVista> tblTerminal;
    @FXML private TableColumn<MedicamentoVista, Integer> colcodIdMedicamento;
    @FXML private TableColumn<MedicamentoVista, String> colcodCUM;
    @FXML private TableColumn<MedicamentoVista, String> colProveedor;
    @FXML private TableColumn<MedicamentoVista, String> colNombreGenerico;
    @FXML private TableColumn<MedicamentoVista, String> colNombreComercial;
    @FXML private TableColumn<MedicamentoVista, Integer> colCantidad;
    @FXML private TableColumn<MedicamentoVista, String> colFormaFarmaceutica;
    @FXML private TableColumn<MedicamentoVista, String> colConcentracion;
    @FXML private TableColumn<MedicamentoVista, String> colPresentacion;
    
    @FXML private TableView<ProveedorVista> tblProveedor;
    @FXML private TableColumn<ProveedorVista, Integer> colcodProveedor;
    @FXML private TableColumn<ProveedorVista, String> colNombreProveedor;
    @FXML private TableColumn<ProveedorVista, String> colRUC;
    
// Tabla Insumos 

@FXML private Tab tabInsumos;

@FXML private TableView<InsumoVista>   tblInsumos;
@FXML private TableColumn<InsumoVista, Integer> colIdInsumo;
@FXML private TableColumn<InsumoVista, Integer> colIdProveedorInsumo;
@FXML private TableColumn<InsumoVista, String>  colCUDIM;
@FXML private TableColumn<InsumoVista, String>  colNombreGenericoInsumo;
@FXML private TableColumn<InsumoVista, String>  colNombreComercialInsumo;
@FXML private TableColumn<InsumoVista, Integer> colCantidadInsumo;
@FXML private TableColumn<InsumoVista, String>  colEspecificacionTecnica;
@FXML private TableColumn<InsumoVista, String>  colEspecialidad;



// Tabla Pedidos

@FXML private javafx.scene.control.TextField txtObservacionPedido;
@FXML private javafx.scene.control.TextField txtCantidadPedido;
@FXML private ChoiceBox<ProveedorVista> choiceProveedor; // Cambia el tipo según tu modelo
@FXML private ChoiceBox<MedicamentoInsumoVista> choiceMedicamentoInsumo;      // Cambia el tipo según tu modelo
@FXML private TableView<PedidoVista> tblPedidos;
@FXML private TableColumn<PedidoVista, Integer>    colIdPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdProveedorPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdMedicamentoPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdInsumoPedido;
@FXML private TableColumn<PedidoVista, Integer>    colCantidadPedido;
@FXML private TableColumn<PedidoVista, LocalDate>  colFechaPedido;
@FXML private TableColumn<PedidoVista, String>     colObservacion;
@FXML private ChoiceBox<Integer> choiceIdPedido;

// Tabla Entregas
@FXML private javafx.scene.control.TextField txtObservacionEntrega;
@FXML private javafx.scene.control.TextField txtCantidadEntrega;
@FXML private ChoiceBox<Integer> choiceIdEntrega;

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//@FXML private ChoiceBox<InternacionVista> choiceInternacion; // Cambia el tipo según tabla de Internacion

@FXML private ChoiceBox<ProveedorVista> choiceProveedorEntregas; // Cambia el tipo según tu modelo
@FXML private ChoiceBox<MedicamentoInsumoVista> choiceMedicamentoInsumoEntregas;      // Cambia el tipo según tu modelo
@FXML private TableView<EntregasVista> tblEntregas;
@FXML private TableColumn<EntregasVista, Integer> colIdEntregas;
@FXML private TableColumn<EntregasVista, Integer> colIdInternacion;
@FXML private TableColumn<EntregasVista, Integer> colIdProveedorEnt;
@FXML private TableColumn<EntregasVista, Integer> colIdMedicamentoEnt;
@FXML private TableColumn<EntregasVista, Integer> colIdInsumoEnt;
@FXML private TableColumn<EntregasVista, LocalDateTime> colFechaEntregas;  // o <LocalDate> si usas LocalDate
@FXML private TableColumn<EntregasVista, Integer> colCantidadEnt;
@FXML private TableColumn<EntregasVista, String> colObservacionEnt;

// Tabla Historial
@FXML private TableView<HistorialMovimientoVista> tblHistorial;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colIdHistorial;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colIdInternacionHist;
@FXML private TableColumn<HistorialMovimientoVista, String>      colTipoMovimiento;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colIdProveedorHist;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colIdMedicamentoHist;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colIdInsumoHist;
@FXML private TableColumn<HistorialMovimientoVista, LocalDateTime> colFechaMovimiento;
@FXML private TableColumn<HistorialMovimientoVista, Integer>     colCantidadHist;
@FXML private TableColumn<HistorialMovimientoVista, String>      colObservacionHist;
   
    private void onTabChanged(ObservableValue<? extends Tab> obs, Tab oldTab, Tab newTab) {
    // — botones (ya lo tienes)
    
    
    boolean isViajes    = newTab == tabProveedores;
    boolean isHistorial = newTab == tabHistorial;
    boolean isTerminal = newTab == tabMedicamentos;
    boolean isEntregas = newTab == tabEntregas;
    boolean isPedidos = newTab == tabPedidos;

    
    
    if (isTerminal) {

    // 1) Llama al servicio
    ConductorVistaService service = new ConductorVistaService();
    List<MedicamentoVista> lista = service.obtenerTodosLosConductores();

    // 2) Convierte a ObservableList
    ObservableList<MedicamentoVista> data = FXCollections.observableArrayList(lista);


    // Insumos (corrección de nombre)
    InsumoService insSvc = new InsumoService();
    List<InsumoVista> insumos = insSvc.obtenerTodosLosInsumos();
    System.out.println(">> Insumos cargados: " + insumos.size());
    tblInsumos.setItems(FXCollections.observableArrayList(insumos));

    // 3) Asigna al TableView
    tblTerminal.setItems(data);
}
    if(isPedidos){

    // 1) Llama al servicio
    PedidoService svc = new PedidoService();
    List<PedidoVista> lista = svc.obtenerTodosLosPedidos();

    // 2) Convierte a ObservableList
    ObservableList<PedidoVista> data = FXCollections.observableArrayList(lista);

    // 3) Asigna al TableView
    tblPedidos.setItems(data);

    ProveedorVistaService proveedorService = new ProveedorVistaService();
    List<ProveedorVista> proveedores = proveedorService.obtenerTodosLosProveedores();
    ObservableList<ProveedorVista> obsProveedores = FXCollections.observableArrayList(proveedores);
    choiceProveedor.setItems(obsProveedores);  
    
    choiceProveedor.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
    if (newVal != null) {
        int idProveedor = newVal.getIdProveedor();
        MedicamentoInsumoService service = new MedicamentoInsumoService();
        List<MedicamentoInsumoVista> medInsumoList = service.obtenerMedicamentosEInsumosPorProveedor(idProveedor);
        ObservableList<MedicamentoInsumoVista> obsLista = FXCollections.observableArrayList(medInsumoList);
        choiceMedicamentoInsumo.setItems(obsLista);
    } else {
        choiceMedicamentoInsumo.getItems().clear();
    }
    });

    }

if (isHistorial) {
    // 1) Llama al servicio
    HistorialService svc = new HistorialService();
    List<HistorialMovimientoVista> movimientos = svc.obtenerTodosLosMovimientos();

    // 2) Convierte a ObservableList
    ObservableList<HistorialMovimientoVista> data = FXCollections.observableArrayList(movimientos);

    // 3) Asigna al TableView
    tblHistorial.setItems(data);
}



if (isEntregas) {
    // 1) Llama al servicio para cargar la tabla
    EntregaService svc = new EntregaService();
    List<EntregasVista> lista = svc.obtenerTodasLasEntregas();
    ObservableList<EntregasVista> data = FXCollections.observableArrayList(lista);
    tblEntregas.setItems(data);

    // 2) Llenar ChoiceBox de proveedores
    ProveedorVistaService proveedorService = new ProveedorVistaService();
    List<ProveedorVista> proveedores = proveedorService.obtenerTodosLosProveedores();
    ObservableList<ProveedorVista> obsProveedores = FXCollections.observableArrayList(proveedores);
    choiceProveedorEntregas.setItems(obsProveedores);

    // 3) Llenar ChoiceBox de medicamentos/insumos según proveedor seleccionado
    choiceProveedorEntregas.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
        if (newVal != null) {
            int idProveedor = newVal.getIdProveedor();
            MedicamentoInsumoService service = new MedicamentoInsumoService();
            List<MedicamentoInsumoVista> medInsumoList = service.obtenerMedicamentosEInsumosPorProveedor(idProveedor);
            ObservableList<MedicamentoInsumoVista> obsLista = FXCollections.observableArrayList(medInsumoList);
            choiceMedicamentoInsumoEntregas.setItems(obsLista);
        } else {
            choiceMedicamentoInsumoEntregas.getItems().clear();
        }
    });

    // 4) Internación: puedes dejar el campo deshabilitado y prellenado con "0"
    //txtInternacion.setText("0");
    //txtInternacion.setDisable(true);
}

    
    if (isViajes) {

    // 1) Llama al servicio
    ProveedorVistaService service = new ProveedorVistaService();
    List<ProveedorVista> lista = service.obtenerTodosLosProveedores();

    // 2) Convierte a ObservableList
    ObservableList<ProveedorVista> data = FXCollections.observableArrayList(lista);

    // 3) Asigna al TableView
    tblProveedor.setItems(data);
}
    
  
}    

@FXML 
private void handleSalir(ActionEvent event) {
    try {
        // Vuelve al Login cargando el FXML correspondiente
        App.setRoot("Login");
    } catch (IOException e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR,
            "No se pudo regresar al login:\n" + e.getMessage()
        ).showAndWait();
    }
}

    
private void cargarHistorial() {
    HistorialService historialService = new HistorialService();
    List<HistorialMovimientoVista> historial = historialService.obtenerTodosLosMovimientos();
    ObservableList<HistorialMovimientoVista> obsHistorial = FXCollections.observableArrayList(historial);
    tblHistorial.setItems(obsHistorial);
}

private void cargarPedidos() {
    PedidoService pedidoService = new PedidoService();
    List<PedidoVista> pedidos = pedidoService.obtenerTodosLosPedidos();
    ObservableList<PedidoVista> obsPedidos = FXCollections.observableArrayList(pedidos);
    tblPedidos.setItems(obsPedidos);
}


private void cargarIdsDePedidos() {
    // Llamar al servicio para obtener todos los pedidos
    PedidoService pedidoService = new PedidoService();
    List<PedidoVista> pedidos = pedidoService.obtenerTodosLosPedidos();

    // Crear una lista de IDs de pedidos
    List<Integer> idsPedidos = new ArrayList<>();
    for (PedidoVista pedido : pedidos) {
        idsPedidos.add(pedido.getIdPedido());  // Suponiendo que el método `getIdPedido()` retorna el ID de Pedido
    }

    // Convertir la lista de IDs a ObservableList
    ObservableList<Integer> obsIdsPedidos = FXCollections.observableArrayList(idsPedidos);
    
    // Asignar la lista observable al ChoiceBox de ID de Pedido
    choiceIdPedido.setItems(obsIdsPedidos);
}

private void cargarIdsDeEntregas() {
    // Llamar al servicio para obtener todos los ID de entregas
    EntregasDAO entregasDAO = new EntregasDAO();
    List<EntregasVista> entregas = entregasDAO.obtenerTodasLasEntregas();  // Obtener todas las entregas

    // Crear una lista de IDs de entregas
    List<Integer> idsEntregas = new ArrayList<>();
    for (EntregasVista entrega : entregas) {
        idsEntregas.add(entrega.getIdEntregas());  // Suponiendo que el método getIdEntregas() retorna el ID de entrega
    }

    // Convertir la lista de IDs a ObservableList
    ObservableList<Integer> obsIdsEntregas = FXCollections.observableArrayList(idsEntregas);
    
    // Asignar la lista observable al ChoiceBox de ID de entrega
    choiceIdEntrega.setItems(obsIdsEntregas);
}


@FXML
private void handleFiltrarPedidos(ActionEvent event) {
    // Obtener el valor seleccionado en el ChoiceBox de ID de Pedido
    Integer idPedido = choiceIdPedido.getValue();  // Obtener el valor seleccionado en el ChoiceBox

    // Obtener los valores seleccionados en los demás ChoiceBoxes
    ProveedorVista proveedor = choiceProveedor.getValue();
    MedicamentoInsumoVista medIns = choiceMedicamentoInsumo.getValue();

    // Filtrar los valores según el tipo (Medicamento o Insumo)
    Integer idMedicamento = (medIns != null && medIns.getTipo().equals("MEDICAMENTO")) ? medIns.getId() : null;
    Integer idInsumo = (medIns != null && medIns.getTipo().equals("INSUMO")) ? medIns.getId() : null;

    // Llamar al DAO para filtrar los pedidos usando el ID del pedido y los otros filtros
    PedidoDAO pedidoDAO = new PedidoDAO();
    List<PedidoVista> pedidosFiltrados = pedidoDAO.filtrarPedidos(idPedido, idMedicamento, idInsumo);

    // Convertir la lista filtrada a ObservableList
    ObservableList<PedidoVista> data = FXCollections.observableArrayList(pedidosFiltrados);

    // Asignar los datos filtrados a la tabla de pedidos
    tblPedidos.setItems(data);
}



@FXML
private void handleFiltrarEntregas(ActionEvent event) {
    // Obtener el ID de entrega seleccionado en el ChoiceBox
    Integer idEntrega = choiceIdEntrega.getValue();  // Obtener el valor seleccionado en el ChoiceBox

    if (idEntrega == null) {
        // Si no se seleccionó un ID de entrega, mostrar un mensaje de advertencia
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING,
            "Debe seleccionar un ID de entrega.").showAndWait();
        return;
    }

    // Llamar al DAO para obtener las entregas filtradas por el ID de entrega
    EntregasDAO entregasDAO = new EntregasDAO();
    List<EntregasVista> entregas = entregasDAO.filtrarEntregasPorId(idEntrega);

    // Actualizar la tabla con las entregas filtradas
    ObservableList<EntregasVista> data = FXCollections.observableArrayList(entregas);
    tblEntregas.setItems(data);
}




@FXML
private void handleAñadirPedido(ActionEvent event) {
    System.out.println("Añadir pedido presionado");

    ProveedorVista proveedor = choiceProveedor.getValue();
    MedicamentoInsumoVista medIns = choiceMedicamentoInsumo.getValue();
    String cantidadStr = txtCantidadPedido.getText();
    String observacion = txtObservacionPedido.getText();


    int cantidad;
    try {
        cantidad = Integer.parseInt(cantidadStr);
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING, 
            "La cantidad debe ser un número entero positivo.").showAndWait();
        return;
    }

    // Usar null en vez de 0 para cumplir la restricción CHECK
    Integer idMedicamento = medIns.getTipo().equals("MEDICAMENTO") ? medIns.getId() : null;
    Integer idInsumo = medIns.getTipo().equals("INSUMO") ? medIns.getId() : null;

    PedidoDAO pedidoDAO = new PedidoDAO();
    int newId = pedidoDAO.insertarPedido(
        proveedor.getIdProveedor(),
        idMedicamento,
        idInsumo,
        cantidad,
        LocalDate.now(),
        observacion
    );

    if (newId != -1) {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, 
            "Pedido registrado correctamente. ID generado: " + newId).showAndWait();
        cargarPedidos();
        cargarHistorial();
        choiceMedicamentoInsumo.setValue(null);
        txtCantidadPedido.clear();
        txtObservacionPedido.clear();
    } else {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR, 
            "Error al registrar el pedido.").showAndWait();
    }
}

private void cargarEntregas() {
    EntregaService entregaService = new EntregaService();
    List<EntregasVista> entregas = entregaService.obtenerTodasLasEntregas();
    ObservableList<EntregasVista> obsEntregas = FXCollections.observableArrayList(entregas);
    tblEntregas.setItems(obsEntregas);
}

@FXML
private void handleAñadirEntrega(ActionEvent event) {
    ProveedorVista proveedor = choiceProveedorEntregas.getValue();
    MedicamentoInsumoVista medIns = choiceMedicamentoInsumoEntregas.getValue();
    String cantidadStr = txtCantidadEntrega.getText();
    String observacion = txtObservacionEntrega.getText();

    // Validación
    if (proveedor == null || medIns == null || cantidadStr.isEmpty()) {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING, 
            "Debes seleccionar un proveedor, un medicamento/insumo y una cantidad.").showAndWait();
        return;
    }

    int cantidad;
    try {
        cantidad = Integer.parseInt(cantidadStr);
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING,
            "La cantidad debe ser un número entero positivo.").showAndWait();
        return;
    }

    // Internación siempre 0
    int idInternacion = 0;
    Integer idMedicamento = medIns.getTipo().equals("MEDICAMENTO") ? medIns.getId() : null;
    Integer idInsumo = medIns.getTipo().equals("INSUMO") ? medIns.getId() : null;

    EntregasDAO entregaDAO = new EntregasDAO();
    int newId = entregaDAO.insertarEntrega(
        idInternacion,
        proveedor.getIdProveedor(),
        idMedicamento,
        idInsumo,
        LocalDate.now(),
        cantidad,
        observacion
    );

    if (newId != -1) {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION,
            "Entrega registrada correctamente. ID generado: " + newId).showAndWait();
        cargarEntregas();
        cargarHistorial();
        choiceProveedor.setValue(null);
        choiceMedicamentoInsumo.setValue(null);
        txtCantidadEntrega.clear();
        txtObservacionEntrega.clear();
    } else {
        new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
            "Error al registrar la entrega.").showAndWait();
    }
}

}