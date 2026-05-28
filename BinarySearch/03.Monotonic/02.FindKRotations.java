class Solution {
    public int findKRotation(int nums[]) {
        // Code here
        int low=0,high=nums.length-1;
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[nums.length-1]){
                low=mid+1;
            }
            else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
}
