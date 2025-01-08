/*
Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  
Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300]
Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible.

*/

// O(n^2) Time and O(1) Space

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int cnt=0,n=arr.length;
        for(int i=n-1;i>=2;--i){
            int l=0,r=i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i]){
                cnt+=(r - l);
                r--;
                }
                else
                l++;
            }
        }
        return cnt;
    }
}
