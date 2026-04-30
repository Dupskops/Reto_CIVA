
INSERT INTO marca (nombre) VALUES 
('Volvo'), 
('Scania'), 
('Mercedes-Benz'), 
('Marcopolo');


INSERT INTO bus (numero_bus, placa, fecha_creacion, caracteristicas, activo, marca_id) VALUES 

('EXC-100', 'CVA-123', CURRENT_TIMESTAMP, 'Excluciva: Asientos cama 180° y 160°, cortinas divisorias, pantallas individuales, Wi-Fi, alimentación y terramoza.', true, 1),
('EXC-101', 'CVA-124', CURRENT_TIMESTAMP, 'Excluciva: Asientos cama 180°/160°, Wi-Fi, entretenimiento. Equipaje: 20kg bodega, 8kg cabina. Cinturones de seguridad.', true, 2),


('SUP-200', 'CVA-456', CURRENT_TIMESTAMP, 'Superciva: Asientos reclinables (tipo cama/semicama), baños diferenciados, TV/Video, aire acondicionado. Cinturones.', true, 3),
('SUP-201', 'CVA-457', CURRENT_TIMESTAMP, 'Superciva: Asientos reclinables, baños diferenciados, aire acondicionado. Equipaje: 20kg bodega, 8kg cabina.', false, 4),


('ECO-300', 'CVA-789', CURRENT_TIMESTAMP, 'Econociva: Asientos cómodos reclinables, baño químico, seguridad básica. Equipaje: 20kg bodega, 8kg cabina.', true, 1);


INSERT INTO bus (numero_bus, placa, fecha_creacion, caracteristicas, activo, marca_id) VALUES 
-- Buses EXCLUCIVA
('EXC-102', 'CVA-901', CURRENT_TIMESTAMP, 'Excluciva: Asientos cama 180°/160°, Wi-Fi. Ruta regular: Lima - Arequipa.', true, 1),
('EXC-103', 'CVA-902', CURRENT_TIMESTAMP, 'Excluciva: Asientos cama 180°/160°, pantallas, terramoza. Ruta regular: Lima - Cusco.', true, 2),
('EXC-104', 'CVA-903', CURRENT_TIMESTAMP, 'Excluciva: Cortinas divisorias, alimentación. Unidad de refuerzo de temporada.', false, 1),

-- Más Buses SUPERCIVA
('SUP-202', 'CVA-904', CURRENT_TIMESTAMP, 'Superciva: Asientos reclinables, TV/Video. Ruta regular: Lima - Piura.', true, 3),
('SUP-203', 'CVA-905', CURRENT_TIMESTAMP, 'Superciva: Baños diferenciados, aire acondicionado. Ruta regular: Lima - Trujillo.', true, 4),
('SUP-204', 'CVA-906', CURRENT_TIMESTAMP, 'Superciva: Asientos semicama, Wi-Fi básico. Ruta regular: Lima - Chiclayo.', true, 3),
('SUP-205', 'CVA-907', CURRENT_TIMESTAMP, 'Superciva: Aire acondicionado, TV/Video. En revisión técnica preventiva.', false, 4),

-- Buses ECONOCIVA
('ECO-301', 'CVA-908', CURRENT_TIMESTAMP, 'Econociva: Asientos cómodos, baño químico. Ruta corta: Lima - Ica.', true, 1),
('ECO-302', 'CVA-909', CURRENT_TIMESTAMP, 'Econociva: Asientos reclinables. Ruta corta: Lima - Huaraz.', true, 2),
('ECO-303', 'CVA-910', CURRENT_TIMESTAMP, 'Econociva: Seguridad básica, sin aire acondicionado. Reservado para viajes especiales.', true, 1);


