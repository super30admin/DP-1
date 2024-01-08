//Constant space solution
class Solution {
    public int rob(int[] nums) {
        //Tc: O(n)  Sc: O(1)
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        if(n<2) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            int temp = curr;
            curr = Math.max(prev+nums[i], curr);
            prev = temp;
        }
        return curr;
//DP
        /*
        //Tc: O(n)  Sc: O(n)
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n ; i++)
        {
            dp [i] = Math.max(dp[i-1], nums[i]+ dp[i-2]);
        }
        return dp[n-1];
        */
    }
}

//Exhaustive Approach
/*
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return helper(nums, 0, 0);
      
    }

    private int helper(int[] nums, int index, int amount)
    {
        //base case
        if(index >= nums.length) return amount;
        //logic
        //If we want to select the num
        int case1 = helper(nums, index+2, amount+nums[index]);
        // Don't want to select the num
        int case2 = helper(nums, index+1, amount);

        return Math.max(case1, case2);
    }
}
*/