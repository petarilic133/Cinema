insert into user_entity(id, username, password, first_name, last_name, phone, email, date_of_birth, user_type, deleted) values
('50f6a1c2-d9b8-4125-8498-5751260163d1', 'admin1', '$2y$12$ObGG.OQ9g3DadAPBw9kUpOOJK.ECOM47VfIY3DOjKpmHdS/E9dJry', 'Darko', 'Milicic', '064/143-423', 'admin1@gmail.com', '1987-04-04', 'ADMIN', 'false'),
('ab959313-7e30-4cde-83e0-dd63c22dbfe5', 'admin2', '$2y$12$rp58vd3F9Hwsh.4EMtxLp.VbKAy6UN4RMMzTAq42evJKVNiuV3FJu', 'Bogdan', 'Bogdanovic', '064/167-493', 'admin2@gmail.com', '1985-05-05', 'ADMIN', 'false'),
('491124ec-13ed-411c-82c4-922444d8a278', 'manager1', '$2y$12$mWTJFnF6cnWF3NQ5Pl1kJuT7P82o4WCu9HLvWPde4diVv041DQ4zS', 'Zoran', 'Tosin', '062/160-493', 'manager1@gmail.com', '1995-06-05', 'MANAGER', 'false'),
('cb370fc1-b2ce-4062-95c0-d8c894996f09', 'manager2', '$2y$12$0mmcKYxkH6zlSoklu7dWvORinXzQ6ZkHTkh5vNmoOyNhQaE20ff4u', 'Dejan', 'Stankovic', '062/167-493', 'manager2@gmail.com', '1991-05-11', 'MANAGER', 'false'),
('cf2c415b-2e78-4b3b-90b3-2ef651c40efe', 'customer1', '$2y$12$s06nm9XuTZR95NEHwZSmCumNzDVzGY5VwB6HjpxrGlssnNFVJkuNi', 'Petar', 'Ilic', '061/107-493', 'customer1@gmail.com', '1998-03-11', 'CUSTOMER', 'false'),
('bf7e722d-e326-4c1f-88fd-77cf762af6b1', 'customer2', '$2y$12$pShSZ.9CJId9Yap1h8j/LOUOQDmzbwWlhYCI5GsyP.ckql3Kb0xJe', 'Djura', 'Djuric', '062/167-675', 'customer2@gmail.com', '1997-11-12', 'CUSTOMER', 'false');

insert into admin(id, user_id) values
('b9130118-6608-4655-98b5-26ce0c183091', '50f6a1c2-d9b8-4125-8498-5751260163d1'),
('c03c7963-4751-40f8-a32f-47587c5c1f4f', 'ab959313-7e30-4cde-83e0-dd63c22dbfe5');

insert into manager(id, user_id) values
('dd33b2f1-f90a-4f95-bf19-97e4b212c329', '491124ec-13ed-411c-82c4-922444d8a278'),
('4611ecdc-fd3f-41c9-ab1f-a132306f4e6c', 'cb370fc1-b2ce-4062-95c0-d8c894996f09');

insert into customer(id, user_id) values
('408b7730-eb6e-4657-841a-039a3496b20c', 'cf2c415b-2e78-4b3b-90b3-2ef651c40efe'),
('14b6fb87-b277-4df9-a145-d7d28e2eb556', 'bf7e722d-e326-4c1f-88fd-77cf762af6b1');