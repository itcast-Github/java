package cn.itcast.demo3;
/*
 *  自定义异常
 *    继承Exception,或者继承RuntimeException
 *    构造方法中,super将异常信息,传递给父类
 */
public class FuShuException extends RuntimeException{
	public FuShuException(String s){
		super(s);
	}
	
	public FuShuException(){}
}
