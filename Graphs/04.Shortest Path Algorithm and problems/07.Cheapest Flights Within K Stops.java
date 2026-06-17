import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, src, 0});

        cost[src] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int stops = curr[0];
            int node = curr[1];
            int currCost = curr[2];

            if (stops > k) {
                continue;
            }

            for (int[] nei : adj.get(node)) {

                int adjNode = nei[0];
                int price = nei[1];

                if (currCost + price < cost[adjNode]
                        && stops <= k) {

                    cost[adjNode] = currCost + price;

                    q.offer(new int[]{
                            stops + 1,
                            adjNode,
                            cost[adjNode]
                    });
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
