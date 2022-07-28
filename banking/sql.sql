CREATE TABLE Customer(
   cid      BIGINT         PRIMARY KEY AUTO_INCREMENT,
   userid   VARCHAR(20)      NOT NULL,
   passwd   VARCHAR(20)      NOT NULL,
   name   VARCHAR(20)      NOT NULL,
   ssn      VARCHAR(14)      NOT NULL,
   phone    VARCHAR(13)      NOT NULL,
   regDate   TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT			NOT NULL,
	accountNum		CHAR(11)		NOT NULL,
	accType			CHAR(1)			NOT NULL DEFAULT 'S',
	balance			DOUBLE			NOT NULL DEFAULT '0',
	interestRate	DOUBLE			NOT NULL DEFAULT '0.0',
	overAmount		DOUBLE			NOT NULL DEFAULT '0.0',
	regDate			TIMESTAMP		NOT NULL   DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_CustomerId_Fk
		FOREIGN KEY(CustomerId) REFERENCES Customer(cid)
   
)AUTO_INCREMENT = 3001;



 SELECT a.aid, a.customerId, a.accountNum, a.accType,a.balance, a.interestRate, a.overAmount, a.regDate
FROM Account a INNER JOIN Customer c ON a.customerId = c.cid
WHERE c.cid =1001
;
SELECT * FROM Account WHERE accountNum = '634-96-1269';
UPDATE Account SET balance = balance + 5000 WHERE accountNum = "333-65-5548"; 