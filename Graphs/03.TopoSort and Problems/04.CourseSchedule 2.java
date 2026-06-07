class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preq = pre[1];

            adj.get(preq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            res[idx++] = node;

            for (int neigh : adj.get(node)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        if (idx == numCourses) {
            return res;
        }

        return new int[0];
    }
}
