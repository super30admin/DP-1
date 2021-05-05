package DynamicProgramming;

/*
-------------------------------------------------------------------------------------------------------
    Time complexity : exponential
    space complexity: exponential
    Did this code run successfully in leetcode : yes
    problems faces : no
    at every step either choose the element or not,
    if you have chosen an element  from the coin, reduce the total amount by coins[index] and increase the number of coins by one
    if you are not choosing the element at index, increase the index by one and keep the amount and number of coins as same
*/

public class CoinChangeWithRecursion {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return -1;
        
        int minCoins = 0;

        return findCoinChangeForGivenSum(coins, 0, amount, minCoins);
    }

    public int findCoinChangeForGivenSum(int[] coins, int index, int amount, int minCoins) {

        if(amount ==0) return minCoins; //valid
        
        if(index==coins.length  || amount <0) return -1; //not valid
        
         //choose the coin  ,reduce the total amount by coins[index] and increase the number of coins by one
        
        int case1=findCoinChangeForGivenSum(coins, index, amount-coins[index], minCoins+1);  //-1 or num
        
        //not choose the coin,  increase the index by one and keep the amount and number of coins as same
        int case2 = findCoinChangeForGivenSum(coins, index+1, amount, minCoins); //-1 or num
        
        if(case1 == -1) return case2;
        else if(case2 == -1 )return case1;
        
        return Math.min(case1, case2);
    }
}
