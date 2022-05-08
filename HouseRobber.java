class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    // keeping track of every subarrays
    // so when we recursively perform the operations,
    // if value already exists for the given pos,
    // we just retrieve instead of going through the tree again
    public int rob(int[] nums) {
        return helper(0, nums);
    }
    private int helper(int i, int[] nums) {
        if(i >= nums.length) {
            return 0;
        }
        if(memo.containsKey(i)) return memo.get(i);
        // if we choose adjacent houses, we add 0 to profit
        int case1 = helper(i+1, nums);
        // if we choose non-adjacent houses, we add the value of each house
        int case2 = helper(i+2, nums)+nums[i];
        memo.put(i, Math.max(case1, case2));
        // return max of case 1
        return Math.max(case1, case2);
    }
}