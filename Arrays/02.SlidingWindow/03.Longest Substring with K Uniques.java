class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int low=0,high=0;
        int maxlen=-1;
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        while(high<s.length()){
            char ch=s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char left=s.charAt(low);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                low++;
            }
            if(map.size()==k){
                maxlen=Math.max(maxlen,high-low+1);
            }
            high++;
        }
        return maxlen;
    }
}
