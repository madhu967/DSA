class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (fast < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                slow = nums[0];

                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }

                return slow;
            }
        }

        return -1;
    }
}
