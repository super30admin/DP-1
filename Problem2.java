/* Problem 2: House Robber
*/

// Time Complexity : O(n) where n is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//DP Problem
//1. Greedy approach- take max/min of amount(house) and taking 1 path. It will fail in few cases. Since its not exhaustive
//2. Brute force Exhaustive- Using recursion approach. Here we will have 2 choices(choose or not choose) and decision making criteria is only n(nums array length). here we have only index as decision parameter and not amount(this is not a constraint)
//Recursion will result in TLE(time limit exceeded) and O(t)=O(2^n)
//3. DP Approach: first look for repeated subproblems, use tabular approach, O(t)=O(n) and O(s)=(n) since we will be creating dp array(space:O(n))
//here we will work on 1d array only(decision: 1) but we will bifurcate into choose or not choose choices
//3.1 Optimising space for DP approach: we can consider skip and take variables instead of creating dp array, O(t)=O(n) and O(s)=O(n)
//note: if something gets overwritten(like skip value here), store it in temp variable

//Approach 3: Optimising space for DP Approach O(t) = O(n), O(s) = O(1), no dp array used
//use skip and take variables
class Solution {
    public int rob(int[] nums) {
        //edge case
        if(nums == null) return 0;
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        //traverse array
        for(int i = 1; i < n; i++){
            //initialise temp
            //to avoid skip value to be overwritten, store it in temp variable
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}
//Approach 2: DP Approach
// class Solution {
//     public int rob(int[] nums) {
//         //edge case
//         if(nums == null) return 0;
//         int n = nums.length;
//         //initialising dp array
//         //here we will be taking two choices: not choose(0) and choose(1)
//         int[][] dp = new int[n][2];
//         dp[0][1] = nums[0];
//         //traverse the array
//         for(int i = 1; i < n; i++){
//             //Case1: skip
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//             //Case2: take
//             dp[i][1] = dp[i-1][0] + nums[i];
//         }
//         return Math.max(dp[n-1][0], dp[n-1][1]);
//     }
// }
    
//Approach 1: Brute force: Recursion exhaustive approach: results in TLE
// class Solution {
//     public int rob(int[] nums) {
//         //edge case
//         if(nums == null) return 0;
//         return helper(nums, 0, 0);
//     }
//     private int helper(int[] nums, int index, int amount){
//         //base
//         //if index goes out of bound, then return amount(base case always depends on changing decision paramters)
//         if(index >= nums.length) return amount;
//         //logic
//         //Case1: choose
//         int case1 = helper(nums, index + 2, amount + nums[index]);
//         //Case2: not choose
//         int case2 = helper(nums, index + 1, amount);
//         return Math.max(case1, case2);
//     }
// }