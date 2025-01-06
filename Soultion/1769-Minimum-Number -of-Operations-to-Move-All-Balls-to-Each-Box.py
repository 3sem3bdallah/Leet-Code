class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        boxes = list(map(int, list(boxes)))

        n = len(boxes)
        l1 = [0]*n

        for i in range(n):
            for j in range(n):
                if boxes[j] == 1:
                    dis = abs(j - i)
                    l1[i] += dis
        return l1
