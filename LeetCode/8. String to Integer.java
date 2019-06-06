/* String to Integer:
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are ignored
 * and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such
 * sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Assume we are dealing with an environment which could only store integers range: [-2^31, 2^31 - 1]. If the numerical
 * value is out of the range of representable values, INT_MAX or INT_MIN is returned.
 */

class Problem8 {
    public int myAtoi(String str) {
    	
    	String strNew = str.trim(); // Return a string whose value is this string, with any leading and trailing whitespace removed.
    	if(strNew == null || strNew.isEmpty()) return 0;
    	
    	int index = 0;
    	int sign = 1;
    	
    	char first = strNew.charAt(index);
    	if(first == '-' || first == '+') {
    		sign = first == '-'? -1 : 1;
    		index++;
    	}
    	
    	long res = 0;
    	
    	while(index < strNew.length()) {
    		char temp = strNew.charAt(index);
        	int digit = temp - '0';
        	if(digit < 0 || digit > 9) break;
        	res = res * 10 + digit;
        	index++;
        	// Detect overflow.
        	if(res > Integer.MAX_VALUE) {
        		return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
    	}
    	
    	return (int)res * sign;
    }
}



