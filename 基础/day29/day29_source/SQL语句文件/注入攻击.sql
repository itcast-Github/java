CREATE TABLE users(
     id INT PRIMARY KEY AUTO_INCREMENT,
     username VARCHAR(100),
     PASSWORD VARCHAR(100)
);

INSERT INTO users (username,PASSWORD) VALUES ('a','1'),('b','2');

SELECT * FROM users;

-- 登录查询
SELECT * FROM users WHERE username='dsfsdfd' AND PASSWORD='wrethiyu'1 
OR 1=1

SELECT * FROM users WHERE username='a' AND PASSWORD='1'OR'1=1'