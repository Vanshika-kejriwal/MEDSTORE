drop database if exists MedicalStore;
create database MedicalStore;
use MedicalStore;

CREATE TABLE `MedicalStore`.`customer` (
  `idcustomer` INT NOT NULL auto_increment,
  `customer_name` VARCHAR(45) NULL,
  `customer_sex` VARCHAR(6) NOT NULL,
  `customer_phn_no` VARCHAR(12) NOT NULL,
  `customer_aadhar_no` VARCHAR(12) NULL,
  `customer_state` VARCHAR(20) NOT NULL,
  `customer_street` VARCHAR(45) NOT NULL,
  `customer_city` VARCHAR(45) NOT NULL,
  `customer_pincode` INT(6) NOT NULL,
  `customer_house_no` VARCHAR(45) NOT NULL,
  `customer_dob` date not null,
  PRIMARY KEY (`idcustomer`),
  UNIQUE INDEX `c_aadhar_no_UNIQUE` (`customer_aadhar_no` ASC) VISIBLE); 


insert into customer values(1,'Amit','Male','1234567890','012345678912','Rajasthan','civil marg','Ajmer','302001','12','2002-02-25');
insert into customer values(2,'Narendra','Male','0987654321','231345678912','Uttar Pradesh','civil line','Agra','123456','14','2002-02-25');
insert into customer values(3,'Himanshu','Male','9034567890','012345670912','Delhi','guru nagar','Delhi','302121','35','2002-02-25');
insert into customer values(4,'Sumit','Male','9834567890','352345678912','Rajasthan','Ghan bagh','Nagaur','309001','13','2002-02-25');
insert into customer values(5,'Ashrita','Female','9999567890','999945678912','Gujarat','Aham','Ahamdabad','452001','02','2002-02-25');
insert into customer values(6,'Vanshika','Female','9965567890','999875678912','Gujarat','Anand','Ahamdabad','452001','02','2002-02-25');
insert into customer values(7,'Amrita','Female','9993467890','999941278912','Gujarat','Anand','Gandhinagar','452301','02','2002-02-25');

-- select * from customer;

-- creating user table

CREATE TABLE `MedicalStore`.`users`(
	`user_id` INT NOT NULL,
    `username` VARCHAR(40) PRIMARY KEY NOT NULL ,
    `password` VARCHAR(64) NOT NULL ,
    `role` VARCHAR(45) NOT NULL ,
    `enabled` TINYINT,
    `email` VARCHAR(45) unique not null,
     UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    CONSTRAINT `user_id`
 		FOREIGN KEY (`user_id`)
		REFERENCES `MedicalStore`.`customer` (`idcustomer`)
 		ON DELETE CASCADE
 		ON UPDATE CASCADE-- 
);

insert into users values (1,'amit','1234','ROLE_USER',1,'amitc9405@gmail.com');
insert into users values (2,'narendra','1234','ROLE_USER',1,'nkumar@gmail.com');

select * from medicalstore.users;

