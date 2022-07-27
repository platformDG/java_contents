DROP TABLE Account;
DROP TABLE Customer;
CREATE TABLE Customer (
   cid         BIGINT         PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY는 자동으로 NOT NULL임, AUTO_INCREMENT는 INSERT 될 때마다 자동으로 증가해주는 키워드
   name      VARCHAR(20)      NOT NULL,
   ssn         VARCHAR(14)      NOT NULL,
   phone      VARCHAR(14)      NOT NULL,
   userID   VARCHAR(16)      NOT NULL,
   passwd      VARCHAR(60)      NOT NULL, -- 보안을 위해 내부에서 인코딩해서 알수없는 코드 60자리 형태로 변경하도록 만들기 때문에 60으로 지정
   regDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP -- 데이터가 들어온 날짜를 입력하기 위해 만듬(값이 안들어갔을 대 현재의 TIMESTAMP값을 넣겠다는 의미)
) AUTO_INCREMENT = 1001; -- 1001번부터 시작한다는 의미(초기 셋팅값)

CREATE TABLE Account (
	aid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	accountnum 		VARCHAR(11) 	NOT NULL,
	balance			DOUBLE			NOT NULL DEFAULT 0.0,
	interestrate	DOUBLE			NOT NULL DEFAULT 0.0,
	overdraftAmount DOUBLE			NOT NULL DEFAULT 0.0,
	accounttype		CHAR(1)			NOT NULL DEFAULT 'S',
	customerid		BIGINT			NOT NULL,
	regDate			TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	Account_customerID_FK FOREIGN KEY (customerid) REFERENCES Customer(cid)
) AUTO_INCREMENT = 3001 ;

ALTER Table Customer CHANGE customerid userID VARCHAR(16) NOT NULL;

INSERT INTO Account (accountnum, customerid)
VALUES ('111-11-1111', 1001);

SELECT * FROM Account;

SELECT * FROM Customer;

SELECT Account.* FROM Account, Customer  WHERE Account.customerid = Customer.cid

SELECT a.* FROM Account a INNER JOIN Customer c ON a.customerid = c.cid WHERE c.ssn = '901213-1167521'