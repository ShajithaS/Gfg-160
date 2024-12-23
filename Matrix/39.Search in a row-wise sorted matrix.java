/*
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Examples :

Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true.
Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
Output: false
Explanation: 56 is not present in the matrix, so the output is false.
Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
Output: false
Explanation: 91 is not present in the matrix.
*/
//[Naive Approach] Comparing with all elements – O(n*m) Time and O(1) Space
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==x){
                    return true;
                }
            }
        }
        return false;
    }
}

//[Expected Approach] Using Binary Search - O(n * log(m)) Time and O(1) Space
class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        for(int i=0;i<mat.length;i++){
            // Perform binary search on the ith row
            if (search(mat[i], x))
                return true;
        }
        return false;
    }
  static boolean search(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // If x == mid, return true
            if (x == arr[mid])
                return true;

            // If x < arr[mid], search in the left half
            if (x < arr[mid])
                hi = mid - 1;

            // If x > arr[mid], search in the right half
            else
                lo = mid + 1;
        }
        return false;
  }
}
