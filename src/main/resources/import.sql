//Usuario
INSERT INTO users(enable, nombre, password, username) VALUES (1,'Miryam Archivo', '$2y$12$V5SGLIS3D6/kNQ4GLOWDDOkCUsdYax73FJIzTdVXeSmwRS5P.JXM2', 'admin');
INSERT INTO users(enable, nombre, password, username) VALUES (1,'Maria Archivo', '$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'user');

//Roles
INSERT INTO authorities(authority, usuario) VALUES ('ROLE_ADMIN',1);
INSERT INTO authorities(authority, usuario) VALUES ('ROLE_USER',2);

//Dependencias
INSERT INTO dependencias(descripcion, nombre) VALUES ('Encargadas de Actas de grado', 'Secretaria General');

 