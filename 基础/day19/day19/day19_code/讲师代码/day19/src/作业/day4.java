package 作业;

public class day4 {

		public static void main(String[] args) {
			String str =  "goOd gooD stUdy dAy dAy up";
			
			function(str);
			System.out.println(function(str));
		}

		private static String function(String str) {
			
			String[] arr =str.split(" ");//将str字符串以" "为届截取为多个字符串数组
			StringBuilder sb =new StringBuilder();//创建StringBuilder对象
			for (int i = 0; i < arr.length; i++) {//遍历数组
				
				StringBuilder sb2 =new StringBuilder(arr[i].toLowerCase());
				
				sb2.replace(0, 1, sb2.substring(0, 1).toUpperCase());
				sb.append(sb2.toString()+" ");
				
			}
			return sb.toString();
			
			
		}
		

			
		}

