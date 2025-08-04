/***************************************
 * 2) Catálogos básicos
 ***************************************/

CREATE TABLE dbo.Proveedor (
    id_proveedor   INT IDENTITY(1,1) PRIMARY KEY,
    ruc            VARCHAR(20)   NOT NULL,
    nombre         VARCHAR(150)  NOT NULL
);
GO


CREATE TABLE dbo.Medicamento (
    id_medicamento     INT           IDENTITY(1,1) PRIMARY KEY,
    id_proveedor       INT           NOT NULL
        CONSTRAINT FK_Medicamento_Proveedor 
        REFERENCES dbo.Proveedor(id_proveedor),
    CUM                VARCHAR(50)   NOT NULL,
    nombre_generico    VARCHAR(100)  NOT NULL,
    nombre_comercial   VARCHAR(100)  NOT NULL,
    cantidad           INT           NOT NULL,
    forma_farmaceutica VARCHAR(50)   NOT NULL,
    concentracion      VARCHAR(50)   NOT NULL,
    presentacion       VARCHAR(100)  NOT NULL
);
GO

CREATE TABLE dbo.Insumo (
    id_insumo              INT           IDENTITY(1,1) PRIMARY KEY,
    id_proveedor           INT           NOT NULL
        CONSTRAINT FK_Insumo_Proveedor
        REFERENCES dbo.Proveedor(id_proveedor),
    cudim                  VARCHAR(20)   NOT NULL,
    nombre_generico        VARCHAR(100)  NOT NULL,
    nombre_comercial       VARCHAR(100)  NOT NULL,    
    cantidad               INT           NOT NULL,
    especificacion_tecnica VARCHAR(250)  NULL,
    especialidad           VARCHAR(250)  NULL
);
GO

/***************************************
 * 3) Movimientos: Pedidos (compras)
 ***************************************/
-- Crear la nueva tabla Pedidos
CREATE TABLE dbo.Pedidos (
    id_pedido         INT            NOT NULL PRIMARY KEY,  -- Sin IDENTITY

    -- Foreign key a internacion (permite duplicados)
    id_internacion    INT            NULL
        CONSTRAINT FK_Id_Internacion 
        REFERENCES [dbo].[Internación](id_internacion),

    -- Asegura que solo uno de los dos (medicamento o insumo) esté presente
    CONSTRAINT CHK_Pedidos_Item CHECK (
        (id_medicamento IS NOT NULL AND id_insumo IS NULL)
     OR (id_medicamento IS NULL    AND id_insumo IS NOT NULL)
    ),
    
    -- A quién le pides
    id_proveedor      INT            NOT NULL
        CONSTRAINT FK_Pedidos_Proveedor 
        REFERENCES dbo.proveedor(id_proveedor),
    
    -- Pedido de medicamento o insumo
    id_medicamento    INT            NULL
        CONSTRAINT FK_Pedidos_Medicamento 
        REFERENCES dbo.medicamento(id_medicamento),
    id_insumo         INT            NULL
        CONSTRAINT FK_Pedidos_Insumo 
        REFERENCES dbo.Insumo(id_insumo),
    
    -- Datos del pedido
    cantidad          INT            NOT NULL,
    fecha_pedido      DATETIME       NOT NULL,
    observacion       NVARCHAR(MAX)  NULL,    
    
);
GO

/***************************************
 * 4) Movimientos: Entregas (egresos)
 ***************************************/

-- Crear la nueva tabla Entregas
CREATE TABLE dbo.Entregas (
    id_entregas       INT            IDENTITY(1,1) PRIMARY KEY,

    id_pedido         INT            NULL
        CONSTRAINT FK_Entregas_Pedido
        REFERENCES dbo.Pedidos(id_pedido),

    id_internacion    INT            NULL
        CONSTRAINT FK_Entregas_Internacion 
        REFERENCES [dbo].[Internación](id_internacion),

    id_proveedor      INT            NOT NULL
        CONSTRAINT FK_Entregas_Proveedor 
        REFERENCES dbo.proveedor(id_proveedor),

    id_medicamento    INT            NULL
        CONSTRAINT FK_Entregas_Medicamento 
        REFERENCES dbo.medicamento(id_medicamento),

    id_insumo         INT            NULL
        CONSTRAINT FK_Entregas_Insumo 
        REFERENCES dbo.Insumo(id_insumo),

    fecha_entregas    DATETIME       NOT NULL,
    cantidad          INT            NOT NULL,
    observacion       NVARCHAR(MAX)  NULL,

    CONSTRAINT CHK_Entregas_Item CHECK (
        (id_medicamento IS NOT NULL AND id_insumo IS NULL)
     OR (id_medicamento IS NULL    AND id_insumo IS NOT NULL)
    )
);
GO


/***************************************
 * 5) Historial de todos los movimientos
 ***************************************/

CREATE TABLE dbo.Historial_Movimientos (
    id_historial      INT            IDENTITY(1,1) PRIMARY KEY,
    id_internacion    INT            NULL
    CONSTRAINT FK_HistMov_Internacion REFERENCES dbo.[Internación](id_internacion),
    tipo_movimiento   NVARCHAR(20)   NOT NULL,   -- 'PEDIDO' | 'ENTREGA'
    id_proveedor      INT            NOT NULL
        CONSTRAINT FK_HistMov_Proveedor REFERENCES dbo.proveedor(id_proveedor),
    id_medicamento    INT            NULL
        CONSTRAINT FK_HistMov_Medicamento REFERENCES dbo.medicamento(id_medicamento),
    id_insumo         INT            NULL
        CONSTRAINT FK_HistMov_Insumo REFERENCES dbo.Insumo(id_insumo),
    fecha_movimiento  DATETIME       NOT NULL,
    cantidad          INT            NOT NULL,
    observacion     NVARCHAR(MAX)  NULL,
    CONSTRAINT CHK_HistMov_Item CHECK (
        (id_medicamento IS NOT NULL AND id_insumo IS NULL)
     OR (id_medicamento IS NULL AND id_insumo IS NOT NULL)
    )
);
GO