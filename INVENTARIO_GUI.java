/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.inventario;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import inventarioBLL.ConductorVistaService;
import inventarioBLL.EntregaService;
import inventarioBLL.HistorialService;
import inventarioBLL.InsumoService;
import inventarioBLL.MedicamentoInsumoService;
import inventarioBLL.PedidoService;
import inventarioBLL.ProveedorVistaService;
import inventarioBLL.*;
import InventarioDAL.*;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 
 */
public class INVENTARIO_GUI implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        public class PedidoTemporal {
        private Integer idEntrega;
        private Integer idPedido;
        private Integer idInteracion;
        private String proveedor;
        private String medicamento;
        private String insumo;
        private LocalDate fecha;
        private int cantidad;
        private String observacion;

        public PedidoTemporal(Integer idEntrega, Integer idPedido, Integer idInteracion,
                              String proveedor, String medicamento, String insumo,
                              LocalDate fecha, int cantidad, String observacion) {
            this.idEntrega = idEntrega;
            this.idPedido = idPedido;
            this.idInteracion = idInteracion;
            this.proveedor = proveedor;
            this.medicamento = medicamento;
            this.insumo = insumo;
            this.fecha = fecha;
            this.cantidad = cantidad;
            this.observacion = observacion;
        }

        public Integer getIdEntrega() {
            return idEntrega;
        }

        public void setIdEntrega(Integer idEntrega) {
            this.idEntrega = idEntrega;
        }

        public Integer getIdPedido() {
            return idPedido;
        }

        public void setIdPedido(Integer idPedido) {
            this.idPedido = idPedido;
        }

        public Integer getIdInteracion() {
            return idInteracion;
        }

        public void setIdInteracion(Integer idInteracion) {
            this.idInteracion = idInteracion;
        }

        public String getProveedor() {
            return proveedor;
        }

        public void setProveedor(String proveedor) {
            this.proveedor = proveedor;
        }

        public String getMedicamento() {
            return medicamento;
        }

        public void setMedicamento(String medicamento) {
            this.medicamento = medicamento;
        }

        public String getInsumo() {
            return insumo;
        }

