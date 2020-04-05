package com.edwin.codeutil;

import com.edwin.lianxi.numberRandom;

/**
 * @author Administrator
 *Java实现encode()和Decode()方法
 * 
 * 请你用java，c，c++ 中任何一种语言实现两个函数encode（）和decode（），分别实现对字符串的变换和复原。
变换函数encode（）顺序考察以知字符串的字符，按以下规则逐组生成新字符串：

1、若已知字符串的当前字符不是大于0的数字字符，则复制该字符与新字符串中；

2、若以已知字符串的当前字符是一个数字字符，且他之后没有后继字符，则简单地将它复制到新字符串中；
3、若以已知字符串的当前字符是一个大于0的数字字符，并且还有后继字符,设该数字字符的面值为n,
     则将它的后继字符(包括后继字符是一个数字字符) 重复复制n+1 次到新字符串中;
4、以上述一次变换为一组,在不同组之间另插入一个下划线'_'用于分隔;
5、若以知字符串中包含有下划线'_'，则变换为用"\UL".

 例如:encode()函数对字符串24ab_2t2的变换结果为 444_aaaaa_a_b_\UL_ttt_t_2
 *
 */
public class EnCodeAndDecode {
	
	/**
	 * 字符串的变换
	 * @param data
	 * @return
	 */
	public static String enCode(String data){
		if(null ==data||"".equals(data)){
			return null;
		}
		
		StringBuffer enData = new StringBuffer();
		//遍历字符
		int l =  data.length();
		for (int i = 0; i < l; i++) {
			char c = data.charAt(i);
			if (Character.isDigit(c)){//判断是否是数字
				if (c<='0') {//满足条件1
					enData.append(c);
				}
				if (i==l-1) {//满足条件2
					enData.append(c);
					continue;
				}
				if (c> '0'&&i<l-1) {//满足条件3
					int n = Integer.parseInt(""+c)+1;
					while (n>0) {
						enData.append(data.charAt(i+1));
						n--;
					}
				}
			}else{//非数字
				if ("_".equals(""+c)) {//满足条件5
					enData.append("\\UL");
				}else {//其他隐含条件
					enData.append(c);
				}
			}
			enData.append("_");//条件4
		}
		return enData.toString();
	}
	
	
	
	public static String deCode(String enData){
		if (null==enData||"".equals(enData)) 
			return null;
		
		if (enData.indexOf("_")==-1) 
			return enData;
	
		StringBuffer data = new StringBuffer();
		for (String str : enData.split("_")) {
			if (str.length()==1) {
				data.append(str);
			} else {
				if ("\\UL".equals(str)) {
					data.append("_");
				} else {
					int n = str.length()-1;
					data.append(n);
				}
			}
		}
		
		return data.toString();
	}
	
	public static void main(String[] args) {
		String data ="24ab_2t2";
		System.out.println("data:"+data);
		System.out.println("enData："+enCode(data));
		System.out.println("复原后的data:"+deCode(enCode(data)));
		
	}
	

}
