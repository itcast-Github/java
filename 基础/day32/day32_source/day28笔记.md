今日内容介绍
1、网络三要素及传输协议
2、实现UDP协议的发送端和接收端
3、实现TCP协议的客户端和服务器
4、TCP上传文件案例
 


=======================第一节课开始=============================================

###01网络模型
  *A:网络模型
     TCP/IP协议中的四层分别是应用层、传输层、网络层和链路层，每层分别负责不同的通信功能，接下来针对这四层进行详细地讲解。
       链路层：链路层是用于定义物理传输通道，通常是对某些网络连接设备的驱动协议，例如针对光纤、网线提供的驱动。
       网络层：网络层是整个TCP/IP协议的核心，它主要用于将传输的数据进行分组，将分组数据发送到目标计算机或者网络。
       传输层：主要使网络程序进行通信，在进行网络通信时，可以采用TCP协议，也可以采用UDP协议。
       应用层：主要负责应用程序的协议，例如HTTP协议、FTP协议等。

###02IP地址
 *A:IP地址
      在TCP/IP协议中，这个标识号就是IP地址，它可以唯一标识一台计算机，
      目前，IP地址广泛使用的版本是IPv4，它是由4个字节大小的二进制数来表示，如：00001010000000000000000000000001。
      由于二进制形式表示的IP地址非常不便记忆和处理，因此通常会将IP地址写成十进制的形式，
      每个字节用一个十进制数字(0-255)表示，数字间用符号“.”分开，如 “192.168.1.100”
      127.0.0.1 为本地主机地址(本地回环地址)
###03端口号
 *A:端口号
    通过IP地址可以连接到指定计算机，但如果想访问目标计算机中的某个应用程序，还需要指定端口号。
    在计算机中，不同的应用程序是通过端口号区分的。
    端口号是用两个字节（16位的二进制数）表示的，它的取值范围是0~65535，
    其中，0~1023之间的端口号用于一些知名的网络服务和应用，用户的普通应用程序需要使用1024以上的端口号，从而避免端口号被另外一个应用或服务所占用

###04InetAddress类
  *A:InetAddress类
     /*
      *  表示互联网中的IP地址
      *    java.net.InetAddress
      *  静态方法
      *    static InetAddress  getLocalHost()   LocalHost本地主机
      *    返回本地主机,返回值InetAddress对象
      *    
      *    static InetAddress getByName(String hostName)传递主机名,获取IP地址对象
      *    
      *  非静态方法
      *     String getHoustAddress()获取主机IP地址
      *     String getHoustName()获取主机名
      *    
      */
     public class InetAddressDemo {
      public static void main(String[] args)throws UnknownHostException {
        function_1();
      }
      /*
       * static InetAddress getByName(String hostName)传递主机名,获取IP地址对象
       */
      public static void function_1()throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet);
      }
      
      /*
       *  static InetAddress  getLocalHost()   LocalHost本地主机
       */
      public static void function() throws UnknownHostException{
        InetAddress inet = InetAddress.getLocalHost();
        //输出结果就是主机名,和 IP地址
        System.out.println(inet.toString());
        
        String ip = inet.getHostAddress();
        String name = inet.getHostName();
        System.out.println(ip+"   "+name);
        
        /*String host = inet.toString();
        String[] str = host.split("/");
        for(String s : str){
          System.out.println(s);
        }*/
      }
     }


###05UDP协议
   A:UDP协议
     a:UDP协议概述:
      UDP是无连接通信协议，即在数据传输时，数据的发送端和接收端不建立逻辑连接。
      简单来说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据。
     b:UDP协议特点:
      由于使用UDP协议消耗资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输例如视频会议都使用UDP协议，
      因为这种情况即使偶尔丢失一两个数据包，也不会对接收结果产生太大影响。


###06TCP协议
  *A:TCP协议
    TCP协议是面向连接的通信协议，即在传输数据前先在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间可靠无差错的数据传输。
    在TCP连接中必须要明确客户端与服务器端，
      由客户端向服务端发出连接请求，每次连接的创建都需要经过“三次握手”。
      第一次握手，客户端向服务器端发出连接请求，等待服务器确认
      第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求
      第三次握手，客户端再次向服务器端发送确认信息，确认连接

