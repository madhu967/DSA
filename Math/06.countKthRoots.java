class Solution {
    public int countKthRoots(int l, int r, int k) {
        int st = (int)Math.ceil(Math.pow(l, 1.0 / k) - 1e-9);
        int end = (int)Math.floor(Math.pow(r, 1.0 / k) + 1e-9);
        return Math.max(0, end - st + 1);
    }
}
