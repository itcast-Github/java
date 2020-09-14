package cn.itcast.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		try{
			function();
		}catch(ParseException ex){
			
		}
	}
	
	public static void function()throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2088-8-8");	
		System.out.println(date);
	}
}
