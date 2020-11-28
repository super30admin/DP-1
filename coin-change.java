class Solution {
    // int[][] memo = new int [][];
    
//     public int coinChange(int[] coins, int amount) {
//         if (coins == null || coins.length == 0) {
//             return -1;
//         }
        
//         return helper(coins, amount, 0, 0);
//     }
    
    
//     private int helper(int[] coins, int amount, int index, int min) {
//         if(amount == 0) {
//             return min;
//         }
//         if (index == coins.length || amount < 0) {
//             return -1;
//         }
        
//         int coin1 = helper(coins, amount - coins[index], index, min + 1);
//         int coin2 = helper(coins, amount, index + 1, min);
        
//         if(coin1 == -1) {
//             return coin2;
//         }
        
//         if(coin2 == -1) {
//             return coin1;
//         }
        
//         return Math.min(coin1, coin2);
//     }
// Time Complexity - O(NM)
// Space Complexity - O(NM)
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length == 0 || coins == null) {
            return 0;
        }
        
        int[][] arr = new int[coins.length+1][amount+1];
        
        for(int i=1;i<arr[0].length;i++) {
            arr[0][i] = amount + 1;
        }
        System.out.println(arr[0][0]);
        
        for(int i=1;i<arr.length;i++) {
            for(int j=1;j<arr[0].length;j++) {
                if (coins[i-1]<=j) {
                    arr[i][j] = Math.min(arr[i-1][j], 1 + arr[i][j-coins[i-1]]);
                }
                else {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        if(arr[coins.length][amount] == amount + 1) {
            return -1;
        }
        return arr[coins.length][amount];
    }
}
