/*
    创建数据库
    create database 数据库名;
*/
CREATE DATABASE mybase;
/*
  使用数据库
  use 数据库名
*/
USE mybase;

/*
      创建数据表的格式
      
      create table 表名(
          列名1 数据类型 约束,
          列名2 数据类型 约束,
          列名3 数据类型 约束
      );
      创建用户表,用户编号,姓名,用户的地址
      将编号列,设置为主键约束,保证列的数据唯一性,非空性
      primary key AUTO_INCREMENT
      让主键列数据,实现自动增长
*/
 CREATE TABLE users (
     uid INT PRIMARY KEY AUTO_INCREMENT ,
     uname VARCHAR(20),
     uaddress VARCHAR(200)
 );
/*show tables  显示所有数据表
desc  users    查看表中结构
drop table users 删除数据表
*/



