class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0, total = 0;

        int left = 0;

        for (int right = 0; right < n; ++right) {
            total += fruits[right][1];

            while (left <= right && !canReach(fruits, left, right, startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    private boolean canReach(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int costLeftFirst = Math.abs(startPos - leftPos) + Math.abs(rightPos - leftPos);
        int costRightFirst = Math.abs(startPos - rightPos) + Math.abs(rightPos - leftPos);

        return Math.min(costLeftFirst, costRightFirst) <= k;
    }
}