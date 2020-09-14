/*
   对数据进行更新操作
   数据在原有的基础上修改
   格式:
     update 表名 set 列1=值1,列2=值2 where 条件
     where 条件: 数据中的唯一性
*/

-- 修改智能手机,价格上调到15999
UPDATE product SET price = 15999 WHERE id=2

-- 修改彩色电视,名字改为黑白电视机,价格,100
UPDATE product SET pname='黑白电视机', price=100 WHERE id = 6

/*
    修改条件的写法
    id=6
    id<>6
    id<=6  
    与或非  && || !
    && and
    || or 
    ! not
    
    id in (1,3,4,5,6) 包含
*/
-- 将笔记本的价格,和空调的价格,全部修改为2000
UPDATE product SET price = 2000 WHERE id = 1 OR id = 7;

/*
  删除表中的数据
  格式:
    delete from 表名 where 条件
    
    drop table 表名 删除整个数据表
*/
-- 删除热水器
DELETE FROM product WHERE id=8;
