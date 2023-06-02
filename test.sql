-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3310
-- Tiempo de generación: 01-06-2023 a las 09:29:12
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
(3, 'Acuéstate en el banco, sostén la barra con un agarre amplio y baja lentamente hacia el pecho. Luego, empuja la barra hacia arriba hasta que los brazos estén extendidos.', 'Bancos de ejercicio', 'Pectorales (pecho)', 'Press de banca con barra', 0, 0, 0, 8),
(4, 'Agarra la barra con las palmas hacia adelante y los brazos extendidos. Luego, levántate hasta que la barbilla esté por encima de la barra y luego baja lentamente.\nSeries y repeticiones: 3 series de 8-10 repeticiones.', 'Equipos de entrenamiento de peso corporal', 'Dorsales (espalda)', 'Dominadas', 0, 10, 3, 8),
(5, 'Sostén una mancuerna en cada mano a la altura de los hombros. Luego, extiende los brazos hacia arriba hasta que las pesas se encuentren casi tocando y luego baja lentamente.', 'Pesas libres', 'Deltoides (hombros)', 'Press de hombros con mancuernas', 0, 12, 3, 8),
(6, 'Ajusta la velocidad de la cinta según tu nivel de comodidad y corre a un ritmo constante durante el tiempo deseado. Tiempo estimado: 20-30 minutos.', 'Máquinas de cardio', 'Otro', 'Correr en cinta', 0, 0, 1, 9),
(7, 'Coloca los pies en los pedales y sujeta las asas. Realiza un movimiento de balanceo simultáneo de las piernas y los brazos, manteniendo un ritmo constante. Tiempo estimado entre 20 - 30 minutos.', 'Máquinas de cardio', 'Otro', 'Máquina elíptica', 0, 0, 1, 9),
(8, 'Sujeta las asas de la cuerda de saltar y salta con ambos pies a medida que la cuerda pasa por debajo. Intenta mantener un ritmo constante.\n3 series de 1 minuto cada una, con descanso de 30 segundos entre cada serie.', 'Máquinas de cardio', 'Otro', 'Saltos de cuerda', 0, 0, 3, 9),
(9, 'Siéntate en el suelo con las piernas extendidas. Inclínate hacia adelante y trata de tocar tus dedos de los pies, manteniendo las piernas rectas. Mantén la posición durante 15-20 segundos.', 'Equipos de estiramiento y movilidad', 'Otro', 'Estiramientos de piernas', 0, 3, 3, 10),
(10, 'De pie, extiende los brazos hacia los lados. Gira los hombros hacia adelante en círculos amplios durante 10 repeticiones y luego gíralos hacia atrás durante otras 10 repeticiones.', 'Equipos de estiramiento y movilidad', 'Otro', 'Rotación de hombros', 0, 10, 2, 10),
(11, 'Acuéstate boca arriba y lleva las rodillas hacia el pecho. Envuelve tus brazos alrededor de las piernas y tira suavemente hacia el pecho para sentir un estiramiento en la espalda baja. Mantén la posición durante 20 segundos.', 'Equipos de estiramiento y movilidad', 'Otro', 'Estiramiento de espalda', 0, 3, 3, 10);

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
(1, 1, 'javi@getfit.com', 'Entrenamiento de fuerza y acondicionamiento', 'Javier'),
(2, 4, 'natalia@getfit.com', 'Entrenamiento deportivo', 'Natalia'),
(3, 6, 'pedro@getfit.com', 'Entrenamiento funcional', 'Pedro');

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
  `descripcion` varchar(1000) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`id`, `descripcion`, `duracion`, `nombre`, `precio`) VALUES
(3, 'Acceso ilimitado al gimnasio durante el horario de apertura;\nUso de todas las áreas de entrenamiento, como pesas, máquinas cardiovasculares y zonas de estiramientos;\nAcceso a clases grupales estándar, como aeróbicos y yoga, de acuerdo con el horario semanal;\nConsulta con un entrenador personal una vez al mes para establecer metas y recibir orientación básica', 30, 'Basico', 25),
(4, 'Acceso ilimitado al gimnasio durante el horario de apertura;\nUso de todas las áreas de entrenamiento, incluyendo pesas, máquinas cardiovasculares, zonas de estiramientos y áreas especializadas (como área de boxeo o sala de spinning);\nAcceso a todas las clases grupales disponibles en el gimnasio, incluyendo clases especiales y de alta intensidad;\nConsulta con un entrenador personal una vez al mes para establecer metas, recibir asesoramiento personalizado y seguimiento regular;\nDescuentos exclusivos en servicios adicionales, como masajes terapéuticos o planes nutricionales personalizados', 30, 'Premium', 35),
(5, 'Acceso ilimitado al gimnasio durante el horario de apertura, incluyendo acceso prioritario en horarios concurridos;\nUso de todas las áreas de entrenamiento, incluyendo pesas, máquinas cardiovasculares, zonas de estiramientos y áreas especializadas;\nAcceso ilimitado a todas las clases grupales disponibles, sin restricciones;\nConsulta con un entrenador personal dos veces al mes para establecer metas, recibir asesoramiento personalizado y seguimiento regular;\nAcceso exclusivo a sesiones de entrenamiento en grupos reducidos o clases especiales VIP;\nDescuentos especiales en todos los servicios adicionales, así como acceso a eventos y talleres exclusivos del gimnasio.', 30, 'VIP', 40);

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
(8, 'Esta rutina se enfoca en el desarrollo de fuerza y músculos en la parte superior del cuerpo', 'Dificil', 2, 'Fuerza y Hipertrofia (Superior)', NULL),
(9, 'Esta rutina se centra en mejorar la resistencia cardiovascular y quemar calorías.', 'Medio', 1, 'Resistencia Cardiovascular', NULL),
(10, 'Esta rutina se enfoca en mejorar la flexibidad y la movilidad en todo el cuerpo', 'Facil', 1, 'Flexibilidad y Movilidad', NULL);

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
(1, 0, 'getfit@getfit.com', b'1', '', 'Hombre', 'admin', 0, '', '$2a$10$d.QPRfSqzumsN8nHMYc9we2t1xgDTlML3dM8YnwkYRcdbi3pDqaGy', 'foto.png', 0, 'admin', NULL),
(2, 177, 'raul@getfit.com', b'1', '2023-06-01', 'Hombre', 'raul', 340, '2354 6235 6324 5746', '$2a$10$eeT9LZ8mc/m7xmWnuFQY/egaJYwQqm8WsK0iD4VDlAgLuXK4s/Adq', 'default.png', 66, 'raul', 3);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `rutinas`
--
ALTER TABLE `rutinas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
