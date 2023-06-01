-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2023 a las 22:27:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicios`
--

CREATE TABLE `ejercicios` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `equiponecesario` varchar(255) DEFAULT NULL,
  `grupomuscular` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peso` int(11) NOT NULL,
  `repeticiones` int(11) NOT NULL,
  `series` int(11) NOT NULL,
  `rutina_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `ejercicios`
--

INSERT INTO `ejercicios` (`id`, `descripcion`, `equiponecesario`, `grupomuscular`, `nombre`, `peso`, `repeticiones`, `series`, `rutina_id`) VALUES
(1, 'Acuéstate en un banco, agarra la barra con las manos separadas a la anchura de los hombros, baja la barra hacia el pecho y luego empújala hacia arriba hasta que los brazos estén extendidos.', 'Bancos de ejercicio', 'Pectorales (pecho)', 'Press de banca', 0, 10, 4, 1),
(2, 'Colócate entre dos barras paralelas, con los brazos extendidos, baja el cuerpo flexionando los codos y luego empuja hacia arriba hasta que los brazos estén completamente extendidos.', 'Equipos de entrenamiento de peso corporal', 'Pectorales (pecho)', 'Fondos en paralelas', 0, 12, 4, 1),
(3, 'Siéntate en un banco inclinado, sostén una mancuerna en cada mano, baja los brazos hacia los lados hasta que los codos estén en ángulo recto, luego empuja las mancuernas hacia arriba hasta que los brazos estén extendidos.', 'Pesas libres', 'Pectorales (pecho)', 'Press inclinado con mancuernas', 0, 10, 4, 1),
(4, 'Ponte frente a una polea alta con una cuerda de tríceps, agarra la cuerda/barra con las manos hacia abajo, estira los brazos hacia abajo y luego flexiona los codos para llevar la cuerda hacia abajo hasta que los brazos estén completamente extendidos', 'Máquinas de musculación', 'Tríceps', 'Extensiones de tríceps en polea', 0, 10, 4, 1),
(5, '.', 'Equipos de entrenamiento de peso corporal', 'Dorsales (espalda)', 'Dominadas', 0, 8, 3, 2),
(6, '.', 'Máquinas de musculación', 'Dorsales (espalda)', 'Remo con barra', 0, 12, 4, 2),
(7, '.', 'Pesas libres', 'Bíceps', 'Curl de bíceps con mancuernas', 0, 12, 4, 2),
(8, '.', 'Pesas libres', 'Dorsales (espalda)', 'Peso muerto', 0, 10, 4, 2),
(9, '.', 'Máquinas de musculación', 'Pantorrillas', 'Sentadillas', 0, 10, 4, 3),
(10, '.', 'Máquinas de musculación', 'Cuádriceps', 'Prensa de piernas', 0, 10, 4, 3),
(11, '.', 'Máquinas de musculación', 'Cuádriceps', 'Zancadas', 0, 10, 4, 3),
(12, '.', 'Máquinas de musculación', 'Pantorrillas', 'Elevación de talones', 0, 10, 4, 3),
(13, '.', 'Máquinas de musculación', 'Pectorales (pecho)', 'Press de banca con barra', 0, 10, 4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `id` bigint(20) NOT NULL,
  `anosexperiencia` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `especializacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`id`, `anosexperiencia`, `correo`, `especializacion`, `nombre`) VALUES
