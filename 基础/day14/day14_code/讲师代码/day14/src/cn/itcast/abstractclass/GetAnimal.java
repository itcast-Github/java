package cn.itcast.abstractclass;

public class GetAnimal {
	/*
	 * 定义方法,方法的返回值是Animal类型
	 * 抽象类,抽象类没有对象的,因此在方法的return后,返回Animal 的子类的对象
	 */
	public Animal getAnimal(int i){
		if(i==0)
			
			return new Cat();
		
		return new Dog();
	}
}
