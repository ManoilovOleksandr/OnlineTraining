CREATE TABLE `user` (
  `id` int(8) NOT NULL ,
  `isAdmin` bit(1) NOT NULL,
  `age` int(11) NOT NULL ,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (1, TRUE , 30, '2016-10-15 12:00:01', 'Ivan');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (2, FALSE , 40, '2016-10-15 12:00:01', 'Petro');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (3, TRUE , 50, '2016-10-15 12:00:01', 'Sasha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (4, TRUE, 30, '2016-10-15 12:00:01', 'Tania');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (5, FALSE, 40, '2016-10-15 12:00:01', 'Tania');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (6, TRUE, 50, '2016-10-15 12:00:01', 'Katerina');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (7, FALSE, 30, '2016-10-15 12:00:01', 'Olya');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (8, TRUE, 35, '2016-10-15 12:00:01', 'Lena');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (9, FALSE, 40, '2016-10-15 12:00:01', 'Zoia');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (10, TRUE, 50, '2016-10-15 12:00:01', 'Ivan');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (11, TRUE , 30, '2016-10-15 12:00:01', 'Poman');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (12, FALSE , 40, '2016-10-15 12:00:01', 'Sasha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (13, FALSE, 50, '2016-10-15 12:00:01', 'Lena');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (14, TRUE, 35, '2016-10-15 12:00:01', 'Gena');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (15, FALSE, 30, '2016-10-15 12:00:01', 'Igor');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (16, TRUE, 40, '2016-10-15 12:00:01', 'Vova');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (17, FALSE, 50, '2016-10-15 12:00:01', 'Zhora');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (18, TRUE, 30, '2016-10-15 12:00:01', 'Gosha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (19, FALSE, 35, '2016-10-15 12:00:01', 'Petro');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (20, TRUE, 40, '2016-10-15 12:00:01', 'Ivan');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (21, TRUE , 30, '2016-10-15 12:00:01', 'Katerina');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (22, FALSE , 40, '2016-10-15 12:00:01', 'Gosha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (23, FALSE, 50, '2016-10-15 12:00:01', 'Olya');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (24, TRUE, 35, '2016-10-15 12:00:01', 'Olya');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (25, FALSE, 40, '2016-10-15 12:00:01', 'Lena');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (26, TRUE, 50, '2016-10-15 12:00:01', 'Ivan');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (27, FALSE, 30, '2016-10-15 12:00:01', 'Sasha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (28, TRUE, 40, '2016-10-15 12:00:01', 'Sasha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (29, FALSE, 35, '2016-10-15 12:00:01', 'Tania');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (30, TRUE, 30, '2016-10-15 12:00:01', 'Vera');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (31, TRUE , 30, '2016-10-15 12:00:01', 'Ivan');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (32, FALSE , 35, '2016-10-15 12:00:01', 'Roman');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (33, FALSE, 40, '2016-10-15 12:00:01', 'Vadim');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (34, TRUE, 50, '2016-10-15 12:00:01', 'Zhora');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (35, FALSE, 40, '2016-10-15 12:00:01', 'Roman');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (36, TRUE, 30, '2016-10-15 12:00:01', 'Sasha');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (37, FALSE, 40, '2016-10-15 12:00:01', 'Olya');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (38, TRUE, 35, '2016-10-15 12:00:01', 'Lena');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (39, FALSE, 50, '2016-10-15 12:00:01', 'Vera');
INSERT INTO test.user (id, isAdmin, age, created_date, name) VALUES (40, TRUE, 18, '2016-10-15 12:00:01', 'Gosha');

COMMIT;