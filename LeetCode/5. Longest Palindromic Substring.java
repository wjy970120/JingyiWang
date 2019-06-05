/* Longest Palindromic Substring:
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */

class Solution5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        String longest = s.substring(0, 1);
        // Center extension is to treat each letter of a given string as the center.
        for(int i = 0; i < s.length(); i++) {
            // Similar to the case of aba, extending from i to both sides.
        	String temp = helper(s, i, i);
            
            if(temp.length() >= longest.length()) {
                longest = temp;
            }
            
            // Similar to the case of abba, extending to both sides centered on i and i+!.
            temp = helper(s, i, i+1);
            
            if(temp.length() >= longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }
    
    public String helper(String s, int begin, int end) {
        while(begin >= 0 && end <= s.length() -1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        
        // Because when finish the loop, begin=-1, end=s.length().
        // We should return s.substring(begin+1, end).
        return s.substring(begin + 1, end);
    }
}
