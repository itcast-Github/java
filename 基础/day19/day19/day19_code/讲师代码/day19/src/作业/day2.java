package 作业;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SpringLayout.Constraints;

public class day2 {
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	list.add("a");
	list.add("f");
	list.add("b");
	list.add("c");
	list.add("a");
	list.add("d");
	boolean  b = Constraints(list,"d");
	
}

private static boolean Constraints(List<String> list, Object obj) {
	/*思路:
		第一步：遍历
		第二步：和传入的数据进行对比，相等 ：包含，返回true。不相等 ：不包含 返回false*/
		if(obj== null){
			for (String str : list) {
				if(str==obj){
					return true;
				}
			
			}
		}else {
			//说明不是null
			for (String str : list) {
				if(str.equals(obj))
				return true;
			}
		}
		return false;
}
}
