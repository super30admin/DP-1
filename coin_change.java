//Time Complexity: O(n)
//Space Complexity: O(n), due to temp array
// Approach followed: Greedy
//Passed on Leet code: Half test case failed

class Solution {
    public int coinChange(int[] coins, int amount) {
        //Arrays.sort(coins,Collections.reverseOrder());
        Arrays.sort(coins);
        int desc[] = new int[coins.length];
        for(int i=0,j=coins.length-1;i<coins.length;i++,j--){
            desc[j]=coins[i];
        }
       
        int coin_count=0;
        int buffer=amount;
        for(int i=0;i<coins.length;i++){
            if((i>0)&&(desc[i-1]<=buffer)){
                buffer-=desc[i-1];
                coin_count++;
                System.out.println("Coin used "+desc[i]);
            }
            if(desc[i]<=buffer){
            buffer-=desc[i];
                coin_count++;
                System.out.println("Coin used "+desc[i]);
            }
            System.out.println("buffer is "+buffer);  
        }
        System.out.println(coin_count);
        if(buffer==0) return coin_count;
        else return -1;
    }
}


