//  Time complexity : O(n)
// Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {

        // Recursive approach
        // return getHelper(nums, 0, 0);

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev = nums[0];
        int curr =  Math.max(nums[0], nums[1]);

        for(int i=2; i< nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;

        // Using 1D array
        // int dp[] = new int[nums.length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for(int i=2; i< nums.length; i++){
        //     dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        // }
        // return dp[nums.length-1];

        
    }

    // Recursive approach 
    // private int getHelper(int nums[], int i, int amount){

    //     // basic
    //     if(i >= nums.length) return amount;

    //     // logic
    //     int case0 = getHelper(nums, i+1, amount);

    //     int case1 = getHelper(nums, i+2, amount + nums[i]);

    //     return Math.max(case0, case1);
    // }
}