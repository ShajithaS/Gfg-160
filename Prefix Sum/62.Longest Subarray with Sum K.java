/*
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
*/

//[Expected Approach] Using Hash Map and Prefix Sum – O(n) Time and O(n) Space

    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int prefsum=0;
        for(int i=0;i<arr.length;i++){
            prefsum+=arr[i];
            if(prefsum==k)
                res=i+1;
            else if(map.containsKey(prefsum-k))
                res=Math.max(res,i-map.get(prefsum-k));
            if(!map.containsKey(prefsum))
                map.put(prefsum,i);
        }
            return res;
    }
}