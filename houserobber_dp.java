//TC: O(n)
//SC: O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        int [][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i=1; i < nums.length; i++){
            //skip
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
            //take
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

//TC: O(n)
//SC: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        // int [][] dp = new int[nums.length][2];
        // dp[0][1] = nums[0];
        int skip = 0;
        int take = nums[0];
        for(int i=1; i < nums.length; i++){
            int temp = skip;
            //skip
            skip = Math.max(skip,take);
            
            //take
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}
