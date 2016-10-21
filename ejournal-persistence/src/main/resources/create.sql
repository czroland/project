INSERT INTO public.users( id, name, email, password ) VALUES (1, 'teacher','123','123');
INSERT INTO public.users( id, name, email, password ) VALUES (2, 'student','123','123');
INSERT INTO public.teachers( id,user_id ) VALUES (1,1);
INSERT INTO public.classes( id, year, teacher_id ) VALUES (1, '2010',1);
INSERT INTO public.students( id, user_id, class_id ) VALUES (1, 2,1);