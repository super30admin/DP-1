//T.C O(2 pow n)
//S.C O(1)
// Did this code successfully run on Leetcode : yes (https://leetcode.com/problems/house-robber/)
// Any problem you faced while coding this : -

/*
Run through each choose, dont choose case in recursion and get max value from both in each iteration
 */
public class HouseRobber {
    //Recursive approach
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i, int cost) {
        //base
        if(i >= nums.length)
            return cost;

        //logic
        //not choosing
        int case0 = helper(nums, i+1, cost);

        //choose
        int case1 = helper(nums, i+2, cost+ nums[i]);

        return Math.max(case0, case1);
    }
}