========================================第二节课=========================================
###07数据包和发送对象介绍
  *A:数据包和发送对象介绍:
    DatagramPacket数据包的作用就如同是“集装箱”，
       可以将发送端或者接收端的数据封装起来。然而运输货物只有“集装箱”是不够的，还需要有码头。
       在程序中需要实现通信只有DatagramPacket数据包也同样不行，为此JDK中提供的一个DatagramSocket类。
       DatagramSocket类的作用就类似于码头，使用这个类的实例对象就可以发送和接收DatagramPacket数据包
    DatagramPacket:封装数据
    DatagramSocket:发送DatagramPacket

###08UDP发送端
   *A:UDP发送端
	     /*
        *  实现UDP协议的发送端:
        *    实现封装数据的类 java.net.DatagramPacket  将你的数据包装
        *    实现数据传输的类 java.net.DatagramSocket  将数据包发出去
        *    
        *  实现步骤:
        *    1. 创建DatagramPacket对象,封装数据, 接收的地址和端口
        *    2. 创建DatagramSocket
        *    3. 调用DatagramSocket类方法send,发送数据包
        *    4. 关闭资源
        *    
        *    DatagramPacket构造方法:
        *      DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
        *      
        *    DatagramSocket构造方法:
        *      DatagramSocket()空参数
        *      方法: send(DatagramPacket d)
        *      
        */
       public class UDPSend {
        public static void main(String[] args) throws IOException{
          //创建数据包对象,封装要发送的数据,接收端IP,端口
          byte[] date = "你好UDP".getBytes();
          //创建InetAddress对象,封装自己的IP地址
          InetAddress inet = InetAddress.getByName("127.0.0.1");
          DatagramPacket dp = new DatagramPacket(date, date.length, inet,6000);
          //创建DatagramSocket对象,数据包的发送和接收对象
          DatagramSocket ds = new DatagramSocket();
          //调用ds对象的方法send,发送数据包
          ds.send(dp);
          //关闭资源
          ds.close();
        }
       }



###09UDP接收端
   *A:UDP接收端
       /*
        *  实现UDP接收端
        *    实现封装数据包 java.net.DatagramPacket 将数据接收
        *    实现输出传输     java.net.DatagramSocket 接收数据包
        *    
        *  实现步骤:
        *     1. 创建DatagramSocket对象,绑定端口号
        *         要和发送端端口号一致
        *     2. 创建字节数组,接收发来的数据
        *     3. 创建数据包对象DatagramPacket
        *     4. 调用DatagramSocket对象方法
        *        receive(DatagramPacket dp)接收数据,数据放在数据包中
        *     5. 拆包
        *          发送的IP地址
        *            数据包对象DatagramPacket方法getAddress()获取的是发送端的IP地址对象
        *            返回值是InetAddress对象
        *          接收到的字节个数
        *            数据包对象DatagramPacket方法 getLength()
        *          发送方的端口号
        *            数据包对象DatagramPacket方法 getPort()发送端口
        *     6. 关闭资源
        */
       public class UDPReceive {
        public static void main(String[] args)throws IOException {
          //创建数据包传输对象DatagramSocket 绑定端口号
          DatagramSocket ds = new DatagramSocket(6000);
          //创建字节数组
          byte[] data = new byte[1024];
          //创建数据包对象,传递字节数组
          DatagramPacket dp = new DatagramPacket(data, data.length);
          //调用ds对象的方法receive传递数据包
          ds.receive(dp);
          
      
        }
       }


