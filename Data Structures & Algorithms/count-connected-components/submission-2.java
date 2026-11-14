class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap();
    Set<Integer> seen = new HashSet<Integer>();

    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        var result = 0;

        for (var i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (var edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (var i = 0; i < n; i++) {
            if (seen.contains(i)) {
                continue;
            }

            result++;

            dfs(i, -1);
        }

        return result;
    }

    private void dfs(int node, int parent) {
        if (seen.contains(node)) {
            return;
        }

        seen.add(node);

        for (var n: graph.get(node)) {
            if (n == parent) {
                continue;
            }

            dfs(n, node);
        }
    }
}
