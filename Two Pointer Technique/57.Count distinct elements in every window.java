/*
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2. 
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1. 
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
*/

//[Naive Approach] Traversing all windows of size k – O(n * k) Time and O(1) Space
class GfG {
    static ArrayList<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;  
        ArrayList<Integer> res = new ArrayList<>();
      
        // Iterate over every window
        for (int i = 0; i <= n - k; i++) {
          
            // Hash Set to count unique elements
            HashSet<Integer> st = new HashSet<>();
            for(int j = i; j < i + k; j++)
                st.add(arr[j]);
          
            // Size of set denotes the number of unique elements
            // in the window
            res.add(st.size());
        }
        return res;
    }
}

//[Expected Approach] Sliding Window Technique – O(n) Time and O(k) Space

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        res.add(map.size());
        for(int i=k;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k])==0){
                map.remove(arr[i-k]);
            }
            res.add(map.size());
        }
        return res;
    }
}
