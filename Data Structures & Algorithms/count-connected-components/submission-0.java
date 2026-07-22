class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 1) {
                continue;
            }
            count++;
            dfs(graph, visited, i);
        }
        return count;
    }

    void dfs(Map<Integer, List<Integer>> graph, int[] visited, int u) {
        if (visited[u] == 1) return;
        visited[u] = 1;
        for (int v : graph.getOrDefault(u, Collections.emptyList())) {
            dfs(graph, visited, v);
        }
    }
}
