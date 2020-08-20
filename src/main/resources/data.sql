insert into user_entity(id, username, password, first_name, last_name, phone, email, date_of_birth, user_type, deleted) values
('50f6a1c2-d9b8-4125-8498-5751260163d1', 'admin1', '$2y$12$ObGG.OQ9g3DadAPBw9kUpOOJK.ECOM47VfIY3DOjKpmHdS/E9dJry', 'Darko', 'Milicic', '064/143-423', 'admin1@gmail.com', '1987-04-04', 'ADMIN', 'false'),
('ab959313-7e30-4cde-83e0-dd63c22dbfe5', 'admin2', '$2y$12$rp58vd3F9Hwsh.4EMtxLp.VbKAy6UN4RMMzTAq42evJKVNiuV3FJu', 'Bogdan', 'Bogdanovic', '064/167-493', 'admin2@gmail.com', '1985-05-05', 'ADMIN', 'false'),
('491124ec-13ed-411c-82c4-922444d8a278', 'manager1', '$2y$12$mWTJFnF6cnWF3NQ5Pl1kJuT7P82o4WCu9HLvWPde4diVv041DQ4zS', 'Zoran', 'Tosic', '062/160-493', 'manager1@gmail.com', '1995-06-05', 'MANAGER', 'false'),
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

insert into cinema(id, name, address, email, phone, deleted) values
('65b98dc3-710b-4aa7-a99f-669318f03028', 'Cinestar', 'Bulevar Oslobodjenja 23', 'cinestar@gmail.com', '062/535-634', 'false'),
('60eb2a6a-bfe8-47e4-b39a-f1190262dc23', 'Cineplexx', 'Heroja Pinkija 16', 'cineplexx@gmail.com', '065/734-634', 'false');

insert into cinema_manager(cinema_id, manager_id) values
('65b98dc3-710b-4aa7-a99f-669318f03028', 'dd33b2f1-f90a-4f95-bf19-97e4b212c329'),
('65b98dc3-710b-4aa7-a99f-669318f03028', '4611ecdc-fd3f-41c9-ab1f-a132306f4e6c'),
('60eb2a6a-bfe8-47e4-b39a-f1190262dc23', 'dd33b2f1-f90a-4f95-bf19-97e4b212c329');

insert into movie(id, name, description, duration, genre_type, deleted) values
('982787eb-63a0-482a-8936-f614923889ab', 'Inception', 'Very exciting.', 140, 'ACTION', 'false'),
('63d69f0a-6b98-466c-8de8-710478101c00', 'Aquaman', 'A lot of action.', 110, 'ACTION', 'false'),
('df3ef2b3-e16b-4ee6-a749-f246bf92b12d', 'Matrix', 'Confuing and thrilling.', 100, 'SF', 'false'),
('c11da362-bc64-46da-81ce-ee9fa9e920e3', 'Notebook', 'Sad and romantic.', 90, 'ROMANCE', 'false'),
('7ec77dd5-f19c-4233-9c40-f5a0981b392a', 'The Dark Knight', 'The best action movie ever.', 130, 'ACTION', 'false'),
('b0127403-4662-42d3-a0ef-b819c84191d7', 'The switch', 'Very funny and romantic.', 80, 'COMEDY', 'false'),
('3a77d2dc-26b6-4db2-85b9-78b88375556a', 'The Lion King', 'For kids.', 70, 'CARTOON', 'false');

insert into hall(id, mark, capacity, deleted, cinema_id) values
('5c4dabbb-8b52-485f-b625-4c51ac690088', 'Hall A', 150, 'false', '65b98dc3-710b-4aa7-a99f-669318f03028'),
('6b19ba5f-dab0-41af-9798-188c5f8a5d19', 'Hall B', 100, 'false', '65b98dc3-710b-4aa7-a99f-669318f03028'),
('91ebc8e8-be63-445f-9845-807250635ee7', 'Hall C', 50, 'false', '65b98dc3-710b-4aa7-a99f-669318f03028'),
('d005b504-850e-4ce7-915d-861214b447ff', 'Hall A', 120, 'false', '60eb2a6a-bfe8-47e4-b39a-f1190262dc23'),
('19cf0a6e-69d1-4993-8f87-bf6eb0dcc274', 'Hall B', 100, 'true', '60eb2a6a-bfe8-47e4-b39a-f1190262dc23'),
('fce9f8d5-2c55-4aee-8ec5-8803cd7d61a0', 'Hall C', 80, 'false', '60eb2a6a-bfe8-47e4-b39a-f1190262dc23'),
('47f66b21-0586-4013-a670-23c4385a7488', 'Hall D', 40, 'false', '60eb2a6a-bfe8-47e4-b39a-f1190262dc23');

