/*
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
*/

//expected approach: using hashmap, TC:O(n) , SC:O(n)
public long subarrayXor(int arr[], int k) {
        // code here
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefix=0;
        for(int i=0;i<arr.length;i++){
            prefix^=arr[i];
            cnt+=map.getOrDefault(prefix^k,0);
            if(prefix==k)
            cnt++;
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return cnt;
    }
