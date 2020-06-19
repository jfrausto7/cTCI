package cTCI;

import java.util.HashMap;
import java.util.Map;


public class palindromePerm {
	
	public static Boolean isPerm(String s) {
		char[] c = s.toCharArray();
		int tracker;
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		
		//check to see if string length is even; act accordingly
		if(c.length % 2 == 0) {
			tracker = 1;
		}else {
			tracker = 0;
		}
		
		//populate the HashMap
		for(char i : c) {
			if(chars.containsKey(i)) {
				chars.put(i, chars.get(i) + 1);
			}else {
				chars.put(i, 1);
			}
		}

		//iterate through HashMap and check for result of algorithm
		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			
			if(entry.getValue() % 2 != 0) {
				if(tracker == 1) {
					return false;
				}else {
					tracker++;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		//driver code
		
		//true values to be tested
		System.out.println(isPerm("poop"));
		System.out.println(isPerm("acerarc"));
		System.out.println(isPerm("iccvi"));
		System.out.println(isPerm("oom"));
		System.out.println(isPerm("velel"));
		
		//false values to be tested
		System.out.println(isPerm("shot"));
		System.out.println(isPerm("hope"));
		System.out.println(isPerm("lip"));
		System.out.println(isPerm("malicious"));
		System.out.println(isPerm("palindrome"));
	}

}
