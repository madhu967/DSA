import java.util.*;

class Solution {

    public String findOrder(String[] dict, int N, int K) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < N - 1; i++) {

            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {

                if (s1.charAt(j) != s2.charAt(j)) {

                    adj.get(s1.charAt(j) - 'a')
                       .add(s2.charAt(j) - 'a');

                    break;
                }
            }
        }

        int[] indegree = new int[K];

        for (int u = 0; u < K; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.append((char)(node + 'a'));

            for (int neighbor : adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return ans.toString();
    }
}
