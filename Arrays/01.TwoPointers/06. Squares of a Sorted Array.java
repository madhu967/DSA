class Solution {
    public int[] sortedSquares(int[] nums) {
         int n=nums.length;
         int k=n-1;
         int[] res=new int[n];
         int i=0,j=n-1;
         while(i<=j){
            if(Math.abs(nums[j])>=Math.abs(nums[i])){
                res[k]=nums[j]*nums[j];
                j--;
               
                
            }
            else{
                res[k]=nums[i]*nums[i];
                i++;
            
            }
            k--;

         }
         return res;
    }
}
