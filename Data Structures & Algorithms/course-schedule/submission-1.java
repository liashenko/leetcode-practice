class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisite[1] -> prerequisite[0]
        Map<Integer, List<Integer>> courses = new HashMap<>();
        for (int[] p : prerequisites) {
            courses.computeIfAbsent(p[1], x -> new ArrayList<>()).add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (var k : courses.keySet()) {
            if (hasCycle(courses, visited, k)) {
                return false;
            }
        }
        return true;
    }
    // 0 -> 1
    // 1 -> 0
    boolean hasCycle(Map<Integer, List<Integer>> courses, int[] visited, int course) {
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        visited[course] = 1; // visiting
        for (int c : courses.getOrDefault(course, Collections.emptyList())) {
            if (hasCycle(courses, visited, c)) {
                return true;
            }
        }
        visited[course] = 2; // visited
        return false;
    }
}
