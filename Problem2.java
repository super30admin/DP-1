// Time Complexity : Approach 1: O(n), Approach 2: O(n) where n = number of houses
// Space Complexity : Approach 1: O(n), Approach 2: O(n) where n = number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem2 {
    
    // Memoization Approach (Top-Down)

    private static int[] dp;
    
    public static int rob1(int[] nums) {
        dp = new int[nums.length];
        // dp[index] == -1 represents that the calculation has not been done via recursion yet
        Arrays.fill(dp, -1);
        return rob1(nums, 0);
    }
    
    private static int rob1(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] > -1) {
            return dp[index];
        }
        // If I rob the present house, add value at present index to value for index+2
        int select = nums[index] + rob1(nums, index+2);
        // If I don't rob the present house, the value is equal to the value for index+1
        int notselect = rob1(nums, index+1);

        // Set the calculated value (max of select and notselect) at corresponmding index in the dp array
        dp[index] = Math.max(select, notselect);
        return dp[index];
    }

    
    // Iterative Approach (Bottom-up)

    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length+2];
        for (int i = nums.length-1; i >= 0; i--) {
            // If I rob the present house, add value at present index to value for index+2
            int select = nums[i] + dp[i+2];
            // If I don't rob the present house, the value is equal to the value for index+1
            int notselect = dp[i+1];
            // Set the calculated value (max of select and notselect) at corresponmding index in the dp array
            dp[i] = Math.max(select, notselect);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int ans1 = rob1(nums);
        int ans2 = rob2(nums);
        System.out.println("Answer for Approach-1(Top-down approach) is : " + ans1);
        System.out.println("Answer for Approach-2(Bottom-up approach) is : " + ans2);
    }

}
