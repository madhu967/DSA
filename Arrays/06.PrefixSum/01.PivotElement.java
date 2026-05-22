class Solution {
    public int pivotIndex(int[] nums) {
        int prefixsum=0,sum=0,right=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            
            right=sum-nums[i]-prefixsum;
            if(prefixsum==right){
                return i;
            }
            prefixsum+=nums[i];
        }
        return -1;
    }
}
