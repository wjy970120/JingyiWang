/* Valid Parentheses:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */

class Problem20 {
    public boolean isValid(String s) {
        if(s.isEmpty() == true) return true;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	if(temp == '(' || temp == '{' || temp == '[') stack.push(temp);
        	// If it's not a left parentheses and there is no left parentheses before, then it's false.
            else if(stack.isEmpty()) return false;
        	else if(temp == ')' && stack.pop() != '(') return false;
        	else if(temp == '}' && stack.pop() != '{') return false;
        	else if(temp == ']' && stack.pop() != '[') return false;
        }
        
        return stack.isEmpty();
    }
}