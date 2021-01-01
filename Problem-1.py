#Time Complexity :o(n2)
#Space Complexity :o(n2)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def _newArray(self,size):
        return [0]*size
    
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if(len(coins)==0 or coins==None):
            return 0
        mat=[]
        
        for i in range(len(coins)+1):
            mat.append(self._newArray(amount+1))            
        
        for i in range(1,amount+1):
            mat[0][i]=99999
            
        for i in range(1,len(mat)):
            for j in range(1,len(mat[0])):
                if(coins[i-1]>j):
                    mat[i][j]=mat[i-1][j]
                else:
                    mat[i][j]=min(mat[i-1][j],1+mat[i][j-coins[i-1]])
                
        ans=mat[len(mat)-1][len(mat[0])-1]
        if(ans>=99999):
            ans= -1
        return ans
        
            
        