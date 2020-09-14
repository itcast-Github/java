package cn.itcast.demo;

public class Demo02 {

	 public static void main(String[] args) {
		Test01 t = new Test01();
		int method = t.method();
		System.out.println(method);
		//返回路径：每次碰到return就会在返回路径中临时存储这个被返回的值，
		//无论方法内有任何的改变，返回路径中的这个值一致不变。        		 
	}
}
class Test01{
	 
     public int method(){
    	 int i = 0 ;
    	 try{
    		 System.out.println(1/0);
    		 return i;
    	 }catch (Exception e) {
    		// e.printStackTrace();
    	}finally{
    		i = 20;
    		System.out.println("我一定执行"+i);
    	}
    	 return i;
     }
	
	
}
