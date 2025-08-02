class Solution {
    public long minCost(int[] basket1, int[] basket2) {
         Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        for (int val : basket1) freq.put(val, freq.getOrDefault(val, 0) + 1);
        for (int val : basket2) freq.put(val, freq.getOrDefault(val, 0) - 1);

        List<Integer> extra = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;

        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                extra.add(key);
            }
            minVal = Math.min(minVal, key);
        }

        Collections.sort(extra);
        long cost = 0;
        int m = extra.size() / 2;
        for (int i = 0; i < m; i++) {
            cost += Math.min(extra.get(i), 2 * minVal);
        }

        return cost;
    }
}