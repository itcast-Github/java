/*
    比较运算符,计算结果只有2个可能,true,false
	结算结果的数据类型, boolean类型
	==  比较符号两边的数据 
	!=  比较符号两边的数据 
	>   比较符号两边的数据   1<2  true  2<2 false
	<   比较符号两边的数据 
	>=  比较符号两边的数据   1>=2 false  2>=2 true 
	<=  比较符号两边的数据 
*/
public class Operator_3{
	public static void main(String[] args){
		int i = 3;
		int j = 4;
		System.out.println(i=j); // 4
		System.out.println(i==j); // true
		
		System.out.println(2==1); // false
		System.out.println(2!=1); // true
	}
}