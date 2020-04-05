package com.edwin.algorithm;
/**
 * 
 * @author Administrator
 *	二分查找
  又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。
 */

public class BinarySearch {
	
	public static int biSearch(int[] array ,int a){ //a 待查关键字
		int low = 0; //最小位索引
		int high = array.length-1;  //最大位索引
		int mid ;
		while(low < high){
			mid = (low+high)/2 ; //中间位置
			if(array[mid] == a){
				return mid+1 ; //返回要查找的元素所在的位数
			}else if (array[mid] < a) { // 继续在右半部分查找
				low = mid ;
			}else {
				high =mid;
			}
			
		}	
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,6,9,11,15,20,28,31,45,50,56,89};
		int biSearch = biSearch(arr, 50);
		
		System.out.println("所查找的元素的在第"+biSearch+"位");
		System.out.println(arr[biSearch]);
		
	}

}
