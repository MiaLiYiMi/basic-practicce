package com.lym.arithmetic;

/**
 * 约瑟夫环问题
 * 递归
 * @author Administrator
 * @date 2018-9-18
 * 100个人从1开始依次报数，报数为13的人出局，，出局者的下一个报数人从头开始报数，以此类推，直到剩余人数不超过一半为止
 */
public class JosephusDemo {

	public static void main(String[] args) {
		// sum指的是总人数，key指的是每次最大报到的数值，n是第n次，该函数每次可以求出第n次扔海里的人的编号
		int sum=100;
		int key=13;
		int[] losers=new int[50];
		for (int i = 1; i < 51; i++) {
			System.out.println(">>>>第"+i+"次");
			int loser=1+getNumber(sum, key, i);
			System.out.println("淘汰的编号是："+loser);
			System.out.println();
			losers[i]=loser;
		}
		System.out.println("淘汰的编号正序如下："+sortAscNum(losers));
		System.out.println("幸存的编号正序如下："+sortDescNum(losers));
	}


	public static int getNumber(int sum, int key, int n) {
		if (n == 1) 
			return (sum + key - 1) % sum;
		else
			return (getNumber(sum - 1, key, n - 1) + key) % sum;
	}
	
	private static String sortAscNum(int[] losers) {
		
		return null;
	}
	
	private static String sortDescNum(int[] losers) {
		
		return null;
	}

}
