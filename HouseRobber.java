// Time Complexity : O(n) where n is no. of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We will be using the dp approach. We use the bottom up approach.
 * If we choose the house we get the amount for i-1th not choosing house and add current house amount
 * If we dont choose the house we take the amount for previous house sum
 *
 * */

public class HouseRobber {

    public int rob(int[] nums){
        //edge
        if(nums==null || nums.length==0) return 0;

        //using array to keep track of previous sums
        int skip = 0, take = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp  = skip;
            //we dont choose
            skip = Math.max(skip, take);
            //we choose
            take = temp + nums[i];
        }

        return Math.max(skip, take);
    }
}