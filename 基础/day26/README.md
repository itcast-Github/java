今日内容介绍
```
1、多线程
2、线程池
```
 

 


=======================第一节课开始=============================================

### 01进程概念
*A:进程概念 
   *a:进程：进程指正在运行的程序。确切的来说，当一个程序进入内存运行，
        即变成一个进程，进程是处于运行过程中的程序，并且具有一定独立功能。

### 02线程的概念 
 *A:线程的概念
   *a:线程：线程是进程中的一个执行单元(执行路径)，负责当前进程中程序的执行，
          一个进程中至少有一个线程。一个进程中是可以有多个线程的，
          这个应用程序也可以称之为多线程程序。
    简而言之：一个程序运行后至少有一个进程，一个进程中可以包含多个线程

### 03深入线程的概念
  A:深入线程的概念
    什么是多线程呢？
     即就是一个程序中有多个线程在同时执行。
     一个核心的CPU在多个线程之间进行着随即切换动作,由于切换时间很短(毫秒甚至是纳秒级别),导致我们感觉不出来
    
    单线程程序：即，若有多个任务只能依次执行。当上一个任务执行结束后，下一个任务开始执行。如去            网吧上网，网吧只能让一个人上网，当这个人下机后，下一个人才能上网。
    多线程程序：即，若有多个任务可以同时执行。如，去网吧上网，网吧能够让多个人同时上网。

### 04迅雷的多线程下载
   A:迅雷的多线程下载
     多线程,每个线程都读一个文件

### 05线程的运行模式
   A:线程的运行模式
    a:分时调度
      所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间。
    
    b:抢占式调度
     优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)，Java使用的为抢占式调度。
    
     大部分操作系统都支持多进程并发运行，现在的操作系统几乎都支持同时运行多个程序。比如：现在我们上课一边使用编辑器，一边使用录屏软件，同时还开着画图板，dos窗口等软件。此时，这些程序是在同时运行，”感觉这些软件好像在同一时刻运行着“。

     实际上，CPU(中央处理器)使用抢占式调度模式在多个线程间进行着高速的切换。对于CPU的一个核而言，某个时刻，只能执行一个线程，而 CPU的在多个线程间切换速度相对我们的感觉要快，看上去就是在同一时刻运行。
     其实，多线程程序并不能提高程序的运行速度，但能够提高程序运行效率，让CPU的使用率更高。


 
### 06main的主线程
  *A:main的主线程
    /*
     *  程序中的主线程
     */
    public class Demo {
      public static void main(String[] args) {
        System.out.println(0/0);
        function();
        System.out.println(Math.abs(-9));
      }
      
      public static void function(){
        for(int i = 0 ; i < 10000;i++){
          System.out.println(i);
        }
      }
    }



=======================第二节课开始=============================================
### 07Thread类介绍
  A:Thread类介绍:Thread是程序中的执行线程。Java 虚拟机允许应用程序并发地运行多个执行线程。
     发现创建新执行线程有两种方法。
     a:一种方法是将类声明为 Thread 的子类。该子类应重写 Thread 类的 run 方法。创建对象，开启线程。run方法相当于其他线程的main方法。
     b:另一种方法是声明一个实现 Runnable 接口的类。该类然后实现 run 方法。然后创建Runnable的子类对象，传入到某个线程的构造方法中，开启线程。


### 08实现线程程序继承Thread
   *A:实现线程程序继承Thread
	    /*
       * 创建和启动一个线程
       *   创建Thread子类对象
       *   子类对象调用方法start()
       *      让线程程序执行,JVM调用线程中的run
       */
      public class ThreadDemo {
        public static void main(String[] args) {
          SubThread st = new SubThread();
          SubThread st1 = new SubThread();
          st.start();
          st1.start();
          for(int i = 0; i < 50;i++){
            System.out.println("main..."+i);
          }
        }
      }
      /*
       *  定义子类,继承Thread 
       *  重写方法run 
       */
      public class SubThread  extends Thread{
        public void run(){
          for(int i = 0; i < 50;i++){
            System.out.println("run..."+i);
          }
        }
      }

	 


