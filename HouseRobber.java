// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber {
    public int rob(int[] nums) {

        int skip = 0;
        int take = nums[0];

        // Two cases here - either rob the house or not rob the house,
        // At every ith house, skip represents if we skip the ith house - we take max of the skip and take from (i-th) house
        // take represents, if we take the current house, then we need to add the current house money with previous house skip
        // because we can't rob two adjacent houses.
        for(int i =1; i< nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }

        // Our ans will be max of skip and take
        return Math.max(skip, take);

    }
}

