class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # First method by using Loop

        # if n<=0:
        #     return False
        # while n%2==0:
        #     n//2
        # if n==1:
        #     return True
        # else:
        #     return False

        # 2nd method by using recursion
        if n<=0:
            return False
        if n==1:
            return True
        if (n%2!=0):
            return False
        
        return self.isPowerOfTwo(n//2)
        

        
        