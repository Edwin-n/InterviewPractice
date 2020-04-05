package com.edwin.algorithm;
/**
 * 
 * @author Administrator
 *	���ֲ���
  �ֽ��۰���ң�Ҫ������ҵ���������ÿ��ȡ�м�λ�õ�ֵ�����ؼ��ֱȽϣ�����м�λ��
��ֵ�ȴ���ؼ��ִ�����ǰ�벿��ѭ��������ҵĹ��̣�����м�λ�õ�ֵ�ȴ���ؼ���С��
���ں�벿��ѭ��������ҵĹ��̡�ֱ�����ҵ���Ϊֹ������������û�д���Ĺؼ��֡�
 */

public class BinarySearch {
	
	public static int biSearch(int[] array ,int a){ //a ����ؼ���
		int low = 0; //��Сλ����
		int high = array.length-1;  //���λ����
		int mid ;
		while(low < high){
			mid = (low+high)/2 ; //�м�λ��
			if(array[mid] == a){
				return mid+1 ; //����Ҫ���ҵ�Ԫ�����ڵ�λ��
			}else if (array[mid] < a) { // �������Ұ벿�ֲ���
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
		
		System.out.println("�����ҵ�Ԫ�ص��ڵ�"+biSearch+"λ");
		System.out.println(arr[biSearch]);
		
	}

}
