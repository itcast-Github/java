CREATE TABLE zhangwu (
  id INT PRIMARY KEY AUTO_INCREMENT, -- 账务ID
  zname VARCHAR(200), -- 账务名称
  zmoney DOUBLE -- 金额
);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (1,'吃饭支出',247);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (2,'工资收入',12345);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (3,'服装支出',1000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (4,'吃饭支出',325);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (5,'股票收入',8000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (6,'打麻将支出',8000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (7,NULL,5000);


/*
   查询指定列的数据
   格式:
     select 列名1,列名2 from 表名
*/
SELECT zname,zmoney FROM zhangwu;

/*
  查询所有列的数据
  格式:
    select * from 表名
*/
SELECT * FROM zhangwu;

/*
   查询去掉重复记录
   DISTINCT 关键字 跟随列名
*/
SELECT  DISTINCT zname FROM zhangwu

/*
  查询重新命名列
  as 关键字
*/
SELECT zname AS 'name' FROM zhangwu 

/*
  查询数据中,直接进行数学计算
  列对数字进行计算
*/
SELECT zname,zmoney+1000 AS'sum' FROM zhangwu

-- 查询所有的吃饭支出
SELECT * FROM zhangwu WHERE zname='吃饭支出'

-- 查询金额大于1000
SELECT * FROM zhangwu WHERE zmoney>1000

-- 查询金额在2000到5000之间 
SELECT * FROM zhangwu WHERE zmoney >= 2000 AND zmoney <= 5000
-- 改造成between and 方式
SELECT * FROM zhangwu WHERE zmoney BETWEEN 2000 AND 5000

-- 查询金额是 1000,3500,5000 其中一个
SELECT * FROM zhangwu WHERE zmoney = 1000 OR zmoney=3500 OR zmoney=5000
-- 改造成in方式
SELECT * FROM zhangwu WHERE zmoney  IN (1000,3500,5000)


-- like 模糊查询 配合通配符
-- 查询所有的支出
SELECT * FROM zhangwu WHERE zname LIKE '%支出%'


-- 查询账务名字,五个字符的
SELECT * FROM zhangwu WHERE zname LIKE'_____'

-- 查询账务名,不为空的
SELECT * FROM zhangwu WHERE zname IS NOT NULL

SELECT * FROM zhangwu WHERE   NOT ( zname IS NULL)
