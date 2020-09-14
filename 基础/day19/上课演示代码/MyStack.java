package cn.itcast.demo;

import java.util.LinkedList;

public class MyStack<E> {
	  
	  private LinkedList<E> linked ;
	  
	  public MyStack(){
		  linked = new LinkedList<E>();
	  }
	  // 压栈  ： 添加元素   弹栈 ： 取出最后进去元素
	  public void myPush(E e){
		  linked.add(e);
	  }
	  public E myPop(){
		  
		  return linked.removeLast();
	  }
	   
	

}
