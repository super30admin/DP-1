//space - O(n)
//time - O(n)
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i=1; i<=nums.length; i++) {
            //not taken = max(previous taken, previous not taken)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //taken = current value + previous not taken
            dp[i][1] = nums[i-1] + dp[i-1][0];
            System.out.println(dp[i][0] + " " + dp[i][1]);
        }
        
        
        
        
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
        
    }
}

//recursion

class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0,0);
    }
    public int helper(int[] nums, int index, int valueRobbed) {
        if(index >= nums.length)
            return valueRobbed;
        
        int robbed = helper(nums, index+2, valueRobbed+nums[index]);
        int notRobbed = helper(nums, index+1, valueRobbed);
        
        return Math.max(robbed, notRobbed);
    }
}
