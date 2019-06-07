/* Reverse Vowels of a String:
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */

class Problem345 {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray(); // Convert this string to a new character array.
        int start = 0;
        int end = ch.length - 1;
        String vowels = "aeiouAEIOU";
        
        while(start < end) {
        	while(start < end && vowels.indexOf(ch[start]) == -1) { // If vowels.indexOf(ch[start] == -1), then it indicates that ch[start] is not a vowel.
        		start++;
        	}
        	
        	while(start < end && vowels.indexOf(ch[end]) == -1) {
        		end--;
        	}
        	
        	char temp = ch[start];
        	ch[start] = ch[end];
        	ch[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(ch);
    }
}
