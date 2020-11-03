package leetcode.editor.cn;

/**
 * https://blog.csdn.net/qq_15457239/article/details/51029858
 * https://blog.csdn.net/wangls56/article/details/88783783?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
 * 二叉树公共节点
 * @author ：xinze
 * @date ：Created by 2020/11/3 15:54
 * @description：
 * @modified By：
 * @version:
 */

public class CommonFather {
    public static void main(String[] args) {

    }

    /**
     * 二叉树最近公共节点
     * https://blog.csdn.net/wangls56/article/details/88783783?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
     * @param root
     * @param a
     * @param b
     * @return
     */
    TreeNode commonFather(TreeNode root, TreeNode a, TreeNode b){
        if(root==null){
            return null;
        }
        if(root==a){
            return a;
        }
        if(root==b){
            return b;
        }
        TreeNode left = commonFather(root.left,a,b);
        TreeNode right = commonFather(root.right,a,b);

        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
