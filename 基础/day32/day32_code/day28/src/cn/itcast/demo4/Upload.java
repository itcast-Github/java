package cn.itcast.demo4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Upload implements Runnable{
	
	private Socket socket;
	
	public Upload(Socket socket){this.socket=socket;}
	
	public void run() {
		try{
		//通过客户端连接对象,获取字节输入流,读取客户端图片
		InputStream in = socket.getInputStream();
		//将目的文件夹封装到File对象
		File upload = new File("d:\\upload");
		if(!upload.exists())
			upload.mkdirs();
		
		//防止文件同名被覆盖,从新定义文件名字
		//规则:  域名+毫秒值+6位随机数
		String filename="itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
		//创建字节输出流,将图片写入到目的文件夹中                         
		FileOutputStream fos = new FileOutputStream(upload+File.separator+filename);
		//读写字节数组
		byte[] bytes = new byte[1024];
		int len = 0 ;
		while((len = in.read(bytes))!=-1){
			fos.write(bytes, 0, len);
		}
		//通过客户端连接对象获取字节输出流
		//上传成功写回客户端
		socket.getOutputStream().write("上传成功".getBytes());
		
		fos.close();
		socket.close();
		}catch(Exception ex){
			
		}
	}
	
}
