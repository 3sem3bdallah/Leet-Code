class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        length = 2**n - 1
        invert = False

        while length > 1:
            half = length // 2

            if k <= half:
                length = half
            elif k > half + 1:
                k = length - k + 1
                length = half
                invert = not invert
            else:
                return '1' if not invert else '0'

        return '0' if not invert else '1'

    def helper(self, length, k, invert):
        if length == 1:
            return '0' if not invert else '1'

        half = length // 2

        if k <= half:
            return self.helper(half, k, invert)
        elif k > half + 1:
            return self.helper(half, length - k + 1, not invert)
        else:
            return '1' if not invert else '0'
