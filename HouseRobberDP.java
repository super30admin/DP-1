//T.C O(n)
//S.C O(n)
// Did this code successfully run on Leetcode : yes (https://leetcode.com/problems/house-robber/)
// Any problem you faced while coding this : -

/*
Rob alternate houses to get max value
Greedy doesn't always work for the best Ex: 1,5,6,5,0
Be exhaustive, identify repeated subproblems from DP tree
Choose storage - here single array as decision-making parameter is just house values
 */
public class HouseRobberDP {
    //DP with tabulation matrix
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<nums.length; i++) {
            res[i] = Math.max(res[i-1], nums[i] + res[i-2]);
        }
        return res[nums.length-1];

    }
}
