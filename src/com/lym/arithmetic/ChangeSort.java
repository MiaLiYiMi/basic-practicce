package com.lym.arithmetic;

/**
 * 交换排序
 * @author lym
 *
 */
public class ChangeSort {

	public static void main(String[] args) {
		
		ChangeSort changeSort=new ChangeSort();
		int num[]={12,54,1,23,87,65,43,21,9};
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		changeSort.bubbleSort(num);
		System.out.println();
		
		changeSort.bubbleSort2(num);
		System.out.println();
		
		changeSort.quickSort(num, 0, num.length-1);
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
	}
	
	/**
	 * 冒泡排序，时间复杂度O(n^2),稳定
	 * @param num
	 */
	public void bubbleSort(int num[]){
		int tmp;
		for (int i = 0; i < num.length-1; i++) {
			for (int j = 0; j < num.length-i-1; j++) {
				if (num[j]>num[j+1]) {
					tmp=num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
				}
			}
		}
	}
	/**
	 * 在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 
	 * 从而使排序趟数几乎减少了一半
	 * @param num
	 */
	public void bubbleSort2(int num[]){
		int tmp;
		int high=num.length-1;
		int low=0;
		while (low<high) {
			////正向冒泡,找到最大者
			for (int j = low; j < high; ++j) {
				if (num[j]>num[j+1]) {
					tmp=num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
				}
			}
			//修改high值, 前移一位
			--high;	
			//反向冒泡,找到最小者
			for (int j = high; j >low; --j) {
				if (num[j]<num[j-1]) {
					tmp=num[j];
					num[j]=num[j-1];
					num[j-1]=tmp;
				}
			}
			//修改low值,后移一位  
			++low;
		}
	}
	/**
	 * 快速排序，不稳定
	 * 先分成比基数小和比基数大的两部分
	 * @param num
	 */
	public int partition(int num[],int low,int high){
		int tmp;
		int priKeynum=num[low];//基准元素
		//从数组的两端交替地向中间扫描 
		while (low<high) {
			//从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端  
			while(low<high&&num[high]>=priKeynum)
				--high;
			
			tmp=num[low];
			num[low]=num[high];
			num[high]=tmp;
			
			while(low<high&&num[low]<=priKeynum)
				++low;
			
			tmp=num[low];
			num[low]=num[high];
			num[high]=tmp;

		}
		return low;
	}
	public void quickSort(int num[],int low,int high){
		if (low<high) {
			//将表一分为二
			int priLoc=partition(num,low,high);
			//递归对低子表递归排序
			quickSort(num, low, priLoc-1);
			//递归对高子表递归排序  
			quickSort(num, priLoc+1, high);
		}
	}

}

