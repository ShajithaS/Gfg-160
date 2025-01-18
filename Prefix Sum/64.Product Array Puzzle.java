/*
Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
*/

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length,product=1,zerocnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
            zerocnt++;
            else
            product*=arr[i];
        }
        if(zerocnt>1)
        return new int[n];
        for(int i=0;i<n;i++){
            arr[i]= zerocnt>0 ? (arr[i]==0 ? product : 0) : product/arr[i];
        }
        return arr;
    }
}

//Time Complexity: O(n), where n is the size of the array. The algorithm requires two linear traversals of the array.
//Space Complexity: O(1), as the solution uses only a constant amount of additional space.
