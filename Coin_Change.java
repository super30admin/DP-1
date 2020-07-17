
public class Coin_Change {
	public int coinChange(int[] coins, int amount) {
		//Approach: I have tried the recursion tree and pasted in another file. Please check that too.
		//1. So with the recursion tree we could see that, there are so many overlapping structures and we could build a dp solution with it. 
		//Hence putting together everything in a dp matrix. coins will be in the rows and target amount will be columns.
		//Initially we will start with coin "0" and then fill the first row and column accordingly.
		//2. We have seen a pattern while building this dp matrix, its that for target amount which are lesser than the new coin, 
		//there is no use of the new coin so we will go with how we formed the target amount with old coins. ie. we will take previous column entry from dp amtrix.
		//else we need to fid the minimumno of ways of making that target amount, so we will consider the minimum of [previous entry or will add one to the [target - new coin] 
		//and check how the difference amount was made in the dp matrix adding 1 to it.
        int[][] dpArray = new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++)
        {
            dpArray[i][0] = 0;
        }
        for(int i=1;i<amount+1;i++)
        {
            dpArray[0][i] = amount+1;
        }
        for(int i=1;i <= coins.length;i++)
        {
            for(int j = 1; j< amount+1; j++)
            {
                //if target amount is lesser than the new coin
                if(j < coins[i-1])
                {
                    dpArray[i][j] = dpArray[i-1][j];
                }else                
                    dpArray[i][j] = Math.min(dpArray[i-1][j], 1+dpArray[i][j-coins[i-1]]);
                
            }
        }
     /*   for(int i=0; i <= coins.length;i++)
        {
            for(int j=0;j< amount+1;j++)
            {
                System.out.print(dpArray[i][j] + " --");
            }
            System.out.println(" ");
        }*/
        if(dpArray[coins.length][amount] >= amount+1)
        {
            return -1;
        }else
            return dpArray[coins.length][amount];
    }
}
//Time Complexity : O(nT) where n is the number of coins and T is the target amount 
//Space Complexity : O(nT) where n is the number of coins and T is the target amount 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//For recursive approach: I have built the recursive tree, based on the facts - either i can discard a coin or i can use the coin.
//Time Complexity : O(2 ^ (T/minimum coin in coins array)) where n is the number of coins and T is the target amount 
//Space Complexity : O(T/minimum coin in coins array) this is how long the recursion tree grows and it is for recursion stack.
//Did this code successfully run on Leetcode : No because of TLE i dint try this.
//Any problem you faced while coding this :