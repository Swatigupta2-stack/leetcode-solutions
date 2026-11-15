
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        // Step 2: Create arrays
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        // Step 3: DFS for every unvisited node
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, adj, visited, pathVisited, stack)) {
                    return new int[0]; // Cycle exists
                }
            }
        }

        // Step 4: Pop stack to get course order
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    boolean dfs(int node, List<List<Integer>> adj,
                boolean[] visited, boolean[] pathVisited,
                Stack<Integer> stack) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, adj, visited, pathVisited, stack)) {
                    return true;
                }

            } else if (pathVisited[neighbor]) {
                return true; // Cycle detected
            }
        }

        // Backtracking
        pathVisited[node] = false;

        // Push after completing all neighbors
        stack.push(node);

        return false;
    }
}
