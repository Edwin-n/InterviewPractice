package com.edwin.algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		String str = "READY";
		if (str.equals("ONLINE")||str.equals("READY")) {
			System.out.println("ÔÚÏß");
		}
	}
	
	public ArrayList<Integer> printListFromTailToHead(String[] str) {
	    Stack<Integer> stack = new Stack<>();
	    while (str != null) {
//	        stack.
	        
	    }
	    ArrayList<Integer> ret = new ArrayList<>();
	    while (!stack.isEmpty())
	        ret.add(stack.pop());
	    return ret;
	}
}
