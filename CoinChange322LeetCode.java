//time complexity : O(n*amount) n=number of coins
//space complexity ; O(amount)
//I don't face any problems
//runs successfully on leetcode


public class CoinChange322LeetCode {

    //Bottom Up Approach

    public int coinChange(int[] coins, int amount) {

        int[] prev = new int[amount+1];

        for(int i=1; i<=amount;i++){
            prev[i] = Integer.MAX_VALUE;
        }

        int[] current = new int[amount+1];

        for(int i=0; i<coins.length; i++){

            for(int j=1; j<=amount;j++){

                int select;
                if(j-coins[i]<0){
                    select = Integer.MAX_VALUE;
                }
                else{

                    if(current[j-coins[i]]==Integer.MAX_VALUE){
                        select = Integer.MAX_VALUE;
                    }
                    else{
                        select = 1 + current[j-coins[i]];
                    }
                }

                //int select = (j-coins[i])<0 ? Integer.MAX_VALUE : (1 + current[j-coins[i]]);
                int notSelect = prev[j];

                current[j] = Math.min(select, notSelect);
            }
            prev = current;

        }

        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];

    }











    //top down Approach
//    int[][] dp;
//
//    public int coinChange(int[] coins, int amount) {
//
//        dp = new int[coins.length][amount+1];
//
//        int count = coinChange(coins, 0 ,amount);
//        return count == Integer.MAX_VALUE ? -1 : count;
//
//    }
//
//    public int coinChange(int[] coins, int index, int amount){
//
//        if(amount == 0){
//            return 0;
//        }
//
//        if(amount<0 || index == coins.length){
//            return Integer.MAX_VALUE;
//        }
//
////         if(dp[index][amount] == 0){
//
////             //not choosing a coin
////             int notChoose = coinChange(coins, index+1, amount) ;
//
////             //choosing a coin
////             int choose = coinChange(coins, index, amount-coins[index]);
//
////             if(choose!= Integer.MAX_VALUE){
////                 choose+=1;
////             }
//
////             int minimumCoins = Math.min(notChoose, choose);
////             dp[index][amount] = minimumCoins;
////             return minimumCoins;
////         }
////         else{
////             return dp[index][amount];
////         }
//
//
//        if(dp[index][amount] != 0){
//            return dp[index][amount];
//        }
//
//        //not choosing a coin
//        int notChoose = coinChange(coins, index+1, amount) ;
//
//        //choosing a coin
//        int choose = coinChange(coins, index, amount-coins[index]);
//
//        if(choose!= Integer.MAX_VALUE){
//            choose+=1;
//        }
//
//        int minimumCoins = Math.min(notChoose, choose);
//        dp[index][amount] = minimumCoins;
//        return minimumCoins;
//
//    }
}
