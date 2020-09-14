今日内容介绍
```
1、Map接口
2、模拟斗地主洗牌发牌
```

 
 


=======================第一节课开始=============================================

### 01Map集合概述
  A:Map集合概述:
    我们通过查看Map接口描述,发现Map接口下的集合与Collection接口下的集合，它们存储数据的形式不同
    	a:Collection中的集合，元素是孤立存在的（理解为单身），向集合中存储元素采用一个个元素的方式存储。
    	
        b:Map中的集合，元素是成对存在的(理解为夫妻)。每个元素由键与值两部分组成，通过键可以找对所对应的值。
     
    	Collection中的集合称为单列集合，Map中的集合称为双列集合。
    	需要注意的是，Map中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。
    Map
     |--HashMap
     |--LinkedHashMap

### 02Map接口中的常用方法 
  A:Map接口中的常用方法 
       /*
        *  Map接口中的常用方法
        *    使用Map接口的实现类 HashMap
        */
       public class MapDemo {
       	public static void main(String[] args) {
       		function_2();
       	}
       	/*
       	 *  移除集合中的键值对,返回被移除之前的值
       	 *  V remove(K)
       	 */
       	public static void function_2(){
       		Map<Integer,String> map = new HashMap<Integer, String>();
       		map.put(1, "a");
       		map.put(2, "b");
       		map.put(3, "c");
       		System.out.println(map);
       		
       		String value = map.remove(33);
       		System.out.println(value);
       		System.out.println(map);
       	}
       	
       	/*
       	 * 通过键对象,获取值对象
       	 * V get(K)
       	 * 如果集合中没有这个键,返回null
       	 */
       	public static void function_1(){
       		//创建集合对象,作为键的对象整数,值的对象存储字符串
       		Map<Integer,String> map = new HashMap<Integer, String>();
       		map.put(1, "a");
       		map.put(2, "b");
       		map.put(3, "c");
       		System.out.println(map);
       		
       		String value = map.get(4);
       		System.out.println(value);
       	}
       	
       	/*
       	 *  将键值对存储到集合中
       	 *  V put(K,V) K 作为键的对象, V作为值的对象
       	 *  存储的是重复的键,将原有的值,覆盖
       	 *  返回值一般情况下返回null,
       	 *  存储重复键的时候,返回被覆盖之前的值
       	 */
       	public static void function(){
       		//创建集合对象,HashMap,存储对象,键是字符串,值是整数
       		Map<String, Integer> map = new HashMap<String, Integer>();
       		map.put("a", 1);
       		
       		map.put("b", 2);
       		
       		map.put("c", 3);
       		
       		System.out.println(map);
       	}
       }



### 03Map集合遍历方式keySet方法
  A:Map集合遍历方式keySet方法
     1.获取Map集合中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键
     2.遍历键的Set集合，得到每一个键
     3.根据键利用get(key)去Map找所对应的值
     /*
      *  Map集合的遍历
      *    利用键获取值
      *    Map接口中定义方法keySet
      *    所有的键,存储到Set集合
      */
     public class MapDemo1 {
     	public static void main(String[] args) {
     		/*
     		 *  1. 调用map集合的方法keySet,所有的键存储到Set集合中
     		 *  2. 遍历Set集合,获取出Set集合中的所有元素 (Map中的键)
     		 *  3. 调用map集合方法get,通过键获取到值
     		 */
     		Map<String,Integer> map = new HashMap<String,Integer>();
     		map.put("a", 11);
     		map.put("b", 12);
     		map.put("c", 13);
     		map.put("d", 14);
     		
     		//1. 调用map集合的方法keySet,所有的键存储到Set集合中
     		Set<String> set = map.keySet();
     		//2. 遍历Set集合,获取出Set集合中的所有元素 (Map中的键)
     		Iterator<String> it = set.iterator();
     		while(it.hasNext()){
     			//it.next返回是Set集合元素,也就是Map中的键
     			//3. 调用map集合方法get,通过键获取到值
     			String key = it.next();
     			Integer value = map.get(key);
     			System.out.println(key+"...."+value);
     		}
     		
     		System.out.println("=======================");
     		

     		for(String key : map.keySet()){
     			Integer value = map.get(key);
     			System.out.println(key+"...."+value);
     		}
     	}
     }
    