CREATE TABLE `MedicalStore`.`customer_email` (
  `idcustomer` INT NOT NULL,
  `customer_emailcol` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `customer_emailcol_UNIQUE` (`customer_emailcol` ASC) VISIBLE,
  UNIQUE INDEX `idcustomer_UNIQUE` (`idcustomer` ASC) VISIBLE,
  CONSTRAINT `idcustomer`
    FOREIGN KEY (`idcustomer`)
    REFERENCES `MedicalStore`.`customer` (`idcustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


insert into customer_email values(1,'amitc9405@gmail.com');
insert into customer_email values(2,'nkumarman98@gmail.com');
insert into customer_email values(3,'knight123@gmail.com');
insert into customer_email values(4,'sumit43@gmail.com');
insert into customer_email values(5,'amirta1969@gmail.com');
insert into customer_email values(6,'vanshika.bhu@gmail.com');

-- select * from customer_email;


    
    CREATE TABLE `MedicalStore`.`manager` (
  `idmanager` INT NOT NULL,
  `manager_first_name` VARCHAR(45) NOT NULL,
  `manager_last_name` VARCHAR(45) NULL,
  `manager_sex` VARCHAR(6) NOT NULL,
  `manager_DOB` DATE NOT NULL,
  `manager_aadhar_no` VARCHAR(12) NULL,
  `manager_phn_no` VARCHAR(12) NOT NULL,
  `manager_state` VARCHAR(20) NOT NULL,
  `manager_city` VARCHAR(45) NOT NULL,
  `manager_pincode` INT(6) NOT NULL,
  `manager_street` VARCHAR(45) NOT NULL,
  `manager_house_no` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  PRIMARY KEY (`idmanager`),
  UNIQUE INDEX `m_m_aadhar_n0_UNIQUE` (`manager_aadhar_no` ASC) VISIBLE);


insert into manager values(1,'Gurpreet','Bandhe','Male','1980-12-30','123456789032','1876543210','Uttar Pradesh','varanasi',221105,'bhikharipur','12',50000);
insert into manager values(2,'Raghunandan','Rawat','Male','1990-12-30','123457789032','2876543210','Uttar Pradesh','Unnao',201105,'Panna gali','32',45000);
insert into manager values(3,'Pankaj','Yadav','Male','1985-12-30','323456789032','1976543210','Haryana','Rewari',123105,'Assi gali','12',100000);
insert into manager values(4,'Harsh','Kumar','Male','1983-12-30','423456789032','3876543210','Bihar','Patna',341105,'Chhoti gali','52',60000);
insert into manager values(5,'Aryan','Sharma','Male','1981-12-30','123456989032','1876433210','Kashmir','Kathua',521105,'Tedhi Gali','62',32000);
insert into manager values(6,'Soumya','Bansal','Female','1992-12-30','123456786532','1876549810','Rajasthan','Kota',621105,'Samne wali gali','72',50000);
  

-- select * from manager;




  
CREATE TABLE `MedicalStore`.`shop` (
  `idshop` INT NOT NULL,
  `shop_name` VARCHAR(45) NOT NULL,
  `shop_state` VARCHAR(45) NOT NULL,
  `shop_city` VARCHAR(20) NOT NULL,
  `shop_pincode` INT(6) NOT NULL,
  `shop_street` VARCHAR(45) NOT NULL,
  `shop_no` INT NOT NULL,
  `emp_id` INT NULL,
  PRIMARY KEY (`idshop`),
  UNIQUE INDEX `emp_id_UNIQUE` (`emp_id` ASC) VISIBLE,
  CONSTRAINT `emp_id`
    FOREIGN KEY (`emp_id`)
    REFERENCES `MedicalStore`.`manager` (`idmanager`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);


insert into shop values(1,'Varsha Medical store','Rajasthan','Ajmer',302001,'Sardar Nagar',1001,1);
insert into shop values(2,'Sandhy Medical store','Rajasthan','Badmer',332001,'Bandhe Nagar',1002,2);
insert into shop values(3,'Amrita Medicos','Uttar pradesh','Prayagraj',232001,'Bhavpuri',1003,3);
insert into shop values(4,'Smriti Medical & clinic','Uttar Pradesh','Firozabad',252003,'Virat Street',1004,4);
insert into shop values(5,'Mitali Pharma','Gujrat','Surat',500200,'Patel puri',1005,5);
insert into shop values(6,'Anjali clinic','Uttar Pradesh','Varansi',221002,'Mahamanapuri',1006,6);


-- select * from shop;

    
    CREATE TABLE `MedicalStore`.`shop_expenditure` (
  `idexpenditure` INT NOT NULL,
  `idshop` INT NOT NULL,
  `idmanager` INT NOT NULL,
  `expenditure_date` DATE NOT NULL,
  `exp_amount` INT NOT NULL,
  `expenditure_discription` VARCHAR(150) NOT NULL,
  INDEX `idshop_idx` (`idmanager` ASC, `idshop` ASC) VISIBLE,
  PRIMARY KEY (`idexpenditure`),
  CONSTRAINT `idshop`
    FOREIGN KEY (`idmanager` , `idshop`)
    REFERENCES `MedicalStore`.`shop` (`emp_id` , `idshop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


insert into shop_expenditure values(1,1,1,'2020-12-13',4000,'furniture repair');
insert into shop_expenditure values(2,2,2,'2019-11-30',6000,'banner prinitng');
insert into shop_expenditure values(3,3,3,'2021-10-20',7000,'repairing of walls ');
insert into shop_expenditure values(4,4,4,'2020-08-30',8000,'furniture purchase for expansion');
insert into shop_expenditure values(5,5,5,'2019-05-24',150000,'new room construction');
insert into shop_expenditure values(6,6,6,'2021-03-23',60000,'License renew');


-- select * from shop_expenditure;




    CREATE TABLE `MedicalStore`.`feedback` (
  `idfeedback` INT NOT NULL,
  `comment` VARCHAR(200) NULL,
  `rating` INT(1) NOT NULL,
  `shopid` INT NOT NULL,
  PRIMARY KEY (`idfeedback`),
  INDEX `idshop_idx` (`shopid` ASC) VISIBLE,
  CONSTRAINT `shopid`
    FOREIGN KEY (`shopid`)
    REFERENCES `MedicalStore`.`shop` (`idshop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


insert into feedback values(1,'overall experince avergae is okay. packaging of product was not. delivery was fater than expected.',3,1);
insert into feedback values(2,'Superb service offerd by the seller. Got product delivered faster and also privacy is maintained, even delivery executive do not about the product in the packet. ',5,2);
insert into feedback values(3,'good',4,3);
insert into feedback values(4,'recommended to buy procuct from seller',5,4);
insert into feedback values(5,'Not recommended',1,5);
insert into feedback values(6,'Mixed experience',3,6);



-- select * from feedback;





CREATE TABLE `MedicalStore`.`medicines` (
  `identification_id` INT NOT NULL,
  `medicine_name` VARCHAR(100) NOT NULL,
  `medicine_description` VARCHAR(1500) NOT NULL,
  `manufacturing_date` DATE NOT NULL,
  `expiry_date` DATE NOT NULL,
  `price` INT NOT NULL,
  `available_quantity` INT NOT NULL,
  `shop_id` INT NOT NULL,
  PRIMARY KEY (`identification_id`,`shop_id`),
  INDEX `shop_id_idx` (`shop_id` ASC) VISIBLE,
  CONSTRAINT `shop_id`
    FOREIGN KEY (`shop_id`)
    REFERENCES `MedicalStore`.`shop` (`idshop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,1);
insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,2);
insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,3);
insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,4);
insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,5);
insert into medicines values(1,'Natures Velvet Hydrolyzed Collagen Powder Unflavoured','Product highlights. Beneficial in maintaining healthy hair, skin and nails. Useful in reducing pain and swelling in muscles, joints and bonesReduces fine lines, pigments and dryness.Natures Velvet Hydrolyzed Collagen Powder Unflavoured.It is specially formulated with highly bioavailable marine collagen peptides that improve skin and hairs overall texture and strengthen joints and bones. This is one of the best ways to support your joint health and beautify your look from within.','2022-05-25','2025-05-25',1296,100,6);

insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,1);
insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,2);
insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,3);
insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,4);
insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,5);
insert into medicines values(2,'Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet','Information about Immunity Care Combo of 1mg Panch Tulsi 30ml Drops and Patanjali Ayurveda Giloy Ghanvati 60 Tablet. Patanjali Ayurveda Giloy Ghan Vati (Patanjali Ayurved Limited). Patanjali Ayurveda Divya Giloy Ghan Vati contains Giloy (Tinospora cordifolia) as active ingredient.. Key benefits/uses of Patanjali Ayurveda Divya Giloy Ghanvati:. - Used for the treatment of general weakness, recurrent infections, immuno-deficiency disorders, appetite loss, chronic constipation with mucus in the stool, common cold, high cholesterol, hepatitis, jaundice and other liver disorders and various autoimmune disorders. - Also beneficial in dengue, chicken guinea, skin and urinary disorders. Directions for use/Dosage:. - Above 12 years: 1 tablet twice daily. - Below 12 years: Half tablet twice daily or as directed by the physician. Indications:. General weakness, common cold, weak immunity, jaundice, liver disorders, dengue etc.. Safety information:. - Read the label carefully before use. - Do not exceed the recommended dose. - Keep out of the reach and sight of children','2022-05-25','2025-05-25',300,100,6);

