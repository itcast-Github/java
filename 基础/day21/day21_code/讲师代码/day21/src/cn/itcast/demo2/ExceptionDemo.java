package cn.itcast.demo2;
/*
 *  继承后,在子类重写父类方法的时候,异常处理
 *  结论:
 *    父类的方法,如果抛出异常,子类重写后
 *      可以不抛出异常
 *      也可以抛出异常,但是,如果子类要抛,抛出的异常不能大于父类的异常
 *        大于,都指的是继承关系
 *        
 *    父类的方法,没有异常抛出,子类重写后
 *       也不能抛出异常
 *       如果子类中调用了抛出异常的方法,别无选择,只能try..catch处理
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.function();
	}
}

class Fu{
	public void function(){
		
	}
}
class Zi extends Fu{
	public void function(){
		
			try {
				method();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	}
	public void method()throws Exception{
		
	}
}
