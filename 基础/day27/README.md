今日内容介绍
```
1、多线程安全问题
2、等待唤醒机制
```
 
 


=======================第一节课开始=============================================

### 01线程操作共享数据的安全问题
  *A:线程操作共享数据的安全问题
    如果有多个线程在同时运行，而这些线程可能会同时运行这段代码。
    程序每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。
  
### 02售票的案例
 *A:售票的案例
     /*
      * 多线程并发访问同一个数据资源
      * 3个线程,对一个票资源,出售
      */
     public class ThreadDemo {
      public static void main(String[] args) {
        //创建Runnable接口实现类对象
        Tickets t = new Tickets();
        //创建3个Thread类对象,传递Runnable接口实现类
        Thread t0 = new Thread(t);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        
        t0.start();
        t1.start();
        t2.start();
        
      }
     }
    
     public class Tickets implements Runnable{
      
      //定义出售的票源
      private int ticket = 100;
      private Object obj = new Object();
      
      public void run(){
        while(true){
       
            if( ticket > 0){
              
              System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
            }
          
        }
      }
     }


### 03线程安全问题引发
 *A:线程安全问题引发
    /*
     * 多线程并发访问同一个数据资源
     * 3个线程,对一个票资源,出售
     */
    public class ThreadDemo {
     public static void main(String[] args) {
       //创建Runnable接口实现类对象
       Tickets t = new Tickets();
       //创建3个Thread类对象,传递Runnable接口实现类
       Thread t0 = new Thread(t);
       Thread t1 = new Thread(t);
       Thread t2 = new Thread(t);
       
       t0.start();
       t1.start();
       t2.start();
       
     }
    }
    /*
     *  通过线程休眠,出现安全问题
     */
    public class Tickets implements Runnable{
     
     //定义出售的票源
     private int ticket = 100;
     private Object obj = new Object();
     
     public void run(){
       while(true){
 
         //对票数判断,大于0,可以出售,变量--操作
           if( ticket > 0){
             try{
                Thread.sleep(10); //加了休眠让其他线程有执行机会
             }catch(Exception ex){}
             System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
           }
       }
     }
    }

### 04同步代码块解决线程安全问题
  *A:同步代码块解决线程安全问题
      *A:售票的案例
          /*
           * 多线程并发访问同一个数据资源
           * 3个线程,对一个票资源,出售
           */
          public class ThreadDemo {
           public static void main(String[] args) {
             //创建Runnable接口实现类对象
             Tickets t = new Tickets();
             //创建3个Thread类对象,传递Runnable接口实现类
             Thread t0 = new Thread(t);
             Thread t1 = new Thread(t);
             Thread t2 = new Thread(t);
             
             t0.start();
             t1.start();
             t2.start();
             
           }
          }
          /*
           *  通过线程休眠,出现安全问题
           *  解决安全问题,Java程序,提供技术,同步技术
           *  公式:
           *    synchronized(任意对象){
           *      线程要操作的共享数据
           *    }
           *    同步代码块
           */
          public class Tickets implements Runnable{
           
           //定义出售的票源
           private int ticket = 100;
           private Object obj = new Object();
           
           public void run(){
             while(true){
               //线程共享数据,保证安全,加入同步代码块
               synchronized(obj){
               //对票数判断,大于0,可以出售,变量--操作
                 if( ticket > 0){
                   try{
                      Thread.sleep(10);
                   }catch(Exception ex){}
                   System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
                 }
               }
             }
           }
          }

### 05同步代码块的执行原理
   A:同步代码块的执行原理
     同步代码块: 在代码块声明上 加上synchronized
     synchronized (锁对象) {
       可能会产生线程安全问题的代码
     }
     同步代码块中的锁对象可以是任意的对象；但多个线程时，要使用同一个锁对象才能够保证线程安全。


=======================第二节课开始============================================= 
### 06同步的上厕所原理
  *A:同步的上厕所原理
    a:不使用同步:线程在执行的过程中会被打扰
       线程比喻成人
       线程执行代码就是上一个厕所
      第一个人正在上厕所,上到一半,被另外一个人拉出来
    b:使用同步:
       线程比喻成人
       线程执行代码就是上一个厕所
       锁比喻成厕所门
      第一个人上厕所,会锁门
      第二个人上厕所,看到门锁上了,等待第一个人上完再去上厕所


