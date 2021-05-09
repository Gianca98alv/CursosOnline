use cursosonline;

-- HORARIOS
INSERT INTO Horario(dia, hora) VALUES (1, 13);
INSERT INTO Horario(dia, hora) VALUES (1, 19);
INSERT INTO Horario(dia, hora) VALUES (2, 13);
INSERT INTO Horario(dia, hora) VALUES (2, 19);
INSERT INTO Horario(dia, hora) VALUES (4, 13);
INSERT INTO Horario(dia, hora) VALUES (4, 19);
INSERT INTO Horario(dia, hora) VALUES (5, 13);
INSERT INTO Horario(dia, hora) VALUES (5, 15);

-- ROLES
INSERT INTO Rol(descripcion) VALUES ("Administrador");
INSERT INTO Rol(descripcion) VALUES ("Profesor");
INSERT INTO Rol(descripcion) VALUES ("Estudiante");

-- ESTADOS DE MATRICULA
INSERT INTO Estado(descripcion) VALUES ("Activa");
INSERT INTO Estado(descripcion) VALUES ("Finalizada");

-- AREAS TEMATICAS
INSERT INTO area_tematica(descripcion) values ('Idiomas');
INSERT INTO area_tematica(descripcion) values ('Gastronomia');
INSERT INTO area_tematica(descripcion) values ('Administracion');
INSERT INTO area_tematica(descripcion) values ('Economia');

-- USUARIO ADMINISTRADOR
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("1111", 1, "1111", CURRENT_TIMESTAMP(), 1);
-- ADMINISTRADOR
INSERT INTO Administrador(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("1111", "Perez", "Lopez", "Juan", "1111", "juan@gmail.com");

-- USUARIOS PROFESORES
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("2222", 2, "2222", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("3333", 2, "3333", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("4444", 2, "4444", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("5555", 2, "5555", CURRENT_TIMESTAMP(), 1);
-- PROFESORES
INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("2222", "Salas", "Benavidez", "Maria", "2222", "maria@gmail.com");
INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("3333", "Zapata", "Hernandez", "Pablo", "3333", "pablo@gmail.com");
INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("4444", "Guzman", "Orozco", "Jennifer", "4444", "jennifer@gmail.com");
INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("5555", "Gutierrez", "Urbina", "Esteban", "5555", "esteban@gmail.com");

-- ESPECIALIDADES 
INSERT INTO Especialidad(profesor_id_profesor, area_tematica_id) VALUES(1, 1);
INSERT INTO Especialidad(profesor_id_profesor, area_tematica_id) VALUES(2, 2);
INSERT INTO Especialidad(profesor_id_profesor, area_tematica_id) VALUES(3, 3);
INSERT INTO Especialidad(profesor_id_profesor, area_tematica_id) VALUES(4, 4);

-- USUARIOS ESTUDIANTES
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("6666", 3, "6666", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("7777", 3, "7777", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("8888", 3, "8888", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("9999", 3, "9999", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("1212", 3, "1212", CURRENT_TIMESTAMP(), 1);
-- ESTUDIANTES
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("6666", "Gonzalez", "Piedra", "Valeria", "6666", "valeria@gmail.com");
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("7777", "Portuguez", "Salas", "Oscar", "7777", "oscar@gmail.com");
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("8888", "Solano", "Alvarez", "Abigail", "8888", "abigail@gmail.com");
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("9999", "Villalobos", "Jimenez", "Marco", "9999", "marco@gmail.com");
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("1212", "Arias", "Delgado", "Andres", "1212", "andres@gmail.com");


-- CURSOS
INSERT INTO curso(descripcion, area_tematica_id) values ('Ingles conversacional 1', 1);
INSERT INTO curso(descripcion, area_tematica_id) values ('Ingles conversacional 2', 1);
INSERT INTO curso(descripcion, area_tematica_id) values ('Reposteria', 2);
INSERT INTO curso(descripcion, area_tematica_id) values ('Mariscos', 2);
INSERT INTO curso(descripcion, area_tematica_id) values ('Introduccion a la gerencia', 3);
INSERT INTO curso(descripcion, area_tematica_id) values ('Liderazgo 1', 3);
INSERT INTO curso(descripcion, area_tematica_id) values ('Economia 1', 4);
INSERT INTO curso(descripcion, area_tematica_id) values ('Macroeconomia', 4);

-- GRUPOS
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (1, 1, 1, 25);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (1, 1, 2, 25);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (2, 1, 3, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (2, 1, 4, 20);

INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (3, 2, 1, 15);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (3, 2, 2, 15);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (4, 2, 3, 15);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (4, 2, 4, 15);

INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (5, 3, 5, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (5, 3, 6, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (6, 3, 7, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (6, 3, 8, 20);

INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (7, 4, 5, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (7, 4, 6, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (8, 4, 7, 20);
INSERT INTO Grupo(curso_id, profesor_id, horario_seq, cupo) VALUES (8, 4, 8, 20);
