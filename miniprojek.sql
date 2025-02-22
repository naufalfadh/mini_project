USE [master]
GO
/****** Object:  Database [DB_MBL_KEL1]    Script Date: 05/07/2024 22:04:34 ******/
CREATE DATABASE [DB_MBL_KEL1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DB_MBL_KEL1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\DB_MBL_KEL1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DB_MBL_KEL1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\DB_MBL_KEL1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [DB_MBL_KEL1] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_MBL_KEL1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DB_MBL_KEL1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET ARITHABORT OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DB_MBL_KEL1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DB_MBL_KEL1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DB_MBL_KEL1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DB_MBL_KEL1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET RECOVERY FULL 
GO
ALTER DATABASE [DB_MBL_KEL1] SET  MULTI_USER 
GO
ALTER DATABASE [DB_MBL_KEL1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DB_MBL_KEL1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DB_MBL_KEL1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DB_MBL_KEL1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DB_MBL_KEL1] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DB_MBL_KEL1', N'ON'
GO
ALTER DATABASE [DB_MBL_KEL1] SET QUERY_STORE = OFF
GO
USE [DB_MBL_KEL1]
GO
/****** Object:  Table [dbo].[sparepart_dtlpenjualan]    Script Date: 05/07/2024 22:04:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sparepart_dtlpenjualan](
	[trp_id] [int] NOT NULL,
	[sparepart_id] [int] NOT NULL,
	[jumlah] [int] NOT NULL,
 CONSTRAINT [PK_sparepart_dtlpenjualan] PRIMARY KEY CLUSTERED 
(
	[sparepart_id] ASC,
	[trp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sparepart_mskaryawan]    Script Date: 05/07/2024 22:04:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sparepart_mskaryawan](
	[kry_id] [int] IDENTITY(1,1) NOT NULL,
	[kry_nama] [varchar](50) NULL,
	[kry_email] [varchar](100) NULL,
	[kry_no_tlp] [varchar](14) NULL,
	[kry_status] [int] NULL,
	[kry_creaby] [int] NULL,
	[kry_creadate] [date] NULL,
	[kry_modiby] [int] NULL,
	[kry_modidate] [date] NULL,
 CONSTRAINT [PK_sparepart_mskaryawan] PRIMARY KEY CLUSTERED 
(
	[kry_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sparepart_trpenjualan]    Script Date: 05/07/2024 22:04:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sparepart_trpenjualan](
	[trp_id] [int] IDENTITY(1,1) NOT NULL,
	[trp_tanggal] [date] NULL,
	[trp_total] [int] NULL,
	[kry_id] [int] NULL,
 CONSTRAINT [PK_sparepart_trpenjualan] PRIMARY KEY CLUSTERED 
(
	[trp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_sparepart]    Script Date: 05/07/2024 22:04:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_sparepart](
	[sparepart_id] [int] IDENTITY(1,1) NOT NULL,
	[sparepart_name] [varchar](100) NULL,
	[sparepart_price] [int] NULL,
	[sparepart_stock] [int] NULL,
	[sparepart_brand] [varchar](100) NULL,
	[sparepart_status] [int] NULL,
	[created_by] [int] NULL,
	[creation_date] [date] NULL,
	[modified_by] [int] NULL,
	[modification_date] [date] NULL,
 CONSTRAINT [PK_tb_sparepart] PRIMARY KEY CLUSTERED 
(
	[sparepart_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (3, 4, 2)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (5, 4, 2)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (8, 4, 2)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (11, 4, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (12, 4, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (8, 6, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (12, 6, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (12, 7, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (4, 12, 2)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (9, 12, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (10, 12, 1)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (4, 13, 2)
INSERT [dbo].[sparepart_dtlpenjualan] ([trp_id], [sparepart_id], [jumlah]) VALUES (7, 13, 2)
GO
SET IDENTITY_INSERT [dbo].[sparepart_trpenjualan] ON 

INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (3, CAST(N'2024-04-22' AS Date), 80000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (4, CAST(N'2024-04-22' AS Date), 1646000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (5, CAST(N'2024-04-22' AS Date), 80000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (6, CAST(N'2024-04-23' AS Date), 0, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (7, CAST(N'2024-04-23' AS Date), 46000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (8, CAST(N'2024-04-23' AS Date), 830000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (9, CAST(N'2024-04-23' AS Date), 800000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (10, CAST(N'2024-04-23' AS Date), 800000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (11, CAST(N'2024-07-05' AS Date), 40000, 3)
INSERT [dbo].[sparepart_trpenjualan] ([trp_id], [trp_tanggal], [trp_total], [kry_id]) VALUES (12, CAST(N'2024-07-05' AS Date), 1290000, 3)
SET IDENTITY_INSERT [dbo].[sparepart_trpenjualan] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_sparepart] ON 

INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (1, N'Filter Oli', 57000, 20, N'Bosch', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (3, N'Filter Oli', 75000, 50, N'Bosch', 0, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (4, N'Busi', 40000, 22, N'NGK', 1, NULL, CAST(N'2024-07-05' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (5, N'Filter Udara', 250000, 20, N'K&N', 0, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (6, N'Rem Pad (Depan)', 750000, 8, N'Brembo', 1, NULL, CAST(N'2024-07-05' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (7, N'Rem Pad (Belakang)', 500000, 7, N'Akebono', 1, NULL, CAST(N'2024-07-05' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (8, N'Kampas Rem (Depan)', 300000, 15, N'TRW', 1, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (9, N'Kampas Rem (Belakang)', 200000, 12, N'Nissin', 1, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (10, N'Wiper Blade', 300000, 25, N'Bosch Aerotwin', 1, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (11, N'Baterai Mobil', 1500000, 5, N'VARTA', 0, 1, CAST(N'2024-04-22' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (12, N'Starter Motor', 800000, -1, N'Denso', 1, NULL, CAST(N'2024-04-23' AS Date), 1, CAST(N'2024-04-22' AS Date))
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (13, N'Berring', 23000, 26, N'NTN', 1, NULL, CAST(N'2024-04-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (15, N'Busi Besar', 200000, 20, N'NZK', 0, NULL, CAST(N'2024-04-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_sparepart] ([sparepart_id], [sparepart_name], [sparepart_price], [sparepart_stock], [sparepart_brand], [sparepart_status], [created_by], [creation_date], [modified_by], [modification_date]) VALUES (16, N'Aki', 34000, 100, N'GSAstra', 0, NULL, CAST(N'2024-04-23' AS Date), NULL, NULL)
SET IDENTITY_INSERT [dbo].[tb_sparepart] OFF
GO
ALTER TABLE [dbo].[sparepart_dtlpenjualan]  WITH CHECK ADD  CONSTRAINT [FK_sparepart_dtlpenjualan_sparepart_trpenjualan] FOREIGN KEY([trp_id])
REFERENCES [dbo].[sparepart_trpenjualan] ([trp_id])
GO
ALTER TABLE [dbo].[sparepart_dtlpenjualan] CHECK CONSTRAINT [FK_sparepart_dtlpenjualan_sparepart_trpenjualan]
GO
USE [master]
GO
ALTER DATABASE [DB_MBL_KEL1] SET  READ_WRITE 
GO
