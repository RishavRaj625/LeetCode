class Solution {
    static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
         List<Integer> powersList = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powersList.add(1 << i);
            }
        }

        int size = powersList.size();
        long[] prefix = new long[size];
        prefix[0] = powersList.get(0);
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * powersList.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                long inv = modPow(prefix[l - 1], MOD - 2); // Modular inverse
                ans[i] = (int) ((prefix[r] * inv) % MOD);
            }
        }

        return ans;
    }

    // Modular exponentiation
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}