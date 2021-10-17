package Assignment5;

import java.util.Stack;

public class Q3 {
    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty();
    }
}
// Time complexity: O(n);
// Space complexity: O(n);