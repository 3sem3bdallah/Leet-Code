1class Solution {
2    public TreeNode createBinaryTree(int[][] descriptions) {
3        Map<Integer,TreeNode>map=new HashMap<>();
4        Map<Integer,Integer> root=new HashMap<>();
5        for(int[]arr:descriptions){
6            int parent=arr[0];
7            int child=arr[1];
8            boolean isLeft=arr[2]==1?true:false;
9            if(!map.containsKey(parent)){
10                map.put(parent,new TreeNode(parent));
11            }
12            if(!map.containsKey(child)){
13                map.put(child,new TreeNode(child));
14            }
15            if(isLeft){
16                map.get(parent).left=map.get(child);
17            }else map.get(parent).right=map.get(child);
18            if(root.getOrDefault(parent,0)!=-1){
19                root.put(parent,1);
20            }
21            root.put(child,-1);
22        }
23        int rootValue=0;
24        for(var entry:root.entrySet()){
25            if(entry.getValue()==1){
26                rootValue=entry.getKey();
27                break;
28            }
29        }
30        return map.get(rootValue);
31    }
32}