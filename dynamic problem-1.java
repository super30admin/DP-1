// Time Complexity :o(m*n)
// Space Complexity :0(m+N)
// Did this code successfully run on Leetcode : no got error at 40th testcase;
// Any problem you faced while coding this : edge cases;


// Your code here along with comments explaining your approach;-first dp table is created with rows=coins.length+1,columns=amount+1; filling the table and returning last elemnt.








class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==1){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else{
                return -1;
            }
        }
        Arrays.sort(coins);
        int m=coins.length+1;
        int n=amount+1;
        int[][] a=new int[m][n];
        for(int k=1;k<n;k++){
            a[0][k]= Integer.MAX_VALUE;
        }
        for(int y=0;y<m;y++){
            a[y][0]=0;
        }
    for(int i=1;i<=m-1;i++)       
    {
        for(int j=1;j<=amount;j++)
        {
            if(coins[i-1]<=j)
            {
                a[i][j]=Math.min(1+a[i][j-coins[i-1]],a[i-1][j]); 
            }
            else
                a[i][j]=a[i-1][j];
        }
    }
        
   return a[m-1][n-1]>amount ? -1: a[m-1][n-1]; }
}
       
