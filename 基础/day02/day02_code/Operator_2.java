/*
    赋值运算符
	=
	+= -= *= /= %=
*/
public class Operator_2{
	public static void main(String[] args){
		//= 赋值运算,将右面的值,赋值给左边的变量
		int i = 3;
		i = i + 3;
		System.out.println(i); // 6
		
		// += 赋值运算符  i+=3 i=i+3
		int j = 5;
		j+=6; // j=j+6
		System.out.println(j); // 11
		
		byte b = 1;
		b = (byte)(b + 1);
		System.out.println(b); // 2
		
		byte b1=1;
		b1+=1; // 等同(byte)(b1 + 1);
	    System.out.println(b1); // 2
	}
}