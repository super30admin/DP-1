// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed a lot of help with this, recursion still confuses me a lot
class Solution {
    public int rob(int[] houses) {
        Integer[] m = new Integer[houses.length];
        return helper(houses, 0, m);
    }

    private int helper(int[] houses, int i, Integer[] m) {
        if (i >= houses.length) return 0;

        if (m[i] != null) return m[i];

        int rob = houses[i] + helper(houses, i + 2, m);

        int skip = helper(houses, i + 1, m);

        m[i] = Math.max(rob, skip);
        return m[i];
    }
}
