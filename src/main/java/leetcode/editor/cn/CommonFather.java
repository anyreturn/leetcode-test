package leetcode.editor.cn;

import java.util.LinkedList;

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

        //Executors.newCachedThreadPool();
        //Long
        //Integer
        //Double

        //Float
        //AbstractQueuedSynchronizer
        //HashSet
        //LinkedList
        //ArrayList
        //Object
        //Collections
    }

    /**
     * 二叉树最近公共节点
     * https://blog.csdn.net/wangls56/article/details/88783783?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
     * 递归实现
     * @param root
     * @param a
     //* @param b
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
        //先在左子树中查找节点，如果找到则返回节点 a或者 b,否则返回 null
        TreeNode left = commonFather(root.left,a,b);
        TreeNode right = commonFather(root.right,a,b);

        //如果左右子树均不为空，表示已在当前节点的子节点中找到a,b节点，当前root节点为最近公共父节点
        if(left!=null && right!=null){
            return root;
        }
        //如果 left不为空表示，在当前 root子节点中存在 left(a或者b、a和b),返回 left,表示其中一个节点已找到或者两个节点已找到
        if(left!=null){
            return left;
        }
        //如果 right不为空表示，在当前 root子节点中存在 right(a或者b、a和b),返回 right,表示其中一个节点已找到或者两个节点已找到
        if(right!=null){
            return right;
        }
        return null;
    }

    /**
     * 二叉树两节点的最近公共节点
     * 非递归实现
     * @param root
     * @param a
     * @param b
     * @return
     */
    TreeNode findAncestor(TreeNode root, TreeNode a, TreeNode b){
        if(root==null) {
            return null;
        }
        //a节点路径
        LinkedList<TreeNode> aPath = new LinkedList<>();
        aPath.add(root);
        this.getPath(root,a,aPath);
        //b节点路径
        LinkedList<TreeNode> bPath = new LinkedList<>();
        bPath.add(root);
        this.getPath(root,b,bPath);

        TreeNode father = null;
        for(int i=0; i<aPath.size() && i<bPath.size();i++){
            if(aPath.get(i)==bPath.get(i)){
                father = aPath.get(i);
            }else {
                break;
            }
        }
        return father;
    }

    /**
     * 查找节点的路径
     * @param root
     * @param node
     * @param path
     * @return
     */
    boolean getPath(TreeNode root, TreeNode node, LinkedList<TreeNode> path){
        if(root==node){
            return true;
        }
        //如果左子树不为空，左子树中查找
        if(root.left!=null){
            path.add(root.left);
            if(getPath(root.left, node,path)){
                return true;
            }else {
                path.remove(root.left);
            }
        }

        //如果右子树不为空，在右子树中查找
        if(root.right!=null){
            path.add(root.right);
            if(getPath(root.right, node,path)){
                return true;
            }else {
                path.remove(root.right);
            }
        }
        return false;

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
