class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        while(n>0){
            int digit=n%10;
            map.put(digit,map.getOrDefault(digit,0)+1);
            n=n/10;
        }
        for(int i:map.keySet()){
            sum+=(i*map.get(i));
        }
        return sum;
    }
}
