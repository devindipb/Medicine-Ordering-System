create database pharmacydata

  CREATE TABLE Medicine (
    MedicineID VARCHAR(10) PRIMARY KEY,
    MedicineName VARCHAR(255) NOT NULL,
    Manufacturer VARCHAR(255) NOT NULL,
    ExpiryDate DATE NOT NULL,
    Price money NOT NULL,
    Details VARCHAR(255),
	Stock_Quantity int);

	INSERT INTO Medicine (MedicineID, MedicineName, Manufacturer, ExpiryDate, Price, Details,Stock_Quantity) VALUES
('M001', 'Asprin', 'Bayer','2023-12-31', '$10.99', 'Pain reliever and fever',100),
('M002', 'Amoxicillin', 'Pfizer','2024-06-30', '$15.49', 'Antibiotic for bacterial infections',150),
('M003', 'Lipitor', 'Phizer', '2025-09-15', '$8.75', 'Cholestrol-lowering medication',250),
('M004', 'Tylenol', 'Johnson & Johnson', '2025-09-15', '$8.75', 'Acetaminophen-based pain reliever',200),
('M005', 'Zyrtec', 'Johnson & Johnson', '2025-09-15', '$8.75', 'Acetaminophen-based pain reliver',200);

 CREATE TABLE CART(
       Cart_ID VARCHAR(10) PRIMARY KEY NOT NULL,
	   Customer_ID VARCHAR(10),
	   MedicineID VARCHAR(10),
	   Amount float,
	   FOREIGN KEY (Customer_ID) REFERENCES customer(id),
	   FOREIGN KEY (MedicineID) REFERENCES Medicine(MedicineID));

	   Insert into CART(Cart_ID,Customer_ID,MedicineID,Amount)values
	   ('C01','CT00001','M001','$10.99'),
	   ('C02','CT00002','M002','$15.49'),
	   ('C03','CT00001','M001','$10.99'),
	   ('C04','CT00003','M003','$8.75'),
	   ('C05','CT00004','M004','$8.75');

	   create table orders(
	   id int,
	   medicinename varchar(50),
	   customername varchar(50),
	   shippingaddress varchar(50),
	   contact varchar (10));

	   insert into orders(id,medicinename,customername,shippingaddress,contact)values
	   (1,'Asprin','Perera','Temple road,Dehiwala','011648578'),
	   (2,'Asprin','Gayathri','Temple road,Dehiwala','077859368'),
	   (3,'Zyrtec','Gayathri','MohanTemple road,Dehiwala','08737647'),
	   (4,'Lipitor','Perera','Temple road,Dehiwala','076458338'),
	   (5,'Zyrtec','Mali','Temple road,Dehiwala','093735727');


	   create table pharmacystaff(
   id int primarykey not null,
   firstname varchar (50),
   lastname varchar(50),
   nic varchar(50),
   email varchar(50),
   password varchar (50),
   repassword varchar(50),
   phone varchar (10),
   dob date ,
   country varchar(50));

   insert into (id,firstname,lastname,nic,email,password,repassword,phone,dob,country)values
   (1,'Gayan','Perera','12345v','asd@gamil.com','123ad','123ad','1235743','1990-10-23','Sri lanka'),
   (2,'Gayani','Wijeratne','12345v','aod@gamil.com','563ad','563ad','1095743','1990-10-29','Sri lanka'),  
   (3,'sanka','Perera','128905v','abd@gamil.com','453ad','453ad','12357893','1997-10-23','Sri lanka'),
   (4,'charu','Gunasena','126445v','akd@gamil.com','1243ad','1243ad','16785743','1991-10-23','Sri lanka'),
   (5,'Gayanika','Perera','1234675v','ald@gamil.com','1023ad','1023ad','1235043','1996-10-23','Sri lanka'),
   
   create table feedback(
     id int primary key not null,
     name varchar(50),
     email varchar (50),
     phonenumber varchar (10),
     message varchar (100));

	 insert into (id,name,email,phonenumber,message)vaalues
	 (1,'Gayani','acd@gmail.com','09156758','Good Service'),
	 (2,'Amal','xyz@gmail.com','0771536','Excellet'),
	 (3,'Kamal','qwe@gmail.com','098573637','Quick Service'),
	 (4,'Jayalath','jyu@gmail.com','0912345','Great job'),
	 (5,'Mala','qqq@gmail.com','0771478','Good service');

	    create table deliverystaff(
   id int primarykey not null,
   firstname varchar (50),
   lastname varchar(50),
   nic varchar(50),
   email varchar(50),
   password varchar (50),
   repassword varchar(50),
   phone varchar (10),
   dob date ,
   country varchar(50));

   insert into (id,firstname,lastname,nic,email,password,repassword,phone,dob,country)values
   (1,'Gayasanka','Perera','12345v','asd@gamil.com','123ad','123ad','1235743','1990-10-23','Sri lanka'),
   (2,'Nimal','Wijeratne','12345v','aod@gamil.com','563ad','563ad','1095743','1990-10-29','Sri lanka'),  
   (3,'nayanajith','Perera','128905v','abd@gamil.com','453ad','453ad','12357893','1997-10-23','Sri lanka'),
   (4,'Kumara','Gunasena','126445v','akd@gamil.com','1243ad','1243ad','16785743','1991-10-23','Sri lanka'),
   (5,'Gayantha','Perera','1234675v','ald@gamil.com','1023ad','1023ad','1235043','1996-10-23','Sri lanka');

       create table customer(
   id int primary key not null,
   firstname varchar (50),
   lastname varchar(50),
   nic varchar(50),
   email varchar(50),
   password varchar (50),
   repassword varchar(50),
   phone varchar (10),
   dob date ,
   country varchar(50));

   (1,'Gayan','Perera','12345v','asd@gamil.com','123ad','123ad','1235743','1990-10-23','Sri lanka'),
   (2,'VIKUM','Wijeratne','12345v','aod@gamil.com','563ad','563ad','1095743','1990-10-29','Sri lanka'),  
   (3,'SEETHA','Perera','128905v','abd@gamil.com','453ad','453ad','12357893','1997-10-23','Sri lanka'),
   (4,'charu','Gunasena','126445v','akd@gamil.com','1243ad','1243ad','16785743','1991-10-23','Sri lanka'),
   (5,'AZAM','Perera','1234675v','ald@gamil.com','1023ad','1023ad','1235043','1996-10-23','Sri lanka');

   create table card(
   id int primary key ,
   cardnumber varchar(50),
   expirationdate date,
   cvv varchar(10),
   cardtype varchar(50));

   (1,'12345674322','2028-7-9','232','visa'),
   (2,'12345674322','2028-7-9','212','debit'),
   (3,'12345674322','2028-9-9','239','visa'),
   (4,'12345674322','2028-10-9','267','debit'),
   (5,'12345674322','2028-11-9','456','master');
