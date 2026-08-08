// Approach - Recursion can be used to pursue exhaustive path, but since this problem has repeated sub problems
// we could use Dynamic programming.
//Time Complexity: O(n)
//Space Complexity: O(n)

class HouseRobber {
    public int rob(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int [] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        //Maximum between choose case vs non choose case where we cannot select the immediate neighbouring house.
        for(int i=2 ; i <n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}