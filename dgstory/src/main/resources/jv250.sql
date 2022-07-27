CREATE TABLE Sample10(
	no		INT(11)		DEFAULT NULL,
	name	VARCHAR(20)	DEFAULT NULL,
	birhday	DATE		DEFAULT NULL,
	address	VARCHAR(40)	DEFAULT NULL
);


SELECT *  FROM sample10;

INSERT INTO Sample10 VALUES(1, '유비', '1988-03-21', '대구시 달성군 다사읍');
INSERT INTO Sample10 VALUES(2, '관우', '1999-03-21', '대구시 달성구 감삼동');
INSERT INTO Sample10 VALUES(3, '장비', '2000-03-21', '대구시 중구 반월당');

DELETE FROM Sample10;
	String name;
	String ssn;
	String phone;
	String customerId;
	String passwd;
	List<Account> al;
CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	customerid	VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

INSERT INTO Customer(name, ssn, phone, customerid, passwd)
VALUES('유비', '901213-1167521','010-1235-1215','java','1111');

INSERT INTO Customer(name, ssn, phone, customerid, passwd)
VALUES('관우', '911213-1167521','010-2235-1215','java1','2222');
INSERT INTO Customer(name, ssn, phone, customerid, passwd)
VALUES('장비', '921213-1167521','010-3335-1215','java2','2222');

UPDATE Customer SET ssn ='951213-1167521'
WHERE cid = 1003;


DELETE FROM Customer WHERE cid=1003;