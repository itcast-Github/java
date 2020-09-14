/*
    查询所有的数据
    吃饭支出 共计多少
    工资收入 共计多少
    服装支出 共计多少
    股票收入 共计多少
    打麻将支出 共计多少钱
    
    分组查询:  group by 被分组的列名
    必须跟随聚合函数
    select 查询的时候,被分组的列,要出现在select 选择列的后面
*/
  SELECT SUM(zmoney),zname FROM zhangwu GROUP BY zname
  
-- 对zname内容进行分组查询求和,但是只要支出
SELECT SUM(zmoney)AS 'getsum',zname FROM zhangwu WHERE zname LIKE'%支出%'
GROUP BY zname
ORDER BY getsum DESC

-- 对zname内容进行分组查询求和,但是只要支出, 显示金额大于5000
-- 结果集是分组查询后,再次进行筛选,不能使用where, 分组后再次过滤,关键字 having
SELECT SUM(zmoney)AS 'getsum',zname FROM zhangwu WHERE zname LIKE'%支出%'
GROUP BY zname HAVING getsum>5000