###10UDP接收端的拆包
   *A:UDP接收端的拆包 
      
      /*
       *  实现UDP接收端
       *    实现封装数据包 java.net.DatagramPacket 将数据接收
       *    实现输出传输     java.net.DatagramSocket 接收数据包
       *    
       *  实现步骤:
       *     1. 创建DatagramSocket对象,绑定端口号
       *         要和发送端端口号一致
       *     2. 创建字节数组,接收发来的数据
       *     3. 创建数据包对象DatagramPacket
       *     4. 调用DatagramSocket对象方法
       *        receive(DatagramPacket dp)接收数据,数据放在数据包中
       *     5. 拆包
       *          发送的IP地址
       *            数据包对象DatagramPacket方法getAddress()获取的是发送端的IP地址对象
       *            返回值是InetAddress对象
       *          接收到的字节个数
       *            数据包对象DatagramPacket方法 getLength()
       *          发送方的端口号
       *            数据包对象DatagramPacket方法 getPort()发送端口
       *     6. 关闭资源
       */
      public class UDPReceive {
        public static void main(String[] args)throws IOException {
          //创建数据包传输对象DatagramSocket 绑定端口号
          DatagramSocket ds = new DatagramSocket(6000);
          //创建字节数组
          byte[] data = new byte[1024];
          //创建数据包对象,传递字节数组
          DatagramPacket dp = new DatagramPacket(data, data.length);
          //调用ds对象的方法receive传递数据包
          ds.receive(dp);
          
          //获取发送端的IP地址对象
          String ip=dp.getAddress().getHostAddress();
          
          //获取发送的端口号
          int port = dp.getPort();
          
          //获取接收到的字节个数
          int length = dp.getLength();
          System.out.println(new String(data,0,length)+"..."+ip+":"+port);
          ds.close();
        }
      }



###11键盘输入的聊天
   *A:键盘输入的聊天
    *a:发送端:
      /*
       * 实现UDP发送,键盘输入的形式
       * 输入完毕,发送给接收端      
       */
      public class UDPSend {
        public static void main(String[] args) throws IOException{
          Scanner sc = new Scanner(System.in);
          DatagramSocket ds = new DatagramSocket();
          InetAddress inet = InetAddress.getByName("127.0.0.1");
          while(true){
          String message = sc.nextLine();
          /*if("886".equals(message)){
            break;
          }*/
          byte[] date = message.getBytes();
          DatagramPacket dp = new DatagramPacket(date, date.length, inet,6000);
          ds.send(dp);
          }
        //  ds.close();
        }
      }
       
       

       /*
        *  实现UDP接收端
        *  永不停歇的接收端
        */
       public class UDPReceive {
        public static void main(String[] args)throws IOException {
          //创建数据包传输对象DatagramSocket 绑定端口号
          DatagramSocket ds = new DatagramSocket(6000);
          //创建字节数组
          byte[] data = new byte[1024];
          //创建数据包对象,传递字节数组
          while(true){
          DatagramPacket dp = new DatagramPacket(data, data.length);
          //调用ds对象的方法receive传递数据包
          ds.receive(dp);
          
          //获取发送端的IP地址对象
          String ip=dp.getAddress().getHostAddress();
          
          //获取发送的端口号
          int port = dp.getPort();
          
          //获取接收到的字节个数
          int length = dp.getLength();
          System.out.println(new String(data,0,length)+"..."+ip+":"+port);
          }
          //ds.close();
        }
       }

=======================第三节课======================================
###12TCP的客户端和服务器
   *A:TCP的客户端和服务器
      TCP通信同UDP通信一样，都能实现两台计算机之间的通信，通信的两端都需要创建socket对象。
      区别在于，UDP中只有发送端和接收端，不区分客户端与服务器端，计算机之间可以任意地发送数据。
      而TCP通信是严格区分客户端与服务器端的，在通信时，必须先由客户端去连接服务器端才能实现通信，
      服务器端不可以主动连接客户端，并且服务器端程序需要事先启动，等待客户端的连接。
      在JDK中提供了两个类用于实现TCP程序，一个是ServerSocket类，用于表示服务器端，一个是Socket类，用于表示客户端。
      通信时，首先创建代表服务器端的ServerSocket对象，该对象相当于开启一个服务，并等待客户端的连接，然后创建代表客户端的Socket对象向服务器端发出连接请求，服务器端响应请求，两者建立连接开始通信。