-- you need to run the above two queries by changing primary key; for example you can run like 1-1,1-2,1-3,1-4,1-5,1-6; and the you can run 2-1,2-2,2-3,2-4,2-5,2-6; i have changed primary to
-- primary key (`identification_id`,`shop_id`)



-- select * from medicines;




CREATE TABLE `MedicalStore`.`cart` (
  `idcart` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `identification_id` INT NOT NULL,
  `no_of_medicine` INT NOT NULL,
  PRIMARY KEY (`idcart`,`customer_id`,`identification_id`), 
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `identification_id_idx` (`identification_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `MedicalStore`.`customer` (`idcustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `identification_id`
    FOREIGN KEY (`identification_id`)
    REFERENCES `MedicalStore`.`medicines` (`identification_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

insert into cart values(1,1,1,5);
insert into cart values(1,1,2,10);
insert into cart values(2,2,2,20);
insert into cart values(2,2,1,20);
-- insert into cart values(2,2,2,2);
-- insert into cart values(2,2,1,2);
-- insert into cart values(2,2,2,2);


-- select * from cart;





    
  -- removed the cart id as it is not primary key(because we made custid and medicine id as primary key of cart to add multiple items in cart)    
    --  added custid as foreign key which REFERENCES to customer table not the cart table as reason as above cust id alone is not primary key
    CREATE TABLE `MedicalStore`.`order` (
  `idorder` INT NOT NULL,
  `order_date` DATE NOT NULL,
  `payment_status` VARCHAR(45) NOT NULL,
  `delivery_status` VARCHAR(45) NOT NULL,
  `customer` INT NOT NULL,
  PRIMARY KEY (`idorder`),
  INDEX `customer_id_idx` (`customer` ASC) VISIBLE,
  CONSTRAINT `customer`
    FOREIGN KEY (`customer`)
    REFERENCES `MedicalStore`.`customer` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);




insert into MedicalStore.order values(1,'2022-11-01','Confirmed','Yet to be delivered',1);
insert into MedicalStore.order values(2,'2022-11-01','Confirmed','Yet to be delivered',2);
insert into MedicalStore.order values(3,'2022-11-01','Confirmed','Yet to be delivered',2);
insert into MedicalStore.order values(4,'2022-11-01','Confirmed','Yet to be delivered',3);
insert into MedicalStore.order values(5,'2022-11-01','Confirmed','Yet to be delivered',3);
insert into MedicalStore.order values(6,'2022-11-01','Confirmed','Yet to be delivered',2);




-- select * from order;

;


    
    
    CREATE TABLE `MedicalStore`.`bill` (
  `bill_no` INT NOT NULL,
  `cost` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`bill_no`),
  INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `MedicalStore`.`order` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


insert into bill values(1,500,1);
insert into bill values(2,600,1);
insert into bill values(3,650,1);
insert into bill values(4,700,1);
insert into bill values(5,800,1);
insert into bill values(7,300,1);
insert into bill values(8,400,1);
insert into bill values(9,1000,1);



-- select * from bill;


    
    
    
    CREATE TABLE `MedicalStore`.`transaction_history` (
  `transaction_id` INT NOT NULL,
  `mode_of_transaction` VARCHAR(45) NOT NULL,
  `amount` INT NOT NULL,
  `transaction_date` DATE NOT NULL,
  `customer__id` INT NOT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `customer_id_idx` (`customer__id` ASC) VISIBLE,
  CONSTRAINT `customer__id`
    FOREIGN KEY (`customer__id`)
    REFERENCES `MedicalStore`.`customer` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);


insert into MedicalStore.transaction_history values(1,'UPI',500,'2022-11-01',1);
insert into MedicalStore.transaction_history values(2,'UPI',600,'2022-11-01',2);
insert into MedicalStore.transaction_history values(3,'UPI',700,'2022-11-01',3);
insert into MedicalStore.transaction_history values(4,'UPI',800,'2022-11-01',6);
insert into MedicalStore.transaction_history values(5,'UPI',900,'2022-11-01',4);
insert into MedicalStore.transaction_history values(6,'UPI',1000,'2022-11-01',5);




-- select * from transaction_history;

