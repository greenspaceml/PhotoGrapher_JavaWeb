USE [Photo]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 3/29/2020 12:52:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[Name] [ntext] NULL,
	[Address] [ntext] NULL,
	[City] [ntext] NULL,
	[Country] [ntext] NULL,
	[Telephone] [varchar](20) NULL,
	[Email] [varchar](200) NULL,
	[image] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 3/29/2020 12:52:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [ntext] NOT NULL,
	[Description] [ntext] NOT NULL,
	[Image] [ntext] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImageInGallery]    Script Date: 3/29/2020 12:52:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImageInGallery](
	[GalleryID] [int] NOT NULL,
	[Image] [varchar](50) NOT NULL,
	[ID] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[GalleryID] ASC,
	[Image] ASC,
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 3/29/2020 12:52:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[About] [ntext] NOT NULL,
	[ShortAbout] [ntext] NOT NULL,
	[Image] [varchar](100) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Contact] ([Name], [Address], [City], [Country], [Telephone], [Email], [image]) VALUES (N'Bo Quang Vĩ Đại', N'Vân Đồn', N'Quảng Ninh', N'Việt Nam', N'0912345678', N'quangxxx@vandon.com', N'map.png')
SET IDENTITY_INSERT [dbo].[Gallery] ON 

INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (1, N'Gallery 1', N'Witness Japan landscape overcome by a breathtaking sea of cherry-blossoms this April. Incredible shades of
 pink stretch across the main islands that make up the country', N'boyVioletShirt.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (2, N'Gallery 2', N'Expect to be greeted by drumbeats, fireworks and a whole lot of energy at Beltane Fire
 Festival in Edinburgh. Taking place on April 30', N'girlBlackShirt.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (3, N'Gallery 3', N'Take this opportunity to check out Edinburgh and its many attractions. Top spots are
 the Edinburgh Castle, National Galleries of Scotland', N'boyBlueEye.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (6, N'Gallery 4', N'For many, travel is a means of escape. Increasingly though, it provides an opportunity for dreams to come true, bodies to be repaired, and lives to be changed.', N'boyBlueEye.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (7, N'Gallery 5', N'It is little wonder then that more and more people from countries with overloaded healthcare systems are venturing overseas for medical treatment.', N'boyVioletShirt.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (8, N'Gallery 6', N'Many independent healthcare travellers put a great deal of effort into their journey to and from a country, bearing in mind the time spent in a foreign country', N'girlBlackShirt.jpg')
INSERT [dbo].[Gallery] ([ID], [Name], [Description], [Image]) VALUES (9, N'Gallery 7', N'In Malaysia, we take care of every single minute detail for you. We have been consistent winners from 2015 to 2019 at the Internal Medical Travel Journal Awards.', N'boyBlueEye.jpg')
SET IDENTITY_INSERT [dbo].[Gallery] OFF
SET IDENTITY_INSERT [dbo].[ImageInGallery] ON 

INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'boyBlueEye.jpg', 4)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'boyBrownEye.jpg', 5)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'boyVioletShirt.jpg', 1)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'cat.jpg', 10)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'dog.jpg', 9)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlBlackShirt.jpg', 3)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlBlackShirt.jpg', 22)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlInBW.jpg', 6)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlShortHair.jpg', 7)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlWithHand.jpg', 8)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (1, N'girlYellowEye.jpg', 2)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (2, N'boyBlueEye.jpg', 12)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (2, N'boyBrownEye.jpg', 13)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (2, N'girlBlackShirt.jpg', 11)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (2, N'girlInBW.jpg', 14)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (2, N'girlShortHair.jpg', 15)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (3, N'boyBlueEye.jpg', 16)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (3, N'boyBrownEye.jpg', 17)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (3, N'girlInBW.jpg', 18)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (3, N'girlShortHair.jpg', 19)
INSERT [dbo].[ImageInGallery] ([GalleryID], [Image], [ID]) VALUES (3, N'girlWithHand.jpg', 20)
SET IDENTITY_INSERT [dbo].[ImageInGallery] OFF
INSERT [dbo].[Information] ([About], [ShortAbout], [Image]) VALUES (N'COVID-19 is a new virus that belongs to the Coronavirus group which is actually
common across the world. This particular virus can cause respiratory illnesses which could
lead to more severe health problems. COVID-19 can spread from person-to-person, causing much fear
and confusion among the general public. Many countries around the world have implemented
drastic measures to protect their citizens. Some countries shut their borders while
others impose self-isolation for all arrivals. In other words, your travel plan is likely to be affected.', N'COVID-19 is a new virus', N'girlYellowEye.jpg')
ALTER TABLE [dbo].[ImageInGallery]  WITH CHECK ADD FOREIGN KEY([GalleryID])
REFERENCES [dbo].[Gallery] ([ID])
GO
