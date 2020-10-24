/**
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * Algorithm: LC-198  (Using 2 variables: skip and take)
 1. Since here unlike coin change problem we just want previous values instead of going 2 or 3 or n steps back
    I just used skip(0-case values) and take(1-case values)
 2. Initialize skip = 0 and take = nums[0] (first value of the array)
 3. Iterating over each cell:
        skip = max of previous row values(skip and take)
        take = prev skip + current element (To retain the prev skip, i used temp to store it)
 4. Return Max(skip, take)
 */
package DP;

public class HouseRobberDPUsing2Var {

    public static int rob(int[] nums){

        if(nums == null || nums.length == 0) return 0;
        int skip = 0;
        int take = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }

    public static void main(String args[]){

        int[] nums = new int[]{2,7,9,8,1};
        System.out.println("Maximum amount that can be robbed: "+ rob(nums));
    }
}
