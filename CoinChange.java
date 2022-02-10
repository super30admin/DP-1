/*
Time complexity: O(S*n)
Space Complexity: O(N)
Code run on Leetcode: Yes
Any difficulties: No

Approach:
Attempted once explained in the class
 */
public class CoinChange {
    private static int [][] memo;
    public static int coinChange(int[] coins, int amount){

        memo = new int[coins.length][amount+1];

        int count = reachTarget(coins, 0, amount);
        return count!=Integer.MAX_VALUE? count: -1;
    }
    public static int reachTarget(int[] coins, int index, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount<0 || index == coins.length){
            return Integer.MAX_VALUE;
        }

        if(memo[index][amount] == 0){
            int notChooseCondition = reachTarget(coins, index+1, amount);
            int chooseCondition = reachTarget(coins, index, amount-coins[index]);
            if(chooseCondition!= Integer.MAX_VALUE){
                chooseCondition+=1;
            }
            memo[index][amount] = Math.min(notChooseCondition, chooseCondition);
        }
        return memo[index][amount];
    }
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int[] coins1 = {2};
        int[] coins2 = {1};
        System.out.println("minimum number of coins required: "+ coinChange(coins, 11));
        System.out.println("minimum number of coins required: "+ coinChange(coins1,3));
        System.out.println("minimum number of coins required: "+ coinChange(coins2,0));
    }
}
