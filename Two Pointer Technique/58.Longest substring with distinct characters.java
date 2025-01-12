/*
Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
*/

static int longestUniqueSubstr(String s) {
        int n = s.length();
        int res = 0;

        // last index of all characters is initialized as -1
        int[] lastIndex = new int[MAX_CHAR];
        for (int i = 0; i < MAX_CHAR; i++) {
            lastIndex[i] = -1;
        }

        // Initialize start of current window
        int start = 0;

        // Move end of current window
        for (int end = 0; end < n; end++) {

            // Find the last index of s[end]
            // Update starting index of current window as
            // maximum of current value of end and last index + 1
            start = Math.max(start, lastIndex[s.charAt(end) - 'a'] + 1);

            // Update result if we get a larger window
            res = Math.max(res, end - start + 1);

            // Update last index of s[end]
            lastIndex[s.charAt(end) - 'a'] = end;
        }
        return res;
    }
