/*
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
*/
//Naive approach:Linear Search, TC:O(n)
static int countFreq(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
          
            // If the current element is equal to 
            // target, increment the result
            if (arr[i] == target)
                res++;
        }
      
        return res;
}

//Optimal approach: Binary search , O(logn)
class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int cnt=upperbound(arr,target)-lowerbound(arr,target);
        return cnt;
    }
    private static int lowerbound(int[] arr, int target){
        int ans=arr.length;
        int low = 0, high = arr.length - 1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }      
        return ans;
    }
    private static int upperbound(int[] arr, int target){
        int ans=arr.length;
        int low = 0, high = arr.length - 1;
        while(low<=high){
        int mid=low+(high-low)/2;
        if(arr[mid]>target){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
        }
        return ans;
    }
}