### 09线程执行的随机性
   *A:线程执行的随机性
    /*
      代码分析:
         整个程序就只有三个线程,
         一个是主线程
           启动另外两个线程
            st.start();
            st1.start();
            for(int i = 0; i < 50;i++){
              System.out.println("main..."+i);
            }
         一个是st(Thread-0)线程
         for(int i = 0; i < 50;i++){
           System.out.println("run..."+i);
         }
         一个是st1(Thread-1)线程下 

    */
     public class ThreadDemo {
       public static void main(String[] args) {
         SubThread st = new SubThread();
         SubThread st1 = new SubThread();
         st.start();
         st1.start();
         for(int i = 0; i < 50;i++){
           System.out.println("main..."+i);
         }
       }
     }
     /*
      *  定义子类,继承Thread 
      *  重写方法run 
      */
     public class SubThread  extends Thread{
       public void run(){
         for(int i = 0; i < 50;i++){
           System.out.println("run..."+i);
         }
       }
     }


### 10为什么要继承Thread
   *A:什么要继承Thread
    a:我们为什么要继承Thread类，并调用其的start方法才能开启线程呢？
       继承Thread类：因为Thread类用来描述线程，具备线程应该有功能。那为什么不直接创建Thread类的对象呢？
       如下代码：
        Thread t1 = new Thread();
        t1.start();//这样做没有错，但是该start调用的是Thread类中的run方法
                  //而这个run方法没有做什么事情，更重要的是这个run方法中并没有定义我们需要让线程执行的代码。

    b:创建线程的目的是什么？
     是为了建立程序单独的执行路径，让多部分代码实现同时执行。也就是说线程创建并执行需要给定线程要执行的任务。
     对于之前所讲的主线程，它的任务定义在main函数中。自定义线程需要执行的任务都定义在run方法中。

### 11多线程内存图解
   *A:多线程内存图解
      多线程执行时，到底在内存中是如何运行的呢？
        多线程执行时，在栈内存中，其实每一个执行线程都有一片自己所属的栈内存空间。进行方法的压栈和弹栈。
        当执行线程的任务结束了，线程自动在栈内存中释放了。但是当所有的执行线程都结束了，那么进程就结束了。
 

=======================第三节课开始=============================================
### 12获取线程名字Thread类方法getName
   *A:获取线程名字Thread类方法getName 
    /*
     *  获取线程名字,父类Thread方法
     *    String getName()
     */
    public class NameThread extends Thread{
      
      public NameThread(){
        super("小强");
      }
      
      public void run(){
        System.out.println(getName());
      }
    }
    
    /*
     *  每个线程,都有自己的名字
     *  运行方法main线程,名字就是"main"
     *  其他新键的线程也有名字,默认 "Thread-0","Thread-1"
     *  
     *  JVM开启主线程,运行方法main,主线程也是线程,是线程必然就是
     *  Thread类对象
     */
    public class ThreadDemo {
      public static void main(String[] args) {
        NameThread nt = new NameThread();
        nt.start();
        
         

      }
    }
### 13获取线程名字Thread类方法currentThread
  *A:获取线程名字Thread类方法currentThread
   /*
    *  获取线程名字,父类Thread方法
    *    String getName()
    */
   public class NameThread extends Thread{

     public void run(){
       System.out.println(getName());
     }
   }
   
   /*
    *  每个线程,都有自己的名字
    *  运行方法main线程,名字就是"main"
    *  其他新键的线程也有名字,默认 "Thread-0","Thread-1"
    *  
    *  JVM开启主线程,运行方法main,主线程也是线程,是线程必然就是
    *  Thread类对象
    *  Thread类中,静态方法
    *   static Thread currentThread()返回正在执行的线程对象
    */
   public class ThreadDemo {
     public static void main(String[] args) {
       NameThread nt = new NameThread();
       nt.start();
       
       /*Thread t =Thread.currentThread();
       System.out.println(t.getName());*/
       System.out.println(Thread.currentThread().getName());


     }
   }
 
