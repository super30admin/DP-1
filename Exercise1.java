class Solution {
    public int coinChange(int[] coins, int amount) {
    int temp=amount,count=0,index=coins.length-1;
        while(index>=0)
        {
            if(temp==0){return count;}
            if(temp>=coins[index]){temp-=coins[index];count++;}
            else{--index;}
        }
        return -1;
    }
}