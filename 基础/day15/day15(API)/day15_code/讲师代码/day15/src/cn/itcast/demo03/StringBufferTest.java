package cn.itcast.demo03;

public class StringBufferTest {
	public static void main(String[] args) {
		int[] arr = {4,1,4,56,7,8,76};
		System.out.println(toString(arr));
	}
   /*
    * int[] arr = {34,12,89,68};将一个int[]中元素转成字符串 
    * 格式 [34,12,89,68]
    * String s = "["
    * 数组遍历
    *   s+= arr[i];
    *  s+"]"
    *  StringBuffer实现,节约内存空间, String + 在缓冲区中,append方法
    */
	public static String toString(int[] arr){
		//创建字符串缓冲区
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		//数组遍历
		for(int i = 0 ; i < arr.length;i++){
			//判断是不是数组的最后一个元素
			if(i == arr.length-1){
				buffer.append(arr[i]).append("]");
			}else{
				buffer.append(arr[i]).append(",");
			}
		}
		return buffer.toString();
	}
}