### 14线程名字设置
   A:线程名字设置
      /*
       *  获取线程名字,父类Thread方法
       *    String getName()
       */
      public class NameThread extends Thread{
        
        public NameThread(){
          super("小强");
        }
        
        public void run(){
          System.out.println(getName());
        }
      }
      
      /*
       *  每个线程,都有自己的名字
       *  运行方法main线程,名字就是"main"
       *  其他新键的线程也有名字,默认 "Thread-0","Thread-1"
       *  
       *  JVM开启主线程,运行方法main,主线程也是线程,是线程必然就是
       *  Thread类对象
       *  Thread类中,静态方法
       *   static Thread currentThread()返回正在执行的线程对象
       */
      public class ThreadDemo {
        public static void main(String[] args) {
          NameThread nt = new NameThread();
          nt.setName("旺财");
          nt.start();

        }
      }


### 15Thread类方法sleep
   A:Thread类方法sleep
     public class ThreadDemo {
      public static void main(String[] args) throws Exception{
        /*for(int i = 0 ; i < 5 ;i++){
          Thread.sleep(50);
          System.out.println(i);
        }*/
        
        new SleepThread().start();
      }
     }
     
     public class SleepThread extends Thread{
      public void run(){
        for(int i = 0 ; i < 5 ;i++){
          try{
            Thread.sleep(500);//睡眠500ms,500ms已到并且cpu切换到该线程继续向下执行
          }catch(Exception ex){
            
          }
          System.out.println(i);
        }
      }
     }

 
   
### 16实现线程的另一种方式实现Runnable接口
   A:实现线程的另一种方式实现Runnable接口
	   /*
      *  实现接口方式的线程
      *    创建Thread类对象,构造方法中,传递Runnable接口实现类
      *    调用Thread类方法start()
      */
     public class ThreadDemo {
      public static void main(String[] args) {
        SubRunnable sr = new SubRunnable();
        Thread t = new Thread(sr);
        t.start();
        for(int i = 0 ; i < 50; i++){
          System.out.println("main..."+i);
        }
      }
     }
   
     /*
      *  实现线程成功的另一个方式,接口实现
      *  实现接口Runnable,重写run方法
      */
     public class SubRunnable implements Runnable{
      public void run(){
        for(int i = 0 ; i < 50; i++){
          System.out.println("run..."+i);
        }
      }
     }


### 17实现接口方式的好处 
    A:实现接口方式的好处
     第二种方式实现Runnable接口避免了单继承的局限性，所以较为常用。
     实现Runnable接口的方式，更加的符合面向对象，线程分为两部分，一部分线程对象，一部分线程任务。
     继承Thread类，线程对象和线程任务耦合在一起。
     一旦创建Thread类的子类对象，既是线程对象，有又有线程任务。
     实现runnable接口，将线程任务单独分离出来封装成对象，类型就是Runnable接口类型。Runnable接口对线程对象和线程任务进行解耦。
     (降低紧密性或者依赖性,创建线程和执行任务不绑定)

### 18匿名内部类实现线程程序 
    *A:匿名内部类实现线程程序 
    /*
     *  使用匿名内部类,实现多线程程序
     *  前提: 继承或者接口实现
     *  new 父类或者接口(){
     *     重写抽象方法
     *  }
     */
    public class ThreadDemo {
      public static void main(String[] args) {
        //继承方式  XXX extends Thread{ public void run(){}}
        new Thread(){
          public void run(){
            System.out.println("!!!");
          }
        }.start();
        
        //实现接口方式  XXX implements Runnable{ public void run(){}}
        
        Runnable r = new Runnable(){
          public void run(){
            System.out.println("### ");
          }
        };
        new Thread(r).start();
        
        
        new Thread(new Runnable(){
          public void run(){
            System.out.println("@@@");
          }
        }).start();
        
      }
    }
=======================第四节课开始=============================================

### 19线程的状态图
   A:线程的状态图
	    a:参见线程状态图.jpg

