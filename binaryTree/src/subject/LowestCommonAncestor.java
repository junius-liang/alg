package subject;

import model.TreeNode;

/**
 * @author junius
 * @date 2022/12/07 13:01
 * @project MyAlg
 * 最近公共祖先
 **/
public class LowestCommonAncestor {
    /**
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        //判空
        if (root == null){
            return -1;
        }
        // 如果o1跟o2任意一个与root匹配，则公共祖先是root
        if (root.val==o1||root.val==o2){
            return root.val;
        }
        //从左右子树寻找公共祖先
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1,o2);

        if (left==-1){
            return right;
        }
        if (right==-1){
            return left;
        }
        return root.val;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
                return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) {
                return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }

}
