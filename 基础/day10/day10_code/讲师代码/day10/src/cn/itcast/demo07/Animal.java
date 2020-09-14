package cn.itcast.demo07;
/*
 *   抽象类,可以没有抽象方法,可以定义带有方法体的方法
 *   让子类继承后,可以直接使用
 */
public  abstract class Animal {
     public void sleep(){
    	 System.out.println("动物睡觉");
     }
     
    // private abstract void show();
     //抽象方法,需要子类重写, 如果父类方法是私有的,子类继承不了,也就没有了重写
}
