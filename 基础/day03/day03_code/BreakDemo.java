/*
    break 关键字
	作用于循环中,终止循环的作用
*/
public class BreakDemo{
	public static void main(String[] args){
		int i = 1;
		while(i < 2000){
			if(i == 3){
				break;
			}else{
				System.out.println(i);
			}
			i++;
		}
	}
}