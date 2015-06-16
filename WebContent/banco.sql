-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `banco`;


-- Volcando estructura para tabla banco.tarjetacredito
CREATE TABLE IF NOT EXISTS `tarjetacredito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(12) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `cupoMaximo` int(11) NOT NULL DEFAULT '0',
  `cupoDisponible` int(11) NOT NULL DEFAULT '0',
  `tipo` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `numComprobacion` varchar(7) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `contrasenha` varchar(4) COLLATE utf8_spanish_ci NOT NULL DEFAULT '0',
  `bloqueada` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla banco.tarjetacredito: ~2 rows (aproximadamente)
DELETE FROM `tarjetacredito`;
/*!40000 ALTER TABLE `tarjetacredito` DISABLE KEYS */;
INSERT INTO `tarjetacredito` (`id`, `numero`, `cupoMaximo`, `cupoDisponible`, `tipo`, `numComprobacion`, `contrasenha`, `bloqueada`) VALUES
	(1, '258', 10, 57, 'visa', '333', '333', 1),
	(2, '25', 250, 25, 'visa', '111', '111', 0);
/*!40000 ALTER TABLE `tarjetacredito` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
