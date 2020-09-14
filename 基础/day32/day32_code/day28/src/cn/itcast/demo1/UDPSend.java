package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 *  实现UDP协议的发送端:
 *    实现封装数据的类 java.net.DatagramPacket  将你的数据包装
 *    实现数据传输的类 java.net.DatagramSocket  将数据包发出去
 *    
 *  实现步骤:
 *    1. 创建DatagramPacket对象,封装数据, 接收的地址和端口
 *    2. 创建DatagramSocket
 *    3. 调用DatagramSocket类方法send,发送数据包
 *    4. 关闭资源
 *    
 *    DatagramPacket构造方法:
 *      DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 *      
 *    DatagramSocket构造方法:
 *      DatagramSocket()空参数
 *      方法: send(DatagramPacket d)
 *      
 */
public class UDPSend {
	public static void main(String[] args) throws IOException{
		//创建数据包对象,封装要发送的数据,接收端IP,端口
		byte[] date = "你好UDP".getBytes();
		//创建InetAddress对象,封装自己的IP地址
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(date, date.length, inet,6000);
		//创建DatagramSocket对象,数据包的发送和接收对象
		DatagramSocket ds = new DatagramSocket();
		//调用ds对象的方法send,发送数据包
		ds.send(dp);
		//关闭资源
		ds.close();
	}
}
