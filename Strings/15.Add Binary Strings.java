/*
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
*/
class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        int len1=s1.length(),len2=s2.length();
        if(len1>len2){
            s2="0".repeat(len1-len2)+s2;
        }
        else{
            s1="0".repeat(len2-len1)+s1;
        }
        StringBuilder sb=new StringBuilder();
        int carry=0;
        for(int i=s1.length()-1;i>=0;i--){
            int bit1=s1.charAt(i)-'0';
            int bit2=s2.charAt(i)-'0';
            int sum=bit1+bit2+carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        if(carry==1){
            sb.append(carry);
        }
        String ans=sb.reverse().toString();
        return ans.replaceFirst("^0+(?!$)","");
    }
}
