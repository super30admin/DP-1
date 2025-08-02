//To solve this problem, I’m using bottom-up dynamic programming (DP). Although this problem can initially be solved using recursion, it involves repeated subproblems. Hence, a DP-based solution is more efficient.
//The core idea of bottom-up DP is to solve smaller subproblems first and then build up to the solution of the overall problem. In this case, the two dimensions of the problem are:

//The coins array (which represents the available denominations),

//The amount we need to make.

//We use a 2D DP matrix where:

// Rows represent the number of coins considered.

// The 0th row means no coins are available.

// The 1st row means only the first coin is available.

// The 2nd row includes the first two coins, and so on.

// Columns represent the target amounts from 0 to the desired amount.

// Each cell dp[i][j] represents the minimum number of coins required to make amount j using the first i coins.

// so here we have two options that is to choose ‘1’ and go forward and not to choose ‘1’ and go forward. so if we dont choose and go forward i.e we have no coins and the target is ‘2’ and this value we already calculated in the no coins row.  and when we take the choice up now we choose one coin + (the Target amount is one which we have already calculated beforehand). we take both the values and calculate the minimum and build the entire markets so the minimum points required would be lying in the very last cell.

//here the time complexity would be O(M x N) M being the no.of coins and n beings the amount.

//The space  complexity would be O(M x N) since we are using (M x N) Matrix.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;
        for(int i=1;i<n+1;i++){
            dp[0][i]=99999;
        }

        for(int i=1;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(j<coins[i-1])dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
        return(dp[m][n]==99999)?-1:dp[m][n];
    }

}
