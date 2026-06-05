class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                dist[r][c] = distance;

                for (int[] d : dirs) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        !visited[nr][nc]) {

                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            distance++;
        }

        return dist;
    }
}
