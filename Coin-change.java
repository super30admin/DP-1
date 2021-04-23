// Worst case Time: O(Number of coins * amount)
// Space: O(Number of coins * amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
      if(amount == 0){
        return 0;
      }
      if(coins == null || coins.length == 0){
        return 0;
      }
      
      //Eg: [3,5,6] amount = 12
      int[][] dp = new int[coins.length+1][amount+1]; 
      int maxLimit = amount+1;//inf
      
      for(int i=0;i<=coins.length;i++){
        dp[i][0] = 0;
      }
        for(int j = 1;j<=amount;j++){
           dp[0][j] = maxLimit;
        }
      
      
      for(int i=1;i<=coins.length;i++){
        
        for(int j = 1;j<=amount;j++){
           
          if(coins[i-1] > j){ // access coins in given array using i-1 as we have added another row in our dp matrix
            // if(i>0)
              dp[i][j] = dp[i-1][j];
          }
          else{
            // if(i>0)
              
            // if(dp[i][j-coins[i-1]] == maxLimit){
            //   dp[i][j] = maxLimit;
            // }
            // else
              dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
          }
          //System.out.println(dp[i][j]);
        }
        //System.out.println("========== end of loop");
        
      }
      // System.out.println(Integer.MAX_VALUE);
      if(dp[coins.length][amount] > amount){
        return -1;
      }
      return dp[coins.length][amount];
      
    }
}




// // First Attempt: Brute force (Partial output)

// class Solution {
//   public int coinChange(int[] coins, int amount) {
//       Arrays.sort(coins);
//       HashMap<Integer,Integer> map = new HashMap<>();
//       int totalCount = 0;
//       // int count =0;
//         for(int i=coins.length-1;i>=0;i--){
//           int value = coins[i];
//           while(amount >= value){
//             amount -= value;
//            int count = 0;
//             if(map.containsKey(value)){
//               int valueCount = map.get(value);
//               map.put(value,++valueCount);
//             }
//             else
//               map.put(value,++count);
            
//           }
//           System.out.println(amount);
//         }
      
//       for(int i:map.values()){
//         totalCount += i;
//       }
      
//       if(amount == 0){
//         return totalCount;
//       }else
//         return -1;
//     }
// }
