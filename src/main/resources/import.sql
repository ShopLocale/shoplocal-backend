-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: trini
-- ------------------------------------------------------
-- Server version	5.7.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('3be30c5e-7ab7-4a96-9e19-603cb8677748','769 Sec-8','Main Road','Meerut','2021-02-27 16:52:03.373968','Main Market','2021-02-27 16:52:03.373968','28.9551864','77.7455757','8754547074','mom','250004','Uttar Pradesh');
INSERT INTO `address` VALUES ('678c9925-d2b4-4c6b-a7b4-c1e163836f5c','A-1','Somdutt Vihar','Meerut','2021-02-27 16:51:54.768563','New Market','2021-02-27 16:51:54.768563','28.9551864','77.7455757','8754547074','new house','250004','Uttar Pradesh');
INSERT INTO `address` VALUES ('8d7d4d74-da31-430a-9894-ad573d344310','FC Block 13','PNB Road','Meerut','2021-02-26 18:41:11.931430','Main Market','2021-02-26 18:41:11.931430','28.9551864','77.7455757','875454707','shop_address','250004','Uttar Pradesh');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
--INSERT INTO `address` VALUES ('32c5103b-d9ff-4fa7-a7ee-76c50b2bbb22','FC Block 13','PNB Road','Main','Meerut','8754547071','2021-02-05 20:50:19.129855','Shop address','Main Market','2021-02-05 20:50:19.129855','28.9551864','77.7455757','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('5775307a-7f30-46c9-8164-19ac723881b6','Old address','The absolute gym Road','Main','Meerut','8754547079','2021-02-05 21:09:27.464315','Shop address','Main Market','2021-02-05 21:09:27.464315','28.9494509','77.747575','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('5d2b723f-ec2d-477c-b9bd-566bb6bd33bc','FC Block 13','Okkiyampet','Main','Meerut','8754547073','2021-02-05 17:30:13.945149','Shop address','Main Market','2021-02-05 17:30:13.945149','28.9494509','77.747575','250003','Uttar Pradesh');
--INSERT INTO `address` VALUES ('5d2b723f-ec2d-477c-b9bd-566bb6bd33bd','FC Block 13','Okkiyampet','Main','Meerut','8754547074','2021-02-05 17:30:13.945149','Shop address','Main Market','2021-02-05 17:30:13.945149','28.9494509','77.747575','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('5d2b723f-ec2d-477c-b9bd-566bb6bd33be','FC Block 13','Okkiyampet','Main','Meerut','8754547072','2021-02-05 17:30:13.945149','Shop address','Main Market','2021-02-05 17:30:13.945149','28.9495636','77.748111','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('5d2b723f-ec2d-477c-b9bd-566bb6bd33bf','FC Block 13','Okkiyampet','Main','Meerut','8754547070','2021-02-05 17:30:13.945149','Shop address','Main Market','2021-02-05 17:30:13.945149','28.9647044','77.736061','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('d613a023-223f-439b-b89f-f17dd7c19bf6','FC Block 13','The absolute gym Road','Main','Meerut','8754547077','2021-02-05 20:52:58.428716','Shop address','Main Market','2021-02-05 20:52:58.428716','28.9494509','77.747575','250004','Uttar Pradesh');
--INSERT INTO `address` VALUES ('f948cc29-6921-491d-abfc-df226411f8f2','FC Block 13','Jai Sai Kitchen Ghar Road','Main','Meerut','8754547071','2021-02-05 20:51:46.438272','Shop address','Main Market','2021-02-05 20:51:46.438272','28.9506161','77.7463391','250004','Uttar Pradesh');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('043972fd-814a-4461-a97c-fd170b4f35c5','2021-01-01 07:41:30.325140','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/grocery.jpg?alt=media&token=439e7a0e-1244-48b8-9329-ec1d39ac3786','2021-01-01 07:41:30.325140','Grocery');
INSERT INTO `category` VALUES('0b2f6213-7310-4a7c-8dd2-944df015deec','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/clothing.jpg?alt=media&token=83f80592-d462-44b2-b264-ea53062bfdae','2021-01-01 07:41:30.329826','Clothing');
INSERT INTO `category` VALUES('141f2864-03ad-4234-81da-b0190f067d2b','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/footwear.jpg?alt=media&token=1cda552a-748f-474d-9bc8-53865b61496c','2021-01-01 07:41:30.329826','Footwear');
INSERT INTO `category` VALUES('19a797bc-a5cb-4367-a4a2-7e4e8f1e9dfe','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/%20toys%20and%20games.jpg?alt=media&token=e0758806-6a26-424a-bb6c-079905881ee4','2021-01-01 07:41:30.329826','Toys and Games');
INSERT INTO `category` VALUES('335c08f9-d13c-4647-b06d-6c4963083d46','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/Books.jpeg?alt=media&token=49bbed96-dc35-4745-acac-7bc852095afe','2021-01-01 07:41:30.329826','Books');
INSERT INTO `category` VALUES('34132d01-d2fd-4a1d-8761-10bc7c98d7e7','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/Electronics.png?alt=media&token=d38f3a07-1407-4f3f-b683-312b78d333d0','2021-01-01 07:41:30.329826','Electronics');
INSERT INTO `category` VALUES('40db083a-2261-4c80-9b4a-8c8a19ec9b10','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/Sports%20and%20fitness.jpg?alt=media&token=6337a74c-b023-4deb-b449-0838000e935e','2021-01-01 07:41:30.329826','Sports and Fitness');
INSERT INTO `category` VALUES('46b36f29-7e7f-4b1c-99cf-b2553af03d72','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/jewellery.jpg?alt=media&token=4d908157-186a-4455-b0f7-2b78147195ac','2021-01-01 07:41:30.329826','Jewellery');
INSERT INTO `category` VALUES('473b38d9-3755-4aa6-8cac-a3c326b1ae5a','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/mobile%20access.jpg?alt=media&token=1552be5e-8383-4eb7-bff2-499c5d5440f5','2021-01-01 07:41:30.329826','Mobile and Accessories');
INSERT INTO `category` VALUES('4d259990-6861-4590-8ad4-d83c9b6fdbd8','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/supplements.jpg?alt=media&token=108c6807-3d35-4739-8311-29aaf123f5d7','2021-01-01 07:41:30.329826','Supplements');
INSERT INTO `category` VALUES('5241fd0d-136e-4ce2-a091-701dfdd91007','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/tools%20and%20hardware.jpeg?alt=media&token=7a947773-7b17-4c87-a6df-67acbc0697fb','2021-01-01 07:41:30.329826','Tools and Hardware');
INSERT INTO `category` VALUES('5badc556-8dd4-494d-8b73-8d1720ae0e21','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/computer%20and%20hardware.jpeg?alt=media&token=8c2d74ed-1bdd-4cb5-a74b-494b96bce313','2021-01-01 07:41:30.329826','Computer and Accessories');
INSERT INTO `category` VALUES('60bbd13d-7aed-4f6c-93c4-aae9b79c9a0b','2021-01-01 07:41:30.329826','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/Home%20Decor.jpeg?alt=media&token=d2af24ef-9ea4-4957-bb80-90071335bf61','2021-01-01 07:41:30.329826','Home Decor');
--('5badc556-8dd4-494d-8b73-8d1720ae0e21','2021-01-01 07:41:30.296027','2021-01-01 07:41:30.296027','Watches'),('60bbd13d-7aed-4f6c-93c4-aae9b79c9a0b','2021-01-01 07:41:30.329299','2021-01-01 07:41:30.329299','Furniture'),('676539b1-a187-464c-9308-3531a81e12ef','2021-01-01 07:41:30.327404','2021-01-01 07:41:30.327404','Jewellery'),('7b03f874-92fb-4a7b-b4cc-770dc673aef3','2021-01-01 07:41:30.330816','2021-01-01 07:41:30.330816','Clothing & Accessories'),('891c98c5-dffe-40a9-a3ec-d6dafe3c6999','2021-01-01 07:41:30.326169','2021-01-01 07:41:30.326169','Musical Instruments'),('895a0a02-eaf6-44f3-b07b-0d1fc6b84e1b','2021-01-01 07:41:30.329299','2021-01-01 07:41:30.329299','Garden & Outdoors'),('9e406431-99f4-4b5e-976b-d5d4f8aa1278','2021-01-01 07:41:30.325140','2021-01-01 07:41:30.325140','Tools & Home Improvement'),('abfbb398-5c33-4304-bb97-ede82b36b319','2021-01-01 07:41:30.329826','2021-01-01 07:41:30.329826','Baby'),('b1fdd169-3447-4e8b-bc55-7591621438e2','2021-01-01 07:41:30.325140','2021-01-01 07:41:30.325140','Sports, Fitness & Outdoors'),('b31284e7-2dc6-4798-b5cf-30d197e740e6','2021-01-01 07:41:30.331424','2021-01-01 07:41:30.331424','Electronics'),('b681e230-efad-4182-8c71-a9082ee19e61','2021-01-01 07:41:30.326169','2021-01-01 07:41:30.326169','Luxury Beauty'),('cf21268a-2607-4f07-88ca-774636cce278','2021-01-01 07:41:30.327932','2021-01-01 07:41:30.327932','Home & Kitchen'),('cf6a8601-330d-4e70-9088-f1e6fc8132b5','2021-01-01 07:41:30.326169','2021-01-01 07:41:30.326169','Medicine'),('e806248d-4f72-4bcb-813c-4c38c5cc2c42','2021-01-01 07:41:30.329826','2021-01-01 07:41:30.329826','Appliances'),('ea576ec3-8dae-4c4e-a370-a3a4e93eedce','2021-01-01 07:41:30.327932','2021-01-01 07:41:30.327932','Grocery & Gourmet Foods'),('f6c02ce9-6564-4c0e-a459-865f508f804b','2021-01-01 07:41:30.329826','2021-01-01 07:41:30.329826','Books'),('fdbcb927-c3ee-4ecd-a208-392722d2410b','2021-01-01 07:41:30.329826','2021-01-01 07:41:30.329826','Others');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('75292376-4842-4ee6-bb3f-bb25b41522fa','','2021-02-27 16:30:02.970888','satycool16@gmail.com','SagarC','2021-02-27 16:30:02.970888','JainC','8754547070');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer_addresses`
--

LOCK TABLES `customer_addresses` WRITE;
/*!40000 ALTER TABLE `customer_addresses` DISABLE KEYS */;
INSERT INTO `customer_addresses` VALUES ('75292376-4842-4ee6-bb3f-bb25b41522fa','3be30c5e-7ab7-4a96-9e19-603cb8677748');
INSERT INTO `customer_addresses` VALUES ('75292376-4842-4ee6-bb3f-bb25b41522fa','678c9925-d2b4-4c6b-a7b4-c1e163836f5c');
/*!40000 ALTER TABLE `customer_addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES ('71887454-bf16-46d3-b1c0-9810e6e2f93e', '', '2021-02-26 18:37:22.042360', 'satycool16@gmail.com', 'Sagar', '2021-02-26 18:37:22.042360', 'Jain', '8754547074');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES ('a45e76f0-c7c6-4c89-b401-47c45337a195', '', 'Grocery', '2021-02-26 18:41:11.931174',50.0, 'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/clothing.jpg?alt=media&token=83f80592-d462-44b2-b264-ea53062bfdae', '2021-02-26 18:41:11.931174', 'Pickup', 'Test local store', 'tls', '8d7d4d74-da31-430a-9894-ad573d344310', '71887454-bf16-46d3-b1c0-9810e6e2f93e');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('3125bb0c-0478-46b9-b362-63c721d51f50','\0','2021-02-27 15:59:16.510912','Noodles','https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/grocery.jpg?alt=media&token=439e7a0e-1244-48b8-9329-ec1d39ac3786','2021-02-27 15:59:16.510912','pack','Maggi',20,1,'a45e76f0-c7c6-4c89-b401-47c45337a195');
INSERT INTO `product` VALUES ('ced576d0-5630-4377-a481-e3f1ec473a6a','','2021-02-27 16:00:15.367366',NULL,'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/grocery.jpg?alt=media&token=439e7a0e-1244-48b8-9329-ec1d39ac3786','2021-02-27 16:00:15.367366',NULL,'Maggi 400gm',40,NULL,'a45e76f0-c7c6-4c89-b401-47c45337a195');
INSERT INTO `product` VALUES ('3b8d398e-96ec-48b4-9e7f-9fa04eafa141','','2021-03-07 16:44:05.955290',NULL,'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/clothing.jpg?alt=media&token=83f80592-d462-44b2-b264-ea53062bfdae','2021-03-07 16:44:05.955290',NULL,'T-Shirt Denim XL',1000,NULL,'a45e76f0-c7c6-4c89-b401-47c45337a195');
INSERT INTO `product` VALUES ('44712033-d24d-43a4-98e9-b4aa0a6ba241','','2021-03-07 16:46:15.570905',NULL,'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/Books.jpeg?alt=media&token=49bbed96-dc35-4745-acac-7bc852095afe','2021-03-07 16:46:15.570905',NULL,'Subtle Art of not giving a f**k',199,NULL,'a45e76f0-c7c6-4c89-b401-47c45337a195');
INSERT INTO `product` VALUES ('bd03ab39-0501-435c-a2d3-c6e0bb66021b','','2021-03-07 16:45:28.825952',NULL,'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/footwear.jpg?alt=media&token=1cda552a-748f-474d-9bc8-53865b61496c','2021-03-07 16:45:28.825952',NULL,'Puma Shoe 9',2999,NULL,'a45e76f0-c7c6-4c89-b401-47c45337a195');
INSERT INTO `product` VALUES ('e26fd56b-a79f-4ff2-b345-f8cabcc1537c','','2021-03-07 16:43:26.590843',NULL,'https://firebasestorage.googleapis.com/v0/b/trini-flutter.appspot.com/o/grocery.jpg?alt=media&token=439e7a0e-1244-48b8-9329-ec1d39ac3786','2021-03-07 16:43:26.590843',NULL,'Pepsi 600ml',40,NULL,'a45e76f0-c7c6-4c89-b401-47c45337a195');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('5e8aec3b-5a56-45ac-909e-8c6a6f52ffed','2021-02-27 15:59:16.510912', 20, 50,'2021-02-27 15:59:16.510912','Created','Delivery',470,500,'3be30c5e-7ab7-4a96-9e19-603cb8677748','75292376-4842-4ee6-bb3f-bb25b41522fa','a45e76f0-c7c6-4c89-b401-47c45337a195');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES ('25e1fd84-684f-4b36-a13d-9f37cc55d049','ABCDEF',100,1,'5e8aec3b-5a56-45ac-909e-8c6a6f52ffed');
INSERT INTO `order_item` VALUES ('336e7893-e236-4fea-93b5-1b168c537974','ABC',200,2,'5e8aec3b-5a56-45ac-909e-8c6a6f52ffed');
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-05 23:10:30
