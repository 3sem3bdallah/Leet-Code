# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)
import heapq

class FoodRatings:
    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.foodToCuisine = {}
        self.foodToRating  = {}
        self.cuisineHeap   = {}

        for f, c, r in zip(foods, cuisines, ratings):
            self.foodToCuisine[f] = c
            self.foodToRating[f]  = r
            if c not in self.cuisineHeap:
                self.cuisineHeap[c] = []
            heapq.heappush(self.cuisineHeap[c], (-r, f))

    def changeRating(self, food: str, newRating: int) -> None:
        self.foodToRating[food] = newRating
        c = self.foodToCuisine[food]
        heapq.heappush(self.cuisineHeap[c], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        heap = self.cuisineHeap[cuisine]

        while heap:
            rating_neg, food = heap[0]
            if -rating_neg == self.foodToRating[food]:
                return food
            heapq.heappop(heap)
        return None