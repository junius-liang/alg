package subject;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author junius
 * @date 2022/12/02 19:43
 * 树的层次遍历
 **/
public class SequenceTraversal {

    /**
     * 非递归解法
     * @param head
     */
    public static void method1(TreeNode head){
        //定义一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        //当队列不为空时，出队就打印
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }



    /**
     * 递归解法
     */
    public static void method2(TreeNode head){
        if (head == null){
            return;
        }
        List<List<Integer>> res = new ArrayList<>();
        traverse(res,head,1);
    }



    /**
     *
     * @param list 每个子List代表树的层
     * @param node
     * @param curLayer
     */
    private static void traverse(List<List<Integer>> list, TreeNode node, int curLayer) {
        if (node == null){
            return;
        }
        //如果这颗树的层数小于当前层的要放置层，表明要新起一层
        if (list.size()<curLayer){
            List<Integer> newLayer = new ArrayList<>();
            list.add(newLayer);
            newLayer.add(node.val);
        }else{
            List<Integer> layer = list.get(curLayer - 1);
            layer.add(node.val);
        }
        //递归遍历
        traverse(list,node.left,curLayer+1);
        traverse(list,node.right,curLayer+1);
    }

}
