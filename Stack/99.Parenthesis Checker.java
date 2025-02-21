/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "([]"
Output: False
Explanation: The expression is not balanced as there is a missing ')' at the end.
Input: s = "([{]})"
Output: False
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
  */
class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[' )
            stack.push(ch);
            else if(ch==')'||ch==']'||ch=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if((ch==')'&&top!='(')||(ch==']'&&top!='[')||(ch=='}'&&top!='{'))
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//The overall time complexity is O(n).
//The overall space complexity is O(n) in worst case
/*The worst-case scenario occurs when all characters are opening brackets (e.g., "(((([[{{") and get stored in the stack.
In this case, the stack will store all n characters, leading to O(n) space complexity.
In the best case (valid sequence like "(){}[]"), the stack remains mostly empty.*/
