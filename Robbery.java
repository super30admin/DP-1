// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


import java.util.Arrays;

public class Robbery {
    public  int rob(int nums[]){
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return robValue(nums, 0, dp);
    }
    public int robValue(int nums[], int index, int dp[]){

        if (index >= nums.length){
            return 0;
        }
        if(dp[index] == -1) {
            int selected = nums[index] + robValue(nums, index + 2, dp);
            int notSelected = robValue(nums, index + 1, dp);
            dp[index] = Math.max(selected, notSelected);
        }
        return dp[index];
    }
}
