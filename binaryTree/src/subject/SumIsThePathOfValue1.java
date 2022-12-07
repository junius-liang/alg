package subject;

import model.TreeNode;

/**
 * @author junius
 * @date 2022/12/06 22:29
 * @projectName 二叉树中和为某一个值的路径(一)
 * 牛客BM29题
 **/
public class SumIsThePathOfValue1 {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        return method1(root, sum);
    }

    /**
     *
     * @param node 树的节点
     * @param val 剩余值
     * @return 返回结果
     */
    public boolean method1(TreeNode node,int val){
        if (node==null){
            return false;
        }
        if (node.left==null&&node.right==null&&val-node.val==0){
            return true;
        }
        return method1(node.left, val - node.val)||method1(node.right, val - node.val);
    }

}
