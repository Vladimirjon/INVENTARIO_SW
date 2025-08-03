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

import InventarioDAL.EntregasVista;
import InventarioDAL.HistorialMovimientoVista;
import InventarioDAL.InsumoVista;
import InventarioDAL.MedicamentoVista;
import InventarioDAL.PedidoVista;
import InventarioDAL.ProveedorVista;
import inventarioBLL.ConductorVistaService;
import inventarioBLL.EntregaService;
import inventarioBLL.HistorialService;
import inventarioBLL.InsumoService;
import inventarioBLL.PedidoService;
import inventarioBLL.ProveedorVistaService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
colFechaExpiracion     .setCellValueFactory(new PropertyValueFactory<>("fechaExpiracion"));
colCantidadPedido      .setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
colValorUnitario       .setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
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
    @FXML private Button btnBuscar;
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
@FXML private TableView<PedidoVista> tblPedidos;
@FXML private TableColumn<PedidoVista, Integer>    colIdPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdProveedorPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdMedicamentoPedido;
@FXML private TableColumn<PedidoVista, Integer>    colIdInsumoPedido;
@FXML private TableColumn<PedidoVista, LocalDate>  colFechaExpiracion;
@FXML private TableColumn<PedidoVista, Integer>    colCantidadPedido;
@FXML private TableColumn<PedidoVista, BigDecimal> colValorUnitario;
@FXML private TableColumn<PedidoVista, LocalDate>  colFechaPedido;
@FXML private TableColumn<PedidoVista, String>     colObservacion;

// Tabla Entregas
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
    // 1) Llama al servicio
    EntregaService svc = new EntregaService();
    List<EntregasVista> lista = svc.obtenerTodasLasEntregas();

    // 2) Convierte a ObservableList
    ObservableList<EntregasVista> data = FXCollections.observableArrayList(lista);

    // 3) Asigna al TableView
    tblEntregas.setItems(data);
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
    



    @FXML private void handleBuscar(ActionEvent event) {
    //LocalDate desde = dpFechaDesde.getValue();
    //LocalDate hasta = dpFechaHasta.getValue();
    // 1) Validación sencilla
    /*if (desde == null || hasta == null || desde.isAfter(hasta)) {
        new Alert(Alert.AlertType.WARNING,
            "Seleccione un rango de fechas válido."
        ).showAndWait();
        return;
    }*/}}