### 07同步方法
  *A:同步方法:
  /*
   * 多线程并发访问同一个数据资源
   * 3个线程,对一个票资源,出售
   */
  public class ThreadDemo {
    public static void main(String[] args) {
      //创建Runnable接口实现类对象
      Tickets t = new Tickets();
      //创建3个Thread类对象,传递Runnable接口实现类
      Thread t0 = new Thread(t);
      Thread t1 = new Thread(t);
      Thread t2 = new Thread(t);
      
      t0.start();
      t1.start();
      t2.start();
      
    }
  }

  *A:同步方法
     /*
      *  采用同步方法形式,解决线程的安全问题
      *  好处: 代码简洁
      *  将线程共享数据,和同步,抽取到一个方法中
      *  在方法的声明上,加入同步关键字
      *  
      *  问题:
      *    同步方法有锁吗,肯定有,同步方法中的对象锁,是本类对象引用 this
      *    如果方法是静态的呢,同步有锁吗,绝对不是this
      *    锁是本类自己.class 属性
      *    静态方法,同步锁,是本类类名.class属性
      */
     public class Tickets implements Runnable{

      //定义出售的票源
      private  int ticket = 100;
      
      public void run(){
        while(true){
          payTicket();
        }
      }
      
      public  synchronized void payTicket(){  
          if( ticket > 0){
            try{
               Thread.sleep(10);
            }catch(Exception ex){}
            System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
          }
        
      }
     }



### 08JDK1.5新特性Lock接口
   *A:JDK1.5新特性Lock接口
	    查阅API，查阅Lock接口描述，Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。
       Lock接口中的常用方法
            void lock()
            void unlock()
      Lock提供了一个更加面对对象的锁，在该锁中提供了更多的操作锁的功能。
      我们使用Lock接口,以及其中的lock()方法和unlock()方法替代同步，对电影院卖票案例中Ticket



### 09Lock接口改进售票案例
   *A:Lock接口改进售票案例
      /*
       * 多线程并发访问同一个数据资源
       * 3个线程,对一个票资源,出售
       */
      public class ThreadDemo {
        public static void main(String[] args) {
          //创建Runnable接口实现类对象
          Tickets t = new Tickets();
          //创建3个Thread类对象,传递Runnable接口实现类
          Thread t0 = new Thread(t);
          Thread t1 = new Thread(t);
          Thread t2 = new Thread(t);
          
          t0.start();
          t1.start();
          t2.start();
          
        }
      }
      /*
       *  使用JDK1.5 的接口Lock,替换同步代码块,实现线程的安全性
       *  Lock接口方法:
       *     lock() 获取锁
       *     unlock()释放锁
       *  实现类ReentrantLock
       */
      public class Tickets implements Runnable{
        
        //定义出售的票源
        private int ticket = 100;
        //在类的成员位置,创建Lock接口的实现类对象
        private Lock lock = new ReentrantLock();
        
        public void run(){
          while(true){
            //调用Lock接口方法lock获取锁
              lock.lock();
            //对票数判断,大于0,可以出售,变量--操作
              if( ticket > 0){
                try{
                   Thread.sleep(10);
                   System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
                }catch(Exception ex){
                  
                }finally{
                  //释放锁,调用Lock接口方法unlock
                  lock.unlock();
                }
              }
          }
        }
      }

=======================第三节课开始============================================= 
### 10线程的死锁原理
   *A:线程的死锁原理  
     当线程任务中出现了多个同步(多个锁)  时，如果同步中嵌套了其他的同步。这时容易引发一种现象：程序出现无限等待，这种现象我们称为死锁。这种情况能避免就避免掉。
        synchronzied(A锁){
            synchronized(B锁){
                      
            }
        }


