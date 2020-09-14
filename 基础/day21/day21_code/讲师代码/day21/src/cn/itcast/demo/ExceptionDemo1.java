package cn.itcast.demo;
/*
 *  异常的处理方式:
 *    try...catch...finally
 *    格式:
 *      try{
 *        被检测的代码
 *        可能出现异常的代码
 *      }catch(异常类名 变量){
 *         异常的处理方式
 *         循环,判断,调用方法,变量
 *      }finally{
 *         必须要执行代码
 *      }
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		int[] arr = null;
		try{
			int i = getArray(arr);
			System.out.println(i);
			
		}catch(NullPointerException ex){
			System.out.println("###"+ex);
			
		}catch(ArrayIndexOutOfBoundsException ex){
			
			System.out.println("!!!!!!"+ex);
		}
		System.out.println("Game Over");
	}
	/*
	 * 定义方法,抛出异常
	 * 调用者使用try catch
	 */
	 public static int getArray(int[] arr)throws NullPointerException,ArrayIndexOutOfBoundsException{
		 //对数组判空
		 if( arr == null){
			 //手动抛出异常,抛出空指针异常
			 throw new NullPointerException("数组不存在");
		 }
		 //对数组的索引进行判断
		 if( arr.length < 3){
			 //手动抛出异常,抛出数组的索引越界异常
			 throw new ArrayIndexOutOfBoundsException("数组没有3索引");
		 }
		 return arr[3]+1;
	 }
}




