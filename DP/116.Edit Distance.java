/*Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
Examples:

Input: s1 = "geek", s2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e' in s1.
Input: s1 = "gfg", s2 = "gfg"
Output: 0
Explanation: Both strings are same.
Input: s1 = "abcd", s2 = "bcfe"
Output: 3
Explanation: We can convert s1 into s2 by removing ‘a’, replacing ‘d’ with ‘f’ and inserting ‘e’ at the end. */

class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int len2=s2.length();
        int len1=s1.length();
        int dp[][]=new int[len2+1][len1+1];
        for(int i=0;i<=len2;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=len1;j++){
             dp[0][j]=j;   
        }
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int left=dp[i][j-1];
                    int top=dp[i-1][j];
                    int topleft=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(top,Math.min(left,topleft));
                }
            }
        }
        return dp[len2][len1];
    }
}
//Time Complexity: O(n × m)
//Space Complexity: O(n × m) (can be optimized to O(min(n, m)) with space optimization)
