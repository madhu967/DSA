import java.util.*;

class Solution {

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        int[] topo = new int[V];
        int idx = 0;

        while (!stack.isEmpty()) {
            topo[idx++] = stack.pop();
        }

        return topo;
    }

    private static void dfs(int node,
                            ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited,
                            Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // Push after all children are processed
        stack.push(node);
    }
}
