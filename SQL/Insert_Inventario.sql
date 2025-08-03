use polisalud

-- Insert into Proveedor
INSERT INTO proveedor (ruc, nombre) VALUES
('0990000670001', 'ABBOTT LABORATORIOS DEL ECUADOR CIA. LTDA.'),
('1760003410001', 'ACDA PHARMA'),
('1791812670001', 'ABL PHARMA ECUADOR S.A.'),
('1790022900001', 'ADISA'),
('0990017190001', 'ACROMAX LABORATORIO QUÍMICO FARMACÉUTICO S.A.'),
('1791405552001', 'ALCONLAB ECUADOR S.A.'),
('1791253531001', 'BAXTER ECUADOR S.A.'),
('0190373185001', 'BIONCOMEDICA CIA. LTDA.'),
('1791888146001', 'CORPORACIÓN MAGMA ECUADOR S.A.'),
('1792285607001', 'DISTRIBUIDORA DE INSUMOS Y MEDICINAS JUAN BERRONES CÍA. LTDA.'),
('0992710853001', 'PROFARMEC CIA. LTDA.');

select * from proveedor

-- Inserción en Medicamento usando id_proveedor en lugar de nombre
INSERT INTO dbo.Medicamento
  (id_proveedor, CUM, nombre_generico, nombre_comercial, cantidad,
   forma_farmaceutica, concentracion, presentacion)
VALUES
  (1,  'J05AE030910', 'RITONAVIR',       'NORVIR 100 mg CÁPSULAS',                                      150, 'CÁPSULA',                     '100 mg',                  'CAJA X 1 FCO. X 84'),
  (1,  'J01FA090510', 'CLARITROMICINA',  'CLARITROMICINA TABLETAS 500 mg',                             200, 'TABLETA RECUBIERTA',          '500 mg',                  'CAJA X 1 BLÍSTER X 10'),
  (2,  'J01FA101211', 'AZITROMICINA',    'AZITROMICINA SUSPENSIÓN',                                     120, 'POLVO PARA SUSPENSIÓN',       '200 mg/5 ml',             '1 FCO. X 15 ml'),
  (2,  'N02BE015220', 'PARACETAMOL',     'PARACETAMOL (ACETAMINOFÉN) JARABE 150 mg/5 ml',               180, 'JARABE',                      '150 mg/5 ml',             '1 FCO. X 60 ml'),
  (3,  'A06AD113011', 'LACTULOSA',       'LACTULOSA SOLUCIÓN ORAL 65 %',                                100, 'SOLUCIÓN ORAL',               '65 %',                    'CAJA X 1 FCO. X 200 ml'),
  (3,  'N03AE013011', 'CLONAZEPAM',      'ACEPRAN SOLUCIÓN ORAL PARA GOTAS 2.5 mg/ml',                  80,  'SOLUCIÓN ORAL',               '2.5 mg/1 ml',             'CAJA X 1 FCO. X 10 ml'),
  (4,  'J01FA010510', 'ERITROMICINA',    'EREICU 500 TABLETAS',                                         90,  'TABLETA RECUBIERTA',          '500 mg',                  'CAJA X 5 RISTRAS X 10'),
  (4,  'J01CA040140', 'AMOXICILINA',     'ECUMOX 1 g TABLETAS',                                         110, 'TABLETA',                    '1000 mg',                 'CAJA X 1 RISTRA X 10'),
  (5,  'C10AA050520', 'ATORVASTATINA',   'ACROVASTIN 20 mg COMPRIMIDOS RECUBIERTOS',                    130, 'TABLETA RECUBIERTA',          '20 mg',                   'CAJA X 3 BLÍSTERES X 10'),
  (5,  'P02CA030210', 'ALBENDAZOL',      'ADAZOL TABLETAS MASTICABLES',                                 160, 'TABLETA MASTICABLE',          '200 mg',                  'CAJA X 25 RISTRAS X 2'),
  (6,  'S01AA123210', 'TOBRAMICINA',     'TOBREX SOLUCIÓN OFTÁLMICA ESTÉRIL',                           75,  'SOLUCIÓN OFTÁLMICA',          '0.30 %',                  'CAJA X 1 FCO. GOTERO X 5 ml'),
  (6,  'S01BA013611', 'DEXAMETASONA',    'MAXIDEX 0.1 % SUSPENSIÓN OFTÁLMICA ESTÉRIL',                  60,  'SOLUCIÓN OFTÁLMICA',          '1 mg/ml',                 'CAJA X 1 FCO. X 5 ml'),
  (8,  'H02AB09451',  'HIDROCORTISONA, SUCCINATO SÓDICO', 'HIDROCORTISONA 100 mg/2 ml',                            70,  'POLVO PARA INYECCIÓN',       '100 mg',                  'CAJA X 10 FCOS.'),
  (8,  'R03AC02371',  'SALBUTAMOL',      'SALBUTAMOL MK INHALADOR 100 mcg/DOSIS',                       95,  'AEROSOL',                     '0.1 mg/DOSIS (100 mcg/DOSIS)', 'CAJA X 1 ENVASE INHALADOR X 200 DOSIS + ADAPTADOR DOSIFICADOR'),
  (9,  'N04BC060110', 'CABERGOLINA',     'DOSTINEX',                                                    50,  'TABLETA',                     '0.5 mg',                  'CAJA X 1 FCO. X 2 / CAJA X 1 FCO. X 8'),
  (9,  'J01XE011010', 'NITROFURANTOÍNA', 'MACRODANTINA XR 100 CÁPSULAS DE LIBERACIÓN PROLONGADA',      65,  'CÁPSULA LIBERACIÓN PROLONGADA', '100 mg',                'CAJA X 2 BLÍSTERES X 10'),
  (10, 'H02AB094510', 'HIDROCORTISONA, SUCCINATO SÓDICO', 'HIDROCORTISONA 100 mg/2 ml',                           60,  'POLVO PARA INYECCIÓN',       '100 mg',                  'CAJA X 10 FCOS. VIALES'),
  (11, 'A11GA014111', 'ÁCIDO ASCÓRBICO', 'VITAMINA C 500 mg INYECTABLE',                               120, 'SOLUCIÓN INYECTABLE',         '100 mg/ml',               'CAJA X 2 NIDOS X 5 AMP. X 5 ml');
