package com.lym.arithmetic;

/**
 * 回文串
 * @author lym
 *
 */
public class PalindromeDemo {
	
	public static void main(String[] args) {
		PalindromeDemo demo=new PalindromeDemo();
		System.out.println(demo.check("level"));
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

}
