import java.util.*;

class Solution {
    public void bfs(int start, ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}
