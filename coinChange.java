
/**
Time Complexity - O(M * N) where M is the size of coin array, N is the value of amount.
Space Complexity - O(N) where N is the value of amount.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] coinsReq = new int[amount + 1];
        Arrays.fill(coinsReq, Integer.MAX_VALUE);
        coinsReq[0] = 0;

        for(int change = 1; change <= amount; change++) 
            for(int coin : coins)   
                if(change >= coin && coinsReq[change - coin] != Integer.MAX_VALUE && coinsReq[change - coin] + 1 < coinsReq[change]) 
                        coinsReq[change] = coinsReq[change - coin] + 1;

        return coinsReq[amount] == Integer.MAX_VALUE ? -1 : coinsReq[amount];
    }
}