(1, 2, 'pedro@getfit.com', 'Entrenamiento de fuerza y acondicionamiento', 'Pedro'),
(2, 2, 'ricardo@getfit.com', 'Entrenamiento deportivo', 'Ricardo'),
(3, 5, 'pablo@getfit.com', 'Entrenamiento deportivo', 'Pablo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador_rutinas`
--

CREATE TABLE `entrenador_rutinas` (
  `entrenadores_id` bigint(20) NOT NULL,
  `rutinas_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`id`, `descripcion`, `duracion`, `nombre`, `precio`) VALUES
(1, 'Acceso ilimitado a todas las áreas de entrenamiento,\nPrograma de entrenamiento personalizado,\nClases grupales gratuitas\n', 30, 'Fitness Total', 35),
(2, 'Acceso ilimitado a todas las áreas de entrenamiento,\nPrograma de entrenamiento básico,\nClases grupales limitadas (2 por semana)', 15, 'Express Fit', 20),
(3, 'Acceso ilimitado a todas las áreas de entrenamiento,\nPrograma de entrenamiento avanzado,\nClases grupales ilimitadas,\nEvaluación inicial y seguimiento de condición física,\nAsesoramiento nutricional completo', 30, 'Power Pack', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `rol_id` bigint(20) NOT NULL,
  `rol_nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`rol_id`, `rol_nombre`) VALUES
(1, 'ADMIN'),
(2, 'NORMAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutinas`
--

CREATE TABLE `rutinas` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `dificultad` varchar(255) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `rutinas`
--

INSERT INTO `rutinas` (`id`, `descripcion`, `dificultad`, `duracion`, `nombre`, `usuario_id`) VALUES
(1, 'Esta rutina se compone de 3 ejercicios de pectoral, y un ejercicio de triceps', 'Facil', 1, 'Pecho y tríceps (fuerza)', NULL),
(2, 'Esta rutina se compone de 3 ejercicios de dorsal, y un ejercicio de biceps', 'Facil', 1, 'Espalda y bíceps (fuerza)', NULL),
(3, 'Esta rutina se compone de 4 ejercicios de piernas', 'Facil', 1, 'Piernas (fuerza)', NULL),
(4, 'En esta rutina, el enfoque principal está en desarrollar y fortalecer los músculos del pecho y los tríceps.', 'Dificil', 3, 'Pecho y tríceps (hipertrofia)', NULL),
(6, 'En esta rutina, el objetivo es trabajar los músculos de la espalda y los bíceps para lograr un desarrollo equilibrado.', 'Dificil', 3, 'Espalda y bíceps (hipertrofia)', NULL),
(7, 'Esta rutina se centra en el desarrollo y fortalecimiento de los músculos de las piernas. ', 'Dificil', 3, 'Piernas (hipertrofia)', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `altura` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `fechavalidez` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numsecretotarjeta` int(11) NOT NULL,
  `numtarjeta` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `peso` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `plan_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `altura`, `correo`, `enabled`, `fechavalidez`, `genero`, `nombre`, `numsecretotarjeta`, `numtarjeta`, `password`, `perfil`, `peso`, `username`, `plan_id`) VALUES
(1, 0, 'getfit@getfit.com', b'1', '', 'Hombre', 'admin', 0, '', '$2a$10$kK5pF31JCu1GfdBr0zScAODMJmJAQSDq.sS1rnGmWQiVAypi1QW9i', 'foto.png', 0, 'admin', NULL),
(2, 180, 'raul@getfit.com', b'1', '2023-06-01', 'Hombre', 'raul', 340, '5465 4656 7565 6556', '$2a$10$m8/Duoi7ZMyrauuCEhFi6e6fKocdXaPI9HqnSz7snMNUrdemkNsZe', 'default.png', 66, 'raul', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_rol_id` bigint(20) NOT NULL,
  `rol_rol_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_rol_id`, `rol_rol_id`, `usuario_id`) VALUES
(1, 1, 1),
(2, 2, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ls7t5xgmssdlg1kkhm6o5926y` (`nombre`),
  ADD KEY `FK1qutlfhu4b5utydegnox6jo8l` (`rutina_id`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entrenador_rutinas`
--
ALTER TABLE `entrenador_rutinas`
  ADD KEY `FKmbr645xjsy86yxo185aqoiaod` (`rutinas_id`),
  ADD KEY `FK9fhu5nhla1a36q77w0tt6txav` (`entrenadores_id`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ojfgfgdtuob4rxg97kyb0x4c2` (`nombre`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`rol_id`);

--
-- Indices de la tabla `rutinas`
--
ALTER TABLE `rutinas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jnlna8n1k7dof9rp5fq3c9ukx` (`nombre`),
  ADD KEY `FKe3swm1g2oigxudqi4ilyfh8e0` (`usuario_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcu0voijbl28a9iv4vs88rel4i` (`plan_id`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_rol_id`),
  ADD KEY `FK7j1tyvjj1tv8gbq7n6f7efccc` (`rol_rol_id`),
  ADD KEY `FKktsemf1f6awjww4da0ocv4n32` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rutinas`
--
ALTER TABLE `rutinas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  MODIFY `usuario_rol_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  ADD CONSTRAINT `FK1qutlfhu4b5utydegnox6jo8l` FOREIGN KEY (`rutina_id`) REFERENCES `rutinas` (`id`);

--
-- Filtros para la tabla `entrenador_rutinas`
--
ALTER TABLE `entrenador_rutinas`
  ADD CONSTRAINT `FK9fhu5nhla1a36q77w0tt6txav` FOREIGN KEY (`entrenadores_id`) REFERENCES `entrenador` (`id`),
  ADD CONSTRAINT `FKmbr645xjsy86yxo185aqoiaod` FOREIGN KEY (`rutinas_id`) REFERENCES `rutinas` (`id`);

--
-- Filtros para la tabla `rutinas`
--
ALTER TABLE `rutinas`
  ADD CONSTRAINT `FKe3swm1g2oigxudqi4ilyfh8e0` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FKcu0voijbl28a9iv4vs88rel4i` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK7j1tyvjj1tv8gbq7n6f7efccc` FOREIGN KEY (`rol_rol_id`) REFERENCES `roles` (`rol_id`),
  ADD CONSTRAINT `FKktsemf1f6awjww4da0ocv4n32` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
