impl Solution {
    pub fn max_bottles_drunk(num_bottles: i32,mut num_exchange: i32) -> i32 {
        let mut res = num_bottles;
        let mut empty = num_bottles;

        while empty >= num_exchange {
            empty -= num_exchange;
            res +=1;
            empty += 1;
            num_exchange += 1;
        }
        res
    }
}