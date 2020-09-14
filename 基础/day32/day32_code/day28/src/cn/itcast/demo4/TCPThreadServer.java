package cn.itcast.demo4;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(8000);
		while(true){
		//获取到一个客户端,必须开启新线程
		Socket socket = server.accept();
		new Thread( new Upload(socket) ).start();
		}
		
		
	}
}
