/* Time complexity: O(n)
Space Complexity: O(n)

1. Using dynamic programming to solve this problem in the sense that the maximum amount collected by the robber whether he chosses to rob the current house or not, depends on the previous subproblem of not robbing or robbing the previous houses.
2. Basically, a matrix with just two columns of 0 and 1 is used wherein 0 implies not robbing the current house and 1 implies robbing the current house.
3. The maximum of robbing and not robbing the last house would prove to be the solution of the problem.

*/

class Solution{
    public int houseRobber(int[] nums){
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int[][] dp = new dp[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[i];

        for(int i=0; i<nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }

        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    
    }
}