GO
select * from Medicamento

INSERT INTO dbo.Insumo
  (id_proveedor, cudim, nombre_generico, nombre_comercial, cantidad, especificacion_tecnica, especialidad)
VALUES
  (1, '18-962-001', 'Control anormal para química clínica', 'Control patológico', 150,
     'Control de sangre humana con niveles fuera de rango. Incluye aditivos y conservantes.',
     'Química clínica'),
  (2, '18-960-001', 'Kit para química clínica, controles', 'Kit de controles', 200,
     'Kit de controles normal y anormal con aditivos y conservantes.',
     'Química clínica'),
  (3, '18-904-007', 'Reactivos/Kit HPLC HbA1c', 'HbA1c Electroforesis', 120,
     'Reactivos HPLC listos para uso con controles y calibradores.',
     'Química clínica'),
  (4, '18-904-003', 'Control para hemoglobina glicosilada', 'HbA1c control', 180,
     'Control de HbA1c con aditivos. Incluye manual de uso.',
     'Química clínica'),
  (5, '19-484-038', 'Medio deshidratado TCBS', 'T.C.B.S.', 80,
     'Medio para cultivo bacteriano, pH 8.6 ± 0.2.',
     'Microbiología'),
  (6, '19-484-016', 'Medio deshidratado SS', 'SS', 90,
     'Medio para Salmonella/Shigella, pH 7.0 ± 0.2.',
     'Microbiología'),
  (7, '21-148-001', 'Cepillo para tubos de ensayo', 'Escobilla', 50,
     'Escobilla de cerdas con mango de alambre y anillo para colgar.',
     'Material de laboratorio'),
  (8, '17-814-002', 'Adaptador de extracción de sangre', 'Cápsula; Campana', 75,
     'Adaptador PP con rosca y sistema de descarte automático de aguja.',
     'Material de laboratorio');
GO

SELECT * FROM dbo.Insumo;