###13TCP的客户端程序
  *A:TCP的客户端程序
   /*
    *  实现TCP客户端,连接到服务器
    *  和服务器实现数据交换
    *  实现TCP客户端程序的类 java.net.Socket
    *  
    *  构造方法:
    *      Socket(String host, int port)  传递服务器IP和端口号
    *      注意:构造方法只要运行,就会和服务器进行连接,连接失败,抛出异常
    *      
    *    OutputStream  getOutputStream() 返回套接字的输出流
    *      作用: 将数据输出,输出到服务器
    *      
    *    InputStream getInputStream() 返回套接字的输入流
    *      作用: 从服务器端读取数据
    *      
    *    客户端服务器数据交换,必须使用套接字对象Socket中的获取的IO流,自己new流,不行
    */
   public class TCPClient {
    public static void main(String[] args)throws IOException {
      //创建Socket对象,连接服务器
      Socket socket = new Socket("127.0.0.1", 8888);
      //通过客户端的套接字对象Socket方法,获取字节输出流,将数据写向服务器
      OutputStream out = socket.getOutputStream();
      out.write("服务器OK".getBytes());
      
 
      
      socket.close();
    }
   }

 
###14TCP的服务器程序accept方法
   A:TCP的服务器程序accept方法
     /*
      *  实现TCP服务器程序
      *  表示服务器程序的类 java.net.ServerSocket
      *  构造方法:
      *    ServerSocket(int port) 传递端口号
      *  
      *  很重要的事情: 必须要获得客户端的套接字对象Socket
      *    Socket  accept()
      */
     public class TCPServer {
      public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8888);
        //调用服务器套接字对象中的方法accept() 获取客户端套接字对象
        Socket socket = server.accept();
        //通过客户端套接字对象,socket获取字节输入流,读取的是客户端发送来的数据
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data,0,len));
      
        
        socket.close();
        server.close();
      }
     }


###15TCP的服务器程序读取客户端数据
   A:TCP的服务器程序读取客户端数据
      
      /*
       *  实现TCP客户端,连接到服务器
       *  和服务器实现数据交换
       *  实现TCP客户端程序的类 java.net.Socket
       *  
       *  构造方法:
       *      Socket(String host, int port)  传递服务器IP和端口号
       *      注意:构造方法只要运行,就会和服务器进行连接,连接失败,抛出异常
       *      
       *    OutputStream  getOutputStream() 返回套接字的输出流
       *      作用: 将数据输出,输出到服务器
       *      
       *    InputStream getInputStream() 返回套接字的输入流
       *      作用: 从服务器端读取数据
       *      
       *    客户端服务器数据交换,必须使用套接字对象Socket中的获取的IO流,自己new流,不行
       */
      public class TCPClient {
        public static void main(String[] args)throws IOException {
          //创建Socket对象,连接服务器
          Socket socket = new Socket("127.0.0.1", 8888);
          //通过客户端的套接字对象Socket方法,获取字节输出流,将数据写向服务器
          OutputStream out = socket.getOutputStream();
          out.write("服务器OK".getBytes());
          socket.close();
        }
      }
      /*
       *  实现TCP服务器程序
       *  表示服务器程序的类 java.net.ServerSocket
       *  构造方法:
       *    ServerSocket(int port) 传递端口号
       *  
       *  很重要的事情: 必须要获得客户端的套接字对象Socket
       *    Socket  accept()
       */
      public class TCPServer {
        public static void main(String[] args) throws IOException{
          ServerSocket server = new ServerSocket(8888);
          //调用服务器套接字对象中的方法accept() 获取客户端套接字对象
          Socket socket = server.accept();
          //通过客户端套接字对象,socket获取字节输入流,读取的是客户端发送来的数据
          InputStream in = socket.getInputStream();
          byte[] data = new byte[1024];
          int len = in.read(data);
          System.out.println(new String(data,0,len));
        
        }
      }


 
   
