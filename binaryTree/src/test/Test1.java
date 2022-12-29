package test;

import model.TestModelTree;
import model.TreeNode;
import subject.SerializeTree;

/**
 * @author junius
 * @date 2022/12/02 20:47
 *
 **/
public class Test1 {
    public static void main(String[] args) {
        TreeNode node = TestModelTree.build();
        SerializeTree tree = new SerializeTree();
        String serialize = tree.Serialize(node);
        System.out.println(serialize);

        TreeNode deserialize = tree.Deserialize(serialize);
        String serialize1 = tree.Serialize(deserialize);
        System.err.println(serialize1);
    }
}
