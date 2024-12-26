/*
Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.
Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[].
*/
//[Naive Approach] Generating all Possible Pairs – O(n^2) time and O(1) space
class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

//[Expected Approach] Using Hash Set – O(n) time and O(n) space
class GfG {
    static boolean twoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if the complement exists in the set
            if (set.contains(complement)) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);
        }
        // If no pair is found
        return false;
    }
}