### 11线程的死锁代码实现
   *A:线程的死锁代码实现
       public class DeadLock implements Runnable{
        private int i = 0;
        public void run(){
          while(true){
            if(i%2==0){
              //先进入A同步,再进入B同步
              synchronized(LockA.locka){
                System.out.println("if...locka");
                synchronized(LockB.lockb){
                  System.out.println("if...lockb");
                }
              }
            }else{
              //先进入B同步,再进入A同步
              synchronized(LockB.lockb){
                System.out.println("else...lockb");
                synchronized(LockA.locka){
                  System.out.println("else...locka");
                }
              }
            }
            i++;
          }
        }
       }
    
      public class DeadLockDemo {
        public static void main(String[] args) {
          DeadLock dead = new DeadLock();
          Thread t0 = new Thread(dead);
          Thread t1 = new Thread(dead);
          t0.start();
          t1.start();
        }
      }


      public class LockA {
        private LockA(){}
        
        public  static final LockA locka = new LockA();
      }

      
      public class LockB {
        private LockB(){}
        
        public static final LockB lockb = new LockB();
      }



 ### 12线程等待与唤醒案例介绍
   *A:线程等待与唤醒案例介绍 
     等待唤醒机制所涉及到的方法：
         wait（） :等待，将正在执行的线程释放其执行资格 和 执行权，并存储到线程池中。
         notify（）：唤醒，唤醒线程池中被wait（）的线程，一次唤醒一个，而且是任意的。
         notifyAll（）： 唤醒全部：可以将线程池中的所有wait() 线程都唤醒。
       其实，所谓唤醒的意思就是让 线程池中的线程具备执行资格。必须注意的是，这些方法都是在 同步中才有效。同时这些方法在使用时必须标明所属锁，这样才可以明确出这些方法操作的到底是哪个锁上的线程。




### 13线程等待与唤醒案例资源类编写
  *A:线程等待与唤醒案例资源类编写
    /*
     *  定义资源类,有2个成员变量
     *  name,sex
     *  同时有2个线程,对资源中的变量操作
     *  1个对name,age赋值
     *  2个对name,age做变量的输出打印
     */
    public class Resource {
      public String name;
      public String sex;
    }

 
### 14线程等待与唤醒案例输入和输出线程
   A:线程等待与唤醒案例输入和输出线程
     /*
       *  输入的线程,对资源对象Resource中成员变量赋值
       *  一次赋值 张三,男
       *  下一次赋值 lisi,nv
     */
      public class Input implements Runnable {
        private Resource r=new Resource();
       
        public void run() {
          int i=0;
          while(true){
            if(i%2==0){
               r.name="张三";
               r.sex="男";
             }else{
                r.name="lisi";
                r.sex="女";
              }
            i++;
          }
        }
      }

      /*
       *  输出线程,对资源对象Resource中成员变量,输出值
       */
      public class Output implements Runnable {
        private Resource r=new Resource() ;
         
        public void run() {
          while(true){
             System.out.println(r.name+"..."+r.sex); 
            }
          }
      }

=================================第四节课=========================================
### 15线程等待与唤醒案例测试类
   A:线程等待与唤醒案例测试类
      /*
       *  开启输入线程和输出线程,实现赋值和打印值
       */
      public class ThreadDemo{
        public static void main(String[] args) {
          
          Resource r = new Resource();
          
          Input in = new Input();
          Output out = new Output();
          
          Thread tin = new Thread(in);
          Thread tout = new Thread(out);
          
          tin.start();
          tout.start();
        }
      }


 
   
### 16线程等待与唤醒案例null值解决
   A:线程等待与唤醒案例null值解决
	    /*
        *  输入的线程,对资源对象Resource中成员变量赋值
        *  一次赋值 张三,男
        *  下一次赋值 lisi,nv
      */
       public class Input implements Runnable {
         private Resource r;
         public Input(Resource r){
           this.r=r;
         }
        
         public void run() {
           int i=0;
           while(true){
             if(i%2==0){
                r.name="张三";
                r.sex="男";
              }else{
                 r.name="lisi"
                 r.sex="女"
               }
             i++;
           }
         }
       }

       /*
        *  输出线程,对资源对象Resource中成员变量,输出值
        */ 
       public class Output implements Runnable {
         private Resource r;
         public Output(Resource r){
            this.r=r;
         } 
         public void run() {
           while(true){
              System.out.println(r.name+"..."+r.sex); 
             }
           }
         }

       }
       /*
        *  开启输入线程和输出线程,实现赋值和打印值
        */
       public class ThreadDemo{
         public static void main(String[] args) {
           
           Resource r = new Resource();
           
           Input in = new Input(r);
           Output out = new Output(r);
           
           Thread tin = new Thread(in);
           Thread tout = new Thread(out);
           
           tin.start();
           tout.start();
         }
       }



