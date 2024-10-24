class MyStack:
    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        for i in range(len(self.queue)-1):
            self.push(self.queue.popleft())
        return self.queue.popleft()
    def top(self) -> int:
        for i in range(len(self.queue) - 1):
            self.push(self.queue.popleft())
        res = self.queue[0]
        self.push(self.queue.popleft())
        return res

    def empty(self) -> bool:
        return len(self.queue) == 0        
