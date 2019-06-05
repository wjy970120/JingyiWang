/* Reverse Integer:
 * Given a 32-bit signed integer, reverse digits of an integer.
 */

class Solution7 {
    public int reverse(int x) {
        // If we use int to store the reversed result, then when it overflows, the data bit of the 
    	// overflow part will be discarded, resulting in incorrect result.
    	// As a result, we use a longer data type long to store the reversed result, so there is certainly 
    	// no loss of data bits.
    	long result = 0;
        while(x != 0) {
        	result = result * 10 + x % 10;
        	x = x / 10;
        }
        
        // Directly compare the reversed result with the upper and lower limits of the int type to determine
        // whether it overflows.
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        	return 0;
        }
        else return (int)result;
    }
}