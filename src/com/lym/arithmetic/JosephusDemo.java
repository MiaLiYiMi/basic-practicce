package com.lym.arithmetic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		//int[] survivals=new int[50];
		for (int i = 1; i < 51; i++) {
			System.out.println(">>>>第"+i+"次");
			int loser=1+getNumber(sum, key, i);
			System.out.println("淘汰的编号是："+loser);
			System.out.println();
			losers[i-1]=loser;
		}
		System.out.println(losers.length);
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
		ChangeSort sort=new ChangeSort();
		sort.quickSort(losers, 0, losers.length-1);
		StringBuffer loser=new StringBuffer();
		for (int i : losers) {
			if (i>0) {
				loser.append(i+",");
			}
		}
		
		return loser.toString();
	}
	
	private static String sortDescNum(int[] losers) {
		List<Integer> survivals=new ArrayList<>();
		for (int i = 1; i < 101; i++) {
			survivals.add(i);
			for (int n : losers) {
				if (i==n) {
					survivals.remove(survivals.size()-1);
				}
			}
		}
		return survivals.toString();
	}

}
