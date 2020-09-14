/*
   实现商品的库存管理
     功能:
	    1. 展示用户选择功能清单
		2. 根据选择的功能编号,进行不同的操作
		   A. 展示所有库存
		   B. 修改库存数量
		   
	  分析:
	    1. 展示用户清单:
		   输出语句, 用户输入, 选择功能序号
		2. 根据选择,调用不同的方法
		    switch语句
			  case 1 2 3
		
		   A  展示库存
		     将存储商品的数组,遍历
		   B  修改库存
		        
			  修改所有的库存数量
*/
import java.util.Scanner;
public class Shopp{
	public static void main(String[] args){
		//使用数组,保存商品的信息
		//品名,尺寸,价格,库存数, 定义5个数组
		String[] brand = {"MacBookAir","ThinkpadT450"};
		double[] size = {13.3,15.6};
		double[] price = {9998.97,6789.56};
		int[] count = {0,0};
		while(true){
		int choose = chooseFunction();
		switch(choose){
			case 1:
			  //调用查看库存清单方法
			  printStore(brand,size,price,count);
			break;
			
			case 2:
			  //调用修改库存的方法
			  update(brand,count);
			break;
			
			case 3:
			 return ;
			
			
			default:
			  System.out.println("没有这个功能");
			break;
		}
		}
	}
	/*
	  定义方法,修改所有商品的库存
	    用户输入1个,修改1个
		返回值,没有
		参数, 库存数的数组, 品名数组
	*/
	public static void update(String[] brand, int[] count){
		//遍历数组,遍历到一个,修改一个
		//接受键盘输入
		Scanner sc = new Scanner(System.in);
		//遍历数组
		for(int i = 0; i < brand.length ; i++){
			System.out.println("请输入"+brand[i]+"的库存数");
			//键盘输入,录入库存, 存储到库存的数组中
			int newCount = sc.nextInt();
			count[i] = newCount;
		}
		//int chooseNumber = sc.nextInt();
	}
	
	/*
	   定义方法,展示所有的库存清单,遍历
	   返回值,没有
	   参数, 数组
	*/
	public static void printStore(String[] brand,double[] size,double[] price,int[] count){
		System.out.println("----------商场库存清单----------");
		System.out.println("品牌型号     尺寸    价格    库存数");
		//定义变量,计算总库存数,和总价格
		int totalCount = 0;
		int totalMoney = 0;
		//遍历数组,将数组中所有的商品信息打印出来
		for(int i = 0 ; i < brand.length ; i++){
			System.out.println(brand[i]+"   "+size[i]+"    "+price[i]+"   "+count[i]);
			totalCount += count[i];
			totalMoney += count[i]*price[i];
		}
		System.out.println("总库存数: "+totalCount);
		System.out.println("商品库存总金额: "+totalMoney);
	}
	
	/*
	  定义方法,实现用户的选择功能,功能的需要返回来
	  返回值, int
	  参数, 没有
	*/
	public static int chooseFunction(){
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		//接受键盘输入
		Scanner sc = new Scanner(System.in);
		int chooseNumber = sc.nextInt();
		return chooseNumber;
	}
}






