class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        if not meetings: 
            return days

        # Step 1: Sort meetings based on start day
        meetings.sort()

        # Step 2: Merge overlapping intervals and count busy days
        busy_days = 0
        prev_start, prev_end = meetings[0] 

        for start, end in meetings[1:]:
            if start > prev_end + 1:  # Non-overlapping meeting
                busy_days += prev_end - prev_start + 1
                prev_start, prev_end = start, end
            else:  # Overlapping, merge intervals
                prev_end = max(prev_end, end)

        # Add last merged interval
        busy_days += prev_end - prev_start + 1

        # Step 3: Compute free days
        return days - busy_days
