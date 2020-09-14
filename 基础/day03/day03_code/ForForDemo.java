/*
   循环的嵌套: 循环里面还有循环, for形式多
   for(){
	   
	    for(){
			
		}
	   
   }
   总的循环次数 =  内循环次数 * 外循环的次数
   内循环,是外循环的循环体
   
   外循环,控制的是行数
   内循环,控制的是每行的个数
*/
public class ForForDemo{
	public static void main(String[] args){
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0; j < i+1 ;j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}