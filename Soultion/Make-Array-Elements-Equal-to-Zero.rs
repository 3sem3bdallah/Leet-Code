impl Solution {
    pub fn count_valid_selections(nums: Vec<i32>) -> i32 {
        let mut prefix = 0;
        let mut cnt = 0;
        let mut sum = 0;
        for &x in &nums { sum += x; }
        for &x in &nums {
            prefix += x;
            if x == 0 {
                cnt += 2 * ((2 * prefix == sum) as i32);
                cnt += ((2 * prefix - sum).abs() == 1) as i32;
            }
        }
        cnt
    }
}
