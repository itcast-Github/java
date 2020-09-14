package cn.itast.demo07;

public class Outer {
	int i = 1;
	class Inner{
		int i = 2;
		public void inner(){
			int i = 3;
			System.out.println(Outer.this.i);
		}
	}
}
