package com.edwin.algorithm;
/**
 * 
 * @author Administrator
 *	ð�������㷨
 *	��1���Ƚ�ǰ�����ڵĶ������ݣ����ǰ�����ݴ��ں�������ݣ��ͽ���������ݽ�����
	��2������������ĵ� 0 �����ݵ� N-1 �����ݽ���һ�α���������һ�����ݾ͡����� �������N-1 ��λ�á�
	��3�� N=N-1����� N ��Ϊ 0 ���ظ�ǰ�����������������ɡ�
 *
 *	ע��N������Ҫ������ɣ��ܹ�����N-1������ÿi�˵��������Ϊ(N-i)�Σ����Կ�����˫��ѭ����䣬������ѭ�������ˣ��ڲ����ÿһ�˵�ѭ������
 */
public class BubbleSort {
	
	//N������ð�������ܹ�Ҫ����N-1�˱Ƚϣ�ÿ�˵��������Ϊ(N-i)�αȽ�
	public static void buSort(int[]array ,int n){ //n������Ҳ������ĳ���
		int i,j;
		for ( i = 0; i < n; i++) {//��ʾn���������
			for ( j = 1; j < n - i; j++) { //
				if(array[j-1]>array[j]){//ǰ������ִ��ں�������־ͽ���
					int temp; //���� array[j-1]��array[j]
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			
		}
	}

	//����һ��������,����һ���������������,����ĳ��Ⱥ�ֵ���������
    //size�������������󳤶�
    public static int[] generateRandomArray(int size,int value){
        //���ɳ������������
        int[] arr = new int[(int)((size+1)*Math.random())];
        for(int i = 0 ;i<arr.length;i++){
            arr[i]=(int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }
    
    //��ӡ����
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
