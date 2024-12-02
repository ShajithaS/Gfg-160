/*
Given two strings txt and pat, the task is to return all indices of occurrences of pat within txt.

Examples:

Input: txt = “abcab”,  pat = “ab”
Output: [0, 3]
Explanation: The string “ab” occurs twice in txt, first occurrence starts from index 0 and second from index 3.


Input: txt=  “aabaacaadaabaaba”, pat =  “aaba”
Output: [0, 9, 12]
*/
class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int slen=txt.length();
        int keylen=pat.length();
        int lps[]=new int[keylen];
        lps[0]=0;
        int len=0;
        for(int i=1;i<keylen;){
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
        ArrayList<Integer> ans=new ArrayList<>();
        for(int si=0,ki=0;si<slen;){
            if(txt.charAt(si)==pat.charAt(ki)){
                si++;
                ki++;
                if(ki==keylen){
                    ans.add(si-ki);
                    ki=lps[ki-1];
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
        return ans;
    }
}
