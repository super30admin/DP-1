// Time Complexity :O(MxN) matrix array of amount and coin length
// Space Complexity :O(MxN) space same as a matrix array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //checking for null'ness

        if(coins == null|| coins.length==0) return 0;
        int m=coins.length ; int n=amount;
        int [][]dp=new int [m+1][n+1];
        dp[0][0]=0;

        //top of the row
        for(int i=1;  i<dp[0].length; i++){
            dp[0][i]=99999; //or the max (amount+1)

        }


        for (int i=1;  i<dp.length ;i++){
            for(int j=1; j<dp[0].length; j++){
                if(j<coins[i-1])////why coins[i-1] ,because in matrix we have 1,2,5 but in code we have zero also ie [0,1,2,5] ..so i-1, but
                {
                    dp[i][j]=dp[i-1][j];
                }else
                    dp[i][j]=Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                //here we will iterate on amount and total coin, we check to see if its a valid value (greater than or equal to 0)
                //and if so, we add our dp[i][j] the minimum of the smallest amount and the current one

            }
        }
        if(dp[m][n] >=99999)
            return -1;
        else
            return dp[m][n];

    }
}






      /*  Bruteforce aproach...but will end " Time Limit Exceeded"


      -------
      return helper(coins,amount,0,0);
    }
    private int helper (int []coins, int amount, int i, int  min){

        //base case:-
        if(amount==0)
            return min;

        if(i==coins.length || amount<0) return -1; //if empty , or amount is not there -> then no solution

        //first case
        int case1= helper(coins, amount-coins[i], i, min+1); //here i only, because infinite no. of same coins can be used
        //if 2nd case
        int case2= helper(coins, amount, i+1, min);

        if(case1== -1) return case2;
        if(case2== -1) return case1;

        //if both cases not giving , then find minimum between case1,case2;
        return Math.min(case1, case2);
    }


}*/