### 04Map集合Entry对象
   A:Map集合Entry对象
     interface Map{
     	interface Entry{//Entry是Map的一个内部接口
     		           //由Map的子类的内部类实现

     	}
     }
     class HashMap{
     	static class Entry<K,V> implements Map.Entry<K,V> {//Entry对象指的就是该类的对象
            final K key;
                  V value;
     	}
     }
     在Map类设计时，提供了一个嵌套接口：Entry。
     Entry将键值对的对应关系封装成了对象。
     即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。
       a:Entry是Map接口中提供的一个静态内部嵌套接口。
       b:相关方法
     	 getKey()方法：获取Entry对象中的键
       getValue()方法：获取Entry对象中的值
       entrySet()方法：用于返回Map集合中所有的键值对(Entry)对象，以Set集合形式返回。

### 05Map集合遍历方式entrySet方法 
   A:Map集合遍历方式entrySet方法
    *
     *  Map集合获取方式
     *  entrySet方法,键值对映射关系(结婚证)获取
     *  实现步骤:
     *    1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
     *        Set<Entry <K,V> >
     *    2. 迭代Set集合
     *    3. 获取出的Set集合的元素,是映射关系对象
     *    4. 通过映射关系对象方法 getKet, getValue获取键值对
     *    
     *    创建内部类对象 外部类.内部类 = new 
     */
    public class MapDemo2 {
    	public static void main(String[] args) {
    		Map<Integer,String> map = new HashMap<Integer, String>();
    		map.put(1, "abc");
    		map.put(2, "bcd");
    		map.put(3, "cde");
    		//1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
    		Set<Map.Entry <Integer,String> >  set = map.entrySet();
    		//2. 迭代Set集合
    		Iterator<Map.Entry <Integer,String> > it = set.iterator();
    		while(it.hasNext()){
    			//  3. 获取出的Set集合的元素,是映射关系对象
    			// it.next 获取的是什么对象,也是Map.Entry对象
    			Map.Entry<Integer, String> entry = it.next();
    			//4. 通过映射关系对象方法 getKet, getValue获取键值对
    			Integer key = entry.getKey();
    			String value = entry.getValue();
    			System.out.println(key+"...."+value);
    		}
    		
    		 
    	}
    }



=======================第二节课开始============================================
### 06Map集合遍历方式增强for循环
   A:Map集合遍历方式增强for循环
     A:Map集合遍历方式entrySet方法
      *
       *  Map集合获取方式
       *  entrySet方法,键值对映射关系(结婚证)获取
       *  实现步骤:
       *    1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
       *        Set<Entry <K,V> >
       *    2. 迭代Set集合
       *    3. 获取出的Set集合的元素,是映射关系对象
       *    4. 通过映射关系对象方法 getKet, getValue获取键值对
       *    
       *    创建内部类对象 外部类.内部类 = new 
       */
      public class MapDemo2 {
      	public static void main(String[] args) {
      		Map<Integer,String> map = new HashMap<Integer, String>();
      		map.put(1, "abc");
      		map.put(2, "bcd");
      		map.put(3, "cde");
      		//1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
      		Set<Map.Entry <Integer,String> >  set = map.entrySet();
      		//2. 迭代Set集合
      		Iterator<Map.Entry <Integer,String> > it = set.iterator();
      		while(it.hasNext()){
      			//  3. 获取出的Set集合的元素,是映射关系对象
      			// it.next 获取的是什么对象,也是Map.Entry对象
      			Map.Entry<Integer, String> entry = it.next();
      			//4. 通过映射关系对象方法 getKet, getValue获取键值对
      			Integer key = entry.getKey();
      			String value = entry.getValue();
      			System.out.println(key+"...."+value);
      		}
      		
      		System.out.println("=========================");
      		for(Map.Entry<Integer, String> entry : map.entrySet()){
      			System.out.println(entry.getKey()+"..."+entry.getValue());
      		}
      	}
      }
      
      注意：Map集合不能直接使用迭代器或者foreach进行遍历。但是转成Set之后就可以使用了。
