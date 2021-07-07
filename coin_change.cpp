// Time Complexity : O(mn) //m being no of coins, n being amount given
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :Understanding when to continue with previous value and when to calculate was tricky.


// Your code here along with comments explaining your approach

//1.Edge case
//A. coins size 0 then return -1
//B. Amount zero return 0 

//2. Calculate coins needed for each denomination and store in the array.
//A. when we deal with first coin we have no reference coin count so calculate it inidividually
//B. fill other arrays with reference to previous coin count

class Solution {
  int calculate_number_of_coins_needed(vector<int>& coins, int amount){
        
      //We are going to loop through this array for every element of the coins array
      vector<int> coins_for_denomination(amount+1, -1);
      coins_for_denomination[0] =0;
      int i=0;
      while(i<coins.size()){
          if(0==i){
              //2.A Loop through the entire array to fill up the elements when i=0;
              for(int denomination=1; denomination<coins_for_denomination.size();denomination++){
                  int temp_denomination=0, count=0;
                  while(temp_denomination<denomination){
                      temp_denomination+=coins[i];
                      count++;
                  }
                  if(temp_denomination==denomination){
                      coins_for_denomination[denomination] = count;
                  }
              }
          }
          
          else{
             //2.B 
              for(int denomination=1; denomination<coins_for_denomination.size();denomination++){
                    if(coins[i] > denomination){
                        continue;
                    }
                  //no match for the coin
                    if(-1 == coins_for_denomination[denomination- coins[i]]){
                        continue;
                    }
                    
                    if(-1 == coins_for_denomination[denomination]){
                        coins_for_denomination[denomination] = (1+ coins_for_denomination[denomination- coins[i]]);
                    }
                    else{
                        coins_for_denomination[denomination] = min(coins_for_denomination[denomination], (1+ coins_for_denomination[denomination- coins[i]]));
                    }
                   
                }
          }
          
         i++; 
      }
      
     return  coins_for_denomination[amount];
     
  }
public:
    int coinChange(vector<int>& coins, int amount) {
        //1.A
        if(0==coins.size()){
            return -1;
        }
        //1.B
        if(0 ==amount){
            return 0;
        }
        //2
        return calculate_number_of_coins_needed(coins, amount);
        
        
    }
};
