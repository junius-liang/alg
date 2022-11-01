package com.cengxubianli;

import com.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author junius
 * @date 2022/11/01 13:04
 * 树的层序遍历
 *
 **/
public class Solution {
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
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        method1(treeNode1);
    }


}
