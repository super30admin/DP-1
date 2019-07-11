// Time Complexity :O(n*n) --> beacuse of for loop
// Space Complexity :O(n)  ---> because of Hashmap
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Didn'' understand how to approach for different test cases


// Your code here along with comments explaining your approach
import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        Arrays.sort(coins);
        for(int i =coins.length-1;i>=0;i--){
            map.put(coins[i],0);
            while((map.get(coins[i])+1)*coins[i]<=amount)
                map.put(coins[i],map.get(coins[i])+1);
            amount = amount - (coins[i])*map.get(coins[i]);
            if(amount == 0) return count + map.get(coins[i]);
            if(amount<coins[0]){
                count = 0;
                amount = amount + (coins[i])*map.get(coins[i]);
            }
            else{
                if(amount>0)
                    count+=map.get(coins[i]);}
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] coins = new int[]{3,4,5};
        int  amount = 7;
        System.out.println(coinChange(coins,amount));
    }
}
