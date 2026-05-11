class Solution {

    public List<List<Integer>> triplets(long[] arr, int target) {

        int n = arr.length;

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n - 2; i++) {

            int j = i + 1;
            int k = n - 1;

            while(j < k) {

                long sum = arr[i] + arr[j] + arr[k];

                if(sum < target) {

                    
                    for(int x = k; x > j; x--) {

                        ans.add(Arrays.asList(
                            (int)arr[i],
                            (int)arr[j],
                            (int)arr[x]
                        ));
                    }

                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return ans;
    }
}
