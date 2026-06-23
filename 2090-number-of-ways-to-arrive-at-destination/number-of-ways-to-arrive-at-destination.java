class Solution {

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            graph.get(u).add(new int[]{v, d});
            graph.get(v).add(new int[]{u, d});
        }

        long[] cost = new long[n];
        long[] ways = new long[n];

        Arrays.fill(cost, Long.MAX_VALUE);

        cost[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int u = (int) curr[0];
            long w = curr[1];

            if (w > cost[u]) continue;

            for (int i = 0; i < graph.get(u).size(); i++) {

                int[] next = graph.get(u).get(i);

                int v = next[0];
                int d = next[1];

                if (cost[u] + d < cost[v]) {

                    cost[v] = cost[u] + d;
                    ways[v] = ways[u];

                    pq.add(new long[]{v, cost[v]});
                }
                else if (cost[u] + d == cost[v]) {

                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}