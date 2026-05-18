class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int maxlen=1;
        int curr=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                curr++;
                maxlen=Math.max(maxlen,curr);
            }
            else{
                curr=1;
            }
            
        }
        return maxlen;
    }
}
