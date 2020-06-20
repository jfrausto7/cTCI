package cTCI;

public class isOneAway {
	
	public static Boolean isOneAway(String s, String t) {
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		int diff = Math.abs(a.length - b.length);
		
		//check difference and respond accordingly
		if(diff > 1) {
			return false;
		}else if(diff == 1) {
			return checkDiff(a,b);
		}else {
			return checkSame(a,b);
		}
	}
	
	//method for if different number of characters in strings
	public static Boolean checkDiff(char[] a, char[] b) {
		char[] big;
		char[] small;
		int pointer = 0;
		
		if(a.length > b.length) {
			big = a;
			small = b;
		}else {
			big = b;
			small = a;
		}
		
		for(char i : small) {
			if(i != big[pointer]) {
				if(i != big[pointer + 1]) {
					return false;
				}
			}
			pointer++;	//increment pointer
		}
		return true;
	}
	
	//method for if same number of characters in strings
	public static Boolean checkSame(char[] a, char[] b) {
		Boolean tracker = false;
		int pointer = 0;
		
		for(char j : a) {
			if(j != b[pointer]) {
				if(tracker == false) {
					tracker = true;
				}else {
					return false;
				}
			}
			pointer++;
		}
		return true;
	}
	
	
	//driver method
	public static void main(String[] args) {
		
		//driver code
		
		//true values
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("yalla", "yalla"));
		System.out.println(isOneAway("apple", "aple"));
		
		System.out.println("Now for false values.");

		//false values
		System.out.println(isOneAway("pale", "bales"));
		System.out.println(isOneAway("pal", "bales"));
		System.out.println(isOneAway("talk", "walks"));
	}

}
