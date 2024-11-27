class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int max=0;
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                continue;
            }
            if(max==arr[i] || arr[i]==max+1){
                max=arr[i];
            }
            else{
                break;
            }
        }
        return max+1;
    }
}
