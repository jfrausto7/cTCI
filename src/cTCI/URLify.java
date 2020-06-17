package cTCI;

import java.util.Arrays;

public class URLify {
	
	public static String urlIFY(String s) {
		
		char[] c = s.toCharArray();
		int spaces = 0;
		char[] t;
		for(char i: c) {
			if(i == ' ') {
				spaces++;
			}
		}
		
		t = new char[c.length + (spaces*2)];
		int newIndex = c.length + (spaces * 2) - 1;
		
		for(int i = c.length - 1; i > -1; i--) {
			if(c[i] == ' ') {
				t[newIndex] = '0';
				t[newIndex - 1] = '2';
				t[newIndex - 2] = '%';
				newIndex -= 3;
			}else {
				t[newIndex] = c[i];
				newIndex--;
			}
			
			//reduce along with loop
			
			
		}
		
		return String.valueOf(t);
		
	}
	
	public static void main(String[] args) {
		System.out.println(urlIFY("Mr John Smith"));
	}

}
