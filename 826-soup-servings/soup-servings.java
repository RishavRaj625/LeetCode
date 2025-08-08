class Solution {
    private Double[][] memo;
    public double soupServings(int n) {
        
         if (n > 5000) return 1.0;
        n = (n + 24) / 25;

        memo = new Double[n + 1][n + 1];
        return dfs(n, n);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != null) return memo[a][b];

        memo[a][b] = 0.25 * (
            dfs(a - 4, b) +
            dfs(a - 3, b - 1) +
            dfs(a - 2, b - 2) +
            dfs(a - 1, b - 3)
        );
        return memo[a][b];
    }
}