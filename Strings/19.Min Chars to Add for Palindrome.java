/*
Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
  */
class Solution {
    public static int minChar(String s) {
        // Write your code here
        int slen=s.length();
        String reverse= new StringBuilder(s).reverse().toString();
        s = s + "-" + reverse;
        int n=s.length();
        int lps[]=new int[n];
        lps[0]=0;
        int len=0;
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(len)){
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
        int ans=slen-lps[n-1];
        return ans;
    }
}
