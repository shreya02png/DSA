import java.util.Stack; 
public class removeKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If there are still digits to remove, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the resulting number
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        removeKDigits solution = new removeKDigits();
        String num = "1432219";
        int k = 3;
        String result = solution.removeKdigits(num, k);
        System.out.println(result); // Output: "1219"
    }
}

//tc: O(n)
//sc: O(n) in worst case when all digits are in increasing order, O(n-k) in best case when all digits are in decreasing order.


//we solve this problem using stack. 
//We iterate through each digit in the input number and compare it with the top of the stack.
// If the current digit is smaller than the top of the stack and we still have digits to remove (k > 0), we pop from the stack.
// This ensures that we are removing larger digits before smaller ones, which helps in forming the smallest possible number.
// After processing all digits, if there are still digits to remove, we pop from the end of the stack.
// Finally, we build the resulting number and remove any leading zeros before returning it.