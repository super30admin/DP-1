//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
//Did it run on leetcode: Yes
//Problems faced any?: No


public class Problem20 {
    public int coinChange(int[] coins, int amount) {
        int[][] minCoins = new int[coins.length+1][amount+1];

        for(int i=0; i<=coins.length; i++){
            for(int j=0; j<=amount; j++){
                minCoins[i][0] = 0;
                minCoins[0][j] = 99999;
            }
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j<coins[i-1]){
                    minCoins[i][j] = minCoins[i-1][j];
                }else{
                    minCoins[i][j] = Math.min(minCoins[i-1][j], 1+minCoins[i][j-coins[i-1]]);
                }
            }
        }

        return minCoins[coins.length][amount] >= 99999 ? -1 : minCoins[coins.length][amount];
    }
}
