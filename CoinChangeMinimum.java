//TC O(amount*coins.length)
//SC O(amount*coins.length)
//runs in leetcode
class CoinChangeMinimum {
    static int[][] dp;
    public static int coinChange(int[] coins, int amount) {
        dp = new int [coins.length][amount+1];
        int ans = coinChange(coins, amount, 0);

        return ans==Integer.MAX_VALUE? -1: ans;
    }
    //  function Minimum no of coins required to meet amount
    private static int coinChange(int[] coins, int amount, int index){
        System.out.println("amount:: " +  amount + " index:: "+ index);

        //base case
        // have reached lowest level of tree, to traverse up to get count of selections
        if(amount ==0){
            return 0; // when amount is 0 dont need any more coins
        }
        //invalid case
        //when amount is negative or we are at index of last coin
        //return max value as we need min number of coins so we can ignore this path.
        if(amount < 0 || index == coins.length){
            return Integer.MAX_VALUE;
        }

        if(dp[index][amount] == 0){  // if this is not already calculated

            int sel =  coinChange(coins, amount-coins[index], index );

            if(sel != Integer.MAX_VALUE ) // check for overflow
                sel=sel+1;

            int notSel = coinChange(coins, amount, index+1);

            dp[index][amount] = Math.min(sel, notSel); //Min num of coins selected
        }
        return dp[index][amount];
    }

    public static final void main(String [] args){

        int [] coins = {1,2,5};
        int amount = 11 ;
        System.out.println("output:: " + coinChange(coins, amount));

    }
}