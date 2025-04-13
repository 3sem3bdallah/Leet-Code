class Solution:
    def countGoodNumbers(self, n: int) -> int:
        mod = 10**9 + 7

        def binaryExp(x, y):
            res = 1
            mul = x % mod

            while y > 0:

                if y % 2 == 1:
                    res = (res * mul) % mod

                mul = (mul * mul) % mod
                y //= 2
            return res

        even_pos = (n + 1) // 2
        odd_pos = n // 2

        return (binaryExp(5, even_pos) * binaryExp(4, odd_pos)) % mod
