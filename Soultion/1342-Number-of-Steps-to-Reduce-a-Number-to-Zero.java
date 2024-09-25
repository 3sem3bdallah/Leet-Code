import java.util.Scanner;

class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            step += 1;
        }
        return step;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(n));
    }
}