### 07HashMap集合存储和遍历
  A:HashMap集合存储和遍历
     /*
      *  使用HashMap集合,存储自定义的对象
      *  自定义对象,作为键,出现,作为值出现
      */
     public class HashMapDemo {
     	public static void main(String[] args) {
     		function_1();
     	}
     	/*
     	 * HashMap 存储自定义对象Person,作为键出现
     	 * 键的对象,是Person类型,值是字符串
     	 * 保证键的唯一性,存储到键的对象,重写hashCode equals
     	 */
     	public static void function_1(){
     		HashMap<Person, String> map = new HashMap<Person, String>();
     		map.put(new Person("a",20), "里约热内卢");
     		map.put(new Person("b",18), "索马里");
     		map.put(new Person("b",18), "索马里");
     		map.put(new Person("c",19), "百慕大");
     		for(Person key : map.keySet()){
     			String value = map.get(key);
     			System.out.println(key+"..."+value);
     		}
     		System.out.println("===================");
     		for(Map.Entry<Person, String> entry : map.entrySet()){
     			System.out.println(entry.getKey()+"..."+entry.getValue());
     		}
     	}
     	
     	/*
     	 * HashMap 存储自定义的对象Person,作为值出现
     	 * 键的对象,是字符串,可以保证唯一性
     	 */
     	public static void function(){
     		HashMap<String, Person> map = new HashMap<String, Person>();
     		map.put("beijing", new Person("a",20));
     		map.put("tianjin", new Person("b",18));
     		map.put("shanghai", new Person("c",19));
     		for(String key : map.keySet()){
     			Person value = map.get(key);
     			System.out.println(key+"..."+value);
     		}
     		System.out.println("=================");
     		for(Map.Entry<String, Person> entry : map.entrySet()){
     			String key = entry.getKey();
     			Person value = entry.getValue();
     			System.out.println(key+"..."+value);
     		}
     	}
     }


### 08LinkedHashMap的特点
   *A:LinkedHashMap的特点
	  
	  /*
	   *  LinkedHashMap继承HashMap
	   *  保证迭代的顺序
	   */
	  public class LinkedHashMapDemo {
	  	public static void main(String[] args) {
	  		LinkedHashMap<String, String> link = new LinkedHashMap<String, String>();
	  		link.put("1", "a");
	  		link.put("13", "a");
	  		link.put("15", "a");
	  		link.put("17", "a");
	  		System.out.println(link);
	  	}
	  }


### 09Hashtable的特点
   *A:Hashtable的特点
	   /*
	    *  Map接口实现类 Hashtable
	    *  底层数据结果哈希表,特点和HashMap是一样的
	    *  Hashtable 线程安全集合,运行速度慢
	    *  HashMap 线程不安全的集合,运行速度快
	    *  
	    *  Hashtable命运和Vector是一样的,从JDK1.2开始,被更先进的HashMap取代
	    *  
	    *  HashMap 允许存储null值,null键
	    *  Hashtable 不允许存储null值,null键
	    *  
	    *  Hashtable他的孩子,子类 Properties 依然活跃在开发舞台
	    */
	   public class HashtableDemo {
	   	public static void main(String[] args) {	
	   		Map<String,String> map = new Hashtable<String,String>();
	   		map.put(null, null);
	   		System.out.println(map);
	   	}
	   }


### 10静态导入
   *A:静态导入:如果本类中有和静态导入的同名方法会优先使用本类的
               如果还想使用静态导入的,依然需要类名来调用
	   /*
	    * JDK1.5新特性,静态导入
	    * 减少开发的代码量
	    * 标准的写法,导入包的时候才能使用
	    * 
	    * import static java.lang.System.out;最末尾,必须是一个静态成员
	    */
	   import static java.lang.System.out;
	   import static java.util.Arrays.sort;


	   public class StaticImportDemo {
	   	public static void main(String[] args) {
	   		out.println("hello");
	   		
	   		int[] arr = {1,4,2};
	   		sort(arr);
	   	}
	   }

