USE [master]
GO
/****** Object:  Database [MinimalismShop]    Script Date: 30-Apr-18 11:11:08 AM ******/
CREATE DATABASE [MinimalismShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MinimalismShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THUCUYEN\MSSQL\DATA\MinimalismShop.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MinimalismShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THUCUYEN\MSSQL\DATA\MinimalismShop_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MinimalismShop] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MinimalismShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MinimalismShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MinimalismShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MinimalismShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MinimalismShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MinimalismShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [MinimalismShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MinimalismShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MinimalismShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MinimalismShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MinimalismShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MinimalismShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MinimalismShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MinimalismShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MinimalismShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MinimalismShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MinimalismShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MinimalismShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MinimalismShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MinimalismShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MinimalismShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MinimalismShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MinimalismShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MinimalismShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MinimalismShop] SET  MULTI_USER 
GO
ALTER DATABASE [MinimalismShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MinimalismShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MinimalismShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MinimalismShop] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MinimalismShop] SET DELAYED_DURABILITY = DISABLED 
GO
USE [MinimalismShop]
GO
/****** Object:  Table [dbo].[AprioriList]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AprioriList](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[vetrai] [nvarchar](50) NULL,
	[vephai] [nvarchar](50) NULL,
 CONSTRAINT [PK_AprioriList] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[code] [nvarchar](50) NOT NULL,
	[idDepartment] [int] NOT NULL,
	[description] [nvarchar](100) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Department]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[code] [nvarchar](50) NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GroupProduct]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupProduct](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NULL,
	[size] [int] NULL,
	[endProduct] [bit] NULL,
	[imge] [nvarchar](50) NULL,
	[price] [int] NOT NULL,
	[isSpecial] [bit] NULL,
	[idCategory] [int] NULL,
	[code] [nvarchar](50) NULL,
	[point] [int] NULL,
	[lastest] [date] NULL,
 CONSTRAINT [PK_GroupProduct] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ImportDetail]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImportDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[price] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[idImportStore] [int] NOT NULL,
	[idGroupProduct] [int] NOT NULL,
	[note] [nvarchar](50) NULL,
 CONSTRAINT [PK_ImportDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ImportStore]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImportStore](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dateImport] [int] NOT NULL,
	[idUser] [int] NOT NULL,
	[idSupplier] [int] NOT NULL,
 CONSTRAINT [PK_ImportStore] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Involve]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Involve](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idOrder] [int] NULL,
	[idGroupProduct] [int] NULL,
	[year] [int] NULL,
 CONSTRAINT [PK_Involve] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderDate] [date] NOT NULL,
	[deliveryDate] [date] NULL,
	[delivery] [bit] NOT NULL,
	[status] [bit] NULL,
	[note] [nvarchar](50) NULL,
	[address] [nvarchar](50) NOT NULL,
	[idUser] [int] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[price] [int] NOT NULL,
	[discount] [int] NOT NULL,
	[idProduct] [int] NOT NULL,
	[idOrder] [int] NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Permission]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Permission](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idRole] [int] NULL,
	[idUser] [int] NULL,
 CONSTRAINT [PK_Permission] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[persistent_logins]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[persistent_logins](
	[username] [varchar](64) NOT NULL,
	[series] [varchar](64) NOT NULL,
	[token] [varchar](64) NOT NULL,
	[last_used] [timestamp] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[series] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Product]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idGroupProduct] [int] NOT NULL,
	[flag] [bit] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Promotion]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[starteDate] [date] NOT NULL,
	[expiredDate] [date] NOT NULL,
	[note] [nvarchar](50) NULL,
 CONSTRAINT [PK_Promotion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PromotionDetail]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PromotionDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[discount] [int] NULL,
	[code] [nvarchar](50) NULL,
	[idGroupProduct] [int] NOT NULL,
	[idPromotion] [int] NOT NULL,
 CONSTRAINT [PK_PromotionDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SocialMediaService]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SocialMediaService](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[SocialMediaService] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_SocialMediaService] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[mail] [nvarchar](50) NOT NULL,
	[phone] [float] NOT NULL,
	[address] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 30-Apr-18 11:11:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](500) NULL,
	[email] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[point] [int] NULL,
	[addressStreet] [nvarchar](50) NULL,
	[addressSuite] [nvarchar](50) NULL,
	[addressCity] [nvarchar](50) NULL,
	[role] [nvarchar](50) NULL,
	[socialMediaService] [nvarchar](50) NULL,
	[years] [int] NULL,
	[habit] [nvarchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Category]  WITH CHECK ADD  CONSTRAINT [FK_Category_Department] FOREIGN KEY([idDepartment])
REFERENCES [dbo].[Department] ([id])
GO
ALTER TABLE [dbo].[Category] CHECK CONSTRAINT [FK_Category_Department]
GO
ALTER TABLE [dbo].[ImportDetail]  WITH CHECK ADD  CONSTRAINT [FK_ImportDetail_GroupProduct] FOREIGN KEY([idGroupProduct])
REFERENCES [dbo].[GroupProduct] ([id])
GO
ALTER TABLE [dbo].[ImportDetail] CHECK CONSTRAINT [FK_ImportDetail_GroupProduct]
GO
ALTER TABLE [dbo].[ImportDetail]  WITH CHECK ADD  CONSTRAINT [FK_ImportDetail_ImportStore] FOREIGN KEY([idImportStore])
REFERENCES [dbo].[ImportStore] ([id])
GO
ALTER TABLE [dbo].[ImportDetail] CHECK CONSTRAINT [FK_ImportDetail_ImportStore]
GO
ALTER TABLE [dbo].[ImportStore]  WITH CHECK ADD  CONSTRAINT [FK_ImportStore_Supplier] FOREIGN KEY([idSupplier])
REFERENCES [dbo].[Supplier] ([id])
GO
ALTER TABLE [dbo].[ImportStore] CHECK CONSTRAINT [FK_ImportStore_Supplier]
GO
ALTER TABLE [dbo].[ImportStore]  WITH CHECK ADD  CONSTRAINT [FK_ImportStore_User] FOREIGN KEY([idUser])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[ImportStore] CHECK CONSTRAINT [FK_ImportStore_User]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([idUser])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([idOrder])
REFERENCES [dbo].[Order] ([id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([idProduct])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Permission]  WITH CHECK ADD  CONSTRAINT [FK_Permission_Role] FOREIGN KEY([idRole])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Permission] CHECK CONSTRAINT [FK_Permission_Role]
GO
ALTER TABLE [dbo].[Permission]  WITH CHECK ADD  CONSTRAINT [FK_Permission_User] FOREIGN KEY([idUser])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Permission] CHECK CONSTRAINT [FK_Permission_User]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_GroupProduct] FOREIGN KEY([idGroupProduct])
REFERENCES [dbo].[GroupProduct] ([id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_GroupProduct]
GO
ALTER TABLE [dbo].[PromotionDetail]  WITH CHECK ADD  CONSTRAINT [FK_PromotionDetail_GroupProduct] FOREIGN KEY([idGroupProduct])
REFERENCES [dbo].[GroupProduct] ([id])
GO
ALTER TABLE [dbo].[PromotionDetail] CHECK CONSTRAINT [FK_PromotionDetail_GroupProduct]
GO
ALTER TABLE [dbo].[PromotionDetail]  WITH CHECK ADD  CONSTRAINT [FK_PromotionDetail_Promotion] FOREIGN KEY([idPromotion])
REFERENCES [dbo].[Promotion] ([id])
GO
ALTER TABLE [dbo].[PromotionDetail] CHECK CONSTRAINT [FK_PromotionDetail_Promotion]
GO
USE [master]
GO
ALTER DATABASE [MinimalismShop] SET  READ_WRITE 
GO
