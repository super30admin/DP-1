/**
 * Time complexity is O(n) because of caching
 * space complexity is O(n)
 */
public class HouseRobberRecursiveMemo {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        
        return rob(nums, 0);
    }
    
    private int rob(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        // rob i
        int case1 = nums[i] + rob(nums, i+2);
        // don't rob i
        int case2 = rob(nums, i+1);
        
        dp[i] = Math.max(case1, case2);
        return dp[i];
        //return Math.max(case1, case2);
    }
}
