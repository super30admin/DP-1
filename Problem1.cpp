// Time Complexity : O(N*M) N is #of denominations available and M is amount. 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to figure out sub problem 


// Your code here along with comments explaining your approach:
// 1. Loop through 2d matrix dp where matrix[0][i]=infinite or max.
// 2. Take minimum value between if we are considering that denomination and not considering it.
// 3. Answer will be last element.

class Solution {
public:
    int minimum(int a,int b){
        if(a<b){return a;}return b;
    }
    int coinChange(vector<int>& coins, int amount) {
        
        int n=coins.size();
        int am=amount+1;
        int arr[n+1][am];
        //cout<<am<<' '<<n;
        for(int i=0;i<=amount;i++){
            arr[0][i]=(10005);
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    arr[i][j]=0;
                }
                else{
                    int x=(j-coins[i-1]);
                    //cout<<"#"<<coins[i-1]<<'\n';
                    if(x<0){
                        arr[i][j]=arr[i-1][j] ;
                    }else{
                        int tt=(arr[i][x]);
                        if(tt!=10005){tt++;}
                        arr[i][j]= minimum(arr[i-1][j],tt) ;}
                        //cout<<x<<' ';
                }
                //cout<<arr[i][j]<<' ';
            }
            cout<<'\n';
            
        }
        if(arr[n][amount]==10005){return -1;}
        return arr[n][amount];
    }
};

