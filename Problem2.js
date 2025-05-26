// ## Problem2 (https://leetcode.com/problems/house-robber/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Converting it into a 1d array was not intuitive

var rob = function(nums) {
    // Time Complexity : O(N)
    // Space Complexity :O (1)
    if(nums.length == 0 )return 0
    if(nums.length==1) return nums[0]
    let dp = []
    let prev = nums[0]
    let current = Math.max(prev,nums[1]+0)
    for(let i = 2;i<=nums.length-1;i++){
        let temp = current
        current = Math.max(current,nums[i]+prev);
        prev= temp
    }
    return current
};

// var rob = function(nums) {
        //** Time Complexity : O(N) */
        //** Space Complexity : O(N) */
//     if(nums.length == 0 )return 0
//     let dp = []
//     dp[0] = nums[0]
//     dp[1] = Math.max(dp[0],nums[1]+0)
//     for(let i = 2;i<=nums.length-1;i++){
//         dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
//     }
//     return dp[nums.length-1];
// };

// var rob = function(nums) {
        //** Time Complexity : O(N) */
        //** Space Complexity : O(N) */
//     let amount = 0
//     let memo = {}
//     function helper(nums,idx){
//         //BaseCase
//         if(idx > nums.length-1) return 0
//         if(memo[idx]!=undefined) return memo[idx]
//         //Logic
//         //Choose
//         let letsRob = nums[idx]+helper(nums,idx+2)
//         //NotChoose
//         let notRob = helper(nums,idx+1)
//         memo[idx] = Math.max(letsRob,notRob)
//         return memo[idx]
//     }   
//     let result = helper(nums,0)
//     return result
// };


// Your code here along with comments explaining your approach
// var rob = function(nums) {
        //** Time Complexity : O(2^N) */
        //** Space Complexity : O(N) */
//     let amount = 0
//     function helper(nums,idx){
//         //BaseCase
//         if(idx > nums.length-1) return 0
//         //Logic
//         //Choose
//         let letsRob = nums[idx]+helper(nums,idx+2)
//         //NotChoose
//         let notRob = helper(nums,idx+1)
//         return Math.max(letsRob,notRob)
//     }   
//     let result = helper(nums,0)
//     return result
// };