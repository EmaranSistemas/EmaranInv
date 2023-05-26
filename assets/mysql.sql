CREATE TABLE `inventario` (
  `id_inventario` integer PRIMARY KEY,
  `id_tienda` integer,
  `id_sucursales` integer,
  `id_producto` integer,
  `inventario` integer,
  `pedido` integer,
  `stock` integer,
  `stock_minimo` integer,
  `variacion` integer,
  `fecha` timestamp DEFAULT (now()),
  `latitud` integer,
  `longitud` integer
);

CREATE TABLE `tiendas` (
  `id_tienda` integer PRIMARY KEY,
  `nombre` varchar(255),
  `id_sucursales` integer
);

CREATE TABLE `sucursales` (
  `id_sucursales` integer PRIMARY KEY,
  `nombre` varchar(255),
  `id_producto` integer
);

CREATE TABLE `productos` (
  `id_producto` integer PRIMARY KEY,
  `nombre` varchar(255)
);

CREATE TABLE `estados` (
  `id_estados` integer PRIMARY KEY
);

CREATE TABLE `catch` (
  `id_catch` integer PRIMARY KEY,
  `id_estados` integer,
  `fecha` timestamp DEFAULT (now()),
  `latitud` integer,
  `longitud` integer
);

ALTER TABLE `sucursales` ADD FOREIGN KEY (`id_sucursales`) REFERENCES `tiendas` (`id_tienda`);

CREATE TABLE `sucursales_productos` (
  `sucursales_id_producto` integer,
  `productos_id_producto` integer,
  PRIMARY KEY (`sucursales_id_producto`, `productos_id_producto`)
);

ALTER TABLE `sucursales_productos` ADD FOREIGN KEY (`sucursales_id_producto`) REFERENCES `sucursales` (`id_producto`);

ALTER TABLE `sucursales_productos` ADD FOREIGN KEY (`productos_id_producto`) REFERENCES `productos` (`id_producto`);


ALTER TABLE `estados` ADD FOREIGN KEY (`id_estados`) REFERENCES `catch` (`id_catch`);

ALTER TABLE `catch` ADD FOREIGN KEY (`fecha`) REFERENCES `inventario` (`fecha`);

ALTER TABLE `inventario` ADD FOREIGN KEY (`stock_minimo`) REFERENCES `tiendas` (`id_tienda`);
