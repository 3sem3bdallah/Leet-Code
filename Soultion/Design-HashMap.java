1class MyHashMap {
2    List<Integer> keys;
3    List<Integer> values;
4
5    public MyHashMap() {
6        keys = new ArrayList<>();
7        values = new ArrayList<>();
8    }
9
10    public void put(int key, int value) {
11        if (keys.contains(key))
12            values.set(keys.indexOf(key), value);
13        else {
14            keys.add(key);
15            values.add(value);
16        }
17    }
18
19    public int get(int key) {
20        if (!keys.contains(key))
21            return -1;
22        return values.get(keys.indexOf(key));
23    }
24
25    public void remove(int key) {
26        if (!keys.contains(key))
27            return;
28        int index = keys.indexOf(key);
29        keys.remove(index);
30        values.remove(index);
31    }
32}