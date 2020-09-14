package cn.itcast.demo2;

public class SleepThread extends Thread{
	public void run(){
		for(int i = 0 ; i < 5 ;i++){
			try{
				Thread.sleep(500);
			}catch(Exception ex){
				
			}
			System.out.println(i);
		}
	}
}
