/*
 * TC: O(n), n: length of nums.
 * SC: O(n), n: length of nums.for memoization
 * 
 * Approach: Here i will recurse and at recursion i will have two cases i.e either to rob the 
 * house or move to the next house.whataver case i choose shouild return me the maximum money.
 * Recurse until last house is robbed. Also, to not repeat the same calculation i willl use cache 
 * to store the subpriblem's results so i dont need to calculate it again when i see the same problem again which 
 * would reduce the time complexity from exponenetial to linear.I am applying top-down DP.
 */

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        this.memo = new int[nums.length+1];
        Arrays.fill(this.memo, -1);
        return helper(nums,0);
    }

    private int helper(int[] nums, int idx){
        //base
        if(idx >= nums.length){
            return 0;
        }

        if(memo[idx] != -1) return memo[idx];


        //not choose
        int case1 = helper(nums, idx+1);
        //choose
        int case2 = nums[idx] + helper(nums, idx+2);

        memo[idx] = Math.max(case1,case2);
        return memo[idx];

    }
}