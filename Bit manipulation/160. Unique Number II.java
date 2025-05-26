/*
Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas only two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

Examples:

Input: arr[] = [1, 2, 3, 2, 1, 4]
Output: [3, 4] 
Explanation: 3 and 4 occur exactly once.
Input: arr[] = [2, 1, 3, 2]
Output: [1, 3]
Explanation: 1 and 3 occur exactly once.
Input: arr[] = [2, 1, 3, 3]
Output: [1, 2]
Explanation: 1 and 2 occur exactly once.
*/

class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        int xor=0;
        for(int num:arr){
            xor^=num;
        }
        //find setbit
        int set=xor & (-xor);
        int x=0;
        int y=0;
        //divide into two groups and xor separately
        for(int num:arr){
            if((set&num)==0){
                x^=num;
            }
            else{
                y^=num;
            }
        }
        //return ans in increasing order
        int res[]=new int[]{x,y};
        Arrays.sort(res);
        return res;
    }
}
