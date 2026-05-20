class Solution {
    public int maxSubArray(int[] nums) {
        int best=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            best=Math.max(nums[i],best+nums[i]);
            ans=Math.max(best,ans);
        }
        return ans;
    }
}
