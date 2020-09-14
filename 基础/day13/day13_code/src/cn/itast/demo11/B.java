package cn.itast.demo11;
import cn.itast.demo10.*;

public class B extends A{
	public void show(){
	  //受保护权限,只能是子类的里面!!!!! 调用父类的受保护成员
		// super
		abc();
	}
}
