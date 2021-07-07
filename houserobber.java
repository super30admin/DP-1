// house robber problem

// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public int houserobber(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;    // return 0 if houses are 0
        }

         if(nums.length == 1){
            return nums[0]; // return that house if house is only 1
        }

         if(nums.length == 2){
            return Math.max(nums[0], nums[1]);  // return maximum of 2 houses for 2 houses
        }

        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]); // return max of houe before and (summation of particular house and house before the previous house)

        }

        return dp[nums.length - 1]; // return the final amount which is maximum
    }
}



