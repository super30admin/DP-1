//time complexity:O(n*amount)
//space complexity:O(amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr=new int[amount+1];
        
        Arrays.fill(arr,amount+1);
        arr[0]=0;
        for(int i=1;i<=amount;i++){
            
            for(int j=0;j<coins.length;j++){
                
                if(i>=coins[j] ){
                    arr[i]=Math.min(arr[i-coins[j]]+1,arr[i]);
                }
            }
        }
        if(arr[amount]==amount+1)return -1;
        return arr[amount];
    }
}