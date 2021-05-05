use cursosonline;

INSERT INTO Rol(descripcion) VALUES ("Administrador");
INSERT INTO Rol(descripcion) VALUES ("Profesor");
INSERT INTO Rol(descripcion) VALUES ("Estudiante");

INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("1111", 1, "1111", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("2222", 2, "2222", CURRENT_TIMESTAMP(), 1);
INSERT INTO Usuario(id_usuario, rol_id, clave, ultimo_aceso, activo) 
VALUES("3333", 3, "3333", CURRENT_TIMESTAMP(), 1);

INSERT INTO Administrador(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("1111", "Perez", "Lopez", "Juan", "1111", "juan@gmail.com");
INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("2222", "Salas", "Benavidez", "Maria", "2222", "maria@gmail.com");
INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
VALUES ("3333", "Arias", "Delgado", "Andres", "3333", "andres@gmail.com");

INSERT INTO area_tematica(descripcion) values ('Idiomas');
INSERT INTO area_tematica(descripcion) values ('Gastronomia');
INSERT INTO area_tematica(descripcion) values ('Administracion');

INSERT INTO curso(descripcion, area_tematica_id) values ('Ingles conversacional 1', 1);
INSERT INTO curso(descripcion, area_tematica_id) values ('Ingles conversacional 2', 1);
INSERT INTO curso(descripcion, area_tematica_id) values ('Reposteria', 2);
INSERT INTO curso(descripcion, area_tematica_id) values ('Mariscos', 2);
INSERT INTO curso(descripcion, area_tematica_id) values ('Introduccion a la gerencia', 3);
INSERT INTO curso(descripcion, area_tematica_id) values ('Economia 1', 3);


