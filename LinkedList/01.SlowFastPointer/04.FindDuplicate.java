
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;
    }
}




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
