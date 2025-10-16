package trees;

 TreeNode build(List<Integer> list,int start,int end){
        if(start > end) return null;
        int max = -1;
        for(int i = start;i <= end;i++){
        if(max == -1 || list.get(i) > list.get(max)){
        max = i;
        }
        }
        TreeNode root = new TreeNode(list.get(max));
        root.left = build(list,start,max - 1);
        root.right = build(list,max + 1,end);
        return root;
        }