class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int totalNodes = m * n;

        List<List<Integer>> adj = new ArrayList<>(totalNodes);
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    int u = r * n + c;

                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                            int v = nr * n + nc;
                            adj.get(u).add(v);
                        }
                    }
                }
            }
        }

        boolean[] visited = new boolean[totalNodes];
        int islands = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int node = r * n + c;
                if (grid[r][c] == '1' && !visited[node]) {
                    dfs(node, adj, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int neighbor : adj.get(u)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}