### 11方法的可变参数
   *A:方法的可变参数
     /*
      *  JDK1.5新的特性,方法的可变参数
      *  前提: 方法参数数据类型确定,参数的个数任意
      *  可变参数语法: 数据类型...变量名
      *  可变参数,本质就是一个数组
      */
     public class VarArgumentsDemo {
     	public static void main(String[] args) {
     		//调用一个带有可变参数的方法,传递参数,可以任意
     	//	getSum();
     		int sum = getSum(5,34,3,56,7,8,0);
     		System.out.println(sum);
 
     	}
     
     	/*
     	 * 定义方法,计算10个整数和
     	 * 方法的可变参数实现
     	 */
     	public static int getSum(int...a){
     		int sum = 0 ;
     		for(int i : a){
     			sum = sum + i;
     		}
     		return sum;
     	}
     	
     	/*
     	 * 定义方法,计算3个整数和
     	 */
     	/*public static int getSum(int a,int b ,int c){
     		return a+b+c;
     	}*/
     	
     	/*
     	 * 定义方法,计算2个整数和
     	 */
     	/*public static int getSum(int a,int b){
     		return a+b;
     	}*/
     }



### 12可变参数的注意事项
   *A:可变参数的注意事项    
	   /*
	    * 可变参数的注意事项
	    * 1. 一个方法中,可变参数只能有一个
	    * 2. 可变参数,必须写在参数列表的最后一位
	    */
	    public static void function(Object...o){
	   	 
	    }
=======================第三节课开始=============================================
### 13Collections工具类
   A:Collections工具类
      /*
       *  集合操作的工具类
       *    Collections
       */
      public class CollectionsDemo {
      	public static void main(String[] args) {
      		function_2();
      	}
      	/*
      	 * Collections.shuffle方法
      	 * 对List集合中的元素,进行随机排列
      	 */
      	public static void function_2(){
      		List<Integer> list = new ArrayList<Integer>();
      		list.add(1);
      		list.add(5);
      		list.add(9);
      		list.add(11);
      		list.add(8);
      		list.add(10);
      		list.add(15);
      		list.add(20);	
      		System.out.println(list);
      		
      		//调用工具类方法shuffle对集合随机排列
      		Collections.shuffle(list);
      		System.out.println(list);
      	}
      	
      	/*
      	 * Collections.binarySearch静态方法
      	 * 对List集合进行二分搜索,方法参数,传递List集合,传递被查找的元素
      	 */
      	public static void function_1(){
      		List<Integer> list = new ArrayList<Integer>();
      		list.add(1);
      		list.add(5);
      		list.add(8);
      		list.add(10);
      		list.add(15);
      		list.add(20);
      		//调用工具类静态方法binarySearch
      		int index = Collections.binarySearch(list, 16);
      		System.out.println(index);
      	}
      	
      	/*
      	 *  Collections.sort静态方法
      	 *  对于List集合,进行升序排列
      	 */
      	public static void function(){
      		//创建List集合
      		List<String> list = new ArrayList<String>();
      		list.add("ewrew");
      		list.add("qwesd");
      		list.add("Qwesd");
      		list.add("bv");
      		list.add("wer");
      		System.out.println(list);
      		//调用集合工具类的方法sort
      		Collections.sort(list);
      		System.out.println(list);
      	}
      }


