CREATE DATABASE  IF NOT EXISTS `tesisescueladb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `tesisescueladb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tesisescueladb
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `id_materia` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `fecha_hora_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `direccion_archivo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_materia`),
  KEY `actividad_usuario_idx` (`id_docente`),
  CONSTRAINT `actividad_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `actividad_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Realizar consultas de actividades diarias y por cada curso(materia)\nPublicación de manera oportuna de lecciones y exámenes por realizarse, son actividades por materia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,2,'2014-11-23','Examen','2014-11-19 05:05:52','');
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencias` (
  `id_estudiante` int(11) NOT NULL COMMENT 'Es el estudiante',
  `id_materia` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `asistio` bit(1) NOT NULL COMMENT '0: ASISTIO\n1: NO ESTUVO PRESENTE',
  `fecha_hora_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_estudiante`,`fecha`,`id_materia`,`id_docente`),
  KEY `asistencia_docente_idx` (`id_docente`),
  KEY `asistencia_materia_idx` (`id_materia`),
  CONSTRAINT `asistencia_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `asistencia_estudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `asistencia_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Control de asistencia diaria a estudiantes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
INSERT INTO `asistencias` VALUES (4,1,2,'2014-11-17','','2014-11-19 05:02:07'),(4,1,2,'2014-11-18','\0','2014-11-19 05:02:07'),(4,1,2,'2014-11-19','','2014-11-19 05:02:07');
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario_general`
--

DROP TABLE IF EXISTS `calendario_general`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario_general` (
  `id_calendario_general` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL COMMENT 'Puede publicar administrador o docente',
  `fecha` varchar(255) NOT NULL,
  `actividad` varchar(255) NOT NULL,
  `fecha_hora_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_calendario_general`),
  CONSTRAINT `calendario_general` FOREIGN KEY (`id_calendario_general`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario_general`
--

