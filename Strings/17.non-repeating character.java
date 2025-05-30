/*
Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
*/
class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) 
            freq[ch - 'a']++;
        for (int i = 0; i < s.length();i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
        return '$';
    }
}
