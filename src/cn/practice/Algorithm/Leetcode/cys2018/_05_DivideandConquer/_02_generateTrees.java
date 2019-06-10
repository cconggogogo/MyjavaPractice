package cn.practice.Algorithm.Leetcode.cys2018._05_DivideandConquer;

import cn.practice.Tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 2. 不同的二叉搜索树
 *
 * 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class _02_generateTrees {
    public List<TreeNode> generateTrees(int n){
        if (n < 1)
            return new LinkedList<>();
        return generateSubtrees(1, n);
    }
    public List<TreeNode> generateSubtrees(int s, int e){
        List<TreeNode> res = new LinkedList<>();
        if (s > e){
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i){
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left: leftSubtrees){
                for (TreeNode right: rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
