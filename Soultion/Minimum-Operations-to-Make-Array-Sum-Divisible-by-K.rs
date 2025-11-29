1impl Solution {
2    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
3        nums.iter().sum::<i32>() % k
4    }
5}