class Solution {
    // 0 -> 2
    // 1 -> 2
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0 && hasCycle(graph, visited, order, i)) {
                return new int[]{};
            }
        }
        // topological sort
        Collections.reverse(order);
        int[] result = new int[order.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = order.get(i);
        }
        return result;
    }

    boolean hasCycle(Map<Integer, List<Integer>> graph, int[] visited, List<Integer> order, int n) {
        if (visited[n] == 1) return true;
        if (visited[n] == 2) return false;
        visited[n] = 1;
        for (int v : graph.getOrDefault(n, Collections.emptyList())) {
            if (hasCycle(graph, visited, order, v)) {
                return true;
            }
        }
        visited[n] = 2;
        order.add(n);
        return false;
    }
}