LOCK TABLES `calendario_general` WRITE;
/*!40000 ALTER TABLE `calendario_general` DISABLE KEYS */;
INSERT INTO `calendario_general` VALUES (1,1,'2014-11-18','Pago de mensualidad','2014-11-19 04:58:33');
/*!40000 ALTER TABLE `calendario_general` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_didacticos`
--

DROP TABLE IF EXISTS `material_didacticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_didacticos` (
  `id_material_didactico` int(11) NOT NULL AUTO_INCREMENT,
  `id_materia` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL,
  `material` varchar(255) NOT NULL,
  `archivo_material` varchar(45) NOT NULL,
  PRIMARY KEY (`id_material_didactico`),
  KEY `material_materia_idx` (`id_materia`),
  KEY `material_docente_idx` (`id_docente`),
  CONSTRAINT `material_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_didacticos`
--

LOCK TABLES `material_didacticos` WRITE;
/*!40000 ALTER TABLE `material_didacticos` DISABLE KEYS */;
INSERT INTO `material_didacticos` VALUES (1,1,3,'Test','material_didacticos/Test.pdf');
/*!40000 ALTER TABLE `material_didacticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materias` (
  `id_materia` int(11) NOT NULL AUTO_INCREMENT,
  `materia` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,'MatématicasIII','Para tercer año de básica'),(2,'ComputaciónXII','Computacion 7 año de báscia');
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajes` (
  `id_envia` int(11) NOT NULL COMMENT 'id_usuario que envia el mensaje',
  `id_recibe` int(11) NOT NULL COMMENT 'id_usuario que recibe el mensaje',
  `mensaje` varchar(255) NOT NULL,
  `fecha_hora_envio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_envia`,`id_recibe`,`fecha_hora_envio`),
  KEY `id_recibeUsuario_idx` (`id_recibe`),
  CONSTRAINT `id_enviaUsuario` FOREIGN KEY (`id_envia`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_recibeUsuario` FOREIGN KEY (`id_recibe`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (1,2,'Hola','2014-11-19 04:18:29'),(2,1,'Hola como estas','2014-11-19 04:18:39');
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_estudiantes`
--

DROP TABLE IF EXISTS `nota_estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_estudiantes` (
  `id_estudiante` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL,
  `nota` decimal(10,0) NOT NULL,
  `fecha_hora_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_estudiante`,`id_materia`),
  KEY `nota_estudiante_materia_idx` (`id_materia`),
  KEY `nota_estudiante_docente_idx` (`id_docente`),
  CONSTRAINT `nota_estudiante_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nota_estudiante_estudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nota_estudiante_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_estudiantes`
--

LOCK TABLES `nota_estudiantes` WRITE;
/*!40000 ALTER TABLE `nota_estudiantes` DISABLE KEYS */;
INSERT INTO `nota_estudiantes` VALUES (4,2,1,10,'2014-11-19 05:03:25'),(4,2,2,9,'2014-11-19 05:03:25');
/*!40000 ALTER TABLE `nota_estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `observaciones`
--

DROP TABLE IF EXISTS `observaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `observaciones` (
  `id_docente` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `observacion` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_hora_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_docente`,`id_estudiante`,`fecha_hora_registro`),
  KEY `observacion_estudiante_idx` (`id_estudiante`),
  KEY `observacion_docente_idx` (`id_docente`),
  CONSTRAINT `observacion_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `observacion_estudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Los profesores podrán dar conocimiento al padre de familia sobre las observaciones escolares y personales de su representado.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `observaciones`
--

LOCK TABLES `observaciones` WRITE;
/*!40000 ALTER TABLE `observaciones` DISABLE KEYS */;
INSERT INTO `observaciones` VALUES (2,4,'SE FUGO','2014-11-18','2014-11-19 05:04:07');
/*!40000 ALTER TABLE `observaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pf_estudiantes`
--

DROP TABLE IF EXISTS `pf_estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pf_estudiantes` (
  `id_pf` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  PRIMARY KEY (`id_pf`,`id_estudiante`),
  KEY `pd_estudiantePadre_idx` (`id_estudiante`),
  CONSTRAINT `pd_estudianteEstudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pd_estudiantePadreFamilia` FOREIGN KEY (`id_pf`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pf_estudiantes`
--

LOCK TABLES `pf_estudiantes` WRITE;
/*!40000 ALTER TABLE `pf_estudiantes` DISABLE KEYS */;
INSERT INTO `pf_estudiantes` VALUES (2,4);
/*!40000 ALTER TABLE `pf_estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Valor único, llave primaria, autoincrementable',
  `rol` varchar(45) NOT NULL COMMENT 'Nombre del rol de usuario',
  `descripcion_rol` varchar(255) NOT NULL COMMENT 'Descripción del rol de usuario, para que lo utilizará',
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='Gestionar 4 tipos de usuarios (administrador, docentes, padres de familia, estudiantes)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador','Administrador del sistema'),(2,'Docente','Docente de la institución'),(3,'Padre de familia','Padre de familia de estudiantes'),(4,'Estudiante','Estudiante');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tareas` (
  `id_docente` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL,
  `fecha_envio` varchar(45) NOT NULL,
  `fecha_entrega` varchar(45) NOT NULL,
  `tarea_docente` varchar(45) NOT NULL,
  `archivo_tarea` varchar(45) NOT NULL,
  `estado_enviado` int(11) NOT NULL,
  `calificacion` decimal(10,0) NOT NULL,
  `estado_calificado` int(11) NOT NULL,
  `tarea_estudiante` varchar(45) NOT NULL,
  `comentario` varchar(255) NOT NULL,
  PRIMARY KEY (`id_docente`),
  KEY `tarea_estudiante_idx` (`id_estudiante`),
  KEY `tarea_materia_idx` (`id_materia`),
  CONSTRAINT `tarea_docente` FOREIGN KEY (`id_docente`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarea_estudiante` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarea_materia` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
INSERT INTO `tareas` VALUES (2,4,1,'2014-11-16','2014-11-18','Enviar su nombre','nombre.txt',1,9,1,'DIEGO ROMERO ARMIJOS','Fácil de realizar');
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_rol` int(11) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `telf_conv` varchar(9) NOT NULL,
  `bloqueado` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  KEY `usuario_rol_idx` (`id_rol`),
  CONSTRAINT `usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'0705462745','1234','DIEGO JACINTO','ROMERO ARMIJOS','diego.romero@kradac.com','0979748969','',0),(2,3,'1105581316','1234','ANDREA MARIBEL','PATIÑO ABAD','mayuri.150293@gmail.com','0969748968','',0),(3,2,'1111111111','1234','AYLEEN','ROMERO','ayleen1304@gmail.com','0978342343','',0),(4,4,'2222222222','1234','JUAN','ROMERO','juan@gmail.com','0982788373','',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tesisescueladb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-30 20:52:49
