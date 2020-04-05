package com.edwin.lianxi;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Administrator
 * 用1-6这6个数字，用java写一个main函数，打印出所有不同的排列，要求：4不能再第三位，3与5不能相连
 *
 */
public class numberRandom { 
	
	String[] stra = { "1","2","3","4","5","6"};
	int n = stra.length;
	boolean[] visited = new boolean[n];
	String result = "";
	TreeSet<String> ts = new TreeSet<String>(); 
	int[][] a = new int[n][n];
	private void searchMap(){
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				if(i==j){
					a[i][j]=0;
					
				}else{
					a[i][j]=1;
				}
				
			}
			
		}
		//3和5不能相连
		a[3][5]=0;
		a[5][3]=0;
		//开始遍历
		for (int i = 0; i < n; i++) {
			search(i);
			
			
		}
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			String str = (String) it.next();
			//4不能在第三位
			if (str.indexOf("4")!=2) {
				System.out.println(str);
			}
		}
		
	}
	
	
	private void search(int startindex){
		visited[startindex] = true;
		result = result + stra[startindex];
		if (result.length()==n) {
			ts.add(result);
		}
		for (int j = 0; j < n; j++) {
			if (a[startindex][j]==1&&visited[j]==false) {
				search(j);
				
			}else{
				continue;
			}
			
		}
		//一个result结束后踢掉最后一个，寻找别的可能性，若没有的话，则继续向前踢掉当前最后一个
		result = result.substring(0, result.length()-1);
		visited[startindex]=false;
	}
	
	public static void main(String[] args) {
		new numberRandom().searchMap();
	}
	
}
