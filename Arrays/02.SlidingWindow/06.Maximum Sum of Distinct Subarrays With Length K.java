class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = 0;

        long sum = 0;
        long maxsum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (high < n) {

            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            sum += nums[high];

            while (high - low + 1 > k) {

                int removes = nums[low];

                map.put(removes, map.get(removes) - 1);

                sum -= nums[low];

                if (map.get(removes) == 0) {
                    map.remove(removes);
                }

                low++;
            }

            if (map.size() == k && high - low + 1 == k) {
                maxsum = Math.max(maxsum, sum);
            }

            high++;
        }

        return maxsum;
    }
}
