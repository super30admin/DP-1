// Time Complexity :  O(N*M)        //itirating matring
// Space Complexity : O(N*M)       //because creating DP matrix
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

//DP SOLUTION
import java.util.*;
class Main {  
  public static int minCoins(int []coins, int amount){
   if(coins==null || coins.length==0){
     return 0;
   }
   int [][]dp=new int[coins.length+1][amount+1];            // adding extra column for 0 and extra row to store dummy infinity to compare and get values;
   int m=dp.length; int n=dp[0].length;                     
   for(int i=1;i<n;i++){
     dp[0][i]=amount+1;
   }
   for(int i=1;i<m;i++){
     for(int j=1;j<n;j++){
       if(j<coins[i-1]){
         dp[i][j]=dp[i-1][j];                              //keeping same values until the amount is less than previous coins
       }else{
         dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);          //takes minimum between the above value and the value which is at[amount-(coins-1)]+1) 
       }
     }
   }
   int result=dp[m-1][n-1];
   if(result>=amount+1){                                                //if result crosses amount which is invalid then returning -1; 
     return -1;
   }
   return result;
  }
  public static void main(String[] args) {
    int []coins={1,2,5};
    int amount=11;
    System.out.println("Minimum coins are: " +minCoins(coins, amount));
  }
}


//RECURSIVE SOLUTION
import java.util.*;
class Main {  
  public static int minCoins(int []coins, int amount){
    if(coins==null || coins.length==0){
      return 0;
    }
    return helper(coins, amount, 0, 0);
  }
  private static int helper(int []coins, int amount, int index, int min){
    if(amount==0){
      return min;
    }
    if(amount<0 || index==coins.length){
      return -1;
    }
    //base 
    //logic to choose
    int case1=helper(coins, amount-coins[index], index, min+1);
    //not choose
    int case2=helper(coins, amount, index+1, min);
    if(case1==-1){
      return case2;
    }
    if(case2==-1){
      return case1;
    }
    return Math.min(case1, case2);
  }
  public static void main(String[] args) {
    int []coins={1,2,5,7};
    int amount=49;
    System.out.println("Minimum coins are " +minCoins(coins, amount));
  }
}