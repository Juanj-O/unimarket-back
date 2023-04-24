insert into unimarket.ciudad values (1, "Armenia");
insert into unimarket.ciudad values (2, "Cali");
insert into unimarket.ciudad values (3, "Ibague");
insert into unimarket.ciudad values (4, "Pereira");
insert into unimarket.ciudad values (5, "Manizales");


INSERT INTO unimarket.usuario VALUES ("1234","123juan","carrera 14","juanlopez@hotmail.com",1,"juan lopez","3218745560","1");
INSERT INTO unimarket.usuario VALUES ("5678","123kelly","calle 20","kellyortiz@gmail.com",1,"kelly ortiz","3145897562","2");
INSERT INTO unimarket.usuario VALUES ("9874","123luis","manzana 1 casa 11","luismendez@hotmail.com",1,"luis mendes","3158965789","3");
INSERT INTO unimarket.usuario VALUES ("1478","123camila","carrera 5 numero 11","camilaosorio@gmail.com",1,"camila osorio","31266589999","4");
INSERT INTO unimarket.usuario VALUES ("5236","123pedro","barrio alamos casa 12 numero 3","pedrorodriguez@hotmail.com",1,"pedro rodriguez","3189657855","5");

INSERT INTO unimarket.producto VALUES (1,"AUDIFONOS SAMSUNG 158-6685",1,now(),date_add(now(),interval 60 DAY),"AUDIFONOS SAMSUNG",75000,10,5236);
INSERT INTO unimarket.producto VALUES (2,"MacBook (Retina, 12 pulgadas, 2017)",1,now(),date_add(now(),interval 60 DAY),"MacBook10,1",6000000,1,5236);
INSERT INTO unimarket.producto VALUES (3,"Elíptica EVOLUTION We, 1  Puestos, Incluye: Calorías Distancia Tiempo",1,now(),date_add(now(),interval 60 DAY),"Elíptica EVOLUTION We",578435,2,5678);
INSERT INTO unimarket.producto VALUES (4,"TV LG 75 Pulgadas 189 cm, MODELO:75NANO75SQA, INCLUYE: CABLE DE PODER, BASE, MAGIC REMOTE, MANUAL DE USUARIO ",1,now(),date_add(now(),interval 60 DAY),"TV LG 75 Pulgadas 189 cm 75NANO75SQA 4K-UHD NanoCell Smart TV",3949900,15,1234);
INSERT INTO unimarket.producto VALUES (5,"Consola NINTENDO SWITCH CHIP TEGRA X1,Full HD, WiFi",1,now(),date_add(now(),interval 60 DAY),"Consola NINTENDO SWITCH con Joy Con Neon/Blue",1599000,20,9874);
INSERT INTO unimarket.producto VALUES (6,"Teclado REF 920-010242",1,now(),date_add(now(),interval 60 DAY),"Teclado MX Keys for Business",30000,10,1478);
INSERT INTO unimarket.producto VALUES (7,"Rosado Lift: 910-006472",0,now(),date_add(now(),interval 60 DAY),"Mouse LIFT",15000,1,1478);

INSERT INTO unimarket.producto_categoria VALUES (1,1);
INSERT INTO unimarket.producto_categoria VALUES (2,2);
INSERT INTO unimarket.producto_categoria VALUES (3,3);
INSERT INTO unimarket.producto_categoria VALUES (4,4);
INSERT INTO unimarket.producto_categoria VALUES (5,5);
INSERT INTO unimarket.producto_categoria VALUES (6,6);
INSERT INTO unimarket.producto_categoria VALUES (7,7);


INSERT INTO unimarket.comentario VALUES (1,"EXCELENTE PRODUCTO",now(),1,5236);
INSERT INTO unimarket.comentario VALUES (2,"EXCELENTE PRODUCTO",now(),2,1234);
INSERT INTO unimarket.comentario VALUES (3,"EXCELENTE PRODUCTO",now(),3,5678);
INSERT INTO unimarket.comentario VALUES (4,"llego rapido",now(),4,9874);
INSERT INTO unimarket.comentario VALUES (5,"EXCELENTE PRODUCTO",now(),5,1478);
INSERT INTO unimarket.comentario VALUES (6,"EXCELENTE PRODUCTO",now(),1,1234);

INSERT INTO unimarket.compra VALUES (1,now(),1,150000,5236);
INSERT INTO unimarket.compra VALUES (2,now(),2,6000000,1234);
INSERT INTO unimarket.compra VALUES (3,now(),3,90000,5678);
INSERT INTO unimarket.compra VALUES (4,now(),2,1599000,9874);
INSERT INTO unimarket.compra VALUES (5,now(),1,3949900,1478);
INSERT INTO unimarket.compra VALUES (6,now(),1,1156870,1478);

INSERT INTO unimarket.detalle_compra VALUES (1,2,75000,1,1);
INSERT INTO unimarket.detalle_compra VALUES (2,1,6000000,2,2);
INSERT INTO unimarket.detalle_compra VALUES (3,1,1599000,4,5);
INSERT INTO unimarket.detalle_compra VALUES (4,1,3949900,5,4);
INSERT INTO unimarket.detalle_compra VALUES (5,3,30000,5,6);
INSERT INTO unimarket.detalle_compra VALUES (6,2,578435,6,3);

INSERT INTO unimarket.favorito VALUES ("5678",1);
INSERT INTO unimarket.favorito VALUES ("1234",2);
INSERT INTO unimarket.favorito VALUES ("5678",3);
INSERT INTO unimarket.favorito VALUES ("1478",5);
INSERT INTO unimarket.favorito VALUES ("5236",6);

INSERT INTO unimarket.moderador VALUES (1,"moderado1","estebanmoderador1@hotmail.com","esteban uran");
INSERT INTO unimarket.moderador VALUES (2,"moderado2","mariamoderador2@gmail.com","maria");
INSERT INTO unimarket.moderador VALUES (3,"moderado3","juanmoderador3@hotmail.com","juan osorio");
INSERT INTO unimarket.moderador VALUES (4,"moderado4","yefersonmoderador4@hotmail.com","yeferson zuluaga");
INSERT INTO unimarket.moderador VALUES (5,"moderado5","julianamoderador5@hotmail.com","juliana arias");

INSERT INTO unimarket.log_publicacion VALUES (1,"se rechaza producto",1,now(),1,1);
INSERT INTO unimarket.log_publicacion VALUES (2,"se aprueba producto",1,now(),2,2);
INSERT INTO unimarket.log_publicacion VALUES (3,"se aprueba producto",1,now(),3,3);
INSERT INTO unimarket.log_publicacion VALUES (4,"se rechaza producto",2,now(),4,7);
INSERT INTO unimarket.log_publicacion VALUES (5,"se aprueba producto",1,now(),5,5);

INSERT INTO unimarket.pqrs VALUES (1,now(),"QUEJA 1",1,"5236");
INSERT INTO unimarket.pqrs VALUES (2,now(),"QUEJA 1",3,"5678");
INSERT INTO unimarket.pqrs VALUES (3,now(),"QUEJA 2",1,"5236");
INSERT INTO unimarket.pqrs VALUES (4,now(),"QUEJA 1",4,"9874");
INSERT INTO unimarket.pqrs VALUES (5,now(),"QUEJA 1",5,"1478");






