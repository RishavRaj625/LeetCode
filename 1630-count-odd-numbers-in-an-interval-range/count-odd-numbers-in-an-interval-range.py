class Solution:
    def countOdds(self, low: int, high: int) -> int:
        return (high+1)//2 - (low//2)
        # diff = (high+1)//2 - (low//2)
        # return diff

        # This formula is vaild for both even or odd 


            
