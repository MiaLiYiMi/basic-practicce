package com.lym.arithmetic;
/**
 * 插入排序
 * 时间复杂度O(n^2)
 * @author lym
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		InsertSort insertSort=new InsertSort();
		int num[]={12,65,398,45,12,3,0,786};
		insertSort.insertSort1(num);
		System.out.println();
		insertSort.binarySort(num);
	}

	/**
	 * 直接插入排序，稳定排序
	 * @param num
	 */
	public void insertSort1(int num[]){
		for (int i = 1; i <num.length; i++) {
			//取相邻两个数比较
			if (num[i]<num[i-1]) {
				int j=i-1;
				int x=num[i];
				num[i]=num[i-1];
				
				while (x<num[j]) {
					num[j+1]=num[j];
					j--;
					if (j<0) {
						break;
					}
				}
				num[j+1]=x;
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+",");
			
		}
	}
	/**
	 * 二分法插入排序，稳定排序
	 */
	public void binarySort(int num[]){
		int i,j,temp;
		int low ,hight ,mid;
		for(i=1;i<num.length;i++)
		{
			temp = num[i];
			low = 0;
			hight = i-1;
			while(low<=hight)
			{
				mid = (low+hight)/2;
			    if(num[mid]>temp)
			    	hight =mid -1;
			    else
			    	low = mid + 1;
			}
			for(j =i-1;j>hight;j--)
				num[j+1] = num[j];
			
			num[hight+1] = temp;
		}
		for (int a = 0; a < num.length; a++) {
			System.out.print(num[a]+",");
		}
	}
	
	
}
