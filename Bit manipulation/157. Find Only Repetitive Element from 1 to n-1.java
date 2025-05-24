/*
Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.

Note: It is guaranteed that there is a repeating element present in the array.

Examples:

Input: arr[] = [1, 3, 2, 3, 4]
Output: 3 
Explanation: The number 3 is the only repeating element.
Input: arr[] = [1, 5, 1, 2, 3, 4]
Output: 1  
Explanation: The number 1 is the only repeating element.
Input: arr[] = [1, 1]  
Output: 1
Explanation: The array is of size 2 with both elements being 1, making 1 the repeating element.
*/

//1. Naive Solution (Brute Force)
public class NaiveSolution {
    public static int findDuplicate(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1; // no duplicate found (shouldn't happen in this problem)
    }
}
//⏱ Time Complexity: O(n²) – due to nested loops

//🧠 Space Complexity: O(1) – constant space

//2. Optimized Solution using Hashing
import java.util.HashSet;

public class HashingSolution {
    public static int findDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
//⏱ Time Complexity: O(n)

//🧠 Space Complexity: O(n) – for storing elements in the set

// 3. Optimized Solution using XOR (Bit Manipulation)

public class XORSolution {
    public static int findDuplicate(int[] arr) {
        int xor = 0;
        int n = arr.length;

        for (int num : arr) {
            xor ^= num;
        }

        for (int i = 1; i <= n - 1; i++) {
            xor ^= i;
        }

        return xor;
    }
}
//⏱ Time Complexity: O(n)

//🧠 Space Complexity: O(1) – constant space
