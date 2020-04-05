package com.edwin.algorithm;
/**
 * 
 * @author Administrator
 *	冒泡排序算法
 *	（1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
	（2）这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉” 到数组第N-1 个位置。
	（3） N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。
 *
 *	注：N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
 */
public class BubbleSort {
	
	//N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较
	public static void buSort(int[]array ,int n){ //n个数，也即数组的长度
		int i,j;
		for ( i = 0; i < n; i++) {//表示n次排序过程
			for ( j = 1; j < n - i; j++) { //
				if(array[j-1]>array[j]){//前面的数字大于后面的数字就交换
					int temp; //交换 array[j-1]和array[j]
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			
		}
	}

	//生成一个对数器,产生一个随机样本的数组,数组的长度和值都是随机的
    //size是生成数组的最大长度
    public static int[] generateRandomArray(int size,int value){
        //生成长度随机的数组
        int[] arr = new int[(int)((size+1)*Math.random())];
        for(int i = 0 ;i<arr.length;i++){
            arr[i]=(int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }
    
    //打印数组
    public static void printArray(int[] arr){
        if(arr==null){
            return;
        }
        for(int i = 0 ;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
	
    
	public static void main(String[] args) {
		
		
	}
}
