package com.edwin.lianxi;

/**
 * @author Administrator
 * 值传递
 */
public class TempTest01 {

	private void test1(int a){
		a = 5;
		System.out.println("test1方法中的a="+a);
		
	}
	
	public static void main(String[] args) {
		TempTest01 t = new TempTest01();
		int a= 3;
		t.test1(a);//传递后，test1方法对变量值的改变不影响这里的a
		System.out.println("main方法中的a="+a);
	}
	
}
