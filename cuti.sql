USE [cuti]
GO
/****** Object:  Table [dbo].[MPegawai]    Script Date: 06/02/2014 22:29:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MPegawai](
	[id_pegawai] [int] IDENTITY(1,1) NOT NULL,
	[nama] [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[jenis_kelamin] [nchar](1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[is_active] [bit] NULL,
	[pekerjaan] [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[alamat] [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]