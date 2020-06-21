package cTCI;

public class compressedString {
	
	public static String compressedString(String s) {
		char[] a = s.toCharArray();
		char tracker = a[0];
		int count = 0;
		StringBuilder result = new StringBuilder();
		
		//iterate through the string
		for(char i : a) {
			if(i == tracker) count++;
			else {
				result = addToString(result, tracker, count);
				tracker = i;
				count = 1;
			}
		}
		
		//add last character to string
		result = addToString(result, tracker, count);
		
		//check difference in size at end
		if(result.length() < s.length()) {
			return result.toString();
		}else {
			return s;
		}
	}
	
	
	//helper method used to add values in character form to string; O(1) time as StringBuilder
	public static StringBuilder addToString(StringBuilder result, char tracker, int count) {
		result.append(tracker);
		result.append(count);
		return result;
	}
	
	//driver code
	public static void main(String[] args) {
		
		//compressed values
		System.out.println(compressedString("aabcccccaaa"));
		System.out.println(compressedString("aaaabbbcddeeeeffff"));
		System.out.println(compressedString("aaabbbcc"));
		
		//original values
		System.out.println(compressedString("abcabcabcd"));
		System.out.println(compressedString("abcdefghijk"));
	}

}
