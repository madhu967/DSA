class Solution {
    HashSet<Character> hs = new HashSet<>();
    public int passwordStrength(String password) {
        int res = 0;
        for(char ch : password.toCharArray()){
            if(hs.contains(ch)){
                continue;
            }
            if(isLowerCase(ch)){
                res += 1;
            }
            else if(isUpperCase(ch)){
                res += 2;
            }
            else if(isDigit(ch)){
                res += 3;
            }
            else if(specialChar(ch)){
                res += 5;
            }
            hs.add(ch);
        }
        return res;
        
    }
    private boolean isLowerCase(char ch){
        return ch >= 'a' && ch <= 'z';
    }
    private boolean isUpperCase(char ch){
        return ch >= 'A' && ch <= 'Z' ;
    }
    private boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
    private boolean specialChar(char ch){
        return "!@#$".indexOf(ch) != -1;
    }
}
