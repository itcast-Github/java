CREATE TABLE sort(
  sid INT PRIMARY KEY AUTO_INCREMENT,
  sname VARCHAR(100),
  sprice DOUBLE,
  sdesc VARCHAR(5000)
);
#初始化数据
INSERT INTO sort(sname,sprice,sdesc) VALUES('家电',2000,'优惠的促销'),
('家具',8900,'家具价格上调,原材料涨价'),
('儿童玩具',300,'赚家长钱'),
('生鲜',500.99,'生鲜商品'),
('服装',24000,'换季销售'),
('洗涤',50,'洗发水促销')


SELECT * FROM sort