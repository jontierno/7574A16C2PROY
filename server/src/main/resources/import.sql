
INSERT INTO SECURITY_USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', true, TIMESTAMP '2016-01-01 10:10:10-05:00');
INSERT INTO SECURITY_USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', true, TIMESTAMP '2016-01-01 10:10:10-05:00');

INSERT INTO SECURITY_USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'quimico', '$2a$06$D4r2U09JUxBZVWBgaixl3eRgtW8VIyTZk45hqfwAQKGzZV5TxqbZq', 'user', 'user', true, TIMESTAMP '2016-01-01 10:10:10-05:00');




INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);


INSERT INTO CAREER(CODE, NAME) VALUES ('10', 'Ingeniría Informática');
INSERT INTO CAREER(CODE, NAME) VALUES ('8', 'Ingeniría Química');

INSERT INTO SUBJECT (CODE, NAME) VALUES ('75.74', 'Sistemas Distribuidos I');
INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('75.74.01', 30, '75.74','Mendez-Pandolfo');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (1,'LUN', '18:00', '21:00','TPO','75.74.01', 'E03');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (2,'MAR', '18:00', '21:00','TPO','75.74.01', 'E03');



INSERT INTO SUBJECT (CODE, NAME) VALUES ('66.71', 'Sistemas Gráficos');
INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('66.71.01', 30, '66.71','Abbate-Luiso-Marino');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (3,'LUN', '16:00', '19:00','TO','66.71.01', 'L01');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (4,'VIE', '16:00', '19:00','PO','66.71.01', 'L01');


INSERT INTO SUBJECT (CODE, NAME) VALUES ('61.03', 'Análisis matemático II A');

INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('61.03.1A', 35, '61.03','Troparevsky-Comas-Porta');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (5,'MAR', '9:00', '11:00','TO','61.03.1A', 'PC-400');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (6,'MAR', '11:00', '13:00','PO','61.03.1A', 'PC-400');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (7,'VIE', '9:00', '11:00','TO','61.03.1A', 'PC-400');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (8,'VIE', '11:00', '13:00','PO','61.03.1A', 'PC-400');

INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('61.03.2A', 35, '61.03','Acero-Lopez-Sarris');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (9,'MAR', '7:00', '9:00','TO','61.03.2A', 'PC-403');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (10,'MAR', '9:00', '11:00','PO','61.03.2A', 'PC-313');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (11,'JUE', '7:00', '9:00','TO','61.03.2A', 'PC-403');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (12,'JUE', '9:00', '11:00','PO','61.03.2A', 'PC-313');


INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('61.03.3', 35, '61.03','Gigola-Perez-De Rossi');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (13,'MIE', '14:00', '16:00','TO','61.03.3', 'PC-411');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (14,'MIE', '16:00', '18:00','PO','61.03.3', 'PC-411');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (15,'VIE', '14:00', '16:00','TO','61.03.3', 'PC-414');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (16,'VIE', '16:00', '18:00','PO','61.03.3', 'PC-414');

INSERT INTO SUBJECT (CODE, NAME) VALUES ('61.08', 'Algebra II');

INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('61.08.1', 35, '61.08','Vargas-Palacios-Oliva');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (17,'LUN', '9:00', '11:00','TO','61.08.1', 'PC-403');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (18,'LUN', '11:00', '13:00','PO','61.08.1', 'PC-400');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (19,'MIE', '9:00', '11:00','TO','61.08.1', 'PC-403');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (20,'MIE', '11:00', '13:00','PO','61.08.1', 'PC-400');

INSERT INTO COURSE (CODE,VACANCIES,SUBJECT_CODE,PROFESSORS) VALUES ('61.08.2', 0, '61.08','Cammilleri-Peralta-Petrovich');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (21,'MIE', '9:00', '11:00','TO','61.08.2', 'PC-500');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (22,'MIE', '11:00', '13:00','PO','61.08.2', 'PC-203');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (23,'VIE', '9:00', '11:00','TO','61.08.2', 'PC-500');
INSERT INTO CLASS (ID,DAY, STARTING_TIME, ENDING_TIME, TYPE,COURSE_CODE,PLACE) VALUES (24,'VIE', '11:00', '13:00','PO','61.08.2', 'PC-203');



INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('10', '75.74');
INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('10', '66.71');
INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('10', '61.03');
INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('10', '61.08');

INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('8', '61.03');
INSERT INTO CAREER_SUBJECT (CAREER_CODE, SUBJECT_CODE) VALUES ('8', '61.08');

INSERT INTO SYSTEM_USER(ID, user_name, first_name,last_name, CAREER_CODE) VALUES(1, 'admin', 'Jonathan', 'Tierno', '10');
INSERT INTO SYSTEM_USER(ID, user_name, first_name,last_name, CAREER_CODE) VALUES(2, 'quimico', 'Juan', 'Perez', '8');


