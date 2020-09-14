/*
   使用聚合函数查询计算
*/

-- count 求和,对表中的数据的个数求和  count(列名)
-- 查询统计账务表中,一共有多少条数据
SELECT COUNT(*)AS'count' FROM zhangwu

-- sum求和,对一列中数据进行求和计算 sum(列名)
-- 对账务表查询,对所有的金额求和计算
SELECT SUM(zmoney) FROM zhangwu
-- 求和,统计所有支出的总金额
SELECT SUM(zname) FROM zhangwu WHERE zname LIKE'%收入%'

INSERT INTO zhangwu (zname) VALUES ('彩票收入')

-- max 函数,对某列数据,获取最大值
SELECT MAX(zmoney) FROM zhangwu

-- avg 函数,计算一个列所有数据的平均数
SELECT AVG(zmoney)FROM zhangwu
