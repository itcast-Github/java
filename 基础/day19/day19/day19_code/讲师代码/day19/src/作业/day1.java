package ื๗าต;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class day1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("f");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("d");
		bianli(list);
		function(list);
	}
	public static void function(List<String> list) {
		HashSet <String> ha = new HashSet<String> ();
		for (String sc : list) {
			
			ha.add(sc);
			
		}
		System.out.println(ha);
	}
	public static void bianli(List <String> list ){
		
			HashSet<String> ha =  new  HashSet<String >();
			for (String i  : list) {
				ha.add(i);
					//System.out.println(ha);
			}
			list.clear();
			list.addAll(ha);
			System.out.println(list);
	}
	
}
	
