class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Arrays.fill(ans,0);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    ans[i]=j-i;
                    break;
                }
            }
        }
        return ans;
    }
}



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Arrays.fill(ans,0);
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ans;
    }
}
