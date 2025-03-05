/*
ou are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

Return the length of the longest possible word chain with words chosen from the given list of words in any order.

Examples:

Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
Output: 4
Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].
Input: words[] = ["abc", "a", "ab"]
Output: 3
Explanation: The longest chain is {"a", "ab" "abc"}
Input: words[] = ["abcd", "dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
Constraint:
1 <= words.length <= 104
1 <= words[i].length <= 10
 words[i] only consists of lowercase English letters.
*/

class Solution {
    static Comparator<String> comp=(s1,s2)->s1.length()-s2.length();
    static boolean compare (String s1,String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        return first==s1.length() && second==s2.length();
    }
    public int longestStringChain(String words[]) {
        // code here
        int n=words.length;
        Arrays.sort(words,comp);
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(compare(words[i] , words[prev]) && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>max)
            max=dp[i];
        }
        return max;
        
    }
}
