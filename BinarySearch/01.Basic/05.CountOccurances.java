class Solution {

    public int countFreq(int[] nums, int target) {

        int start = search(nums, target, true);

        if(start == -1) {
            return 0;
        }

        int end = search(nums, target, false);

        return end - start + 1;
    }

    public static int search(int[] nums, int target, boolean findStartIndex) {

        int ans = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {

                ans = mid;

                if(findStartIndex) {
                    end = mid - 1;
                }

                 else {
                    start = mid + 1;
                }
            }

            else if(target < nums[mid]) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
