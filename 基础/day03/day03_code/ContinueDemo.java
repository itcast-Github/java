/*
    continue 关键字 
	作用: 在循环中, 终止本次循环,开始下一次循环
*/
public class ContinueDemo{
	public static void main(String[] args){
		for(int i = 0 ; i < 10 ; i++){
			if(i%2==0){
				continue;
			}
			System.out.println(i);
		}
	}
}