### 14集合的嵌套
   A:集合的嵌套
    /*
     *  Map集合的嵌套,Map中存储的还是Map集合
     *  要求:
     *    传智播客  
     *      Java基础班
     *        001  张三
     *        002  李四
     *      
     *      Java就业班
     *        001  王五
     *        002  赵六
     *  对以上数据进行对象的存储
     *   001 张三  键值对
     *   Java基础班: 存储学号和姓名的键值对
     *   Java就业班:
     *   传智播客: 存储的是班级
     *   
     *   基础班Map   <学号,姓名>
     *   传智播客Map  <班级名字, 基础班Map>
     */
    public class MapMapDemo {
    	public static void main(String[] args) {
    		//定义基础班集合
    		HashMap<String, String> javase = new HashMap<String, String>();
    		//定义就业班集合
    		HashMap<String, String> javaee = new HashMap<String, String>();
    		//向班级集合中,存储学生信息
    		javase.put("001", "张三");
    		javase.put("002", "李四");
    		
    		javaee.put("001", "王五");
    		javaee.put("002", "赵六");
    		//定义传智播客集合容器,键是班级名字,值是两个班级容器
    		HashMap<String, HashMap<String,String>> czbk =
    				new HashMap<String, HashMap<String,String>>();
    		czbk.put("基础班", javase);
    		czbk.put("就业班", javaee);
    		
    		 keySet(czbk);
    		 
    	}



   
### 15集合的嵌套keySet遍历
   A:集合的嵌套keySet遍历
	   /*
	    *  Map集合的嵌套,Map中存储的还是Map集合
	    *  要求:
	    *    传智播客  
	    *      Java基础班
	    *        001  张三
	    *        002  李四
	    *      
	    *      Java就业班
	    *        001  王五
	    *        002  赵六
	    *  对以上数据进行对象的存储
	    *   001 张三  键值对
	    *   Java基础班: 存储学号和姓名的键值对
	    *   Java就业班:
	    *   传智播客: 存储的是班级
	    *   
	    *   基础班Map   <学号,姓名>
	    *   传智播客Map  <班级名字, 基础班Map>
	    */
	   public class MapMapDemo {
	   	public static void main(String[] args) {
	   		//定义基础班集合
	   		HashMap<String, String> javase = new HashMap<String, String>();
	   		//定义就业班集合
	   		HashMap<String, String> javaee = new HashMap<String, String>();
	   		//向班级集合中,存储学生信息
	   		javase.put("001", "张三");
	   		javase.put("002", "李四");
	   		
	   		javaee.put("001", "王五");
	   		javaee.put("002", "赵六");
	   		//定义传智播客集合容器,键是班级名字,值是两个班级容器
	   		HashMap<String, HashMap<String,String>> czbk =
	   				new HashMap<String, HashMap<String,String>>();
	   		czbk.put("基础班", javase);
	   		czbk.put("就业班", javaee);
	   		
	   		 keySet(czbk);
	   		 
	   	}
	   	
	   	 
	   	
	   	public static void keySet(HashMap<String,HashMap<String,String>> czbk){
	   		//调用czbk集合方法keySet将键存储到Set集合
	   		Set<String> classNameSet = czbk.keySet();
	   		//迭代Set集合
	   		Iterator<String> classNameIt = classNameSet.iterator();
	   		while(classNameIt.hasNext()){
	   			//classNameIt.next获取出来的是Set集合元素,czbk集合的键
	   			String classNameKey = classNameIt.next();
	   			//czbk集合的方法get获取值,值是一个HashMap集合
	   			HashMap<String,String> classMap = czbk.get(classNameKey);
	   			//调用classMap集合方法keySet,键存储到Set集合
	   			Set<String> studentNum = classMap.keySet();
	   			Iterator<String> studentIt = studentNum.iterator();
	   	   
	        	   while(studentIt.hasNext()){
	   				//studentIt.next获取出来的是classMap的键,学号
	   				String numKey = studentIt.next();
	   				//调用classMap集合中的get方法获取值
	   				String nameValue = classMap.get(numKey);
	   				System.out.println(classNameKey+".."+numKey+".."+nameValue);
	   			}
	   		}
	   		
	   		System.out.println("==================================");
	   	    for(String className: czbk.keySet()){
	   	       HashMap<String, String> hashMap = czbk.get(className);	
	   	       for(String numKey : hashMap.keySet()){
	   	    	   String nameValue = hashMap.get(numKey);
	   	    	   System.out.println(className+".."+numKey+".."+nameValue);
	   	       }
	   	    }
	   	}

	   } 
      


### 16集合的嵌套entrySet遍历
    A:集合的嵌套entrySet遍历
    /*
     *  Map集合的嵌套,Map中存储的还是Map集合
     *  要求:
     *    传智播客  
     *      Java基础班
     *        001  张三
     *        002  李四
     *      
     *      Java就业班
     *        001  王五
     *        002  赵六
     *  对以上数据进行对象的存储
     *   001 张三  键值对
     *   Java基础班: 存储学号和姓名的键值对
     *   Java就业班:
     *   传智播客: 存储的是班级
     *   
     *   基础班Map   <学号,姓名>
     *   传智播客Map  <班级名字, 基础班Map>
     */
    public class MapMapDemo {
    	public static void main(String[] args) {
    		//定义基础班集合
    		HashMap<String, String> javase = new HashMap<String, String>();
    		//定义就业班集合
    		HashMap<String, String> javaee = new HashMap<String, String>();
    		//向班级集合中,存储学生信息
    		javase.put("001", "张三");
    		javase.put("002", "李四");
    		
    		javaee.put("001", "王五");
    		javaee.put("002", "赵六");
    		//定义传智播客集合容器,键是班级名字,值是两个班级容器
    		HashMap<String, HashMap<String,String>> czbk =
    				new HashMap<String, HashMap<String,String>>();
    		czbk.put("基础班", javase);
    		czbk.put("就业班", javaee);
    		
    		entrySet(czbk);
    	}
    	
    	public static void entrySet(HashMap<String,HashMap<String,String>> czbk){
    		//调用czbk集合方法entrySet方法,将czbk集合的键值对关系对象,存储到Set集合
    		Set<Map.Entry<String, HashMap<String,String>>> 
    		                         classNameSet = czbk.entrySet();
    		//迭代器迭代Set集合
    		Iterator<Map.Entry<String, HashMap<String,String>>> classNameIt = classNameSet.iterator();
    		while(classNameIt.hasNext()){
    			//classNameIt.next方法,取出的是czbk集合的键值对关系对象
    			Map.Entry<String, HashMap<String,String>> classNameEntry =  classNameIt.next();
    			//classNameEntry方法 getKey,getValue
    			String classNameKey = classNameEntry.getKey();
    			//获取值,值是一个Map集合
    			HashMap<String,String> classMap = classNameEntry.getValue();
    			//调用班级集合classMap方法entrySet,键值对关系对象存储Set集合
    			Set<Map.Entry<String, String>> studentSet = classMap.entrySet();
    			//迭代Set集合
    			Iterator<Map.Entry<String, String>> studentIt = studentSet.iterator();
    			while(studentIt.hasNext()){
    				//studentIt方法next获取出的是班级集合的键值对关系对象
    				Map.Entry<String, String> studentEntry = studentIt.next();
    				//studentEntry方法 getKey getValue
    				String numKey = studentEntry.getKey();
    				String nameValue = studentEntry.getValue();
    				System.out.println(classNameKey+".."+numKey+".."+nameValue);
    			}
    		}
    	     System.out.println("==================================");
    		
    		for (Map.Entry<String, HashMap<String, String>> me : czbk.entrySet()) {
    			String classNameKey = me.getKey();
    			HashMap<String, String> numNameMapValue = me.getValue();
    			for (Map.Entry<String, String> nameMapEntry : numNameMapValue.entrySet()) {
    				String numKey = nameMapEntry.getKey();
    				String nameValue = nameMapEntry.getValue();
    				System.out.println(classNameKey + ".." + numKey + ".." + nameValue);
    			}
    		}
    	}
    	
    
    }


=======================第四节课开始=============================================
        
### 17斗地主的功能分析
   A:斗地主的功能分析
	   a:具体规则：
		   	1. 组装54张扑克牌
		    2. 将54张牌顺序打乱
		   	3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
		   	4. 查看三人各自手中的牌（按照牌的大小排序）、底牌
       b:分析:
	      1.准备牌：
	       完成数字与纸牌的映射关系：
	       使用双列Map(HashMap)集合，完成一个数字与字符串纸牌的对应关系(相当于一个字典)。
	      2.洗牌：
	       通过数字完成洗牌发牌
	      3.发牌：
	       将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
	       存放的过程中要求数字大小与斗地主规则的大小对应。
	       将代表不同纸牌的数字分配给不同的玩家与底牌。
	      4.看牌：
	       通过Map集合找到对应字符展示。
	       通过查询纸牌与数字的对应关系，由数字转成纸牌字符串再进行展示。

### 18斗地主的准备牌
   A:斗地主的准备牌
     /*
      *  实现模拟斗地主的功能
      *   1. 组合牌
      *   2. 洗牌
      *   3. 发牌
      *   4. 看牌
      */
     public class DouDiZhu {
     	public static void main(String[] args) {
     		//1. 组合牌
     		//创建Map集合,键是编号,值是牌
     		HashMap<Integer,String> pooker = new HashMap<Integer, String>();
     		//创建List集合,存储编号
     		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
     		//定义出13个点数的数组
     		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
     		//定义4个花色数组
     		String[] colors = {"♠","♥","♣","♦"};
     		//定义整数变量,作为键出现
     		int index = 2;
     		//遍历数组,花色+点数的组合,存储到Map集合
     		for(String number : numbers){
     			for(String color : colors){
     				pooker.put(index, color+number);
     				pookerNumber.add(index);
     				index++;
     			}
     		}
     		//存储大王,和小王,索引是从0~54,对应大王,小王,...3(牌的顺序从大到小)
     		pooker.put(0, "大王");
     		pookerNumber.add(0);
     		pooker.put(1, "小王");
     		pookerNumber.add(1);
     	 
     }


### 19斗地主的洗牌
    A:斗地主的洗牌
	  /*
	   *  实现模拟斗地主的功能
	   *   1. 组合牌
	   *   2. 洗牌
	   *   3. 发牌
	   *   4. 看牌
	   */
	  public class DouDiZhu {
	  	public static void main(String[] args) {
	  		//1. 组合牌
	  		//创建Map集合,键是编号,值是牌
	  		HashMap<Integer,String> pooker = new HashMap<Integer, String>();
	  		//创建List集合,存储编号
	  		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
	  		//定义出13个点数的数组
	  		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
	  		//定义4个花色数组
	  		String[] colors = {"♠","♥","♣","♦"};
	  		//定义整数变量,作为键出现
	  		int index = 2;
	  		//遍历数组,花色+点数的组合,存储到Map集合
	  		for(String number : numbers){
	  			for(String color : colors){
	  				pooker.put(index, color+number);
	  				pookerNumber.add(index);
	  				index++;
	  			}
	  		}
	  		//存储大王,和小王
	  		pooker.put(0, "大王");
	  		pookerNumber.add(0);
	  		pooker.put(1, "小王");
	  		pookerNumber.add(1);
	  		
	  		//洗牌,将牌的编号打乱
	  		Collections.shuffle(pookerNumber);
	  		
	  	 
	  	}
	  	 
	  }
   

### 20斗地主的发牌
  A:斗地主的发牌
    /*
     *  实现模拟斗地主的功能
     *   1. 组合牌
     *   2. 洗牌
     *   3. 发牌
     *   4. 看牌
     */
    public class DouDiZhu {
    	public static void main(String[] args) {
    		//1. 组合牌
    		//创建Map集合,键是编号,值是牌
    		HashMap<Integer,String> pooker = new HashMap<Integer, String>();
    		//创建List集合,存储编号
    		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
    		//定义出13个点数的数组
    		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
    		//定义4个花色数组
    		String[] colors = {"♠","♥","♣","♦"};
    		//定义整数变量,作为键出现
    		int index = 2;
    		//遍历数组,花色+点数的组合,存储到Map集合
    		for(String number : numbers){
    			for(String color : colors){
    				pooker.put(index, color+number);
    				pookerNumber.add(index);
    				index++;
    			}
    		}
    		//存储大王,和小王
    		pooker.put(0, "大王");
    		pookerNumber.add(0);
    		pooker.put(1, "小王");
    		pookerNumber.add(1);
    		
    		//洗牌,将牌的编号打乱
    		Collections.shuffle(pookerNumber);
    		
    		//发牌功能,将牌编号,发给玩家集合,底牌集合
    		ArrayList<Integer> player1 = new ArrayList<Integer>();
    		ArrayList<Integer> player2 = new ArrayList<Integer>();
    		ArrayList<Integer> player3 = new ArrayList<Integer>();
    		ArrayList<Integer> bottom = new ArrayList<Integer>();
    		
    		//发牌采用的是集合索引%3
    		for(int i = 0 ; i < pookerNumber.size() ; i++){
    			//先将底牌做好
    			if(i < 3){
    				//存到底牌去
    				bottom.add( pookerNumber.get(i));
    			   //对索引%3判断
    			}else if(i % 3 == 0){
    				//索引上的编号,发给玩家1
    				player1.add( pookerNumber.get(i) );
    			}else if( i % 3 == 1){
    				//索引上的编号,发给玩家2
    				player2.add( pookerNumber.get(i) );
    			}else if( i % 3 == 2){
    				//索引上的编号,发给玩家3
    				player3.add( pookerNumber.get(i) );
    			}
    		}
    		 
    	}
    	 
    }

### 21斗地主的看牌
  A:斗地主的看牌
     /*
      *  实现模拟斗地主的功能
      *   1. 组合牌
      *   2. 洗牌
      *   3. 发牌
      *   4. 看牌
      */
     public class DouDiZhu {
     	public static void main(String[] args) {
     		//1. 组合牌
     		//创建Map集合,键是编号,值是牌
     		HashMap<Integer,String> pooker = new HashMap<Integer, String>();
     		//创建List集合,存储编号
     		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
     		//定义出13个点数的数组
     		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
     		//定义4个花色数组
     		String[] colors = {"♠","♥","♣","♦"};
     		//定义整数变量,作为键出现
     		int index = 2;
     		//遍历数组,花色+点数的组合,存储到Map集合
     		for(String number : numbers){
     			for(String color : colors){
     				pooker.put(index, color+number);
     				pookerNumber.add(index);
     				index++;
     			}
     		}
     		//存储大王,和小王
     		pooker.put(0, "大王");
     		pookerNumber.add(0);
     		pooker.put(1, "小王");
     		pookerNumber.add(1);
     		
     		//洗牌,将牌的编号打乱
     		Collections.shuffle(pookerNumber);
     		
     		//发牌功能,将牌编号,发给玩家集合,底牌集合
     		ArrayList<Integer> player1 = new ArrayList<Integer>();
     		ArrayList<Integer> player2 = new ArrayList<Integer>();
     		ArrayList<Integer> player3 = new ArrayList<Integer>();
     		ArrayList<Integer> bottom = new ArrayList<Integer>();
     		
     		//发牌采用的是集合索引%3
     		for(int i = 0 ; i < pookerNumber.size() ; i++){
     			//先将底牌做好
     			if(i < 3){
     				//存到底牌去
     				bottom.add( pookerNumber.get(i));
     			   //对索引%3判断
     			}else if(i % 3 == 0){
     				//索引上的编号,发给玩家1
     				player1.add( pookerNumber.get(i) );
     			}else if( i % 3 == 1){
     				//索引上的编号,发给玩家2
     				player2.add( pookerNumber.get(i) );
     			}else if( i % 3 == 2){
     				//索引上的编号,发给玩家3
     				player3.add( pookerNumber.get(i) );
     			}
     		}
     		//对玩家手中的编号排序
     		Collections.sort(player1);
     		Collections.sort(player2);
     		Collections.sort(player3);
     		//看牌,将玩家手中的编号,到Map集合中查找,根据键找值
     		//定义方法实现
     		look("刘德华",player1,pooker);
     		look("张曼玉",player2,pooker);
     		look("林青霞",player3,pooker);
     		look("底牌",bottom,pooker);
     	}
     	public static void look(String name,ArrayList<Integer> player,HashMap<Integer,String> pooker){
     		//遍历ArrayList集合,获取元素,作为键,到集合Map中找值
     		System.out.print(name+" ");
     		for(Integer key : player){
     			String value = pooker.get(key);
     			System.out.print(value+" ");
     		}
     		System.out.println();
     	}
     }