-- Customer 테이블 생성
-- PRIMARY KEY는 유니크한 존재로 설정하는게 좋다. 주민번호 칼럼인 ssn도 사용해도 무방하나, 넘버값으로 새로운 키값 생성하는것도 좋다.
-- 속도면에서 문자보다 약간 우위에 있다.
-- PRIMARY KEY는 자동으로 NOT NULL임, AUTO_INCREMENT는 INSERT 될 때마다 자동으로 증가해주는 키워드
-- PRIMARY KEY AUTO_INCREMENT로 인해 1001부터 자동 증가하도록 생성함.
-- 보안을 위해 내부에서 인코딩해서 알수없는 코드 60자리 형태로 변경하도록 만들기 때문에 60으로 지정
-- regDate칼럼은 데이터가 들어온 날짜를 입력하기 위해 만듬(CURRENT_TIMESTAMP은 값이 안들어갔을 대 현재의 TIMESTAMP값을 넣겠다는 의미)
CREATE TABLE Customer (
   cid         BIGINT         PRIMARY KEY AUTO_INCREMENT, 
   name      VARCHAR(20)      NOT NULL,
   ssn         VARCHAR(14)      NOT NULL,
   phone      VARCHAR(14)      NOT NULL,
   userID   VARCHAR(16)      NOT NULL,
   passwd      VARCHAR(60)      NOT NULL,
   regDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001; 

-- Customer 테이블 생성
-- CONSTRAINT는 외래키를 설정하기 위해 사용한다.
-- CONSTRAINT 외래키명칭(아무거나 상관없다) FOREIGN KEY (Account에서 왜래키로 사용한 칼럼 ) REFERENCES 참조할 테이블명(참조할 테이블에서 왜래키로 사용한 칼럼)
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

-- 테이블 삭제
-- Customer 테이블 삭제할때 Account 외래키로 지정되어 있어서 삭제가 안된다.
DROP TABLE Customer;
DROP TABLE Account;

--자료 넣기.
--("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
--("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
INSERT INTO Customer ( name, ssn, phone, userid, passwd )
VALUES ( '유재석', '770321-1585447', '010-5524-8546', 'mudo001', 'mudo001' );

INSERT INTO Customer ( name, ssn, phone, userid, passwd )
VALUES ( '서현진', '850405-2582755', '010-5528-5548', 'jin5548', 'a5548' );

INSERT INTO Account ( accountnum, balance, interestrate, overdraftAmount, accounttype, customerid )
VALUES ('111-11-1111', 5000.0, 2.5, 0.0, 'S', 1001);

INSERT INTO Account ( accountnum, balance, interestrate, overdraftAmount, accounttype, customerid )
VALUES ('222-22-2222', 20000.0, 1.5, 0.0, 'S', 1002);

INSERT INTO Account ( accountnum, balance, interestrate, overdraftAmount, accounttype, customerid )
VALUES ('333-33-3333', 30000.0, 0.0, 50000.0, 'C', 1001);

-- 자료 검색하는 방법
SELECT * FROM Customer;
SELECT * FROM Account;
SELECT * FROM Customer WHERE name  = '유재석';

-- 테이블 조인해서 검색하는 방법.
-- 유재석의 계좌의 목록을 조회
SELECT a.*
FROM Account a INNER JOIN Customer c ON a.customerid = c.cid
WHERE c.name = '유재석';

-- customerid별 계좌 갯수는 몇개인지 조회하시오.
SELECT customerid, count(*)
FROM Account
GROUP BY customerid;

-- 고객의 계좌 갯수를 파악할수 있도록 조회하시오.
-- 이름을 동시에 보여주기.
SELECT a.customerid, c.name, count(c.customerid)
FROM Account a INNER JOIN Customer c ON a.customerid = c.cid
GROUP BY a.customerid, c.name;


-- 데이터가 값 업데이트 하기.
UPDATE Customer SET phone = '010-5524-5552' WHERE name  = '유재석';

-- 데이터 삭제하는 방법.
DELETE FROM Customer WHERE name = '서현진';

SELECT a.aid, a.accountnum, a.balance, a.interestrate, a.overdraftamount, a.accounttype, c.name, c.ssn, c.phone, a.regdate
FROM Account a INNER JOIN Customer c ON a.customerid = c.cid
WHERE c.ssn = "700505-1625744"; 