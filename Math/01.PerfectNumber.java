class Solution{
    public boolean checkPerfectNumber(int num) {
        if (num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336) {
            return true;
        } else {
            return false;
        }
    }
}

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}
