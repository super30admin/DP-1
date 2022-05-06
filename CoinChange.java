// Time Complexity : O(N) +O(N.M) N = amount, M= coins
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        arr[0] = 0;
        for(int i =1; i<amount+1; i++)
            arr[i] = amount+1; //fill-p some dummy value, anything > amount

        for(int i =1; i<amount+1; i++) {
            int currAmount = i;
            for(int coin : coins) {
                if(coin <=  currAmount) {
                    int change = currAmount - coin;
                    arr[i] = Math.min(1+arr[i - coin], arr[i]);
                }
            }
        }
        return arr[amount] > amount ? -1 : arr[amount] ;

    }
}
