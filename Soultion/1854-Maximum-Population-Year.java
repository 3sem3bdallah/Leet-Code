public class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[2051];
        
        for (int[] log : logs) {
            population[log[0]]++; 
            population[log[1]]--;
        }
        int maxPopulation = 0;
        int maxYear = 1950;
        int currentPopulation = 0;
        for (int year = 1950; year <= 2050; year++) {
            currentPopulation += population[year];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxYear = year;
            }
        }
        return maxYear;
    }
}
