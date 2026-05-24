class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        temp = n
        add_sum = 0
        product = 1

        while temp > 0:
            r = temp % 10
            temp = temp//10

            add_sum = add_sum + r
            product = product * r

            result = product - add_sum

        return result