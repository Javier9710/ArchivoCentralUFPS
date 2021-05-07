//Usuario
INSERT INTO users(enable, nombre, password, username) VALUES (1,'Miryam Archivo', '$2y$12$V5SGLIS3D6/kNQ4GLOWDDOkCUsdYax73FJIzTdVXeSmwRS5P.JXM2', 'admin');

//Roles
INSERT INTO authorities(authority, user_id) VALUES ('ROLE_ADMIN',1);