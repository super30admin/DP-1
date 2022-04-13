// Recursive Approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }
    public int helper(int[] nums, int currSum, int index){
        //base
        if(index >= nums.length){
            return currSum;
        }
        //logic
        //not choose (zero case)
        int case1 = helper(nums, currSum, index + 1);
        //choose (one case)
        int case2 = helper(nums, currSum + nums[index], index + 2);
        return Math.max(case1, case2);
    }
}


//DP--Solution-1 (using extra space)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length - 1][1]);
    }
}

//Time Complexity : O(n)
// Space Complexity : O(n)

// DP--Soution-2 (wihout using extra space)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int skip = 0;
        int take = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}

//Time Complexity : O(n)
// Space Complexity : O(1)
