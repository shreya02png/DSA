import java.util.*;

// The problem is basically checking if magazine has enough letters to form the ransom note.
// I treat it like a frequency counting problem. First, 
// I count how many times each character appears in the magazine.
// Then I go through each character in the ransom note and reduce its count.
// If at any point the count becomes negative,
// it means magazine doesn't have enough letters,so I return false.
// If I finish checking all characters successfully, I return true.
// Since the characters are lowercase English letters,
// I use an array of size 26 for optimal performance,
// giving O(n + m) time complexity and constant space.

public class RansomNoteAllApproaches {

    // Approach 1: Brute Force
    //tc: O(n*m) where n is the length of ransomNote and m is the length of magazine
    //sc: O(1) as we are modifying the magazine string in place
    public static boolean bruteForce(String ransomNote, String magazine) {
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c);
            if (index == -1) {
                return false;
            }
            magazine = magazine.substring(0, index) + magazine.substring(index + 1);
        }
        return true;
    }

    // Approach 2: HashMap
    //tc: O(n + m) where n is the length of ransomNote and m is the length of magazine
    //sc: O(1) as we are only storing counts of characters (26 lowercase letters)
    public static boolean hashMapApproch(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    // Approach 3: Array (Optimal)
    //tc: O(n + m) where n is the length of ransomNote and m is the length of magazine
    //sc: O(1) as we are only storing counts of characters (26 lowercase letters)
    public static boolean arrayApproach(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println("Brute Force: " + bruteForce(ransomNote, magazine));
        System.out.println("HashMap: " + hashMapApproch(ransomNote, magazine));
        System.out.println("Array Optimal: " + arrayApproach(ransomNote, magazine));
    }
}
