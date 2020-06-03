//Time Complexity: O(mn) m->number of coins n->amount
//Space Complexity: O(n)



class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] arr = new int[amount+1];
       Arrays.fill(arr,amount+1);
       arr[0]=0;
       for(int i=1;i<arr.length;i++){
           for(int c : coins){
               if(i>=c){
                   arr[i]=Math.min(arr[i-c]+1,arr[i]);
               }
           }
       }
       if(arr[arr.length-1]>amount){
           return -1;
       }
       else{
           return arr[arr.length-1];
       }
    }
}