package subject;

import model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author junius
 * @date 2022/12/02 20:33
 **/
public class MaxWidthOfTree {

    /**
     *  解法一：使用map
     */
    public static int method1(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>(32);
        Queue<TreeNode> queue = new LinkedList<>();
        //当前层
        int curLevel = 1;
        //当前层的节点数
        int curNodes = 0;
        //最大节点数
        int max = 0;
        queue.add(root);
        map.put(root,1);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //当前节点所在的层
            int nodeLevel = map.get(node);
            if (node.left!=null){
                map.put(node.left,curLevel+1);
                queue.add(node.left);
            }
            if (node.right!=null){
                map.put(node.right,curLevel+1);
                queue.add(node.right);
            }
            //如果当前层等于节点所在层，当前节点数加一
            if (nodeLevel==curLevel){
                curNodes++;
            }
            //如果不在则说明该结算了，更新最大值,当前层加一并将当前层的节点数置1
            else {
                max = Math.max(max,curNodes);
                curNodes=1;
                curLevel++;
            }
        }
        max = Math.max(max,curNodes);
        return max;
    }



    /**
     * 解法二
     * @param node
     * @return
     */
    public static int method2(TreeNode node){
        if (node==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        TreeNode curEnd = node;
        TreeNode nextEnd = null;
        int max = 0;
        int curNodes = 0;
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (treeNode.left!=null){
                queue.add(treeNode.left);
                nextEnd = treeNode.left;
            }
            if (treeNode.right!=null){
                queue.add(treeNode.right);
                nextEnd = treeNode.right;
            }
            curNodes++;
            if (treeNode==curEnd){
                max = Math.max(max,curNodes);
                curNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
