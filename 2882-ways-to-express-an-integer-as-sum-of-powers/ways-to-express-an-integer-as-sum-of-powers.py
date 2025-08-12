class Solution:
    MOD = 10**9 + 7
    
    def numberOfWays(self, n: int, x: int) -> int:
        from functools import lru_cache
        
        @lru_cache(None)
        def helper(remaining, curr):
            if remaining == 0:
                return 1
            if remaining < 0 or curr ** x > remaining:
                return 0
            
            power = curr ** x
            # Include curr
            include = helper(remaining - power, curr + 1) % self.MOD
            # Exclude curr
            exclude = helper(remaining, curr + 1) % self.MOD
            
            return (include + exclude) % self.MOD
        
        return helper(n, 1)
