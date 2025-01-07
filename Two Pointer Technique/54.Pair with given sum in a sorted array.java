/*
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.
*/
// better approach: Using Hash Map or Dictionary – O(n) Time and O(n) Space
class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                cnt+=map.get(target-arr[i]);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return cnt;
    }
}


//expected approach: Using Two Pointer Technique – O(n) and O(1) Space


class GfG {

    // Function to return the count of pairs
    static int countPairs(int[] arr, int target) {
        int res = 0;
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
          
            // If sum is greater 
            if (arr[left] + arr[right] < target)
                left++;

            // If sum is lesser
            else if (arr[left] + arr[right] > target)
                right--;

            // If sum is equal
            else {
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];
              
                // Count frequency of first element of the pair
                while (left <= right && arr[left] == ele1) {
                    left++;
                    cnt1++;
                }
              
                // Count frequency of second element of the pair
                while (left <= right && arr[right] == ele2) {
                    right--;
                    cnt2++;
                }
               
                // If both the elements are same, then count of
                // pairs = the number of ways to choose 2 
                // elements among cnt1 elements
                if (ele1 == ele2) 
                    res += (cnt1 * (cnt1 - 1)) / 2;
              
                // If the elements are different, then count of
                // pairs = product of the count of both elements
                else 
                    res += (cnt1 * cnt2);
            }
        }
        return res;
    }
}
