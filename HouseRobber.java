//Problem2 (https://leetcode.com/problems/house-robber/)
//T: O(N)
//S: O(N)

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];

        int N = nums.length;
        int dp[] = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            int newLoot = nums[i]+dp[i-1]; // current house value + all alternate old houses value
            int oldLoot = dp[i];
            dp[i+1] = Math.max(oldLoot,newLoot);
        }

        return dp[N];
    }
}

