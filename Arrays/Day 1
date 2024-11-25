//Second Largest
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n=arr.length;
        int l=-1,sl=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>l){
                l=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=l && arr[i]>sl){
                sl=arr[i];
            }
        }
        return sl;
    }
}
