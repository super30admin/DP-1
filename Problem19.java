public class Solution{
   public  int minCoins(int[] intArr,  int target){
           return minCoinsSubFunc(intArr,intArr.length-1,target,0, new int[intArr.length][]);
       }
       
       public  int minCoinsSubFunc(int[] intArr,int endIndex,int remtarget,int coinsConsidered,int[][] map){
           if(remtarget<0 || endIndex==0) return 9999;
           if(remtarget==0) return coinsConsidered;
           if( map[endIndex][remtarget]!=0) return map[endIndex][remtarget];
          map[endIndex][remtarget-intArr[endIndex]]= minCoinsSubFunc(intArr,endIndex, remtarget-intArr[endIndex],coinsConsidered+1,map);
          map[endIndex-1][remtarget]= minCoinsSubFunc(intArr,endIndex-1, remtarget,coinsConsidered,map);
          return Math.min( map[endIndex][remtarget-intArr[endIndex]],
                   map[endIndex-1][remtarget]);
           
        }
}
