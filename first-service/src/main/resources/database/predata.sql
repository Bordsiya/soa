-- добавление первичных значений (заполнить enum org_type)
INSERT INTO organization_type
VALUES (1, 'COMMERCIAL');
INSERT INTO organization_type
VALUES (2, 'PUBLIC');
INSERT INTO organization_type
VALUES (3, 'OPEN_JOINT_STOCK_COMPANY');

-- добавление организаций(кординаты, адрес, организация)
INSERT INTO coordinates
values (1, 3.2, 15);
INSERT INTO address
values (1, 'Nevskiy street', '193318');
INSERT INTO organization
values (1,
        'Yandex Inc.',
        1,
        CURRENT_TIMESTAMP - interval '50' year,
        15400000.3,
        3,
        1);
INSERT INTO coordinates
values (2, 4, 18);
INSERT INTO address
values (2, 'Buharestkaya street', 'A45I32');
INSERT INTO organization
values (2,
        'Tinkoff Inc.',
        2,
        CURRENT_TIMESTAMP  - interval '20' year,
        400000,
        3,
        2);
INSERT INTO coordinates
values (3, 3.2, 950);
INSERT INTO address
values (3, 'Kronva street', 'IFMO322WTF');
INSERT INTO organization
values (3,
        'ITMO W.T.F.',
        3,
        CURRENT_TIMESTAMP  - interval '40' year,
        10000,
        3,
        3);
INSERT INTO coordinates
values (4, 17.8, 210);
INSERT INTO address
values (4, 'Lenina street', 'U10SS9R');
INSERT INTO organization
values (4,
        'LDPR momento',
        4,
        CURRENT_TIMESTAMP - interval '5' year,
        340000.9,
        3,
        4);

INSERT INTO coordinates
values (5, -10.7, -115);
INSERT INTO address
values (5, 'Narvskaya street', '342-019');
INSERT INTO organization
values (5,
        'Wolcheka bakery',
        5,
        CURRENT_TIMESTAMP - interval '10' year,
        500000,
        3,
        5);
INSERT INTO coordinates
values (6, 0, -115);
INSERT INTO address
values (6, 'Bolshevikov prospekt', 'N90-123');
INSERT INTO organization
values (6,
        'Lenta store',
        6,
        CURRENT_TIMESTAMP - interval '12' year,
        800000,
        2,
        6);
INSERT INTO coordinates
values (7, 29, 45);
INSERT INTO address
values (7, 'Big prospekt P.I.', '000-001');
INSERT INTO organization
values (7,
        'Polyakov global industry',
        7,
        CURRENT_TIMESTAMP - interval '4' year,
        77777,
        2,
        7);
INSERT INTO coordinates
values (8, 29, 5);
INSERT INTO address
values (8, 'Wall street', '909-A8N');
INSERT INTO organization
values (8,
        'Intel',
        8,
        CURRENT_TIMESTAMP - interval '32' year,
        20000000,
        2,
        8);
INSERT INTO coordinates
values (9, 120, 115);
INSERT INTO address
values (9, 'Griboedova nab', '15-GOK9');
INSERT INTO organization
values (9,
        'Sberbank Inc.',
        9,
        CURRENT_TIMESTAMP - interval '41' year,
        45000000,
        2,
        9);
INSERT INTO coordinates
values (10, 85, 54);
INSERT INTO address
values (10, 'Bulvarnaya street', '430010');
INSERT INTO organization
values (10,
        'MINECRAFT',
        10,
        CURRENT_TIMESTAMP - interval '100' year,
        100,
        2,
        10);
INSERT INTO coordinates
values (11, 90, 22);
INSERT INTO address
values (11, 'Murmanskaya street', '151515');
INSERT INTO organization
values (11,
        'NorNikel Company',
        11,
        CURRENT_TIMESTAMP - interval '47' year,
        1905000,
        1,
        11);
INSERT INTO coordinates
values (12, 88, -10);
INSERT INTO address
values (12, 'Antonovskaya street', '212432');
INSERT INTO organization
values (12,
        'World stirka company',
        12,
        CURRENT_TIMESTAMP - interval '1' year,
        40000,
        1,
        12);
