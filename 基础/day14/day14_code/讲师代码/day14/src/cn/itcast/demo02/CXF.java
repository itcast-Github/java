package cn.itcast.demo02;
/*
 *  定义长方形类
 *    计算面积,周长
 *  
 *  边长,设计的时候,定义为成员变量,两个计算方法的局部变量
 *  属于谁的? 属于长方形事物, 每个独立计算的功能
 *  
 *  new CXF(10,8);
 */
public class CXF {
	 private int w;
	 private int h;
	 
	 public CXF(int w,int h){
		 this.w = w;
		 this.h = h;
	 }
	
	 public int getArea(){
		 return w*h;
	 }
	 
	 public int getLong(){
		 return (w+h)*2;
	 }
}
