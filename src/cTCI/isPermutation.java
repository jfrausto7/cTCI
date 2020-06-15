package cTCI;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

public class isPermutation {
	
	public static Boolean isPerm(String a, String b) {
		
		// check base case
		if(a.length() != b.length()) {
			return false;
		}
		
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		CharacterIterator aletters = new StringCharacterIterator(a);
		CharacterIterator bletters = new StringCharacterIterator(b);
		
		//actual iterations
		while(aletters.current() != CharacterIterator.DONE) {
			chars.put(Character.toLowerCase(aletters.current()), 1);
			aletters.next();
		}
		while(bletters.current() != CharacterIterator.DONE) {
			if(!chars.containsKey(Character.toLowerCase(bletters.current()))) {
				return false;
			}
			else {
				if(chars.get(Character.toLowerCase(bletters.current())) == 2) {
					return false;
				}
				chars.put(Character.toLowerCase(bletters.current()), 2);
			}
			bletters.next();
		}
		
		//final return statement if not caught in second while loop
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPerm("abc", "cab"));
		System.out.println(isPerm("poop", "pop"));
		System.out.println(isPerm("shot", "tosh"));
		System.out.println(isPerm("sniff", "rot"));
	}

}
