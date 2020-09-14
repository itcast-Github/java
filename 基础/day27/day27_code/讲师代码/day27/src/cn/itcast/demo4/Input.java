package cn.itcast.demo4;
/*
 *  输入的线程,对资源对象Resource中成员变量赋值
 *  一次赋值 张三,男
 *  下一次赋值 lisi,nv
 */
public class Input implements Runnable {
	private Resource r ;
	
	public Input(Resource r){
		this.r = r;
	}
	
	public void run() {
		int i = 0 ;
		while(true){
		  synchronized(r){
			  //标记是true,等待
			    if(r.flag){
			    	try{r.wait();}catch(Exception ex){}
			    }
			  
				if(i%2==0){
					r.name = "张三";
					r.sex = "男";
				}else{
					r.name = "lisi";
					r.sex = "nv";
				}
				//将对方线程唤醒,标记改为true
				r.flag = true;
				r.notify();
		  }
			i++;
		}
	}

}
