//TC is O(mn) where m is distinct conis available and n is the max amount
// SC is O(mn) as new matrix is created
class Solution {
    HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(mem.containsKey(amount)){
            return mem.get(amount);
        }
        int min =Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res=coinChange(coins, amount-coins[i]);
            if(res!=-1){
                min=Math.min(min,res);
            }
        }
        if(min==Integer.MAX_VALUE){
            min = -2;
        }
        min++;
        mem.put(amount, min);
        return min;
    }
}
