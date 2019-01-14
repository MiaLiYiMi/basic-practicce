package com.lym.arithmetic;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//将a[i…m]和a[m +1 …n]归并到辅助数组b[i…n]  
	public void Merge(int a[],int b[],int i){
		int j,k;
		int m=a.length;
		int n=b.length;
		for(k=i,j=m+1;i<m&&j<n;++k){
			if (a[j]<a[i]) {
				b[k]=a[j++];
			}else {
				b[k]=a[i++];
			}
		}
		while(i<=m)
			b[k++]=a[i++];
		while(j<=n)
			b[k++]=a[j++];
	}
	public void mergeSort(){
		
	}
}
