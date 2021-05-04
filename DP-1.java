// Time Complexity : o(coins.length*amount)
// Space Complexity : o((coins.length*amount))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;//edge case check
        
        int[][] dp = new int[coins.length+1][amount+1]; //+1 to include zeros and base values
        
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++)
        {
            dp[0][j]= amount+1;
        }        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(coins[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j]; 
                    // if denomination is greater than current amount then, cant use coin, take from previous val
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1); 
                    //min of whether we choose or not choose the coin
                }                
            }
        }
        /*for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {      System.out.println(dp[i][j]);
            }
        }*/
        int res=  dp[dp.length-1][dp[0].length-1];
        if(res>amount) return -1;
        else
            return res;
    }
}



//Recursive Solution- exponential time
/*public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        return helper(coins, 0, amount, 0);
    }
    
    private int helper(int[] coins, int index, int amount, int min)
    {
        //base
        if(amount==0) return min;// it has reached end of valid path
        
        if(index==coins.length || amount<0) return -1;      //if coins exhausted or amount is going negative  ,  
        //on valid path  
        
        //logic
        int case1= helper(coins, index+1, amount, min); //not choose  - -1 or min
        int case2= helper(coins, index, amount-coins[index], min+1); //choose // -1 or min
        if(case1==-1) return case2;// if not choosing is pushing to a not valid path, return other case
        if(case2==-1) return case1;
        min= Math.min(case1, case2);
        return min;
    }*/