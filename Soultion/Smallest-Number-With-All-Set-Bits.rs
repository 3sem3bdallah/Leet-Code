impl Solution {
    pub fn smallest_number(n: i32) -> i32 {
        let mut x = n;
        while (x & (x + 1)) != 0 {
            x += 1;
        }
        x
    }
}
