package cTCI;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Hashtable;

public class uniqueLetters {
	
	public static void main(String[] args){
		
		//testing for algorithm
		System.out.println(uniqueChar("poop"));
		System.out.println(uniqueChar("theword"));
		System.out.println(uniqueChar("Alamo"));
		System.out.println(uniqueChar("Jeb"));
		
	}
	
	//actual algorithm uses a hashtable
	public static Boolean uniqueChar(String word) {
		Hashtable<Character, Integer> chars = new Hashtable<Character, Integer>();
		CharacterIterator letters = new StringCharacterIterator(word);
		while(letters.current() != CharacterIterator.DONE) {
			char c = Character.toLowerCase(letters.current());
			if(chars.containsKey(c)) {
				return false;
			}else {
				chars.put(c, 1);
			}
			letters.next();
		}
		return true;
	}

}
