package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 *  表示互联网中的IP地址
 *    java.net.InetAddress
 *  静态方法
 *    static InetAddress  getLocalHost()   LocalHost本地主机
 *    返回本地主机,返回值InetAddress对象
 *    
 *    static InetAddress getByName(String hostName)传递主机名,获取IP地址对象
 *    
 *  非静态方法
 *     String getHoustAddress()获取主机IP地址
 *     String getHoustName()获取主机名
 *    
 */
public class InetAddressDemo {
	public static void main(String[] args)throws UnknownHostException {
		function();
	}
	/*
	 * static InetAddress getByName(String hostName)传递主机名,获取IP地址对象
	 */
	public static void function_1()throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet); // www.baidu.com/39.156.66.18
	}
	
	/*
	 *  static InetAddress  getLocalHost()   LocalHost本地主机
	 */
	public static void function() throws UnknownHostException{
		InetAddress inet = InetAddress.getLocalHost();
		//输出结果就是主机名,和 IP地址
		System.out.println(inet.toString()); // DESKTOP-TVCC3NF/10.15.5.64
		
		String ip = inet.getHostAddress();
		String name = inet.getHostName();
		System.out.println(ip+"   "+name); // 10.15.5.64   DESKTOP-TVCC3NF
		
		/*String host = inet.toString();
		String[] str = host.split("/");
		for(String s : str){
			System.out.println(s); // DESKTOP-TVCC3NF  10.15.5.64
		}*/
	}
}





