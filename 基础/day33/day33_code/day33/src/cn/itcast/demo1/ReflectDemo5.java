package cn.itcast.demo1;

import java.lang.reflect.Field;

/*
 *  反射获取成员变量,并修改值
 *  Person类中的成员String name
 */
public class ReflectDemo5 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		//获取成员变量 Class类的方法 getFields() class文件中的所有公共的成员变量
		//返回值是Field[]    Field类描述成员变量对象的类
		/*Field[] fields = c.getFields();
		for(Field f : fields){
			System.out.println(f);
		}*/
		
		//获取指定的成员变量 String name
		//Class类的方法  Field getField(传递字符串类型的变量名) 获取指定的成员变量
		Field field = c.getField("name");
	   
		//Field类的方法 void set(Object obj, Object value) ,修改成员变量的值
		//Object obj 必须有对象的支持,  Object value 修改后的值
		field.set(obj,"王五");
		System.out.println(obj);
		
	}
}
