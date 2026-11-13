class Solution {
    HashMap<Integer, List<Integer>> nodes = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList<>());
        }

        for (var edge: edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {0, -1});
        seen.add(0);

        while (!queue.isEmpty()) {
            var current = queue.pop();
            var node = current[0];
            var parent = current[1];

            for (var nb: nodes.get(node)) {
                if (nb == parent) {
                    continue;
                }

                if (seen.contains(nb)) {
                    return false;
                }

                seen.add(nb);
                queue.add(new int[]{ nb, node });
            }
        }

        return seen.size() == n;
    }
}
