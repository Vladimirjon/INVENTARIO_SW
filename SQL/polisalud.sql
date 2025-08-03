USE [master]
GO
/****** Object:  Database [polisalud]    Script Date: 3/8/2025 17:30:19 ******/
CREATE DATABASE [polisalud]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'polisalud', FILENAME = N'C:\data\polisalud.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'polisalud_log', FILENAME = N'C:\logs\polisalud_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [polisalud] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [polisalud].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [polisalud] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [polisalud] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [polisalud] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [polisalud] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [polisalud] SET ARITHABORT OFF 
GO
ALTER DATABASE [polisalud] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [polisalud] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [polisalud] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [polisalud] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [polisalud] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [polisalud] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [polisalud] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [polisalud] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [polisalud] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [polisalud] SET  ENABLE_BROKER 
GO
ALTER DATABASE [polisalud] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [polisalud] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [polisalud] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [polisalud] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [polisalud] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [polisalud] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [polisalud] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [polisalud] SET RECOVERY FULL 
GO
ALTER DATABASE [polisalud] SET  MULTI_USER 
GO
ALTER DATABASE [polisalud] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [polisalud] SET DB_CHAINING OFF 
GO
ALTER DATABASE [polisalud] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [polisalud] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [polisalud] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [polisalud] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'polisalud', N'ON'
GO
ALTER DATABASE [polisalud] SET QUERY_STORE = OFF
GO
USE [polisalud]
GO
/****** Object:  User [JORGE]    Script Date: 3/8/2025 17:30:19 ******/
CREATE USER [JORGE] FOR LOGIN [JORGE] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [JORGE]
GO
/****** Object:  Table [dbo].[AlaDelHospital]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AlaDelHospital](
	[id_ala] [int] NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[especialidad] [nvarchar](50) NULL,
 CONSTRAINT [PK_AlaDelHospital] PRIMARY KEY CLUSTERED 
(
	[id_ala] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Anamnesis]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Anamnesis](
	[id_anamnesis] [int] NOT NULL,
	[parametro] [nvarchar](50) NULL,
	[valor] [nvarchar](50) NULL,
	[id_consultaExterna] [int] NULL,
	[id_historiaClinica] [int] NULL,
 CONSTRAINT [PK_Anamnesis] PRIMARY KEY CLUSTERED 
(
	[id_anamnesis] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Antecedentes]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Antecedentes](
	[id_antecedentes] [int] NOT NULL,
	[familiares] [nvarchar](550) NULL,
	[patologicos] [nvarchar](550) NULL,
	[fisiologicos] [nvarchar](550) NULL,
	[enfermedades_actuales] [nvarchar](550) NULL,
 CONSTRAINT [PK_Antecedentes] PRIMARY KEY CLUSTERED 
(
	[id_antecedentes] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Aplicar]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aplicar](
	[id_tratamiento] [int] NOT NULL,
	[id_cita] [int] NOT NULL,
 CONSTRAINT [PK_Aplicar] PRIMARY KEY CLUSTERED 
(
	[id_tratamiento] ASC,
	[id_cita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[calendarioDeAtencion]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[calendarioDeAtencion](
	[id_calendario] [int] NOT NULL,
	[fecha] [date] NULL,
	[dia] [nvarchar](50) NULL,
	[hora] [time](7) NULL,
	[id_medico] [nchar](10) NULL,
 CONSTRAINT [PK_calendarioDeAtencion] PRIMARY KEY CLUSTERED 
(
	[id_calendario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita](
	[id_cita] [int] NOT NULL,
	[estatura] [decimal](3, 2) NULL,
	[id_paciente] [nchar](10) NOT NULL,
	[hora] [time](7) NOT NULL,
	[tiempo_enfermedad] [nvarchar](10) NULL,
	[fecha] [date] NOT NULL,
	[presion_sistolica] [smallint] NULL,
	[presion_diastolica] [smallint] NULL,
	[peso] [decimal](5, 2) NULL,
	[frecuencia_cardiaca] [smallint] NULL,
	[motivo] [nvarchar](150) NOT NULL,
	[id_doctor] [nchar](10) NOT NULL,
	[examen_fisico] [nvarchar](250) NULL,
	[temperatura] [decimal](4, 2) NULL,
	[id_tipo] [int] NOT NULL,
	[diagnostico] [nchar](1000) NULL,
 CONSTRAINT [PK_Cita] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ConsultaExterna]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ConsultaExterna](
	[id_consultaExterna] [int] NOT NULL,
	[id_paciente] [nchar](10) NULL,
	[id_medico] [nchar](10) NULL,
	[id_historiaClinica] [int] NULL,
 CONSTRAINT [PK_ConsultaExterna] PRIMARY KEY CLUSTERED 
(
	[id_consultaExterna] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contacto]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contacto](
	[nombres] [nvarchar](50) NULL,
	[apellidos] [nvarchar](50) NULL,
	[telefono] [int] NULL,
	[cedula] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Contacto] PRIMARY KEY CLUSTERED 
(
	[cedula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diagnóstico]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diagnóstico](
	[id_diagnostico] [int] NOT NULL,
	[diagnostico] [nvarchar](50) NULL,
	[motivoConsulta] [nvarchar](50) NULL,
 CONSTRAINT [PK_Diagnóstico] PRIMARY KEY CLUSTERED 
(
	[id_diagnostico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
	[cedula] [nchar](10) NOT NULL,
	[nombres] [nvarchar](50) NOT NULL,
	[apellidos] [nvarchar](50) NOT NULL,
	[usuario_doctor] [nvarchar](64) NOT NULL,
	[contrasena_doctor] [nvarchar](128) NOT NULL,
	[sexo] [nvarchar](6) NOT NULL,
	[fecha_nacimiento] [date] NOT NULL,
	[especialidad] [nvarchar](50) NOT NULL,
	[correo] [nvarchar](50) NULL,
	[estCiv] [nvarchar](3) NULL,
	[telefono] [nvarchar](50) NULL,
	[direc] [nvarchar](50) NULL,
	[fechaGraduacion] [date] NULL,
	[universidad] [nvarchar](50) NULL,
 CONSTRAINT [PK_Doctor] PRIMARY KEY CLUSTERED 
(
	[cedula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Enfermero]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Enfermero](
	[cedula] [int] NOT NULL,
	[nombres] [nvarchar](50) NULL,
	[apellidos] [nvarchar](50) NULL,
	[fecha_nacimiento] [date] NULL,
	[genero] [nvarchar](3) NULL,
	[estado_civil] [nvarchar](50) NULL,
	[telefono] [nvarchar](10) NULL,
	[sangre] [nvarchar](3) NULL,
	[direccion] [nvarchar](50) NULL,
 CONSTRAINT [PK_Enfermero] PRIMARY KEY CLUSTERED 
(
	[cedula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Entregas]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Entregas](
	[id_entregas] [int] IDENTITY(1,1) NOT NULL,
	[id_internacion] [int] NULL,
	[id_proveedor] [int] NOT NULL,
	[id_medicamento] [int] NULL,
	[id_insumo] [int] NULL,
	[fecha_entregas] [datetime] NOT NULL,
	[cantidad] [int] NOT NULL,
	[observacion] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_entregas] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evaluar]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evaluar](
	[id_cita] [int] NOT NULL,
	[id_examen] [int] NOT NULL,
	[motivo_uso] [nvarchar](50) NULL,
	[resultados] [nvarchar](500) NULL,
 CONSTRAINT [PK_Evaluar] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC,
	[id_examen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evolucion]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evolucion](
	[id_evolucion] [int] NOT NULL,
	[pronostico] [nvarchar](250) NULL,
	[id_cita] [int] NOT NULL,
 CONSTRAINT [PK_Evolucion] PRIMARY KEY CLUSTERED 
(
	[id_evolucion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Examen]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Examen](
	[tipo] [nvarchar](50) NOT NULL,
	[costo] [decimal](10, 2) NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[id_examen] [int] NOT NULL,
 CONSTRAINT [PK_Examen] PRIMARY KEY CLUSTERED 
(
	[id_examen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ExamenImagen]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ExamenImagen](
	[id_examenImagen] [int] NOT NULL,
	[tipo] [nvarchar](50) NULL,
	[id_consultaExterna] [int] NULL,
 CONSTRAINT [PK_ExamenImagen] PRIMARY KEY CLUSTERED 
(
	[id_examenImagen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ExamenLaboratorio]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ExamenLaboratorio](
	[id_examenLaboratorio] [int] NOT NULL,
	[tipo] [nvarchar](50) NULL,
	[id_consultaExterna] [int] NULL,
 CONSTRAINT [PK_ExamenLaboratorio] PRIMARY KEY CLUSTERED 
(
	[id_examenLaboratorio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HistoriaClínica]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HistoriaClínica](
	[id_historiaClinica] [int] NOT NULL,
	[fecha_apertura] [date] NULL,
 CONSTRAINT [PK_HistoriaClínica] PRIMARY KEY CLUSTERED 
(
	[id_historiaClinica] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Historial_Movimientos]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Historial_Movimientos](
	[id_historial] [int] IDENTITY(1,1) NOT NULL,
	[id_internacion] [int] NULL,
	[tipo_movimiento] [nvarchar](20) NOT NULL,
	[id_proveedor] [int] NOT NULL,
	[id_medicamento] [int] NULL,
	[id_insumo] [int] NULL,
	[fecha_movimiento] [datetime] NOT NULL,
	[cantidad] [int] NOT NULL,
	[observacion] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_historial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hospital]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hospital](
	[id_hospital] [int] NOT NULL,
	[nombre_hospital] [nvarchar](50) NOT NULL,
	[provinica] [nvarchar](50) NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[calle_primaria] [nvarchar](50) NOT NULL,
	[calle_secundaria] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Hospital] PRIMARY KEY CLUSTERED 
(
	[id_hospital] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Insumo]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Insumo](
	[id_insumo] [int] IDENTITY(1,1) NOT NULL,
	[id_proveedor] [int] NOT NULL,
	[cudim] [varchar](20) NOT NULL,
	[nombre_generico] [varchar](100) NOT NULL,
	[nombre_comercial] [varchar](100) NOT NULL,
	[cantidad] [int] NOT NULL,
	[especificacion_tecnica] [varchar](250) NULL,
	[especialidad] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_insumo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Internación]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Internación](
	[id_internacion] [int] NOT NULL,
	[tipo] [nvarchar](50) NULL,
	[nivelDeCuidado] [nvarchar](50) NULL,
	[id_diagnostico] [int] NULL,
	[id_historiaClinica] [int] NULL,
 CONSTRAINT [PK_Internación] PRIMARY KEY CLUSTERED 
(
	[id_internacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicamento]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicamento](
	[id_medicamento] [int] IDENTITY(1,1) NOT NULL,
	[id_proveedor] [int] NOT NULL,
	[CUM] [varchar](50) NOT NULL,
	[nombre_generico] [varchar](100) NOT NULL,
	[nombre_comercial] [varchar](100) NOT NULL,
	[cantidad] [int] NOT NULL,
	[forma_farmaceutica] [varchar](50) NOT NULL,
	[concentracion] [varchar](50) NOT NULL,
	[presentacion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_medicamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paciente]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paciente](
	[cedula] [nchar](10) NOT NULL,
	[nombres] [nvarchar](50) NOT NULL,
	[apellidos] [nvarchar](50) NOT NULL,
	[fecha_nacimiento] [date] NULL,
	[sexo] [varchar](9) NULL,
	[correo] [nvarchar](50) NULL,
	[usuario_paciente] [nvarchar](64) NOT NULL,
	[contrasena_paciente] [nvarchar](128) NOT NULL,
	[alergias] [nvarchar](300) NULL,
	[edad] [tinyint] NULL,
	[id_antecedetes] [int] NULL,
	[estado_civil] [nvarchar](50) NULL,
	[telefono] [nvarchar](50) NULL,
	[id_contacto] [nchar](10) NULL,
	[sangre] [nvarchar](2) NULL,
	[usuario] [nvarchar](50) NULL,
	[contraseña] [nvarchar](50) NULL,
	[id_sala] [int] NULL,
 CONSTRAINT [PK_Paciente] PRIMARY KEY CLUSTERED 
(
	[cedula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pedidos]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pedidos](
	[id_pedido] [int] IDENTITY(1,1) NOT NULL,
	[id_proveedor] [int] NOT NULL,
	[id_medicamento] [int] NULL,
	[id_insumo] [int] NULL,
	[cantidad] [int] NOT NULL,
	[fecha_pedido] [datetime] NOT NULL,
	[observacion] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_pedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Piso]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Piso](
	[id_piso] [int] NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[habitaciones] [int] NULL,
	[id_ala] [int] NULL,
 CONSTRAINT [PK_Piso] PRIMARY KEY CLUSTERED 
(
	[id_piso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Prescribir]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prescribir](
	[frecuencia] [nvarchar](50) NULL,
	[dosis] [nvarchar](50) NULL,
	[id_receta] [int] NOT NULL,
	[id_medicamento] [int] NOT NULL,
 CONSTRAINT [PK_Prescribir] PRIMARY KEY CLUSTERED 
(
	[id_receta] ASC,
	[id_medicamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[id_proveedor] [int] IDENTITY(1,1) NOT NULL,
	[ruc] [varchar](20) NOT NULL,
	[nombre] [varchar](150) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_proveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Receta]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Receta](
	[id_receta] [int] NOT NULL,
	[tiempo] [nvarchar](10) NOT NULL,
	[fecha_fin] [date] NULL,
	[id_cita] [int] NULL,
	[id_consultaExterna] [int] NULL,
	[id_historiaClinica] [int] NULL,
 CONSTRAINT [PK_Receta] PRIMARY KEY CLUSTERED 
(
	[id_receta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReservaDeAtencion]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReservaDeAtencion](
	[id_reserva] [int] NOT NULL,
	[feca] [date] NULL,
	[dia] [nvarchar](50) NULL,
	[hora] [time](7) NULL,
	[id_medico] [nchar](10) NULL,
	[id_paciente] [nchar](10) NULL,
 CONSTRAINT [PK_ReservaDeAtencion] PRIMARY KEY CLUSTERED 
(
	[id_reserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ResultadoExamenImagen]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ResultadoExamenImagen](
	[id_resultadoExamenImagen] [int] NULL,
	[resultado] [nvarchar](50) NULL,
	[id_historiaClinica] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ResultadoExamenLaboratorio]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ResultadoExamenLaboratorio](
	[id_resultadoExamenLaboratorio] [int] NOT NULL,
	[resultado] [nvarchar](50) NULL,
	[id_historiaClinica] [int] NULL,
 CONSTRAINT [PK_ResultadoExamenLaboratorio] PRIMARY KEY CLUSTERED 
(
	[id_resultadoExamenLaboratorio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sala]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sala](
	[id_sala] [int] NOT NULL,
	[nombre] [nvarchar](50) NULL,
	[camas] [int] NULL,
	[tipo] [nvarchar](50) NULL,
	[id_piso] [int] NULL,
 CONSTRAINT [PK_Sala] PRIMARY KEY CLUSTERED 
(
	[id_sala] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo](
	[id_tipo] [int] NOT NULL,
	[tipo] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Tipo] PRIMARY KEY CLUSTERED 
(
	[id_tipo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Trabajar]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Trabajar](
	[id_doctor] [nchar](10) NOT NULL,
	[id_hospital] [int] NOT NULL,
 CONSTRAINT [PK_Trabajar_1] PRIMARY KEY CLUSTERED 
(
	[id_doctor] ASC,
	[id_hospital] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tratamiento]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tratamiento](
	[id_tratamiento] [int] NOT NULL,
	[objetivo] [nvarchar](250) NULL,
	[descripcion] [nvarchar](250) NULL,
	[tiempo_estimado] [nvarchar](10) NULL,
	[id_receta] [int] NOT NULL,
	[resultadosEsperados] [nchar](1000) NULL,
	[id_internacion] [int] NULL,
 CONSTRAINT [PK_Tratamiento] PRIMARY KEY CLUSTERED 
(
	[id_tratamiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Anamnesis]  WITH CHECK ADD  CONSTRAINT [FK_Anamnesis_ConsultaExterna] FOREIGN KEY([id_consultaExterna])
REFERENCES [dbo].[ConsultaExterna] ([id_consultaExterna])
GO
ALTER TABLE [dbo].[Anamnesis] CHECK CONSTRAINT [FK_Anamnesis_ConsultaExterna]
GO
ALTER TABLE [dbo].[Anamnesis]  WITH CHECK ADD  CONSTRAINT [FK_Anamnesis_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[Anamnesis] CHECK CONSTRAINT [FK_Anamnesis_HistoriaClínica]
GO
ALTER TABLE [dbo].[Aplicar]  WITH CHECK ADD  CONSTRAINT [FK_Aplicar_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Aplicar] CHECK CONSTRAINT [FK_Aplicar_Cita]
GO
ALTER TABLE [dbo].[Aplicar]  WITH CHECK ADD  CONSTRAINT [FK_Aplicar_Tratamiento] FOREIGN KEY([id_tratamiento])
REFERENCES [dbo].[Tratamiento] ([id_tratamiento])
GO
ALTER TABLE [dbo].[Aplicar] CHECK CONSTRAINT [FK_Aplicar_Tratamiento]
GO
ALTER TABLE [dbo].[calendarioDeAtencion]  WITH CHECK ADD  CONSTRAINT [FK_calendarioDeAtencion_Doctor] FOREIGN KEY([id_medico])
REFERENCES [dbo].[Doctor] ([cedula])
GO
ALTER TABLE [dbo].[calendarioDeAtencion] CHECK CONSTRAINT [FK_calendarioDeAtencion_Doctor]
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Doctor1] FOREIGN KEY([id_doctor])
REFERENCES [dbo].[Doctor] ([cedula])
GO
ALTER TABLE [dbo].[Cita] CHECK CONSTRAINT [FK_Cita_Doctor1]
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Paciente] FOREIGN KEY([id_paciente])
REFERENCES [dbo].[Paciente] ([cedula])
GO
ALTER TABLE [dbo].[Cita] CHECK CONSTRAINT [FK_Cita_Paciente]
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Tipo] FOREIGN KEY([id_tipo])
REFERENCES [dbo].[Tipo] ([id_tipo])
GO
ALTER TABLE [dbo].[Cita] CHECK CONSTRAINT [FK_Cita_Tipo]
GO
ALTER TABLE [dbo].[ConsultaExterna]  WITH CHECK ADD  CONSTRAINT [FK_ConsultaExterna_Doctor] FOREIGN KEY([id_medico])
REFERENCES [dbo].[Doctor] ([cedula])
GO
ALTER TABLE [dbo].[ConsultaExterna] CHECK CONSTRAINT [FK_ConsultaExterna_Doctor]
GO
ALTER TABLE [dbo].[ConsultaExterna]  WITH CHECK ADD  CONSTRAINT [FK_ConsultaExterna_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[ConsultaExterna] CHECK CONSTRAINT [FK_ConsultaExterna_HistoriaClínica]
GO
ALTER TABLE [dbo].[ConsultaExterna]  WITH CHECK ADD  CONSTRAINT [FK_ConsultaExterna_Paciente] FOREIGN KEY([id_paciente])
REFERENCES [dbo].[Paciente] ([cedula])
GO
ALTER TABLE [dbo].[ConsultaExterna] CHECK CONSTRAINT [FK_ConsultaExterna_Paciente]
GO
ALTER TABLE [dbo].[Entregas]  WITH CHECK ADD  CONSTRAINT [FK_Entregas_Insumo] FOREIGN KEY([id_insumo])
REFERENCES [dbo].[Insumo] ([id_insumo])
GO
ALTER TABLE [dbo].[Entregas] CHECK CONSTRAINT [FK_Entregas_Insumo]
GO
ALTER TABLE [dbo].[Entregas]  WITH CHECK ADD  CONSTRAINT [FK_Entregas_Internacion] FOREIGN KEY([id_internacion])
REFERENCES [dbo].[Internación] ([id_internacion])
GO
ALTER TABLE [dbo].[Entregas] CHECK CONSTRAINT [FK_Entregas_Internacion]
GO
ALTER TABLE [dbo].[Entregas]  WITH CHECK ADD  CONSTRAINT [FK_Entregas_Medicamento] FOREIGN KEY([id_medicamento])
REFERENCES [dbo].[Medicamento] ([id_medicamento])
GO
ALTER TABLE [dbo].[Entregas] CHECK CONSTRAINT [FK_Entregas_Medicamento]
GO
ALTER TABLE [dbo].[Entregas]  WITH CHECK ADD  CONSTRAINT [FK_Entregas_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Entregas] CHECK CONSTRAINT [FK_Entregas_Proveedor]
GO
ALTER TABLE [dbo].[Evaluar]  WITH CHECK ADD  CONSTRAINT [FK_Evaluar_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Evaluar] CHECK CONSTRAINT [FK_Evaluar_Cita]
GO
ALTER TABLE [dbo].[Evaluar]  WITH CHECK ADD  CONSTRAINT [FK_Evaluar_Examen] FOREIGN KEY([id_examen])
REFERENCES [dbo].[Examen] ([id_examen])
GO
ALTER TABLE [dbo].[Evaluar] CHECK CONSTRAINT [FK_Evaluar_Examen]
GO
ALTER TABLE [dbo].[Evolucion]  WITH CHECK ADD  CONSTRAINT [FK_Evolucion_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Evolucion] CHECK CONSTRAINT [FK_Evolucion_Cita]
GO
ALTER TABLE [dbo].[ExamenImagen]  WITH CHECK ADD  CONSTRAINT [FK_ExamenImagen_ConsultaExterna] FOREIGN KEY([id_consultaExterna])
REFERENCES [dbo].[ConsultaExterna] ([id_consultaExterna])
GO
ALTER TABLE [dbo].[ExamenImagen] CHECK CONSTRAINT [FK_ExamenImagen_ConsultaExterna]
GO
ALTER TABLE [dbo].[ExamenLaboratorio]  WITH CHECK ADD  CONSTRAINT [FK_ExamenLaboratorio_ConsultaExterna] FOREIGN KEY([id_consultaExterna])
REFERENCES [dbo].[ConsultaExterna] ([id_consultaExterna])
GO
ALTER TABLE [dbo].[ExamenLaboratorio] CHECK CONSTRAINT [FK_ExamenLaboratorio_ConsultaExterna]
GO
ALTER TABLE [dbo].[Historial_Movimientos]  WITH CHECK ADD  CONSTRAINT [FK_HistMov_Insumo] FOREIGN KEY([id_insumo])
REFERENCES [dbo].[Insumo] ([id_insumo])
GO
ALTER TABLE [dbo].[Historial_Movimientos] CHECK CONSTRAINT [FK_HistMov_Insumo]
GO
ALTER TABLE [dbo].[Historial_Movimientos]  WITH CHECK ADD  CONSTRAINT [FK_HistMov_Internacion] FOREIGN KEY([id_internacion])
REFERENCES [dbo].[Internación] ([id_internacion])
GO
ALTER TABLE [dbo].[Historial_Movimientos] CHECK CONSTRAINT [FK_HistMov_Internacion]
GO
ALTER TABLE [dbo].[Historial_Movimientos]  WITH CHECK ADD  CONSTRAINT [FK_HistMov_Medicamento] FOREIGN KEY([id_medicamento])
REFERENCES [dbo].[Medicamento] ([id_medicamento])
GO
ALTER TABLE [dbo].[Historial_Movimientos] CHECK CONSTRAINT [FK_HistMov_Medicamento]
GO
ALTER TABLE [dbo].[Historial_Movimientos]  WITH CHECK ADD  CONSTRAINT [FK_HistMov_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Historial_Movimientos] CHECK CONSTRAINT [FK_HistMov_Proveedor]
GO
ALTER TABLE [dbo].[Insumo]  WITH CHECK ADD  CONSTRAINT [FK_Insumo_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Insumo] CHECK CONSTRAINT [FK_Insumo_Proveedor]
GO
ALTER TABLE [dbo].[Internación]  WITH CHECK ADD  CONSTRAINT [FK_Internación_Diagnóstico] FOREIGN KEY([id_diagnostico])
REFERENCES [dbo].[Diagnóstico] ([id_diagnostico])
GO
ALTER TABLE [dbo].[Internación] CHECK CONSTRAINT [FK_Internación_Diagnóstico]
GO
ALTER TABLE [dbo].[Internación]  WITH CHECK ADD  CONSTRAINT [FK_Internación_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[Internación] CHECK CONSTRAINT [FK_Internación_HistoriaClínica]
GO
ALTER TABLE [dbo].[Medicamento]  WITH CHECK ADD  CONSTRAINT [FK_Medicamento_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Medicamento] CHECK CONSTRAINT [FK_Medicamento_Proveedor]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Antecedentes] FOREIGN KEY([id_antecedetes])
REFERENCES [dbo].[Antecedentes] ([id_antecedentes])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Antecedentes]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Contacto] FOREIGN KEY([id_contacto])
REFERENCES [dbo].[Contacto] ([cedula])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Contacto]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Sala] FOREIGN KEY([id_sala])
REFERENCES [dbo].[Sala] ([id_sala])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Sala]
GO
ALTER TABLE [dbo].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Insumo] FOREIGN KEY([id_insumo])
REFERENCES [dbo].[Insumo] ([id_insumo])
GO
ALTER TABLE [dbo].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Insumo]
GO
ALTER TABLE [dbo].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Medicamento] FOREIGN KEY([id_medicamento])
REFERENCES [dbo].[Medicamento] ([id_medicamento])
GO
ALTER TABLE [dbo].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Medicamento]
GO
ALTER TABLE [dbo].[Pedidos]  WITH CHECK ADD  CONSTRAINT [FK_Pedidos_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Pedidos] CHECK CONSTRAINT [FK_Pedidos_Proveedor]
GO
ALTER TABLE [dbo].[Piso]  WITH CHECK ADD  CONSTRAINT [FK_Piso_AlaDelHospital] FOREIGN KEY([id_ala])
REFERENCES [dbo].[AlaDelHospital] ([id_ala])
GO
ALTER TABLE [dbo].[Piso] CHECK CONSTRAINT [FK_Piso_AlaDelHospital]
GO
ALTER TABLE [dbo].[Receta]  WITH CHECK ADD FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Receta]  WITH CHECK ADD  CONSTRAINT [FK_Receta_ConsultaExterna] FOREIGN KEY([id_consultaExterna])
REFERENCES [dbo].[ConsultaExterna] ([id_consultaExterna])
GO
ALTER TABLE [dbo].[Receta] CHECK CONSTRAINT [FK_Receta_ConsultaExterna]
GO
ALTER TABLE [dbo].[Receta]  WITH CHECK ADD  CONSTRAINT [FK_Receta_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[Receta] CHECK CONSTRAINT [FK_Receta_HistoriaClínica]
GO
ALTER TABLE [dbo].[ReservaDeAtencion]  WITH CHECK ADD  CONSTRAINT [FK_ReservaDeAtencion_Doctor] FOREIGN KEY([id_medico])
REFERENCES [dbo].[Doctor] ([cedula])
GO
ALTER TABLE [dbo].[ReservaDeAtencion] CHECK CONSTRAINT [FK_ReservaDeAtencion_Doctor]
GO
ALTER TABLE [dbo].[ReservaDeAtencion]  WITH CHECK ADD  CONSTRAINT [FK_ReservaDeAtencion_Paciente] FOREIGN KEY([id_paciente])
REFERENCES [dbo].[Paciente] ([cedula])
GO
ALTER TABLE [dbo].[ReservaDeAtencion] CHECK CONSTRAINT [FK_ReservaDeAtencion_Paciente]
GO
ALTER TABLE [dbo].[ResultadoExamenImagen]  WITH CHECK ADD  CONSTRAINT [FK_ResultadoExamenImagen_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[ResultadoExamenImagen] CHECK CONSTRAINT [FK_ResultadoExamenImagen_HistoriaClínica]
GO
ALTER TABLE [dbo].[ResultadoExamenLaboratorio]  WITH CHECK ADD  CONSTRAINT [FK_ResultadoExamenLaboratorio_HistoriaClínica] FOREIGN KEY([id_historiaClinica])
REFERENCES [dbo].[HistoriaClínica] ([id_historiaClinica])
GO
ALTER TABLE [dbo].[ResultadoExamenLaboratorio] CHECK CONSTRAINT [FK_ResultadoExamenLaboratorio_HistoriaClínica]
GO
ALTER TABLE [dbo].[Sala]  WITH CHECK ADD  CONSTRAINT [FK_Sala_Piso] FOREIGN KEY([id_piso])
REFERENCES [dbo].[Piso] ([id_piso])
GO
ALTER TABLE [dbo].[Sala] CHECK CONSTRAINT [FK_Sala_Piso]
GO
ALTER TABLE [dbo].[Trabajar]  WITH CHECK ADD  CONSTRAINT [FK_Trabajar_Doctor] FOREIGN KEY([id_doctor])
REFERENCES [dbo].[Doctor] ([cedula])
GO
ALTER TABLE [dbo].[Trabajar] CHECK CONSTRAINT [FK_Trabajar_Doctor]
GO
ALTER TABLE [dbo].[Trabajar]  WITH CHECK ADD  CONSTRAINT [FK_Trabajar_Hospital] FOREIGN KEY([id_hospital])
REFERENCES [dbo].[Hospital] ([id_hospital])
GO
ALTER TABLE [dbo].[Trabajar] CHECK CONSTRAINT [FK_Trabajar_Hospital]
GO
ALTER TABLE [dbo].[Tratamiento]  WITH CHECK ADD  CONSTRAINT [FK_Tratamiento_Internación] FOREIGN KEY([id_internacion])
REFERENCES [dbo].[Internación] ([id_internacion])
GO
ALTER TABLE [dbo].[Tratamiento] CHECK CONSTRAINT [FK_Tratamiento_Internación]
GO
ALTER TABLE [dbo].[Tratamiento]  WITH CHECK ADD  CONSTRAINT [FK_Tratamiento_Receta] FOREIGN KEY([id_receta])
REFERENCES [dbo].[Receta] ([id_receta])
GO
ALTER TABLE [dbo].[Tratamiento] CHECK CONSTRAINT [FK_Tratamiento_Receta]
GO
ALTER TABLE [dbo].[Entregas]  WITH CHECK ADD  CONSTRAINT [CHK_Entregas_Item] CHECK  (([id_medicamento] IS NOT NULL AND [id_insumo] IS NULL OR [id_medicamento] IS NULL AND [id_insumo] IS NOT NULL))
GO
ALTER TABLE [dbo].[Entregas] CHECK CONSTRAINT [CHK_Entregas_Item]
GO
ALTER TABLE [dbo].[Historial_Movimientos]  WITH CHECK ADD  CONSTRAINT [CHK_HistMov_Item] CHECK  (([id_medicamento] IS NOT NULL AND [id_insumo] IS NULL OR [id_medicamento] IS NULL AND [id_insumo] IS NOT NULL))
GO
ALTER TABLE [dbo].[Historial_Movimientos] CHECK CONSTRAINT [CHK_HistMov_Item]
GO
ALTER TABLE [dbo].[Pedidos]  WITH CHECK ADD  CONSTRAINT [CHK_Pedidos_Item] CHECK  (([id_medicamento] IS NOT NULL AND [id_insumo] IS NULL OR [id_medicamento] IS NULL AND [id_insumo] IS NOT NULL))
GO
ALTER TABLE [dbo].[Pedidos] CHECK CONSTRAINT [CHK_Pedidos_Item]
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertarEntrega]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:      Jorge
-- Create date: 2025-08-03
-- Description: Inserta una nueva entrega en la tabla Entregas.
-- =============================================
CREATE PROCEDURE [dbo].[sp_InsertarEntrega]
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
/****** Object:  StoredProcedure [dbo].[sp_InsertarPedido]    Script Date: 3/8/2025 17:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarPedido]
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
USE [master]
GO
ALTER DATABASE [polisalud] SET  READ_WRITE 
GO
