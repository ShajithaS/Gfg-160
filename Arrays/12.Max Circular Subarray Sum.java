class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int n=arr.length;
        int total=0;
        int max_straight=Integer.MIN_VALUE;
        int temp_max=0;
        int min_straight=Integer.MAX_VALUE;
        int temp_min=0;
        for(int i=0;i<n;i++){
            total+=arr[i];

            temp_max+=arr[i];
            max_straight=max_straight>temp_max?max_straight:temp_max;
            temp_max=temp_max<0?0:temp_max;

            temp_min+=arr[i];
            min_straight=min_straight<temp_min?min_straight:temp_min;
            temp_min=temp_min>0?0:temp_min;

        }
        if(total==min_straight){
            return max_straight;
        }
        else{
            return Math.max(max_straight,total-min_straight);
        }
        
    }
}
