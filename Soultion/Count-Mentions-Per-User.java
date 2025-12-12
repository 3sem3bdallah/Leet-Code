1class Solution {
2    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
3        int[] mentions = new int[numberOfUsers];
4        int[] offlineTime = new int[numberOfUsers];
5
6        events.sort((a, b) -> {
7            int timeA = Integer.parseInt(a.get(1));
8            int timeB = Integer.parseInt(b.get(1));
9            return timeA == timeB ? b.get(0).compareTo(a.get(0)) : timeA - timeB;
10        });
11
12        for (List<String> event : events) {
13            if (event.get(0).equals("MESSAGE")) {
14                handleMessage(event, mentions, offlineTime);
15            } else if (event.get(0).equals("OFFLINE")) {
16                handleOffline(event, offlineTime);
17            }
18        }
19
20        return mentions;
21    }
22
23    private void handleMessage(List<String> event, int[] mentions, int[] offlineTime) {
24        int timestamp = Integer.parseInt(event.get(1));
25        String[] tokens = event.get(2).split(" ");
26
27        for (String token : tokens) {
28            if (token.equals("ALL")) {
29                for (int i = 0; i < mentions.length; i++)
30                    mentions[i]++;
31            } else if (token.equals("HERE")) {
32                for (int i = 0; i < mentions.length; i++) {
33                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timestamp)
34                        mentions[i]++;
35                }
36            } else {
37                int id = Integer.parseInt(token.substring(2));
38                mentions[id]++;
39            }
40        }
41    }
42
43    private void handleOffline(List<String> event, int[] offlineTime) {
44        int timestamp = Integer.parseInt(event.get(1));
45        int id = Integer.parseInt(event.get(2));
46        offlineTime[id] = timestamp;
47    }
48}