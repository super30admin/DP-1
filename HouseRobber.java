

//Asymptotic complexity in terms of n = size of the inums
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n ==1) return nums[0];
        else if (n ==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int [n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];

    }
}
