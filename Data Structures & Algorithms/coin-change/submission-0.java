class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        var res = count(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int count(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }

        var res = Integer.MAX_VALUE;

        for (var c: coins) {
            if (amount - c >= 0) {
                var r = count(coins, amount - c);

                if (r != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + r);
                }
            }
        }

        cache.put(amount, res);

        return res;
    }
}
