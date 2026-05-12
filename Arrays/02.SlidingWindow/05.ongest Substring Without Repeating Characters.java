class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxlen=0;
        int[] charIndex=new int[128];
        Arrays.fill(charIndex,-1);
        int left=0;
        for(int right=0;right<n;right++){
            if(charIndex[s.charAt(right)]>=left){
                left=charIndex[s.charAt(right)]+1;
            }
            charIndex[s.charAt(right)]=right;
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        
        return maxLength;
    }
}
