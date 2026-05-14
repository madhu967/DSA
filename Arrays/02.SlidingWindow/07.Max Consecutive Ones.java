class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int count=0,maxcount=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count+=1;
            }
            else{
                maxcount=Math.max(count,maxcount);
                count=0;
            }
        }
        return maxcount=Math.max(maxcount,count);
    }
}
