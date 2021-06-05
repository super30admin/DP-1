// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
1. When forming a Sum you either choose a coin or you don't choose a coin
2. 0 coins cannot make any amount apart from 0 so we can intialize the rest as amount+1 since coins can never be greater than amount (if the value of coin is 1) 
3. 0 amount can only be formed by taking 0 coins of each denomination
4. let's say we are trying to find minimum no of coins required to form an amount 2 from coins [1,2] 
5. case 1 - choose coin 2: find no of coins need to form 2 with 2 denomination 
    = 0 coins of 2 required to form 0 + 1 coin of 2;
6. case 2 - don't choose coin 2: no of coins of denomination 1 used to form amount 2
   =  0 coins of 1 required to form 0 + 1 coin required to form 1 + 1 coin of 1  
7. Find Minimum of both
*/


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
           dp[i][0]=0;
       for(int i=1;i<=amount;i++)
           dp[0][i]=amount+1;
       for(int i=1;i<=coins.length;i++)
           dp[i][0]=0;
       for(int i=1;i<=coins.length;i++)
       {
           for(int j=1;j<=amount;j++)
           {
               if(coins[i-1]>j)
               {
                   dp[i][j]=dp[i-1][j];
               }
               else{
                   dp[i][j]= Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
               }
           }
       }
  
       return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];
    }

    public static void main(String[] args)
    {
        CoinChange obj=new CoinChange();
        int[] coins={5,3};
        System.out.println(obj.coinChange(coins,11));
    }   
}
