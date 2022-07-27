CREATE TABLE UserInfo (
   uid         BIGINT         PRIMARY KEY AUTO_INCREMENT, 
   userID   VARCHAR(16)      NOT NULL,
   passwd      VARCHAR(16)      NOT NULL,
   username      VARCHAR(20)      NOT NULL,
   ssn         VARCHAR(14)      NOT NULL,
   email		VARCHAR(20)      NOT NULL,
   addr      VARCHAR(60)      NOT NULL,
   regDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001; 


INSERT INTO UserInfo(userid, passwd, username, ssn, email, addr )  VAlUES (?, ?, ?, ?, ?, ?)


SELECT * FROM userinfo;

UPDATE UserInfo SET passwd =? username =? ssn =? email =? addr =?  WHERE userid = ? ;