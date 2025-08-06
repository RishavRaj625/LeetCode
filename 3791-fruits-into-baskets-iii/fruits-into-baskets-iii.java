class SegmentTree {
    int N;
    int[] tree;

    public SegmentTree(int[] baskets) {
        int n = baskets.length;
        N = 1;
        while (N < n) N <<= 1;
        tree = new int[N << 1];
        Arrays.fill(tree, -1);
        for (int i = 0; i < n; i++) {
            tree[N + i] = baskets[i];
        }
        for (int i = N - 1; i >= 1; i--) {
            tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
        }
    }

    public boolean placeFruit(int val) {
        int idx = 1; // start from root

        if (tree[idx] < val) {
            return false; // no basket can hold this fruit
        }

        while (idx < N) {
            if (tree[2 * idx] >= val) {
                idx = 2 * idx;
            } else {
                idx = 2 * idx + 1;
            }
        }

        tree[idx] = -1;

        // Update the tree from leaf to root
        while (idx > 1) {
            idx >>= 1;
            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
        }

        return true;
    }
}


class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree segTree = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            if (!segTree.placeFruit(fruit)) {
                unplaced++;
            }
        }

        return unplaced;
    }
}