//The aim of this program is given available coin denominations and amount to find the least number of coins required to find the amount.
//Time complexity : a being equal to the value of amount given O(aN)
//Space complexity: O(a)
//Ran the code on leet code and was accepted on submission 
class Solution 
{
    public int coinChange(int[] coins, int amount)
    {
        // If the amount given is less than 1 then return 0
        if(amount< 1)
            return 0;
        //allocate spaces upto amount+1 to dp array
        int[] dp = new int [amount+1];
        // fills up the values from 0 to amount+1
        Arrays.fill(dp,amount+1);
        //assigning dp 0 index as 0
        dp[0] = 0;
        //iterate from 0 to value of amount
        for (int i =0; i<= amount; i++)
        {
            //Iterating over the coins denominations array "coins"
            for (int j = 0; j<coins.length; j++)
            {
                //if the coin denomination value is less than or equal to the amount value at i
                if(coins[j] <= i)
                {
                    //calculate the dp value for i amount as the minimum between the current dp value for i amount and dp value for current amount minus that of the coin denomination +1
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
                }
            }
        }
        //if the dp value for the given amount is above the value of the given amount return -1 else return the dp value
        return dp[amount] > amount ? -1 : dp[amount];
    }
}