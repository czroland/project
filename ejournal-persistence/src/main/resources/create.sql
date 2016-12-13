INSERT INTO public.subjects(id, name) VALUES (-1, 'Magyar nyelv és irodalom')
INSERT INTO public.subjects(id, name) VALUES (-2, 'Idegen nyelv')
INSERT INTO public.subjects(id, name) VALUES (-3, 'Második idegen nyelv')
INSERT INTO public.subjects(id, name) VALUES (-4, 'Matematika')
INSERT INTO public.subjects(id, name) VALUES (-5, 'Történelem, társadalmi és állampolgári ismeretek')
INSERT INTO public.subjects(id, name) VALUES (-6, 'Etika')
INSERT INTO public.subjects(id, name) VALUES (-7, 'Biológia-egészségtan')
INSERT INTO public.subjects(id, name) VALUES (-8, 'Fizika')
INSERT INTO public.subjects(id, name) VALUES (-9, 'Kémia')
INSERT INTO public.subjects(id, name) VALUES (-10, 'Földrajz')
INSERT INTO public.subjects(id, name) VALUES (-11, 'Ének-zene')
INSERT INTO public.subjects(id, name) VALUES (-12, 'Dráma és tánc')
INSERT INTO public.subjects(id, name) VALUES (-13, 'Vizuális kultúra')
INSERT INTO public.subjects(id, name) VALUES (-14, 'Mozgóképkultúra és médiaismeret')
INSERT INTO public.subjects(id, name) VALUES (-15, 'Művészetek')
INSERT INTO public.subjects(id, name) VALUES (-16, 'Ének-zene')
INSERT INTO public.subjects(id, name) VALUES (-17, 'Dráma és tánc')
INSERT INTO public.subjects(id, name) VALUES (-18, 'Vizuális kultúra')
INSERT INTO public.subjects(id, name) VALUES (-19, 'Mozgóképkultúra és médiaismeret')
INSERT INTO public.subjects(id, name) VALUES (-20, 'Informatika')
INSERT INTO public.subjects(id, name) VALUES (-21, 'Technika, életvitel és gyakorlat')
INSERT INTO public.subjects(id, name) VALUES (-22, 'Testnevelés és sport')

INSERT INTO public.users( id, name, firstname, lastname, email, password ) VALUES (-1, 'teacher','a','a','asd@gh.hu','$2a$10$N4rOzufDNCMGWZtyaNoM4ud.7CWRFtEIXirRlDKOf.hIauBeGErXq');
INSERT INTO public.users( id, name, email, password, firstname, lastname ) VALUES (-2, 'student','student@gmail.com','$2a$10$CKMfM6Trt6ljRNowJXWUg.5eO.GyrZRhYsk0GIO/BSG6W4JlC10re','Kis','Elemer');
INSERT INTO public.users( id, name, email, password, firstname, lastname ) VALUES (-3, 'parent','parent@gmail.com','$2a$10$CKMfM6Trt6ljRNowJXWUg.5eO.GyrZRhYsk0GIO/BSG6W4JlC10re','Kis','Elemer Parent');
INSERT INTO public.users( id, name, email, password, firstname, lastname ) VALUES (-4, 'student2','student2@gmail.com','$2a$10$CKMfM6Trt6ljRNowJXWUg.5eO.GyrZRhYsk0GIO/BSG6W4JlC10re','Kis','Elemer');


INSERT INTO public.parents( id,user_id ) VALUES (-1,-3);
INSERT INTO public.students( id, user_id, parent_id ) VALUES (-1,-2,-1);
INSERT INTO public.students( id, user_id ) VALUES (-2,-4);

INSERT INTO public.teachers( id, user_id) VALUES (-1,-1);

INSERT INTO public.classes( id, year, name ) VALUES (-1, '2018','osztaly');

INSERT INTO public.roles( id, name ) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles( id, name ) VALUES (2, 'ROLE_TEACHER');
INSERT INTO public.roles( id, name ) VALUES (3, 'ROLE_PARENT');
INSERT INTO public.roles( id, name ) VALUES (4, 'ROLE_STUDENT');
INSERT INTO public.roles( id, name ) VALUES (5, 'ROLE_USER');

INSERT INTO public.users_roles(user_id, roles_id) VALUES(-1,1)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-1,2)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-1,5)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-3,3)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-3,5)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-2,4)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-2,5)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-4,4)
INSERT INTO public.users_roles(user_id, roles_id) VALUES(-4,5)

INSERT INTO public.marks(id, signed, student_id, subject_id, teacher_id, value) VALUES(-1, true, -1, -1,-1, 5)
INSERT INTO public.marks(id, signed, student_id, subject_id, teacher_id, value) VALUES(-2, false, -1, -5,-1, 3)