###16TCP的服务器和客户端的数据交换
   A:TCP的服务器和客户端的数据交换
      /*
       *  实现TCP客户端,连接到服务器
       *  和服务器实现数据交换
       *  实现TCP客户端程序的类 java.net.Socket
       *  
       *  构造方法:
       *      Socket(String host, int port)  传递服务器IP和端口号
       *      注意:构造方法只要运行,就会和服务器进行连接,连接失败,抛出异常
       *      
       *    OutputStream  getOutputStream() 返回套接字的输出流
       *      作用: 将数据输出,输出到服务器
       *      
       *    InputStream getInputStream() 返回套接字的输入流
       *      作用: 从服务器端读取数据
       *      
       *    客户端服务器数据交换,必须使用套接字对象Socket中的获取的IO流,自己new流,不行
       */
      public class TCPClient {
        public static void main(String[] args)throws IOException {
          //创建Socket对象,连接服务器
          Socket socket = new Socket("127.0.0.1", 8888);
          //通过客户端的套接字对象Socket方法,获取字节输出流,将数据写向服务器
          OutputStream out = socket.getOutputStream();
          out.write("服务器OK".getBytes());
          
          //读取服务器发回的数据,使用socket套接字对象中的字节输入流
          InputStream in = socket.getInputStream();
          byte[] data = new byte[1024];
          int len = in.read(data);
          System.out.println(new String(data,0,len));
          
          socket.close();
        }
      }
      /*
       *  实现TCP服务器程序
       *  表示服务器程序的类 java.net.ServerSocket
       *  构造方法:
       *    ServerSocket(int port) 传递端口号
       *  
       *  很重要的事情: 必须要获得客户端的套接字对象Socket
       *    Socket  accept()
       */
      public class TCPServer {
        public static void main(String[] args) throws IOException{
          ServerSocket server = new ServerSocket(8888);
          //调用服务器套接字对象中的方法accept() 获取客户端套接字对象
          Socket socket = server.accept();
          //通过客户端套接字对象,socket获取字节输入流,读取的是客户端发送来的数据
          InputStream in = socket.getInputStream();
          byte[] data = new byte[1024];
          int len = in.read(data);
          System.out.println(new String(data,0,len));
          
          //服务器向客户端回数据,字节输出流,通过客户端套接字对象获取字节输出流
          OutputStream out = socket.getOutputStream();
          out.write("收到,谢谢".getBytes());
          
          socket.close();
          server.close();
        }
      }
      



###17TCP的中的流对象
    *A:TCP的中的流对象
        参见图解TCP中的流对象.jpg  

======================================第四节课=================================================
###18TCP图片上传案例分析
    *A:图片上传案例分析
         参见图解TCP上传图片案例.jpg  

###19TCP上传客户端
   *A TCP上传客户端
   /*
    *  实现TCP图片上传客户端
    *  实现步骤:
    *    1. Socket套接字连接服务器
    *    2. 通过Socket获取字节输出流,写图片
    *    3. 使用自己的流对象,读取图片数据源
    *         FileInputStream
    *    4. 读取图片,使用字节输出流,将图片写到服务器
    *       采用字节数组进行缓冲
    *    5. 通过Socket套接字获取字节输入流
    *       读取服务器发回来的上传成功
    *    6. 关闭资源
    */
   public class TCPClient {
    public static void main(String[] args) throws IOException{
      Socket socket = new Socket("127.0.0.1", 8000);
      //获取字节输出流,图片写到服务器
      OutputStream out = socket.getOutputStream();
      //创建字节输入流,读取本机上的数据源图片
      FileInputStream fis = new FileInputStream("c:\\t.jpg");
      //开始读写字节数组
      int len = 0 ;
      byte[] bytes = new byte[1024];
      while((len = fis.read(bytes))!=-1){
        out.write(bytes, 0, len);
      }
      //给服务器写终止序列
      //socket.shutdownOutput();
      
      //获取字节输入流,读取服务器的上传成功
      InputStream in = socket.getInputStream();

      len = in.read(bytes);
      System.out.println(new String(bytes,0,len));
      
      fis.close();
      socket.close();
    }
   }
###20TCP上传服务器
   A:TCP上传服务器
   /*
    *  TCP图片上传服务器
    *   1. ServerSocket套接字对象,监听端口8000
    *   2. 方法accept()获取客户端的连接对象
    *   3. 客户端连接对象获取字节输入流,读取客户端发送图片
    *   4. 创建File对象,绑定上传文件夹
    *       判断文件夹存在, 不存,在创建文件夹
    *   5. 创建字节输出流,数据目的File对象所在文件夹
    *   6. 字节流读取图片,字节流将图片写入到目的文件夹中
    *   7. 将上传成功会写客户端
    *   8. 关闭资源
    *       
    */
   public class TCPServer {
    public static void main(String[] args) throws IOException{
      ServerSocket server = new ServerSocket(8000);
      Socket socket = server.accept();
      //通过客户端连接对象,获取字节输入流,读取客户端图片
      InputStream in = socket.getInputStream();
      //将目的文件夹封装到File对象
      File upload = new File("d:\\upload");
      if(!upload.exists())
        upload.mkdirs();
       
      //创建字节输出流,将图片写入到目的文件夹中                         
      FileOutputStream fos = new FileOutputStream(upload+"t.jpg");
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
      server.close();
    }
   }