INSERT INTO coordinates
values (13, 20, 66);
INSERT INTO address
values (13, 'Liteiniy prospekt', '15OOND');
INSERT INTO organization
values (13,
        'Yoga center',
        13,
        CURRENT_TIMESTAMP - interval '2' year,
        100,
        1,
        13);
INSERT INTO coordinates
values (14, 43, 808);
INSERT INTO address
values (14, 'Fista street', '10O-SLA');
INSERT INTO organization
values (14,
        'Only GACHI CLUB',
        14,
        CURRENT_TIMESTAMP - interval '3' year,
        800,
        1,
        14);
INSERT INTO coordinates
values (15, 20, 150);
INSERT INTO address
values (15, 'Mirovaya street', '1BK178');
INSERT INTO organization
values (15,
        'BBC Inc.',
        15,
        CURRENT_TIMESTAMP - interval '7' year,
        20070,
        1,
        15);

-- добавляем сотрудников
INSERT INTO employee
VALUES (1, 'Bob', 'Smith', null, 1000, 1),
       (2, 'Alice', 'Johnson', 'Ann', 1200, 2),
       (3, 'John', 'Doe', 'Michael', 1500, 3),
       (4, 'Mary', 'Brown', 'Elizabeth', 1100, 4),
       (5, 'David', 'Wilson', null, 1300, 5),
       (6, 'Sarah', 'Davis', 'Jane', 1250, 6),
       (7, 'Michael', 'Jones', 'Robert', 1400, 14),
       (8, 'Linda', 'Miller', 'Lee', 1050, 8),
       (9, 'William', 'Clark', null, 1150, 9),
       (10, 'Jennifer', 'Harris', 'Marie', 1350, 1),
       (11, 'James', 'White', 'Edward', 1550, 1),
       (12, 'Karen', 'Martin', 'Ruth', 1250, 12),
       (13, 'Richard', 'Thompson', null, 1450, 13),
       (14, 'Patricia', 'Anderson', 'Ann', 1100, 14),
       (15, 'Charles', 'Nelson', null, 1200, 15),
       (16, 'Elizabeth', 'Wright', 'Marie', 1300, 1),
       (17, 'Robert', 'Green', 'Lee', 1400, 2),
       (18, 'Susan', 'Hill', null, 1050, 3),
       (19, 'Thomas', 'Baker', 'Edward', 1500, 4),
       (20, 'Jessica', 'Garcia', null, 1250, 5),
       (21, 'Daniel', 'Evans', 'Michael', 1100, 6),
       (22, 'Margaret', 'Turner', 'Ruth', 1350, 7),
       (23, 'Joseph', 'Hernandez', null, 1200, 8),
       (24, 'Nancy', 'King', 'Jane', 1550, 9),
       (25, 'Paul', 'Young', null, 1450, 10),
       (26, 'Karen', 'Williams', 'Ann', 1300, 11),
       (27, 'Kenneth', 'Hall', 'Robert', 1150, 2),
       (28, 'Lisa', 'Gonzalez', null, 1350, 13),
       (29, 'Mark', 'Lee', 'Edward', 1250, 14),
       (30, 'Donna', 'Scott', 'Marie', 1400, 15),
       (31, 'George', 'Walker', null, 1050, 1),
       (32, 'Betty', 'Ramirez', 'Lee', 1150, 2),
       (33, 'Edward', 'Ward', null, 1500, 3),
       (34, 'Helen', 'Roberts', 'Ruth', 1100, 4),
       (35, 'Christopher', 'Johnson', null, 1200, 5),
       (36, 'Laura', 'Lopez', 'Michael', 1450, 6),
       (37, 'Brian', 'Perez', 'Edward', 1300, 7),
       (38, 'Sandra', 'Taylor', null, 1250, 8),
       (39, 'Kevin', 'Wilson', 'Robert', 1400, 9),
       (40, 'Maria', 'Martinez', null, 1050, 14),
       (41, 'Emma', 'Johnson', 'Ann', 42000, 11),
       (42, 'Daniel', 'Smith', 'Michael', 26000, 12),
       (43, 'Sophia', 'Brown', 'Elizabeth', 17000, 3),
       (44, 'Christopher', 'Davis', 'Jane', 34000, 14),
       (45, 'Olivia', 'Clark', null, 12000, 15),
       (46, 'Ethan', 'Miller', 'Lee', 9800, 1),
       (47, 'Ava', 'Harris', 'Marie', 26500, 2),
       (48, 'Matthew', 'Turner', 'Ruth', 41000, 3),
       (49, 'Isabella', 'Walker', null, 16000, 4),
       (50, 'William', 'Roberts', 'Edward', 38000, 5),
       (51, 'Mia', 'Lopez', 'Michael', 8000, 6),
       (52, 'James', 'Young', null, 37000, 5),
       (53, 'Grace', 'Garcia', 'Lee', 29000, 5),
       (54, 'Benjamin', 'Nelson', null, 2500, 9),
       (55, 'Amelia', 'Hernandez', 'Ann', 23000, 10),
       (56, 'Michael', 'Lee', 'Robert', 42000, 11),
       (57, 'Elizabeth', 'Hall', null, 39000, 12),
       (58, 'Alexander', 'Gonzalez', 'Edward', 3400, 13),
       (59, 'Sofia', 'Williams', 'Marie', 16000, 14),
       (60, 'Liam', 'Ramirez', 'Lee', 2300, 15),
       (61, 'Evelyn', 'Ward', 'Michael', 47000, 1),
       (62, 'Daniel', 'King', null, 28000, 2),
       (63, 'Victoria', 'Scott', 'Edward', 11500, 3),
       (64, 'Jacob', 'Ward', 'Robert', 34000, 4),
       (65, 'Madison', 'Perez', null, 27000, 5),
       (66, 'William', 'Hill', 'Ann', 16000, 6),
       (67, 'Ava', 'Hernandez', null, 49000, 7),
       (68, 'Liam', 'Jones', 'Lee', 13500, 8),
       (69, 'Olivia', 'Anderson', 'Marie', 23000, 9),
       (70, 'Noah', 'Evans', null, 3900, 10),
       (71, 'Emily', 'Garcia', 'Michael', 1100, 11),
       (72, 'Michael', 'Martinez', 'Robert', 39500, 12),
       (73, 'Sophia', 'Smith', null, 28000, 13),
       (74, 'Ethan', 'Ward', 'Edward', 21000, 14),
       (75, 'Isabella', 'Davis', 'Lee', 44000, 15),
       (76, 'Jacob', 'Nelson', 'Ann', 15500, 1),
       (77, 'Olivia', 'Walker', null, 24000, 2),
       (78, 'Liam', 'Hernandez', 'Michael', 1700, 3),
       (79, 'Ava', 'Harris', 'Edward', 45000, 4),
       (80, 'Mia', 'Hall', 'Jane', 9800, 5),
       (81, 'James', 'Garcia', 'Marie', 47000, 6),
       (82, 'Evelyn', 'Smith', null, 13000, 7),
       (83, 'Sofia', 'Clark', 'Robert', 29000, 8),
       (84, 'Alexander', 'Anderson', 'Lee', 14000, 9),
       (85, 'Grace', 'Ramirez', null, 2000, 14),
       (86, 'John', 'Smith', null, 1200, 3),
       (87, 'Emily', 'Johnson', 'Ann', 1400, 3),
       (88, 'Michael', 'Doe', 'Edward', 1600, 3),
       (89, 'Olivia', 'Brown', null, 1800, 3),
       (90, 'William', 'Taylor', 'Robert', 2000, 3),
       (91, 'Sophia', 'Harris', null, 2200, 3),
       (92, 'James', 'Turner', 'Lee', 2400, 3),
       (93, 'Ava', 'Walker', 'Michael', 2600, 3),
       (94, 'Logan', 'Martinez', 'Marie', 2800, 3),
       (95, 'Ella', 'Clark', null, 3000, 3),
       (96, 'Emma', 'Hernandez', null, 4000, 9),
       (97, 'Liam', 'Young', 'Robert', 4200, 9),
       (98, 'Isabella', 'Smith', 'Ann', 4400, 9),
       (99, 'Oliver', 'Davis', null, 4600, 9),
       (100, 'Ava', 'Brown', 'Edward', 4800, 9),
       (101, 'William', 'Garcia', 'Marie', 5000, 9),
       (102, 'Sophia', 'Hall', null, 5200, 11),
       (103, 'Noah', 'Johnson', 'Lee', 5400, 11);