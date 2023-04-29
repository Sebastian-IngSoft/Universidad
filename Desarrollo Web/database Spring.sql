-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-07-2022 a las 03:40:56
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `risar2`
--
CREATE DATABASE IF NOT EXISTS `risar2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `risar2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carnetelectronico`
--
-- Creación: 19-07-2022 a las 05:24:03
-- Última actualización: 21-07-2022 a las 03:31:51
--

DROP TABLE IF EXISTS `carnetelectronico`;
CREATE TABLE IF NOT EXISTS `carnetelectronico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DI` varchar(45) NOT NULL,
  `Fecha` date NOT NULL,
  `Usuarios_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CarnetElectronico_Usuarios1` (`Usuarios_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `carnetelectronico`
--

INSERT INTO `carnetelectronico` (`id`, `DI`, `Fecha`, `Usuarios_id`) VALUES
(1, 'U18308827', '2022-07-19', 2),
(3, '8567431', '2022-07-19', 4),
(4, '12312312', '2022-07-20', 5),
(5, '12312312', '2022-07-13', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisoaltura`
--
-- Creación: 19-07-2022 a las 05:24:03
-- Última actualización: 21-07-2022 a las 03:30:25
--

DROP TABLE IF EXISTS `permisoaltura`;
CREATE TABLE IF NOT EXISTS `permisoaltura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` varchar(45) NOT NULL,
  `Descripcion` longtext NOT NULL,
  `Usuarios_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PermisoAltura_Usuarios` (`Usuarios_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `permisoaltura`
--

INSERT INTO `permisoaltura` (`id`, `Fecha`, `Descripcion`, `Usuarios_id`) VALUES
(1, '2022-07-21', 'Instalacion de redes para la comunicacion entre las empresas RISAR SAC y ENTEL, tiempo de la instalacion, jornada completa. Acompañado con un grupo de ing. Estructurales e ing. Sistemas.', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisoingreso`
--
-- Creación: 19-07-2022 a las 06:54:35
-- Última actualización: 21-07-2022 a las 03:32:09
--

DROP TABLE IF EXISTS `permisoingreso`;
CREATE TABLE IF NOT EXISTS `permisoingreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Usuarios_id` int(11) NOT NULL,
  `empresa` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PermisoIngreso_Usuarios1` (`Usuarios_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `permisoingreso`
--

INSERT INTO `permisoingreso` (`id`, `Fecha`, `Usuarios_id`, `empresa`) VALUES
(1, '2022-07-21', 2, 'Entel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--
-- Creación: 19-07-2022 a las 05:24:03
-- Última actualización: 21-07-2022 a las 03:30:38
--

DROP TABLE IF EXISTS `solicitudes`;
CREATE TABLE IF NOT EXISTS `solicitudes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `DI` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `Asunto` varchar(45) NOT NULL,
  `Descripcion` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitudes`
--

INSERT INTO `solicitudes` (`id`, `Nombre`, `DI`, `telefono`, `Asunto`, `Descripcion`) VALUES
(1, 'Sebastian Clever Sarmiento Castro', 'U18308827', 978913563, 'Solicitud de practicas como programador web', 'Buenas tardes estimados, soy un estudiante del sexto ciclo en la carrera de ing. Software, cuento con 1 año de experiencia en el area de programacion web, tengo conocimientos tanto en el Fronten como en el Backend, dispongo de todos los dias laborales en horario completo como media jornada, tengo nuevas ideas sobre como mejorar el sitio web que tienen ahora, dejo un enlace a mi linkedin y github para que puedan ver mi perfil completo y proyectos elaborados hasta el momento, esta a la espera de su pronta respuesta.\r\n\r\n\r\nLinkedin: https://www.linkedin.com/in/sebastian-sarmiento-castro-4a3b64204/\r\ngithub: https://github.com/Sebastian-IngSoft\r\n\r\n\r\nSaludos Cordiales\r\nSebastian Sarmiento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--
-- Creación: 19-07-2022 a las 05:24:03
-- Última actualización: 21-07-2022 a las 03:33:40
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Contrasenia` varchar(45) NOT NULL,
  `Rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `Nombres`, `Apellidos`, `Usuario`, `Contrasenia`, `Rol`) VALUES
(2, 'Sebastian Clever', 'Sarmiento Castro', 'Admin', 'admin', 'Ing. Software'),
(4, 'Miriam', 'Sarmiento Ponciano', 'Miriam', '12345', 'Gerente'),
(5, 'Juan ', 'Rivera Rojas', 'Juan', '12345', 'Gerente');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carnetelectronico`
--
ALTER TABLE `carnetelectronico`
  ADD CONSTRAINT `fk_CarnetElectronico_Usuarios1` FOREIGN KEY (`Usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `permisoaltura`
--
ALTER TABLE `permisoaltura`
  ADD CONSTRAINT `fk_PermisoAltura_Usuarios` FOREIGN KEY (`Usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `permisoingreso`
--
ALTER TABLE `permisoingreso`
  ADD CONSTRAINT `fk_PermisoIngreso_Usuarios1` FOREIGN KEY (`Usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