        public void setInsumo(String insumo) {
            this.insumo = insumo;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getObservacion() {
            return observacion;
        }

        public void setObservacion(String observacion) {
            this.observacion = observacion;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
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

//Temporal
colEntrega.setCellValueFactory(new PropertyValueFactory<>("idEntrega"));
colPedido.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
colInteracion.setCellValueFactory(new PropertyValueFactory<>("idInteracion"));
colProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
colMedicamento.setCellValueFactory(new PropertyValueFactory<>("medicamento"));
colInsumo.setCellValueFactory(new PropertyValueFactory<>("insumo"));
colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
colObservacion.setCellValueFactory(new PropertyValueFactory<>("observacion"));

tablaTemporal.setItems(listaPedidosTemporales);


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

// Tabla Entregas
@FXML private javafx.scene.control.TextField txtObservacionEntrega;
@FXML private javafx.scene.control.TextField txtCantidadEntrega;

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
   
// Tabla temporal

@FXML private TableView<PedidoTemporal> tablaTemporal;
@FXML private TableColumn<PedidoTemporal, Integer> colEntrega;
@FXML private TableColumn<PedidoTemporal, Integer> colPedido;
@FXML private TableColumn<PedidoTemporal, Integer> colInteracion;
@FXML private TableColumn<PedidoTemporal, String> colProveedorTemp;
@FXML private TableColumn<PedidoTemporal, String> colMedicamento;
@FXML private TableColumn<PedidoTemporal, String> colInsumo;
@FXML private TableColumn<PedidoTemporal, LocalDate> colFecha;
@FXML private TableColumn<PedidoTemporal, Integer> colCantidadTemp;
@FXML private TableColumn<PedidoTemporal, String> colObservacionTemp;

private ObservableList<PedidoTemporal> listaPedidosTemporales = FXCollections.observableArrayList();

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
    
    
  
}    @FXML private void handleSalir(ActionEvent event) {
        // Opción A: cerrar solo la ventana actual
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();

        // Opción B: terminar toda la aplicación
        // Platform.exit();
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
        new Alert(Alert.AlertType.WARNING, 
            "La cantidad debe ser un número entero positivo.").showAndWait();
        return;
    }

    String nombreProveedor = proveedor != null ? proveedor.getNombre() : "";
    String nombreMedicamento = medIns != null && medIns.getTipo().equals("MEDICAMENTO") ? medIns.getNombre() : "";
    String nombreInsumo = medIns != null && medIns.getTipo().equals("INSUMO") ? medIns.getNombre() : "";

    int nuevoIdPedido = listaPedidosTemporales.size() + 1; // Simulamos ID incremental

    PedidoTemporal pedidoTemp = new PedidoTemporal(
        null, // IdEntrega temporal
        nuevoIdPedido,
        null, // IdInteracion temporal
        nombreProveedor,
        nombreMedicamento,
        nombreInsumo,
        LocalDate.now(),
        cantidad,
        observacion
    );

    listaPedidosTemporales.add(pedidoTemp);

    new Alert(Alert.AlertType.INFORMATION, 
        "Pedido agregado a tabla temporal. ID: " + nuevoIdPedido).showAndWait();

    // Limpiar entradas
    choiceMedicamentoInsumo.setValue(null);
    txtCantidadPedido.clear();
    txtObservacionPedido.clear();
}
private Integer obtenerIdProveedorPorNombre(String nombreProveedor) {
    if (nombreProveedor == null) return null;

    for (ProveedorVista p : choiceProveedor.getItems()) {
        if (p.getNombre().equals(nombreProveedor)) {
            return p.getIdProveedor();
        }
    }

    return null; // Si no se encuentra
}

private Integer obtenerIdMedicamentoPorNombre(String nombreMed) {
    if (nombreMed == null || nombreMed.isEmpty()) {
        return null;
    }

    for (MedicamentoInsumoVista item : choiceMedicamentoInsumo.getItems()) {
        if ("MEDICAMENTO".equals(item.getTipo()) && nombreMed.equals(item.getNombre())) {
            return item.getId();
        }
    }

    return null;
}

private Integer obtenerIdInsumoPorNombre(String nombreIns) {
    if (nombreIns == null || nombreIns.isEmpty()) {
        return null;
    }

    for (MedicamentoInsumoVista item : choiceMedicamentoInsumo.getItems()) {
        if ("INSUMO".equals(item.getTipo()) && nombreIns.equals(item.getNombre())) {
            return item.getId();
        }
    }

    return null;
}

@FXML
private void handleGuardarPedido(ActionEvent event) {
        if (listaPedidosTemporales.isEmpty()) {
        new Alert(Alert.AlertType.WARNING, 
            "No hay pedidos temporales para guardar.").showAndWait();
        return;
    }

    PedidoDAO pedidoDAO = new PedidoDAO();
    boolean error = false;

    for (PedidoTemporal pedido : listaPedidosTemporales) {
        // Solo procesar los elementos que son PEDIDOS (IdPedido ≠ null)
        if (pedido.getIdPedido() == null) continue;

        Integer idProveedor = obtenerIdProveedorPorNombre(pedido.getProveedor());
        Integer idMedicamento = pedido.getMedicamento() != null && !pedido.getMedicamento().isEmpty() ? obtenerIdMedicamentoPorNombre(pedido.getMedicamento()) : null;
        Integer idInsumo = pedido.getInsumo() != null && !pedido.getInsumo().isEmpty() ? obtenerIdInsumoPorNombre(pedido.getInsumo()) : null;

        int newId = pedidoDAO.insertarPedido(
            idProveedor,
            idMedicamento,
            idInsumo,
            pedido.getCantidad(),
            pedido.getFecha(),
            pedido.getObservacion()
        );

        if (newId == -1) {
            error = true;
            System.out.println("Error al insertar pedido temporal con proveedor: " + pedido.getProveedor());
        }
    }

    if (!error) {
        new Alert(Alert.AlertType.INFORMATION, "Todos los pedidos temporales se han guardado en la base de datos.").showAndWait();
        listaPedidosTemporales.removeIf(p -> p.getIdPedido() != null); // Limpia los pedidos insertados
        cargarPedidos(); // Refresca tabla visual
        cargarHistorial();
    } else {
        new Alert(Alert.AlertType.ERROR, "Uno o más pedidos no se pudieron guardar.").showAndWait();
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
        new Alert(Alert.AlertType.WARNING, 
            "Debes seleccionar un proveedor, un medicamento/insumo y una cantidad.").showAndWait();
        return;
    }

    int cantidad;
    try {
        cantidad = Integer.parseInt(cantidadStr);
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        new Alert(Alert.AlertType.WARNING,
            "La cantidad debe ser un número entero positivo.").showAndWait();
        return;
    }

    // Obtener nombres
    String nombreProveedor = proveedor.getNombre();
    String nombreMedicamento = medIns.getTipo().equals("MEDICAMENTO") ? medIns.getNombre() : "";
    String nombreInsumo = medIns.getTipo().equals("INSUMO") ? medIns.getNombre() : "";

    // Simular ID incremental para la entrega temporal
    int nuevoIdEntrega = listaPedidosTemporales.size() + 1;

    // Agregar a la lista temporal
    PedidoTemporal entregaTemp = new PedidoTemporal(
        nuevoIdEntrega,           // IdEntrega
        null,                     // IdPedido (es una entrega, no un pedido)
        0,                        // IdInteracion (fijo en 0)
        nombreProveedor,
        nombreMedicamento,
        nombreInsumo,
        LocalDate.now(),
        cantidad,
        observacion
    );

    listaPedidosTemporales.add(entregaTemp);

    new Alert(Alert.AlertType.INFORMATION, 
        "Entrega añadida temporalmente con ID: " + nuevoIdEntrega).showAndWait();

    // Limpiar campos
    choiceProveedorEntregas.setValue(null);
    choiceMedicamentoInsumoEntregas.setValue(null);
    txtCantidadEntrega.clear();
    txtObservacionEntrega.clear();
}



@FXML
private void handleGuardarEntrega(ActionEvent event) {
 if (listaPedidosTemporales.isEmpty()) {
        new Alert(Alert.AlertType.WARNING, 
            "No hay entregas temporales para guardar.").showAndWait();
        return;
    }

    EntregasDAO entregaDAO = new EntregasDAO();
    boolean error = false;

    for (PedidoTemporal entrega : listaPedidosTemporales) {
        // Solo procesar entregas (idEntrega ≠ null y idPedido == null)
        if (entrega.getIdEntrega() == null || entrega.getIdPedido() != null) continue;

        Integer idProveedor = obtenerIdProveedorPorNombre(entrega.getProveedor());
        Integer idMedicamento = (entrega.getMedicamento() != null && !entrega.getMedicamento().isEmpty())
            ? obtenerIdMedicamentoPorNombre(entrega.getMedicamento())
            : null;
        Integer idInsumo = (entrega.getInsumo() != null && !entrega.getInsumo().isEmpty())
            ? obtenerIdInsumoPorNombre(entrega.getInsumo())
            : null;

        int newId = entregaDAO.insertarEntrega(
            entrega.getIdInteracion(), // Siempre 0
            idProveedor,
            idMedicamento,
            idInsumo,
            entrega.getFecha(),
            entrega.getCantidad(),
            entrega.getObservacion()
        );

        if (newId == -1) {
            error = true;
            System.out.println("Error al insertar entrega temporal con proveedor: " + entrega.getProveedor());
        }
    }

    if (!error) {
        new Alert(Alert.AlertType.INFORMATION, 
            "Todas las entregas temporales se han guardado en la base de datos.").showAndWait();
        listaPedidosTemporales.removeIf(e -> e.getIdEntrega() != null && e.getIdPedido() == null);
        cargarEntregas();
        cargarHistorial();
    } else {
        new Alert(Alert.AlertType.ERROR, 
            "Uno o más registros de entrega no se pudieron guardar.").showAndWait();
    }

    // Limpiar campos visuales
    choiceProveedorEntregas.setValue(null);
    choiceMedicamentoInsumoEntregas.setValue(null);
    txtCantidadEntrega.clear();
    txtObservacionEntrega.clear();
}

}