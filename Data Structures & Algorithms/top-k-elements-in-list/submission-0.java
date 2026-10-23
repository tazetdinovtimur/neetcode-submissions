class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();

        for (var n: nums) {
            frequencies.putIfAbsent(n, 0);
            frequencies.put(n, frequencies.get(n) + 1);
        }

        var sorted = new ArrayList<int[]>();

        for (var entry: frequencies.entrySet()) {
            sorted.add(new int[] {entry.getKey(), entry.getValue()});
        }

        sorted.sort((a, b) -> b[1] - a[1]);

        var result = new int[k];

        for (var i = 0; i < k; i++) {
            result[i] = sorted.get(i)[0];
        }

        return result;
    }
}
