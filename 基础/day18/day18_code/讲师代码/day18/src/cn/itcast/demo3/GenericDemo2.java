package cn.itcast.demo3;
/*
 *  带有泛型的接口
 *  
 *  public interface List <E>{
 *    abstract boolean add(E e);
 *  }
 *  实现类,先实现接口,不理会泛型
 *  public class ArrayList<E> implements List<E>{
 *  }
 *  调用者 : new ArrayList<String>() 后期创建集合对象的时候,指定数据类型
 *  
 *  实现类,实现接口的同时,也指定了数据类型
 *  public class XXX implements List<String>{
 *  }
 *  new XXX()
 */
public class GenericDemo2 {

}