-- Insertar 4 pedidos (2 de medicamentos, 2 de insumos)
INSERT INTO dbo.Pedidos
  (id_proveedor, id_medicamento, id_insumo, cantidad, fecha_pedido, observacion)
VALUES
  -- Pedido de medicamento: Ritonavir (id_medicamento = 1, id_proveedor = 1)
  (1, 1, NULL,  20, '2025-07-25 08:00:00', 'Pedido de Norvir 100 mg'),

  -- Pedido de medicamento: Paracetamol (id_medicamento = 4, id_proveedor = 2)
  (2, 4, NULL,  50,  '2025-07-26 10:00:00', 'Pedido de jarabe Paracetamol'),
  -- Pedido de insumo: Control patológico (id_insumo = 1, id_proveedor = 1)
  (1, NULL, 1,      30,  '2025-07-27 09:30:00', 'Pedido de control anormal química clínica'),

  -- Pedido de insumo: Medio Salmonella/Shigella SS (id_insumo = 6, id_proveedor = 6)
  (6, NULL, 6,      100,  '2025-07-28 11:15:00', 'Pedido de medio SS para microbiología');
GO

SELECT * FROM dbo.Pedidos;

select * from entregas

-- Insertar 4 entregas (2 de medicamentos, 2 de insumos)
INSERT INTO dbo.Entregas
  (id_internacion, id_proveedor, id_medicamento, id_insumo, fecha_entregas, cantidad, observacion)
VALUES
  -- Entrega de medicamento: Norvir (id_medicamento = 1, id_proveedor = 1)
  (NULL, 1, 1, NULL, '2025-07-26 08:30:00',  20, 'Entrega de Norvir 100 mg'),
  
  -- Entrega de medicamento: Paracetamol (id_medicamento = 4, id_proveedor = 2)
  (NULL, 2, 4, NULL, '2025-07-27 09:45:00',  50, 'Entrega de jarabe Paracetamol'),
  
  -- Entrega de insumo: Control patológico (id_insumo = 1, id_proveedor = 1)
  (NULL, 1, NULL, 1,      '2025-07-28 11:20:00',  30, 'Entrega de control patológico'),
  
  -- Entrega de insumo: Medio Salmonella/Shigella SS (id_insumo = 6, id_proveedor = 6)
  (NULL, 6, NULL, 6,      '2025-07-29 14:00:00', 100, 'Entrega de medio SS para microbiología');
GO

SELECT * FROM dbo.Entregas;


select * from entregas
select * from pedidos
select * from historial_movimientos

-- Poblar Historial_Movimientos con pedidos y entregas
INSERT INTO dbo.Historial_Movimientos
  (id_internacion, tipo_movimiento, id_proveedor, id_medicamento, id_insumo, fecha_movimiento, cantidad, observacion)
VALUES
  -- Pedidos
  (NULL, 'PEDIDO', 1,  1,    NULL, '2025-07-25 08:00:00',  20, 'Pedido de Norvir 100 mg'),
  (NULL, 'PEDIDO', 2,  4,    NULL, '2025-07-26 10:00:00',  50, 'Pedido de jarabe Paracetamol'),
  (NULL, 'PEDIDO', 1,  NULL, 1,    '2025-07-27 09:30:00',  30, 'Pedido de control anormal química clínica'),
  (NULL, 'PEDIDO', 6,  NULL, 6,    '2025-07-28 11:15:00', 100, 'Pedido de medio SS para microbiología'),
  -- Entregas
  (NULL, 'ENTREGA',1,  1,    NULL, '2025-07-26 08:30:00',  20, 'Entrega de Norvir 100 mg'),
  (NULL, 'ENTREGA',2,  4,    NULL, '2025-07-27 09:45:00',  50, 'Entrega de jarabe Paracetamol'),
  (NULL, 'ENTREGA',1,  NULL, 1,    '2025-07-28 11:20:00',  30, 'Entrega de control patológico'),
  (NULL, 'ENTREGA',6,  NULL, 6,    '2025-07-29 14:00:00', 100, 'Entrega de medio SS para microbiología');
GO

SELECT * FROM dbo.Historial_Movimientos;