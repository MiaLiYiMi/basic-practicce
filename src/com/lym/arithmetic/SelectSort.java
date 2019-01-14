package com.lym.arithmetic;

public class SelectSort {

	public static void main(String[] args) {
		SelectSort sort=new SelectSort();
		int num[]={56,23,46,87,11,22,65,1,21,123};
		sort.simpleSelectSort(num);
		System.out.println();
		sort.selectSort(num);
	}
	
	/**
	 * 求最小值的位置
	 * @param num
	 * @param j
	 * @return
	 */
	public int SelectMin(int num[],int j){
		int k=j;
		for (int i = j+1; i < num.length; i++) {
			if (num[k]>num[i]) {
				k=i;
			}

		}
		return k;
	}
	/**
	 * 简单选择排序，不稳定
	 * @param num
	 */
	public void simpleSelectSort(int num[]){
		int key,tmp;
		for (int i = 0; i < num.length; i++) {
			key=SelectMin(num,i);
			if (key!=i) {
				tmp=num[i];
				num[i]=num[key];
				num[key]=tmp;
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
	}
	/**
	 * 二元选择排序，不稳定
	 * @param num
	 */
	public void selectSort(int num[]){
		int min,max,tmp;
		for (int i = 1; i <= num.length/2; i++) {
			min=i;max=i;
			for (int j = i+1; j <=num.length-i; j++) {
				if (num[j]>num[max]) {
					max=j;
					continue;
				}
				if (num[j]<num[min]) {
					min=j;
				}
			}
			tmp=num[i-1];
			num[i-1]=num[min];
			num[min-1]=tmp;
			
			tmp=num[num.length-i];
			num[num.length-i]=num[max];
			num[max]=tmp;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
	}
	/**
	 * 堆排序，时间复杂度O(nlog2^n),不稳定
	 */
	public void heapSort(int num[]){
		
	}
	
}
