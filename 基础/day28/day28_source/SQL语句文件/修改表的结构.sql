 CREATE TABLE users (
     uid INT PRIMARY KEY AUTO_INCREMENT,
     uname VARCHAR(20),
     uaddress VARCHAR(200)
 );
 /*
    添加列,添加字段
    alter table 表名 add 列名 数据类型 约束
 */
  ALTER TABLE users ADD tel INT ;
  
  /*
    修改列, 在原有的列上修改
    修改列名,数据类型约束  
    alter table 表名 modify 列名 数据类型 约束
  */
  ALTER TABLE users MODIFY tel VARCHAR(50);
  
  /*
     修改列名
     alter table 表名 change 旧列名 新列名 数据类型 约束
  */
  ALTER TABLE users CHANGE tel newtel DOUBLE;
  
  /*
    删除列
    alter table 表名 drop 列名  
  */
  ALTER TABLE users DROP newtel;
  
  /*
     修改表名
     rename table 表名 to 新名 
  */
  RENAME TABLE users TO newusers
  