### 17线程等待与唤醒案例数据安全解决
    A:线程等待与唤醒案例数据安全解决
            /*
              *  输入的线程,对资源对象Resource中成员变量赋值
              *  一次赋值 张三,男
              *  下一次赋值 lisi,nv
            */
             public class Input implements Runnable {
               private Resource r;
               public Input(Resource r){
                 this.r=r;
               }
              
               public void run() {
                 int i=0;
                 while(true){
                  synchronized(r){
                   if(i%2==0){
                      r.name="张三";
                      r.sex="男";
                    }else{
                       r.name="lisi"
                       r.sex="女"
                     }
                   i++;
                 }

               }
             }

             /*
              *  输出线程,对资源对象Resource中成员变量,输出值
              */ 
             public class Output implements Runnable {
               private Resource r;
               public Output(Resource r){
                  this.r=r;
               } 
               public void run() {
                 while(true){
                    synchronized(r){
                     System.out.println(r.name+"..."+r.sex); 
                    }
                   }
                 }
               }

             }
             /*
              *  开启输入线程和输出线程,实现赋值和打印值
              */
             public class ThreadDemo{
               public static void main(String[] args) {
                 
                 Resource r = new Resource();
                 
                 Input in = new Input(r);
                 Output out = new Output(r);
                 
                 Thread tin = new Thread(in);
                 Thread tout = new Thread(out);
                 
                 tin.start();
                 tout.start();
               }
             }


### 18线程等待与唤醒案例通信的分析
    *A:线程等待与唤醒案例通信的分析
        输入:赋值后,执行方法wait()永远等待
        输出:变量值打印输出,在输出等待之前,唤醒
        输入的notify(),自己在wait()永远等待
        输入:被唤醒后,重新对变量赋值,赋值后,必须唤醒输出的线程notify(),
             自己的wait()

### 19线程等待与唤醒案例的实现
   *A 线程等待与唤醒案例的实现

     /*
      *  定义资源类,有2个成员变量
      *  name,sex
      *  同时有2个线程,对资源中的变量操作
      *  1个对name,age赋值
      *  2个对name,age做变量的输出打印
      */
     public class Resource {
      public String name;
      public String sex;
      public boolean flag = false;
     }

     /*
      *  输入的线程,对资源对象Resource中成员变量赋值
      *  一次赋值 张三,男
      *  下一次赋值 lisi,nv
      */
     public class Input implements Runnable {
      private Resource r ;
      
      public Input(Resource r){
        this.r = r;
      }
      
      public void run() {
        int i = 0 ;
        while(true){
          synchronized(r){
            //标记是true,等待
              if(r.flag){
                try{r.wait();}catch(Exception ex){}
              }
            
            if(i%2==0){
              r.name = "张三";
              r.sex = "男";
            }else{
              r.name = "lisi";
              r.sex = "nv";
            }
            //将对方线程唤醒,标记改为true
            r.flag = true;
            r.notify();
          }
          i++;
        }
      }

     }
     
     /*
      *  输出线程,对资源对象Resource中成员变量,输出值
      */
     public class Output implements Runnable {
      private Resource r ;
      
      public Output(Resource r){
        this.r = r;
      }
      public void run() {
        while(true){
          synchronized(r){  
            //判断标记,是false,等待
          if(!r.flag){
            try{r.wait();}catch(Exception ex){}
            }
          System.out.println(r.name+".."+r.sex);
          //标记改成false,唤醒对方线程
          r.flag = false;
          r.notify();
          }
        }
      }

     }

     /*
      *  开启输入线程和输出线程,实现赋值和打印值
      */
     public class ThreadDemo{
      public static void main(String[] args) {
        
        Resource r = new Resource();
        
        Input in = new Input(r);
        Output out = new Output(r);
        
        Thread tin = new Thread(in);
        Thread tout = new Thread(out);
        
        tin.start();
        tout.start();
      }
     }

### 20eclipse问题
   A:eclipse问题
   

 
