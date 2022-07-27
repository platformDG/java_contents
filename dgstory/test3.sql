-- 1)
use jv250;

-- 2)
show tables;

-- 3)
DESC Customer;

-- 4)
CREATE INDEX CustomerIndex ON Customer(ssn);

-- 5)
SELECT a.accountNum, a.accountType, a.balance FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '840104-1234567';