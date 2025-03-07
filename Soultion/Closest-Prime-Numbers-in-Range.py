class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        primes = []
        
        for num in range(left, right + 1):
            if num < 2:
                continue
            if num in (2, 3):
                primes.append(num)
                continue  
            
            if num % 2 == 0 or num % 3 == 0:
                continue
            
            i = 5
            is_prime = True  
            while i * i <= num:
                if num % i == 0 or num % (i + 2) == 0:
                    is_prime = False  
                    break  
                i += 6 
            
            if is_prime:
                primes.append(num)
        
        if len(primes) < 2:
            return [-1, -1]

        min_gap = float("inf")
        best_pair = [-1, -1]
        
        for i in range(len(primes) - 1):
            gap = primes[i + 1] - primes[i]
            if gap < min_gap:
                min_gap = gap
                best_pair = [primes[i], primes[i + 1]]

        return best_pair  
