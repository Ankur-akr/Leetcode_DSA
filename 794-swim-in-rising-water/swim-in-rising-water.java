class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if (vis[r][c]) continue;

            vis[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return time;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc]) {

                    pq.offer(new int[]{
                            nr,
                            nc,
                            Math.max(time, grid[nr][nc])
                    });
                }
            }
        }

        return -1;
    }
}