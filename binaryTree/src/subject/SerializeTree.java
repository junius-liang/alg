package subject;

import model.TreeNode;

import java.util.Objects;

/**
 * @author junius
 * @date 2022/12/09 13:45
 * @project MyAlg
 * 序列化与反序列化二叉树
 **/
public class SerializeTree {
    public int index = 0;

    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        pre(root,sb);
        return sb.toString();
    }

    private void pre(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append("#");
            return;
        }
        sb.append(root.val).append("!");
        pre(root.left,sb);
        pre(root.right,sb);
    }

    public TreeNode Deserialize(String str) {
        if (Objects.equals(str, "#")){
            return null;
        }
        TreeNode res = depre(str);
        return res;
    }

    private TreeNode depre(String str) {
        if (str.charAt(index) == '#'){
            ++index;
            return null;
        }
        int val = 0;
        while (str.charAt(index) != '!' && index!=str.length()){
            val=val*10+(str.charAt(index)-'0');
            index++;
        }
        TreeNode treeNode = new TreeNode(val);
        if (index==str.length()){
            return treeNode;
        }else {
            index++;
        }
        treeNode.left = depre(str);
        treeNode.right = depre(str);
        return treeNode;
    }
}
