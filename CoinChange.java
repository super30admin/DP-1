import java.util.HashMap;

public class CoinChange {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public void coin(int[] coins, int amount){
        if(amount == 0){
            hm.put(0,0);
            return;
        }
        coin(coins, amount-1);
        for(int i=0; i<coins.length; i++){
            if(!hm.containsKey(amount) && amount >= coins[i] && hm.containsKey(amount-coins[i])){
                hm.put(amount, hm.get(amount-coins[i])+1);
                continue;
            }
            if(amount >=coins[i] && hm.containsKey(amount-coins[i])){
                if(hm.get(amount-coins[i])+1 < hm.get(amount)){
                    hm.put(amount, hm.get(amount-coins[i])+1);
                }
            }
        }
    }

    public int coinChange(int[] coins, int amount){
        for(int i=0; i<coins.length; i++){
            this.hm.put(coins[i], 1);
        }
        coin(coins, amount);
        if(hm.containsKey(amount)){
            return hm.get(amount);
        }
        else{
            return -1;
        }
    }
}
