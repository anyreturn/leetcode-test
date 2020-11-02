package leetcode.editor.cn;

/**
 * https://blog.csdn.net/weixin_43451928/article/details/91344974
 * 面试题003：给定一个二叉搜索树(BST)，找到树中第K小的节点。
 * ——阿里巴巴出题专家：文景／阿里云CDN资深技术专家
 * 考察点
 * 基础数据结构的理解和编码能力
 * 递归使用
 *
 * @author ：xinze
 * @date ：Created by 2020/11/2 16:48
 * @description：
 * @modified By：
 * @version:
 */

public class KthSmallest {
    public static void main(String[] args) {

    }

    ResultType kThSmallest(TreeNode root, int k){
        if(root==null){
            return new ResultType(false,0,null);
        }

        //处理左孩子
        ResultType reLeft = kThSmallest(root.left,k);
        if(reLeft.found){
            return new ResultType(true,reLeft.val,root.left);
        }

        if(reLeft.val == k-1){
            return new ResultType(true, k,root);
        }
        //处理右孩子
        ResultType reRight = kThSmallest(root.right,k-reLeft.val-1);
        if (reRight.found){
            return new ResultType(true, reRight.val,null);
        }
        //没找到节点 返回总结点数
        return new ResultType(false,reLeft.val+reRight.val+1,null);
    }
}

class TreeNode{

    int val;

    TreeNode left;
    TreeNode right;

     public TreeNode(TreeNode left, TreeNode right,int val,){
        this.left=left;
        this.right=right;
        this.val = val;
    }
}

class ResultType{
    TreeNode treeNode;
    //孩子点个数
    int val;
    //是否已找到
    boolean found;

    public ResultType(boolean found, int val, TreeNode treeNode){
        this.found=found;
        this.val=val;
        this.treeNode=treeNode;
    }
}