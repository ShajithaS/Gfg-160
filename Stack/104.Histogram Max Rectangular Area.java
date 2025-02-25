/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: arr = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: arr = [2,4]
Output: 4
*/
    public static int getMaxArea(int arr[]) {
        // your code here
        int n=arr.length;
        int max=0;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();
        //fill left
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                left[i]=0;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                left[i]=st.isEmpty()?0:st.peek()+1;
                st.push(i);
            }
        }
        //clear stack
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=n-1;i>=0;--i){
            if(st.isEmpty()){
                right[i]=n-1;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                right[i]=st.isEmpty()?n-1:st.peek()-1;
                st.push(i);
            }
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]*(right[i]-left[i]+1));
        }
        return max;
        
    }
/*
The algorithm processes each element in the array three times:
Once for computing the left limits (O(n))
Once for computing the right limits (O(n))
Once for computing the maximum area (O(n))
The stack operations (push and pop) occur at most once per element, leading to O(n) complexity per pass.
Therefore, the total time complexity is O(n) + O(n) + O(n) = O(n).
Space Complexity (SC):
Auxiliary Arrays: left[] and right[] each take O(n) space.
Stack: In the worst case (strictly increasing or decreasing array), the stack can grow to O(n) elements.
Total space complexity is O(n) + O(n) + O(n) = O(n).
Final Complexity Analysis:
Time Complexity: O(n)
Space Complexity: O(n)
*/
