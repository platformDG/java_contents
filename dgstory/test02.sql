-- 1)
INSERT INTO Customer (name, ssn)
VALUES ('James Bond', '900101-1234567');

-- 2)
INSERT INTO Account (accType, balance, interestRate, overdraftAmount, customerId)
VALUES ('C', 2000.0, 0.03, 0.0, 1001);


-- 3)
UPDATE Customer SET name = 'Jason Bourne' WHERE cid = 1002;

-- 4)
DELETE FROM Customer WHERE cid = 1002;

-- 5)
SELECT accType, balance FROM Account WHERE aid = 3001;