/*
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
Input: arr[] = [1, -2, 1, 0, 5]
Output: [[0, 1, 2]]
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
Input: arr[] = [2, 3, 1, 0, 5]
Output: [[]]
Explanation: There is no triplet with sum 0.
  */
//[Naive Approach] Using Three Nested Loops – O(n^3) Time and O(1) Space
public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(i);
                        ans.add(j);
                        ans.add(k);
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }
//[Expected Approach] Using Hashing – O(n^3) Time and O(n^2) Space
static ArrayList<ArrayList<Integer>> findTriplets(int[] arr) {
        
        // Set to handle duplicates
        Set<ArrayList<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();

        // Store sum of all the pairs with their indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mp.computeIfAbsent(arr[i] + arr[j], 
                              k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            
            // Find remaining value to get zero sum
            int rem = -arr[i];
            if (mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for (int[] p : pairs) {
                    
                    // Ensure no two indices are same in triplet
                    if (p[0] != i && p[1] != i) {
                        ArrayList<Integer> curr = 
                          new ArrayList<>(Arrays.asList(i, p[0], p[1]));
                        Collections.sort(curr);
                        resSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(resSet);  
    }
