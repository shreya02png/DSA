import java.util.*;
public class balancedBrackets {

    // Stack Approach
    // "Opening → push"
    // "Closing → check top"

//Time Complexity (TC):O(n)-We traverse the string once.
// Space Complexity (SC):-O(n) in worst case when all characters are opening brackets and stored in stack.

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";
        System.out.println(isBalanced(s1));
        System.out.println(isBalanced(s2));
        System.out.println(isBalanced(s3));
    }
}


//1.Create an empty stack
//2.Traverse the string character by character
//3.If character is:
//   >>'(' or '{' or '[' → push into stack
//4.If character is:
//   >>')' or '}' or ']'
//      >>If stack is empty →INVALID
//      >>Pop top element
//      >>Check if it matches the closing bracket
//      >>If not matching →INVALID
// 5.After traversal:
//   >>If stack is empty →VALID
//   >>Else →  INVALID