### 20线程池的原理
   A:线程池的原理
      1.在java中，如果每个请求到达就创建一个新线程，开销是相当大的。
      2.在实际使用中，创建和销毁线程花费的时间和消耗的系统资源都相当大，甚至可能要比在处理实际的用户请求的时间和资源要多的多。
      3.除了创建和销毁线程的开销之外，活动的线程也需要消耗系统资源。
        如果在一个jvm里创建太多的线程，可能会使系统由于过度消耗内存或“切换过度”而导致系统资源不足。
        为了防止资源不足，需要采取一些办法来限制任何给定时刻处理的请求数目，尽可能减少创建和销毁线程的次数，特别是一些资源耗费比较大的线程的创建和销毁，尽量利用已有对象来进行服务。
      线程池主要用来解决线程生命周期开销问题和资源不足问题。通过对多个任务重复使用线程，线程创建的开销就被分摊到了多个任务上了，而且由于在请求到达时线程已经存在，所以消除了线程创建所带来的延迟。这样，就可以立即为请求服务，使用应用程序响应更快。另外，通过适当的调整线程中的线程数目可以防止出现资源不足的情况。


### 21JDK5实现线程池
    A:JDK5实现线程池
	    /*
       *  JDK1.5新特性,实现线程池程序
       *  使用工厂类 Executors中的静态方法创建线程对象,指定线程的个数
       *   static ExecutorService newFixedThreadPool(int 个数) 返回线程池对象
       *   返回的是ExecutorService接口的实现类 (线程池对象)
       *   
       *   接口实现类对象,调用方法submit (Ruunable r) 提交线程执行任务
       *          
       */
      public class ThreadPoolDemo {
        public static void main(String[] args) {
          //调用工厂类的静态方法,创建线程池对象
          //返回线程池对象,是返回的接口
          ExecutorService es = Executors.newFixedThreadPool(2);
            //调用接口实现类对象es中的方法submit提交线程任务
          //将Runnable接口实现类对象,传递
          es.submit(new ThreadPoolRunnable());
          es.submit(new ThreadPoolRunnable());
          es.submit(new ThreadPoolRunnable());
        
        }
      }

      public class ThreadPoolRunnable implements Runnable {
        public void run(){
          System.out.println(Thread.currentThread().getName()+" 线程提交任务");
        }
      }


### 22实现线程的Callable接口方式
  A:实现线程的Callable接口方式
     /*
      *  实现线程程序的第三个方式,实现Callable接口方式
      *  实现步骤
      *    工厂类 Executors静态方法newFixedThreadPool方法,创建线程池对象
      *    线程池对象ExecutorService接口实现类,调用方法submit提交线程任务
      *    submit(Callable c)
      */
     public class ThreadPoolDemo1 {
      public static void main(String[] args)throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2);
        //提交线程任务的方法submit方法返回 Future接口的实现类
        Future<String> f = es.submit(new ThreadPoolCallable());
        String s = f.get();
        System.out.println(s);
      }
     }
     /*
      * Callable 接口的实现类,作为线程提交任务出现
      * 使用方法返回值
      */

     import java.util.concurrent.Callable;

     public class ThreadPoolCallable implements Callable<String>{
      public String call(){
        return "abc";
      }
     }


### 23线程实现异步计算
  A:线程实现异步计算


    /*
     * 使用多线程技术,求和
     * 两个线程,1个线程计算1+100,另一个线程计算1+200的和
     * 多线程的异步计算
     */
    public class ThreadPoolDemo {
      public static void main(String[] args)throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f1 =es.submit(new GetSumCallable(100));
        Future<Integer> f2 =es.submit(new GetSumCallable(200));
        System.out.println(f1.get());
        System.out.println(f2.get());
        es.shutdown();
      }
    }

     

    public class GetSumCallable implements Callable<Integer>{
      private int a;
      public GetSumCallable(int a){
        this.a=a;
      }
      
      public Integer call(){
        int sum = 0 ;
        for(int i = 1 ; i <=a ; i++){
          sum = sum + i ;
        }
        return sum;
      }
    }