insert into projection(id, date, time, price, deleted, hall_id, movie_id) values
('62d23f82-c44c-4e04-85ff-4a8c0abdebe1', '2020-09-05', '15:00:00', 250, 'false', '5c4dabbb-8b52-485f-b625-4c51ac690088', '982787eb-63a0-482a-8936-f614923889ab'),
('f47321f8-39d7-41ce-8d7d-12cf1ea641c3', '2020-07-06', '20:00:00', 350, 'false', '5c4dabbb-8b52-485f-b625-4c51ac690088', '982787eb-63a0-482a-8936-f614923889ab'),
('028d18ee-fdc9-45a0-9efc-a49fe2ffa287', '2020-09-06', '12:00:00', 150, 'false', '6b19ba5f-dab0-41af-9798-188c5f8a5d19', '982787eb-63a0-482a-8936-f614923889ab'),
('e3b1d43a-863f-41aa-b413-342ec3c6a833', '2020-09-06', '15:00:00', 200, 'true', '6b19ba5f-dab0-41af-9798-188c5f8a5d19', '63d69f0a-6b98-466c-8de8-710478101c00'),
('2e8a7788-d1d9-420c-ad95-51d16750fdc8', '2020-09-07', '14:00:00', 200, 'false', '91ebc8e8-be63-445f-9845-807250635ee7', 'df3ef2b3-e16b-4ee6-a749-f246bf92b12d'),
('4691b573-82b5-44ea-8b66-2e432b24178f', '2020-09-07', '18:00:00', 250, 'false', '6b19ba5f-dab0-41af-9798-188c5f8a5d19', 'c11da362-bc64-46da-81ce-ee9fa9e920e3'),
('c564e6a2-c1d9-4187-9eb7-d42168fcd3dd', '2020-09-07', '15:00:00', 150, 'false', 'd005b504-850e-4ce7-915d-861214b447ff', '7ec77dd5-f19c-4233-9c40-f5a0981b392a'),
('8192ece6-d6e0-4507-9e9d-ad30547a1b78', '2020-09-08', '20:00:00', 300, 'false', 'd005b504-850e-4ce7-915d-861214b447ff', 'df3ef2b3-e16b-4ee6-a749-f246bf92b12d'),
('944ba7b2-8e59-4466-ba4e-8f75a8a754a8', '2020-09-08', '19:00:00', 250, 'false', '19cf0a6e-69d1-4993-8f87-bf6eb0dcc274', 'b0127403-4662-42d3-a0ef-b819c84191d7'),
('70226436-c0f1-4cb3-a1f3-041c8937440a', '2020-09-08', '22:00:00', 350, 'false', '19cf0a6e-69d1-4993-8f87-bf6eb0dcc274', 'b0127403-4662-42d3-a0ef-b819c84191d7'),
('2debc01d-b76b-4473-aa0a-1c5660120564', '2020-09-09', '20:00:00', 400, 'false', 'fce9f8d5-2c55-4aee-8ec5-8803cd7d61a0', '3a77d2dc-26b6-4db2-85b9-78b88375556a'),
('7700a336-3e95-4363-ad05-4a464264f3e8', '2020-09-09', '21:00:00', 300, 'false', '47f66b21-0586-4013-a670-23c4385a7488', '63d69f0a-6b98-466c-8de8-710478101c00');

insert into customer_projection(customer_id, projection_id) values
('408b7730-eb6e-4657-841a-039a3496b20c', 'f47321f8-39d7-41ce-8d7d-12cf1ea641c3'),
('408b7730-eb6e-4657-841a-039a3496b20c', '70226436-c0f1-4cb3-a1f3-041c8937440a'),
('408b7730-eb6e-4657-841a-039a3496b20c', '7700a336-3e95-4363-ad05-4a464264f3e8'),
('14b6fb87-b277-4df9-a145-d7d28e2eb556', '944ba7b2-8e59-4466-ba4e-8f75a8a754a8'),
('14b6fb87-b277-4df9-a145-d7d28e2eb556', '2debc01d-b76b-4473-aa0a-1c5660120564'),
('14b6fb87-b277-4df9-a145-d7d28e2eb556', '62d23f82-c44c-4e04-85ff-4a8c0abdebe1');

