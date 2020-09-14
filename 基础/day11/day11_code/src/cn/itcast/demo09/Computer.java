package cn.itcast.demo09;
/*
 *  定义笔记本类
 *  功能: 开机,关机,使用USB设备
 */
public class Computer {
	public void openComputer(){
		System.out.println("笔记本开机");
	}
	
	public void closeComputer(){
		System.out.println("笔记本关机");
	}
	
	//使用USB设备方法,哪个设备
	//方法的参数,就是USB设备
	public void useUSB(USB usb){// USB usb = new Mouse()
		usb.open();
		usb.close();
	}
	
}
