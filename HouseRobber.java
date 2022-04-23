// Time Complexity : O(2N)== O(N) where N is the number of houses
// Space Complexity : O(2N)== O(N) where N is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// When we chose to rob a home, take math.max of prev two dp rows, if we chose to ignore it, take dp[i-1][0] and add
//curr house count.
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==0 || nums==null) return 0;

        int[][] dp=new int[nums.length][2];

        dp[0][0]=0;
        dp[0][1]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
