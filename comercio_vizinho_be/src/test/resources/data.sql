INSERT INTO tb_users (ID, NAME, EMAIL, PHONE_NUMBER, IMGURL)
VALUES (99, 'New User01', 'newuser01@email.com', 99999901, '');
INSERT INTO tb_users (ID, NAME, EMAIL, PHONE_NUMBER, IMGURL)
VALUES (100, 'New User02', 'newuser02@email.com', 99999902, '');
INSERT INTO tb_users (ID, NAME, EMAIL, PHONE_NUMBER, IMGURL)
VALUES (101, 'New User03', 'newuser03@email.com', 99999903, '');

-- ADDRESS
INSERT INTO tb_adresses (ID, STREET, NUMBER, DETAIL, POSTAL_CODE)
VALUES (99, 'Rua dos bobos', 'zero', 'casa engraçada', '0000-000');
INSERT INTO tb_adresses (ID, STREET, NUMBER, DETAIL, POSTAL_CODE)
VALUES (100, 'Rua das amoras', '123', 'Casa de tijolo', '2222-123');
INSERT INTO tb_adresses (ID, STREET, NUMBER, DETAIL, POSTAL_CODE)
VALUES (101, 'Rua dos porquinhos', '1', 'casa de palha, ao lado da cada de madeira', 'PIG-035-000');

-- GOODS PRODUCTS
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (99, 'Pêssego dos grandes', 'Nacional mesmo', 1.85, 99, 1);
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (100, 'Uva roxa', 'Uva para fazer vinho tinto', 2.85, 99, 1);
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (101, 'Pera rocha', 'Rocha acha', 1.33, 99, 1);

-- GOODS SERVICES
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (103, 'Cortes a laser', 'corto qualquer coisa', 1.85, 99, 2);
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (104, 'Lava carro', 'Lavo seu carro', 2.85, 99, 2);
INSERT INTO tb_goods (ID, NAME, DESCRIPTION, PRICE, USER_ID, GOODS_TYPE) VALUES (105, 'Massagem', 'Faço massagens', 1.33, 99, 2);