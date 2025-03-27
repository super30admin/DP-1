class Solution {
    public int rob(int[] nums) {// TC: O(n) SC: O(1)
        /*
        //using dp array
        int n = nums.length;
        if(n==1) return nums[0]; //if there's only 1 house then return that num as robbed house
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); //if there are only 2 nums, then return the max betwn those two nums as the robbed house
        

        for(int i = 2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); //if there are multiple houses, then return the sum of non-adjacent max nums.
        }
        return dp[n-1];
        */


        //without dp. using 2-pointers
        int n = nums.length;
        if(n==1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i<n; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;
        }
        return curr;



/*
        //exhaustive approach
        return helper(nums, 0,0);
        */
    }
    /*
    //exhaustive approach
    private int helper(int[] nums, int i, int robbings){
        //base case
        if(i >= nums.length) return robbings;

        //logic
        int case0 = helper(nums, i+1, robbings);

        int case1 = helper(nums, i+2, robbings+nums[i]);

        return Math.max(case0, case1);
    }
    */
}
