USE [polisalud]
GO

SELECT [id_entregas]
      ,[id_internacion]
      ,[id_proveedor]
      ,[id_medicamento]
      ,[id_insumo]
      ,[fecha_entregas]
      ,[cantidad]
      ,[observacion]
  FROM [dbo].[Entregas]

GO


USE [polisalud];
GO

-- =============================================
-- Author:      Jorge
-- Create date: 2025-08-03
-- Description: Inserta una nueva entrega en la tabla Entregas.
-- =============================================
CREATE PROCEDURE dbo.sp_InsertarEntrega
    @IdInternacion   INT,
    @IdProveedor     INT,
    @IdMedicamento   INT,
    @IdInsumo        INT,
    @FechaEntregas   DATE,
    @Cantidad        INT,
    @Observacion     VARCHAR(500)
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO dbo.Entregas
    (
        id_internacion,
        id_proveedor,
        id_medicamento,
        id_insumo,
        fecha_entregas,
        cantidad,
        observacion
    )
    VALUES
    (
        @IdInternacion,
        @IdProveedor,
        @IdMedicamento,
        @IdInsumo,
        @FechaEntregas,
        @Cantidad,
        @Observacion
    );

    -- Devuelve el nuevo id_entregas (asumiendo que es IDENTITY)
    SELECT SCOPE_IDENTITY() AS NewIdEntrega;
END
GO


-- =============================================
-- Author:      Johann
-- Create date: 2025-08-03
-- Description: Inserta un nuevo pedido en la tabla Pedidos.
-- =============================================
CREATE PROCEDURE dbo.sp_InsertarPedido
    @IdProveedor     INT,
    @IdMedicamento   INT,
    @IdInsumo        INT,
    @Cantidad        INT,
    @FechaPedido     DATETIME,
    @Observacion     NVARCHAR(MAX)
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO dbo.Pedidos
    (
        id_proveedor,
        id_medicamento,
        id_insumo,
        cantidad,
        fecha_pedido,
        observacion
    )
    VALUES
    (
        @IdProveedor,
        @IdMedicamento,
        @IdInsumo,
        @Cantidad,
        @FechaPedido,
        @Observacion
    );

    -- Devuelve el nuevo id_pedido (asumiendo que es IDENTITY)
    SELECT SCOPE_IDENTITY() AS NewIdPedido;
END
GO

select * from Pedidos

CREATE PROCEDURE dbo.sp_InsertarHistorialEntrega
    @IdInternacion   INT = NULL,
    @IdProveedor     INT,
    @IdMedicamento   INT = NULL,
    @IdInsumo        INT = NULL,
    @FechaMovimiento DATETIME,
    @Cantidad        INT,
    @Observacion     NVARCHAR(MAX)
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO dbo.Historial
    (
        id_internacion,
        tipo_movimiento,
        id_proveedor,
        id_medicamento,
        id_insumo,
        fecha_movimiento,
        cantidad,
        observacion
    )
    VALUES
    (
        @IdInternacion,     -- id_internacion (puede ser NULL)
        'ENTREGA',          -- tipo_movimiento
        @IdProveedor,
        @IdMedicamento,
        @IdInsumo,
        @FechaMovimiento,
        @Cantidad,
        @Observacion
    );
END
GO
