class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] new_coins = new int[coins.length];
        Arrays.sort(coins);
        for(int i= coins.length-1;i>=0;i--){
            new_coins[coins.length-1-i]=coins[i];
        }
         for(int i=0 ;i<new_coins.length;i++){
            System.out.println(new_coins[i]);
        }
      
        int count=0;
        for(int i=0; i<new_coins.length; i++){
            
            while(!(new_coins[i]> amount)){
                System.out.println("amount");
                System.out.println(amount);
                System.out.println("count");
                System.out.println(count);
                System.out.println("new_coins[i]");
                System.out.println(new_coins[i]);
                
                amount = amount-new_coins[i];
                count++;
            }
            if(amount == 0) return count;
            
        }
        return -1;
        
    }
}