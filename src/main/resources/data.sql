INSERT INTO Country (id, version, name, code) VALUES (1, 0, 'Российская Федерация', '643');
INSERT INTO Country (id, version, name, code) VALUES (2, 0, 'Соединенные Штаты Америки', '840');
INSERT INTO Country (id, version, name, code) VALUES (3, 0, 'Королевство Испания', '724');

INSERT INTO Doc_type (id, version, name, code)
    VALUES (1, 0, 'Паспорт гражданина Российской Федерации', '21');
INSERT INTO Doc_type (id, version, name, code)
    VALUES (2, 0, 'Вид на жительство в Российской Федерации', '12');
INSERT INTO Doc_type (id, version, name, code)
    VALUES (3, 0, 'Иные документы', '91');

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
    VALUES (1, 0, 'ПАО Сбербанк', 'Публичное акционерное общество «Сбербанк России»', '7707083893', '773601001', 'Россия, Москва, 117997, ул. Вавилова, д. 19', '8 (800) 555-55-50', false);
INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
    VALUES (2, 0, 'АО «Россельхозбанк»', 'Акционерное общество «Российский Сельскохозяйственный банк»', '7725114488', '997950001', 'Гагаринский переулок, дом 3, Москва, Российская Федерация, 119034', '8 (800) 100-0-100', false);

INSERT INTO Office (id, version, name, organization_id, address, phone, is_active)
    VALUES (1, 0, 'Московский банк ПАО Сбербанк', 1, 'Россия, Москва, 109544, ул. Большая Андроньевская, д. 6', '+7 (495) 500-55-50', false);
INSERT INTO Office (id, version, name, organization_id, address, phone, is_active)
    VALUES (2, 0, 'Свердловский региональный филиал', 2, '620014, Свердловская область, г. Екатеринбург, ул. Февральской революции, д. 15', '(343) 356-18-60', false);

INSERT INTO Position (id, version, name) VALUES (1, 0, 'Оператор колл-центра');
INSERT INTO Position (id, version, name) VALUES (2, 0, 'Генеральный директор');
INSERT INTO Position (id, version, name) VALUES (3, 0, 'Сотрудник охраны');

INSERT INTO User (id, version, first_name, second_name, middle_name, position_id, phone, citizenship_id, is_identified)
    VALUES (1, 0, 'Иван', 'Иванович', 'Иванов', 1, '9250000000', 1, false);
INSERT INTO User (id, version, first_name, second_name, middle_name, position_id, phone, citizenship_id, is_identified)
    VALUES (2, 0, 'Петр', 'Петрович', 'Петров', 2, '9530000000', 2, false);
INSERT INTO User (id, version, first_name, second_name, middle_name, position_id, phone, citizenship_id, is_identified)
    VALUES (3, 0, 'Сидор', 'Сидорович', 'Сидоров', 3, '9630000000', 3, false);

INSERT INTO Document (user_id, version, doc_type_id, number, receive_date, expire_date)
    VALUES (1, 0, 2, '351200000', '2018-04-04', '2018-04-04' );
INSERT INTO Document (user_id, version, doc_type_id, number, receive_date, expire_date)
    VALUES (2, 0, 1, '6599000000', '2018-04-04', '2018-04-04' );
INSERT INTO Document (user_id, version, doc_type_id, number, receive_date, expire_date)
    VALUES (3, 0, 1, '6505000000', '2018-04-04', '2018-04-04' );

INSERT INTO User_Country (user_id, country_id)
    VALUES (1, 3);
INSERT INTO User_Country (user_id, country_id)
    VALUES (2, 1);
INSERT INTO User_Country (user_id, country_id)
    VALUES (2, 2);