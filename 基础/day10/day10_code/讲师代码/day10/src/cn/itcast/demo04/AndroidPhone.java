package cn.itcast.demo04;
/*
 *   定义好的智能手机类
 *   
 *     功能: 打电话,发短信,
 *      来电显示:  号码,姓名,大头像
 *      
 *  新来的智能手机,两个功能没有变化,  只有来电功能发生变化
 *  直接使用先手机中的打电话和发短信功能
 *  新的功能上添加姓名和大头像
 *  
 *  新的手机,继承原来的手机,直接使用Phone类的打电话和发短信功能
 *  但是: 将原来的来电功能,进行重写,加入新的内容
 */
public class AndroidPhone extends Phone{
      public void showNum(){
    	  //父类的中的方法showNum已经可以号码,子类直接用
    	  super.showNum();
    	  System.out.println("显示姓名");
    	  System.out.println("显示大头像");
      }
}
