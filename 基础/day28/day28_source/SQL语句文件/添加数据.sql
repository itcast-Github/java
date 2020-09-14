CREATE TABLE product(
   -- 主键列,自动增长
   id INT PRIMARY KEY AUTO_INCREMENT,
   -- 商品名字,可变字符,非空
   pname VARCHAR(100) NOT NULL,
   -- 商品的价格,double
   price DOUBLE
);

/*
   向数据表中添加数据 insert
   格式:
     insert into 表名(列名1,列名2,列名3) values (值1,值2,值3)
     注意:
        列名,表名问题
        对应问题,
         个数,数据类型
*/

INSERT INTO product (id,pname,price) VALUES (1,'笔记本',5555.99);
INSERT INTO product (id,pname,price) VALUES (2,'智能手机',9999);

/*
   添加数据格式,不考虑主键
   格式:
     insert into 表名 (列名) values (值)
*/
INSERT INTO product (pname,price) VALUES('洗衣机',800);

/*
   添加数据格式,所有值全给出
   格式:
     insert into 表名 values (全列值)
*/
INSERT INTO product VALUES (4,'微波炉',300.25);

/*
   添加数据格式,批量写入
   格式:
     insert into 表名 (列名1,列名2,列名3) values (值1,值2,值3),(值1,值2,值3)
*/
INSERT INTO product (pname,price) VALUES 
('智能机器人',25999.22),
('彩色电视',1250.36),
('沙发',5899.02)


-- insert into product (pname,price) values ('热水器',485.02)
-- INSERT INTO product (id,pname,price) VALUES (7,'空调',485.02)



