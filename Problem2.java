/**
Leet Code Submitted : YES
Time Complexity : O(N^2)
Space Complexity: O(N^2)

We use 2-D array to store coins state for each denomination available at each point we will decide if we want to take this denomination or not. Sort of like Knapsack which helps me to solve such problems **/


class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int[][] coin_storage = new int[coins.length][amount + 1];
        
        Arrays.sort(coins);
        
        for(int coin_index = 0; coin_index < coins.length; coin_index ++){
            for(int change = 0; change < amount+1 ; change ++){
                if(coin_index == 0){
                    if(change % coins[coin_index] == 0){
                        coin_storage[coin_index][change] = change/coins[coin_index];
                    }
                    else{
                        coin_storage[coin_index][change] = -1;
                    }     
                }
                else{
                    
                    if(coins[coin_index] > change){
                        coin_storage[coin_index][change] = coin_storage[coin_index - 1][change];
                    }else{ 
                        if(coin_storage[coin_index - 1][change] == -1 && coin_storage[coin_index][change - coins[coin_index]] == -1){
                            coin_storage[coin_index][change] = -1;
                        }else{
                            if(coin_storage[coin_index - 1][change] == -1)
                                coin_storage[coin_index][change] = coin_storage[coin_index][change - coins[coin_index]] + 1;
                            else if(coin_storage[coin_index][change - coins[coin_index]] == -1)
                                coin_storage[coin_index][change] = coin_storage[coin_index - 1][change];
                            else{
                                if(coin_storage[coin_index - 1][change] != -1 && coin_storage[coin_index][change - coins[coin_index]] != -1)
                                coin_storage[coin_index][change] = Math.min(coin_storage[coin_index - 1][change],coin_storage[coin_index][change - coins[coin_index]] + 1);
                            }
                                
                        }
                
                }
            }
        }
    }
        
        /*for(int i = 0; i<coins.length; i++){
            for(int j = 0; j<amount + 1; j++){
                System.out.println(coin_storage[i][j]);
            }
        }*/
        
        return coin_storage[coins.length-1][amount];
    }
}