package com.edwin.lianxi;

/**
 * @author Administrator
 * 一个数如果恰好等于他的因子之和，这个数就称为“完数”，例如 6 =1+2+3.编程找出1000以内的所有完数
 */
public class wsTest {

	public static void main(String[] args) {
		for (int m = 2; m < 1000; m++) {
			int s= 0;
			for (int i = 1; i < m; i++) {
				if ((m%i)==0) {
					s+=i;
				}
				
			}
			if (s==m) {
				System.out.print(m+" its factors are:");
				for (int j = 1; j < m; j++) {
					
					if ((m%j)==0) {
						System.out.print(j);
						System.out.print(" ");
						
					}
				}
				System.out.println();
			}
		}
	}
}
