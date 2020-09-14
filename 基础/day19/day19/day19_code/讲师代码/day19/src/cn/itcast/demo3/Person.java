package cn.itcast.demo3;

public class Person {
	private String name;
	private int age;

	/*
	 *  没有做重写父类,每次运行结果都是不同整数
	 *  如果子类重写父类的方法,哈希值,自定义的
	 *  存储到HashSet集合的依据
	 */
	public int hashCode(){
		return name.hashCode()+age*55;
	}
	//方法equals重写父类,保证和父类相同
	//public boolean equals(Object obj){}
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(obj instanceof Person){
			Person p = (Person)obj;
			return name.equals(p.name) && age==p.age;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(){}
	
	public String toString(){
		return name+".."+age;
	}
	


}
