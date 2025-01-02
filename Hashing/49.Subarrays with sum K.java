/*
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107
*/

//[Naive Approach] Using Nested Loop – O(n^2) Time and O(1) Space
static int countSubarrays(int[] arr, int k) {
        int res = 0;

        // Pick a starting point of the subarray
        for (int s = 0; s < arr.length; s++) {
            int sum = 0;

            // Pick an ending point
            for (int e = s; e < arr.length; e++) {
                sum += arr[e];
                if (sum == k)
                    res++;
            }
        }

        return res;
    }

//[Expected Approach] Using Hash Map and Prefix Sum – O(n) Time and O(n) Space

public int countSubarrays(int arr[], int k) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                cnt++;
            }
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
