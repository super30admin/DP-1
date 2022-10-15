// Approach: top down dynamic programming with memoization
// Time Complexity : O(n) since you calculate once for each house
// Space Complexity: O(n) in worst case, n space for Dp array and n space for stack
public class Solution {
    
    int[] dp;
    
    public int Rob(int[] nums) {
        dp = new int[nums.Length];
        // value 0 can also be a valid value if a house has no money
        // So to differentiate not calculated cell initialize array with Int32.MinValue
        Array.Fill(dp, Int32.MinValue);
        return rob(0, nums);
    }
    /*
     returns the maximum amount that can robbed from i to n-1 without getting caught 
    */
    public int rob(int index, int[] nums){
        if(index >= nums.Length)
            return 0;
        
        if(dp[index] == Int32.MinValue){
            int select = nums[index] + rob(index+2, nums);
            int notselect = rob(index+1, nums);
            dp[index] = Math.Max(select, notselect);
        }
        
        return dp[index];
    }
}