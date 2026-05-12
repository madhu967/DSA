class Solution {
    public int totalFruit(int[] fruits) {
        int start=0,end=0;
        int n=fruits.length,maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(end<n){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            int curlen=end-start+1;
            maxlen=Math.max(maxlen,curlen);
            end++;
        }
        return maxlen;
    }
}
