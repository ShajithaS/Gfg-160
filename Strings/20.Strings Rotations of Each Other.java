/*
You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
*/
/*[Naive Approach] Generating all rotations – O(n^2) Time and O(1) Space
The idea is to generate all possible rotations of the first string and check if any of these rotations match the second string. If any rotation matches, the two strings are rotations of each other, otherwise they are not.
*/
static boolean areRotations(String s1, String s2) {
        int n = s1.length();

        // Generate and check all possible rotations of s1
        for (int i = 0; i < n; ++i) {
            
            // If current rotation is equal to s2, return true
            if (s1.equals(s2)) {
                return true;
            }

            // Right rotate s1
            char last = s1.charAt(s1.length() - 1);
            s1 = last + s1.substring(0, s1.length() - 1);
        }
        return false;
    }


/* Using KMP Algorithm – O(n) Time and O(n) Space*/

class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        String txt = s1 + s1;
        String pat = s2;
        int len=0;
        int[] lps=new int[s2.length()];
        for(int i=1;i<s2.length();){
            if(pat.charAt(i)==pat.charAt(len)){
                lps[i]=len+1;
                i++;
                len++;
            }
            else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }
                else{
                    len=lps[len-1];
                }
            }
        }
        int slen=txt.length();
        for(int si=0,ki=0;si<slen;){
            if(txt.charAt(si)==pat.charAt(ki)){
                si++;
                ki++;
                if(ki==s2.length()){
                    return true;
                }
            }
            else{
                if(ki==0){
                    si++;
                }
                else{
                    ki=lps[ki-1];
                }
            }
        }
        return false;
    }
}

/*Using Built-in Method*/

static boolean areRotations(String s1, String s2) {
        s1 = s1 + s1;

        // find s2 in concatenated string
        return s1.contains(s2);
    }
