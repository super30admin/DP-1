// Time Complexity : O(mn), where m is the number of coins, n is the total amount
// Space Complexity : O(mn), where m is the number of coins, n is the total amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem1 (https://leetcode.com/problems/coin-change/)
// Your code here along with comments explaining your approach
var helper = (coins, amount, index, coinsUsed) => {
    // Base cases
    // No coins left Or amount is negative
    if(index===coins.length || amount < 0){
        return -1;
    }
    if(amount===0){
        return coinsUsed;
    }
       
    // Case 1: Not using the coin
    let case1 = helper(coins, amount, index+1, coinsUsed);
    // Case 2: Using the coin
    let case2 = helper(coins, amount-coins[index], index, coinsUsed+1);
    if(case1 === -1){
        return case2;
    }
    if(case2===-1){
        return case1;
    }
    return Math.min(case1, case2);
}
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    if(coins===null || coins.length===0 || amount === 0){
        return 0;
    }
    // return helper(coins, amount, 0, 0);
    
    let dp = new Array(coins.length+1);
    for(let i=0; i<dp.length; i++){
        dp[i] = new Array(amount+1);
        dp[i][0] = 0;
    }
    for(let j = 1; j < dp[0].length; j++){
        dp[0][j]=amount+1;
    }
    for(let i = 1; i < dp.length; i++){
        for(let j = 1; j < dp[0].length; j++){
            if(j<coins[i-1]){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-coins[i-1]]+1);
            }        
        }
    }
    let finalValue = dp[dp.length-1][dp[0].length-1];
    if(finalValue === amount+1){
        return -1;
    }
    return finalValue;
    
};