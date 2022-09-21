// Time Complexity :
// O(m), m is the number of houses
// Space Complexity :
// DP: O(m), m is the number of houses
// Using variables : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem2 (https://leetcode.com/problems/house-robber/)
// Your code here along with comments explaining your approach

// Logic
/*
index   nums    skip                take
0       2       0                   2
1       7       Max(skip,take)=2    0+7 = 7
3       9       7                   9+2=11
4       8       11                  8+7=15
5       1       15                  11+1 = 12
*/

var helper = (nums, sum, index) => {
    // Base case
    if(index>=nums.length){
        return sum;
    }
    
    // Case 1 : Do not rob the house
    let case1 = helper(nums, sum, index+1);
    // Case 2: Rob the house
    let case2 = helper(nums, sum+nums[index], index+=2);
    
    return Math.max(case1, case2);
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums === null || nums.length===0){
        return 0;
    }
    // Improve space complexity usinf variables to store the skip and take values
    let skip = 0;
    let take = nums[0];
    for(let i=1; i<nums.length; i++){
        let temp = skip;
        skip = Math.max(skip, take);
        take = nums[i]+temp;
    }
    return Math.max(skip, take);

    // // Recursive
    // // return helper(nums, 0, 0);
    // // Since we have 1 deciding param in recursion, we create a 1D array
    // // We set the 1st and 2nd indexs as 0 and money in 1st house
    // let dp = new Array(nums.length+1);
    // dp[0] = 0;
    // dp[1] = nums[0];
    // // We start filling data from index 2
    // // It is max of 2 cases 1)Do not rob this 2) Rob this and add money robbed till now which is stored in the dp array 
    // for(let i=2; i<dp.length; i++){
    //     dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
    // }
    // return Math.max(dp[dp.length-1], dp[dp.length-2]);
    
};
