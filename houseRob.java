// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// I used a 2D DP array where dp[i][0] means not robbing the current house, and dp[i][1] means robbing it.
// If I skip the current house, I take the max of previous skip or pick. If I rob this house, I add current money to previous skip.
// Finally, I return the max of skip or pick for the last house.


public class houseRob {
    public int rob(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];

        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
    public static void main(String[]args){
        houseRob ob = new houseRob();
        int[] nums1 = new int[] {1,2,3,1};
        int[] nums2 = new int[] {2,7,9,3,1};
        System.out.println("Maximum amount of money can rob is: "+ob.rob(nums1));
        System.out.println("Maximum amount of money can rob is: "+ob.rob(nums2));
    }
    
}
