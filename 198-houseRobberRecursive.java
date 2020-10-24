/**
 * Time Complexity : 
 * Space Complexity :
 * Did this code successfully run on Leetcode : Time limit exceeded since naive recursive approach. In IDE, it ran.
 * Any problem you faced while coding this : Yes
 * Your code here along with comments explaining your approach
 * 1. First we write the logic part and at last the base cases
 * 2. If I choose to rob the house, it will be the 1-case(here case1)..here i choose the current index and then increment it by 2 for the next
 *      helper function call and increase the amount by the number at current index
 * 3. If I not choose to rob the house, it will be 0-case(here case2)..current index will be incremented by 1 and amount remains unchanged
 */

package DP;

public class HouseRobberRecursive {

    public static int rob(int[] nums){

        if(nums == null || nums.length == 0) return 0;

        int result = helper(nums, 0, 0);
        return result;
    }

    public static int helper(int[] nums, int index, int amount){

        //base
        if(index >= nums.length) return amount;

        //logic: if we choose a number: case-1
        //don't choose: case-0
        int case1 = helper(nums, index + 2, amount + nums[index]);  //select a number and then increase the pointer
        int case2 = helper(nums, index + 1, amount);

        return Math.max(case1, case2);
    }
    public static void main(String args[]){

        int[] nums = new int[]{2, 7, 9, 8, 1};
        System.out.println("Maximum amount that can be robbed: "+ rob(nums));
    }
}
