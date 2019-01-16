package com.lym.arithmetic;

/**
 * 在数组 a 中，查找 key，返回 key 所在的位置
 * @author lym
 *
 */
public class ArrayDemo {
	
	private static final int[] array= {4,2,3,5,9,6};

	public static void main(String[] args) {
		ArrayDemo demo=new ArrayDemo();
		System.out.println(demo.findKeyV1(array, 7));
		System.out.println(demo.findKeyV2(array, 7));
	}
	
	public int findKeyV1(int[] arr,int key) {
		int n=arr.length;
		int i=0;
		while (i<n) {
			if (arr[i]==key) {
				return i;
			}
			i++;
		}
		return -1;
	}

	//当arr很长的时候，findKeyV2要比findKeyV1更快，省掉了一个比较语句i<n
	//但大部分情况我们不使用这个方法，因为可读性太差
	public int findKeyV2(int[] arr,int key) {
		int n=arr.length;
		if (arr[n-1]==key) {
			return n-1;
		}
		
		int tmp=arr[n-1];
		arr[n-1]=key;
		
		int i=0;
		while(arr[i]!=key) {
			i++;
		}
		
		arr[n-1]=tmp;
		if (i==n-1) {
			return -1;
		}else {
			return i;
		}
	}
}
