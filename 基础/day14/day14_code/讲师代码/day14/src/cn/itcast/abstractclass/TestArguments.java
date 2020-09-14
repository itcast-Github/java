package cn.itcast.abstractclass;
/*
 *  将抽象类类型,作为方法的参数进行传递
 */
public class TestArguments {
	public static void main(String[] args) {
		//调用operatorAnimal,传递子类对象
		Cat c = new Cat();
		operatorAnimal(c);
		
		operatorAnimal( new Dog());
	}
	/*
	 *  方法operatorAnimal,参数是一个抽象类
	 *  调用方法,传递Animal类型对象,Animal抽象类没有对象
	 *  只能传递Animal的子类的对象 (多态)
	 *  可以传递Animal的任意的子类对象
	 */
	public static void operatorAnimal(Animal a){
		//引用变量a,调用方法eat
		a.eat();
	}
}
