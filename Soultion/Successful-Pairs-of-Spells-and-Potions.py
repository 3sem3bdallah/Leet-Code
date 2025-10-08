import math
import bisect

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        result = []

        for spell in spells:
            minPotion = math.ceil(success / spell)
            idx = bisect.bisect_left(potions, minPotion)
            result.append(m - idx)
        
        return result