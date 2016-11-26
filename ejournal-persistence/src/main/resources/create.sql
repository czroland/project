INSERT INTO public.users( id, name, firstname, lastname, email, password ) VALUES (-1, 'teacher','a','a','asd@gh.hu','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');
INSERT INTO public.users( id, name, email, password ) VALUES (2, 'student','123','123');
INSERT INTO public.teachers( id,user_id ) VALUES (1,2);
INSERT INTO public.classes( id, year, teacher_id ) VALUES (1, '2010',1);
INSERT INTO public.students( id, user_id, class_id ) VALUES (1, 2,1);

INSERT INTO public.roles( id, name ) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles( id, name ) VALUES (2, 'ROLE_TEACHER');
INSERT INTO public.roles( id, name ) VALUES (3, 'ROLE_STUDENT');
INSERT INTO public.roles( id, name ) VALUES (4, 'ROLE_USER');

INSERT INTO public.users_roles(user_id, roles_id) VALUES(-1,1)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-1,2)