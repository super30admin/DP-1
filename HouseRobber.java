// Time Complexity : O(n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We follow the same binary approach here.
// At every house, we have the option wether to rob the house or not rob the house.
// If we rob the house, we increment our robbed value by the amount that is associated to that house.
//      If we rob the house then we cannot rob the corresponding house
//      To increment the amount, we take the amount associated to previously skipped house and add the current amount.
// If we don't rob the house, then the amount will be equal to the currently accumulated sum.
//      We choose this amount by taking the maximum amount that we can obtain from previous house, either by choosing it or not choosing it.
// Finally, when we reach the last house, we return the maximum value associated to choosing and not choosing that house.

public class HouseRobber {
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp+nums[i];
        }
        
        return Math.max(skip, take);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1,14,7,89}));
    }
}
