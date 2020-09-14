/*
  创建管家婆的数据库
  名字 gjp
*/
CREATE DATABASE gjp;

USE gjp;

/*
  创建数据表,表名账务
  字段,列
  主键
  分类名称  可变字符
  金额  double
  账户  可变字符 (支付,收入方法)
  创建日期 date
  账务描述 可变字符
*/

CREATE TABLE gjp_zhangwu(
   -- 主键
   zwid INT PRIMARY KEY AUTO_INCREMENT,
   -- 分类名称   
   flname VARCHAR(200),
   -- 金额
   money DOUBLE,
   -- 账户
   zhanghu VARCHAR(100),
   -- 创建日期
   createtime DATE,
   -- 账务描述
   description  VARCHAR(1000)
);
SELECT * FROM gjp_zhangwu

-- 写入测试的数据
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (1,'吃饭支出',247,'交通银行','2016-03-02','家庭聚餐');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (2,'工资收入',12345,'现金','2016-03-15','开工资了');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (3,'服装支出',1998,'现金','2016-04-02','买衣服');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (4,'吃饭支出',325,'现金','2016-06-18','朋友聚餐');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (5,'股票收入',8000,'工商银行','2016-10-28','股票大涨');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (6,'股票收入',5000,'工商银行','2016-10-28','股票又大涨');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (7,'工资收入',5000,'交通银行','2016-10-28','又开工资了');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (8,'礼金支出',5000,'现金','2016-10-28','朋友结婚');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (9,'其他支出',1560,'现金','2016-10-29','丢钱了');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (10,'交通支出',2300,'交通银行','2016-10-29','油价还在涨啊');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (11,'吃饭支出',1000,'工商银行','2016-10-29','又吃饭');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (12,'工资收入',1000,'现金','2016-10-30','开资');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (13,'交通支出',2000,'现金','2016-10-30','机票好贵');
INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (14,'工资收入',5000,'现金','2016-10-30','又开资');

