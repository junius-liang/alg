package subject;

import model.TreeNode;

/**
 * @author junius
 * @date 2022/12/06 22:12
 * 二叉树的最大深度
 **/
public class MaxDepthOfTree {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        TreeInfo treeInfo = method1(root);
        return treeInfo.curDepth;
    }

    public TreeInfo method1 (TreeNode root) {
        if (root==null){
            return new TreeInfo(0);
        }
        TreeInfo leftNode = method1(root.left);
        TreeInfo rightNode = method1(root.right);
        int curLength = Math.max(leftNode.curDepth,rightNode.curDepth);
        return new TreeInfo(curLength+1);
    }

    /**
     * 定义返回结构
     */
    static class TreeInfo{
        //当前最大深度
        private int curDepth;

        public int getCurDepth() {
            return curDepth;
        }

        public void setCurDepth(int curDepth) {
            this.curDepth = curDepth;
        }

        public TreeInfo(int curDepth) {
            this.curDepth = curDepth;
        }
    }
}
