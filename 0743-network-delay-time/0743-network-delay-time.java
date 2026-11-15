class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        // Step 2: Initialize distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Step 3: Min heap
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            // Ignore outdated entries
            if (distance > dist[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDistance = distance + weight;

                if (newDistance < dist[nextNode]) {

                    dist[nextNode] = newDistance;

                    pq.offer(new int[]{
                        nextNode, newDistance
                    });
                }
            }
        }

        // Step 5: Find maximum shortest distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}