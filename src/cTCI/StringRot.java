package cTCI;

public class StringRot {
	
	// Returns true if s1 is substring of s2 
    static boolean isSubstring( 
        String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
  
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
  
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) 
                    != s1.charAt(j)) 
                    break; 
  
            if (j == M) 
                return true; 
        } 
  
        return false; 
    } 
    
    
    //actual method we needed to make
    public static boolean StringRot(String s1, String s2) {
    	
    	for(int i = 1; i < s2.length(); i++) {
    		if(!isSubstring(s2.substring(0,  i),s1)) {
    			if(i == 1) return false;	//base case
    			
    			String newString = s2.substring(i-1, s2.length()) + s2.substring(0, i-1);
    			if(newString.equals(s1)) {
    				return true;
    			}else {
    				return false;
    			}
    		}
    	}
    	return false;
    }
    
    
    //Driver code
    public static void main(String[] args) {
    	
    	//true values
    	System.out.println(StringRot("waterbottle", "erbottlewat"));
    	System.out.println(StringRot("spaghetti", "ghettispa"));
    	System.out.println(StringRot("venticular", "larventicu"));
    	
    	//false values
    	System.out.println(StringRot("yeet", "yote"));
    	System.out.println(StringRot("breathe", "breath"));
    	System.out.println(StringRot("saw", "was"));
    	System.out.println(StringRot("starbucks", "buckstars"));
    	System.out.println(StringRot("ligma", "jeb "));
    	
    }

}
