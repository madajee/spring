drop table if exists transaction;
drop table  if exists  account;

CREATE TABLE `account` (                                 
           `accountNumber` bigint(20) NOT NULL AUTO_INCREMENT,    
           `name` varchar(50) DEFAULT NULL,                       
           `isactive` tinyint(1) DEFAULT NULL,                    
           `city` varchar(50) DEFAULT NULL,                       
           `country` varchar(50) DEFAULT NULL,                    
           `balance` int(11) DEFAULT NULL,                        
           `emailaddress` varchar(50) DEFAULT NULL,               
           PRIMARY KEY (`accountNumber`)                          
         );

CREATE TABLE `transaction` (                                                                            
                     `transactionId` bigint(20) NOT NULL AUTO_INCREMENT,                                                         
                     `accountNumber` bigint(20) DEFAULT NULL,                                                                    
                     `transactionDate` date DEFAULT NULL,                                                                        
                     `amount` int(11) DEFAULT NULL,                                                                              
                     `txtype` varchar(10) DEFAULT NULL,                                                                            
                     PRIMARY KEY (`transactionId`),                                                                              
                     KEY `accountNumber` (`accountNumber`),                                                                      
                     CONSTRAINT `transactiondetail_ibfk_1` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`)  
                   );

insert into account(name,isactive,city,country,balance,emailaddress)
	values('shiva',true,'Bangalore','India',10000,'sivaprasad.valluru@gmail.com');
insert into account(name,isactive,city,country,balance,emailaddress) 
	values('Prasad',true,'Hyderabad','India',20000,'siva@gmail.com');

