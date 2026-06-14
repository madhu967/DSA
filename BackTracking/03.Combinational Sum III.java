class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, k, n, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int ind, int k, int target,
                                  List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind > 9 || target < 0 || k < 0) {
            return;
        }

        for (int i = ind; i <= 9; i++) {

            ds.add(i);
            findCombinations(i + 1, k - 1, target - i, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
