public class ReverseStringAllWays {

    // 1. Using char array
    //tc: O(n), sc: O(n)
    static String reverseUsingCharArray(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return new String(arr);
    }

    // 2. Using StringBuilder
    //tc: O(n), sc: O(n)
    static String reverseUsingStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 3. Using for loop (concatenation)
    //tc: O(n^2), sc: O(n)
    static String reverseUsingForLoop(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }


    public static void main(String[] args) {
        String s = "HelloWorld";

        System.out.println(reverseUsingCharArray(s));
        System.out.println(reverseUsingStringBuilder(s));
        System.out.println(reverseUsingForLoop(s));
    }
}