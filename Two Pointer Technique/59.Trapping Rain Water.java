/*
Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
*/


//[Expected Approach] Using Two Pointers – O(n) Time and O(1) Space

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left=0,right=arr.length-1;
        int lmax=arr[0],rmax=arr[arr.length-1];
        int water=0;
        while(left<right){
            if(lmax<=rmax){
                water+=lmax-arr[left++];
                lmax=Math.max(lmax,arr[left]);
            }
            else{
                water+=rmax-arr[right--];
                rmax=Math.max(rmax,arr[right]);
            }
        }
        return water;
    }
}
