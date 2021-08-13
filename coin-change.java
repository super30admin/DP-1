//Time Complexity: O(m*n), where m is rows and n is columns
//Space Complexity: O(m*n), size of the auxillary 2D array
//running on leetcode: yes
class Solution {
    public int coinChange(int[] coins, int amount) {
//base case
        if (coins==null || coins.length==0)
        {
            return -1;
        }
        
        //dp matrix length or rows= amount and rows=coins
        //adding 1 to columns because amount is 11(11th index is needed), first column is 0 so we will get amount only till 10. adding 1 to rows to balance the columns
        int[][] dp = new int[coins.length+1][amount+1];
        //first row is 0 coins to form any amount so fill row with infinity
        //traversing cols(length of dp)
        for (int k=1; k<amount+1; k++)//i=1 coz 0th col is 0 amount, so 0coins for 0 amt is 0
        {
            //if first row is set to Integer.MAX, it will overflow if anything is added to it
            //set first row to amount+1 coz that value wont be used(can also take a big value instead of amount+1)
            dp[0][k]=amount+1;
        }
        //traverse the dp array
        for (int i=1; i < dp.length; i++)//rows
        {
            for (int j=1; j < dp[0].length; j++)//columns
            {
                //amount<coin denomination
                //taking i-1 coz, before 1 was added to rows to balnce the rows with columns
                if (j < coins[i-1]) 
                {
                    //take the value from directly row above
                    dp[i][j]=dp[i-1][j];
                }
                else//option os choosing or not choosing the current denomination coin
                {
                    dp[i][j]= Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        //last element is the answer, but if the last element is more than amount means amount cannot be formed
        int result = dp[dp.length-1][dp[0].length-1];
        if (result == amount+1)
        {
            return -1;
        }
        return result;
        }
        
    }
