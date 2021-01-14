//198. House Robber
//Using Recursion, Brute force


class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int i, int maxAmount){
        if(i>nums.length-1)
            return maxAmount;

        //Dont choose house
        int case1 = helper(nums, i+1, maxAmount);

        //Choose house
        int case2 = helper(nums, i+2, maxAmount + nums[i]);

        return Math.max(case1, case2);

    }
}


//DP Solution
// Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];

        if(nums == null || nums.length==0)
            return 0;

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int m = dp.length; //4
        int n = dp[0].length; //2
        for(int i=1; i<m; i++){
            for(int j = 0; j<2; j++){
                if(j==0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][1]);
                else
                    dp[i][j] = dp[i-1][0] + nums[i];
            }
        }
        return Math.max(dp[m-1][0], dp[m-1][1]);
    }
}

//DP Solution
// Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int rob(int[] nums) {
        int chosen = 0, notChosen = 0;

        if(nums == null || nums.length==0)
            return 0;

        for(int i=0; i<nums.length; i++){
            int temp = chosen;
            chosen = notChosen + nums[i];
            notChosen = Math.max(temp, notChosen);
        }
        return Math.max(chosen, notChosen);
    }
}





