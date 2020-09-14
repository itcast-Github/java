/*
    逻辑运算符,对两个boolean类型数据之间进行计算
	结果也是boolean类型
	
	& : 一边是false,运算结果就是false, 见了false,就是false
	| : 一边是true,运算结果就是true,见了true,就是true
	^ : 两边相同为false,不同为true
	! : 取反 !true = false  !false=true
	&& : 短路与 , 一边是false,另一边不运行
	|| : 短路或 , 一边是true,另一边不运行
*/
public class Operator_4{
	public static void main(String[] args){
		System.out.println( false & true );//false
		System.out.println( true | true );
		System.out.println( false ^ false );//F
		System.out.println( true ^ false );//T
		System.out.println( true ^ true );//F 
		System.out.println( !true );

// false
// true
// false
// true
// false
// false
		System.out.println( "--------------------------" );
		int i = 3;
		int j = 4;
		System.out.println(3>4 && ++j>2);
		System.out.println(i);
		System.out.println(j);
		
		System.out.println(3==3 || ++j>2);
		System.out.println(i);
		System.out.println(j);
	}
}
// --------------------------
// false
// 3
// 4
// true
// 3
// 4

