class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> count=new HashMap<>();
        for(char c:text.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        int ans = count.getOrDefault('b', 0);

        ans = Math.min(ans, count.getOrDefault('a', 0));
        ans = Math.min(ans, count.getOrDefault('l', 0) / 2);
        ans = Math.min(ans, count.getOrDefault('o', 0) / 2);
        ans = Math.min(ans, count.getOrDefault('n', 0));

        return ans;
    }
}
