package subject;

import model.TreeNode;

/**
 * @author junius
 * @date 2022/12/02 20:18
 * 平衡二叉树
 **/
public class BalancedTree {
    static class Info{
        public boolean isBalance;
        public int height;
        public Info(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }



    public boolean method1(TreeNode root){
        Info result = balance(root);
        return result.isBalance;
    }



    private Info balance(TreeNode root) {
        if (root==null){
            return new Info(true,0);
        }
        //如果左右子树不是平衡树，直接返回
        Info leftNode = balance(root.left);
        Info rightNode = balance(root.right);
        if (!leftNode.isBalance){
            return new Info(false,Math.max(leftNode.height, rightNode.height)+1);
        }
        if (!rightNode.isBalance){
            return new Info(false,Math.max(leftNode.height, rightNode.height)+1);
        }
        //左右树都是平衡树,就看它的左右两个子树的高度差的绝对值不超过1
        if (Math.abs(leftNode.height-rightNode.height)<=1){
            return new Info(true,Math.max(leftNode.height,rightNode.height)+1);
        }
        return new Info(false,Math.max(leftNode.height,rightNode.height)+1);
    }

}
