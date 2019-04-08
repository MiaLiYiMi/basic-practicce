package com.lym.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文串
 * @author lym
 *
 */
public class PalindromeDemo {
	
	public static void main(String[] args) {
		PalindromeDemo demo=new PalindromeDemo();
		System.out.println(demo.check("level"));
		demo.testStream();
	}
	
	public boolean check(String str) {
		String[] strings=str.split("");
		int i=0;
		int j=str.length()-1;
		for(;i<=j;i++,j--) {
			if (!strings[i].equals(strings[j])) {
				return false;
			}
		}
		return true;
	}

	public void testStream() {
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
//		注意：迭代的时候对ArrayList进行修改就会Exception in thread "main" java.util.ConcurrentModificationException
//		int i=0;
//		list.stream().forEach(item->{
//			while(list.size()<10) {
//				list.add(i, i+1);
//			}
//		});
		
		list.stream().forEach(item->{System.out.println(item);});
		
	}
}
