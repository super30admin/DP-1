// ## Problem1 (https://leetcode.com/problems/coin-change/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Understanding why we do [j-coins[i]] was hard, but later got to know its the subproblem we have solved already


// Your code here along with comments explaining your approach
var coinChange = function(coins, amount) {
    //TC : O(N * M)
    //SC : O(N * M)
    const n = coins.length
    const dp = Array.from({length:n+1},()=>Array(amount+1).fill(Infinity));

    //Set all rows as of 0 as 0
    for(let i =0;i<=n;i++){
        dp[i][0] =0
    }
    for(let i =1;i<=n;i++){
        for(let j=1;j<=amount;j++){
            if(j >= coins[i-1]){
                dp[i][j] = Math.min(dp[i-1][j], 1 +dp[i][j-coins[i-1]])
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    return dp[n][amount] === Infinity ? -1 : dp[n][amount];
};


// var coinChange = function(coins, amount) {
        //TC : 2^N * M , M  = amount
        //SC : O(M)
//     function helper(amount, n) {
//         // Base cases
//         if (amount < 0) return Infinity;
//         if (amount === 0) return 0;
//         if (n < 0) return Infinity;

//         // Choose the nth coin (reuse allowed)
//         let pick = 1 + helper(amount - coins[n], n);  

//         // Don't choose the nth coin (move to next)
//         let notPick = helper(amount, n - 1);

//         return Math.min(pick, notPick);
//     }

//     const result = helper(amount, coins.length - 1);
//     return result === Infinity ? -1 : result;
// };
