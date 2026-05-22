class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int[] freq = new int[k];
        int prefixSum = 0;
        int count = 0;

        freq[0] = 1;

        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;

            if (rem < 0) {
                rem += k;
            }

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }
}


class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem,
                    map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