###21TCP图片上传问题解决
/*
 *  实现TCP图片上传客户端
 *  实现步骤:
 *    1. Socket套接字连接服务器
 *    2. 通过Socket获取字节输出流,写图片
 *    3. 使用自己的流对象,读取图片数据源
 *         FileInputStream
 *    4. 读取图片,使用字节输出流,将图片写到服务器
 *       采用字节数组进行缓冲
 *    5. 通过Socket套接字获取字节输入流
 *       读取服务器发回来的上传成功
 *    6. 关闭资源
 */
public class TCPClient {
  public static void main(String[] args) throws IOException{
    Socket socket = new Socket("127.0.0.1", 8000);
    //获取字节输出流,图片写到服务器
    OutputStream out = socket.getOutputStream();
    //创建字节输入流,读取本机上的数据源图片
    FileInputStream fis = new FileInputStream("c:\\t.jpg");
    //开始读写字节数组
    int len = 0 ;
    byte[] bytes = new byte[1024];
    while((len = fis.read(bytes))!=-1){
      out.write(bytes, 0, len);
    }
    //给服务器写终止序列
    socket.shutdownOutput();//想服务端写入一个结束标志
    
    //获取字节输入流,读取服务器的上传成功
    InputStream in = socket.getInputStream();

    len = in.read(bytes);
    System.out.println(new String(bytes,0,len));
    
    fis.close();
    socket.close();
  }
}

###TCP上传文件名 
  *A:TCP上传文件名
   /*
    *  TCP图片上传服务器
    *   1. ServerSocket套接字对象,监听端口8000
    *   2. 方法accept()获取客户端的连接对象
    *   3. 客户端连接对象获取字节输入流,读取客户端发送图片
    *   4. 创建File对象,绑定上传文件夹
    *       判断文件夹存在, 不存,在创建文件夹
    *   5. 创建字节输出流,数据目的File对象所在文件夹
    *   6. 字节流读取图片,字节流将图片写入到目的文件夹中
    *   7. 将上传成功会写客户端
    *   8. 关闭资源
    *       
    */
   public class TCPServer {
    public static void main(String[] args) throws IOException{
      ServerSocket server = new ServerSocket(8000);
      Socket socket = server.accept();
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
      server.close();
    }
   }

###多线程上传案例
*A:多线程上传案例
  public class TCPThreadServer {
    public static void main(String[] args) throws IOException {
      ServerSocket server = new ServerSocket(8000);
      while (true) {
        // 获取到一个客户端,必须开启新线程,为这个客户端服务
        Socket socket = server.accept(); 
        new Thread(new Upload(socket)).start();
      }
    }
  }

  public class Upload implements Runnable {

    private Socket socket;

    public Upload(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try {
        // 通过客户端连接对象,获取字节输入流,读取客户端图片
        InputStream in = socket.getInputStream();
        // 将目的文件夹封装到File对象
        File upload = new File("d:\\upload");
        if (!upload.exists())
          upload.mkdirs();

        // 防止文件同名被覆盖,从新定义文件名字
        // 规则: 域名+毫秒值+6位随机数
        String filename = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
        // 创建字节输出流,将图片写入到目的文件夹中
        FileOutputStream fos = new FileOutputStream(upload + File.separator + filename);
        // 读写字节数组
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
          fos.write(bytes, 0, len);
        }
        // 通过客户端连接对象获取字节输出流
        // 上传成功写回客户端
        socket.getOutputStream().write("上传成功".getBytes());

        fos.close();
        socket.close();
      } catch (Exception ex) {

      }
    }

  }
