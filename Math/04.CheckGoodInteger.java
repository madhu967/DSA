class Solution {
    public boolean checkGoodInteger(int n) {
        int sum=0;
        int ssum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            ssum+=digit*digit;
            n=n/10;
        }
        if(ssum-sum>=50){
            return true;
        }
        return false;
    }
}
