// Time Complexity : O(n) where n = is traversing entire array nums
// Space Complexity : O(1) just storing 1 value at a time in r1 & r2
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES with intutuion


class Problem2 {
    public int rob(int[] nums) {
        int r1 = 0, r2 = 0;

        // [r1, r2, n, n+1, ......]
        for (int num : nums){
            int tmp = Math.max(r1 + num, r2);
            r1 = r2;
            r2 = tmp;
        }

        return r2;
    }
}