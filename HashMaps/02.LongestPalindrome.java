class Solution {
    public int longestPalindrome(String s) {
        int len=0;
        boolean odd=false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int val:map.values()){
            if(val%2==0){
                len+=val;
            }
            else{
                len+=(val-1);
                odd=true;
            }
        }
        if(odd) len++;
        return len;
    }
}
