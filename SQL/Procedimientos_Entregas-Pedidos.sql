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


-- Ejemplo de Uso

DECLARE @NuevoEntregaID INT;

EXEC dbo.sp_InsertarEntrega
    @IdInternacion = 3,
    @IdProveedor   = 5,
    @IdMedicamento = 12,
    @IdInsumo      = 20,
    @FechaEntregas = GETDATE(),
    @Cantidad      = 50,
    @Observacion   = 'Entrega de insumos y medicamentos';
-- Captura el ID generado:
-- SET @NuevoEntregaID = SCOPE_IDENTITY();
