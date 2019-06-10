package cn.practice.Algorithm.DataStructure.Ohters.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 树的定义和实现
 * @author Administrator
 *
 */
public class Tree {
    private Object data;
    private List<Tree> childs;

    public Tree(){
        data = null;
        childs = new ArrayList();
        childs.clear();
    }

    public Tree(Object data) {
        this.data = data;
        childs = new ArrayList();
        childs.clear();
    }

    /**
     * 添加子树
     * @param tree 子树
     */
    public void addNode(Tree tree) {
        childs.add(tree);
    }

    /**
     * 置空树
     */
    public void clearTree() {
        data = null;
        childs.clear();
    }

    /**
     * 求树的深度
     * 这方法还有点问题，有待完善
     * @return 树的深度
     */
    public int dept() {
        return dept(this);
    }
    /**
     * 求树的深度
     * 这方法还有点问题，有待完善
     * @param tree
     * @return
     */
    private int dept(Tree tree) {
        if(tree.isEmpty()) {
            return 0;
        }else if(tree.isLeaf()) {
            return 1;
        } else {
            int n = childs.size();
            int[] a = new int[n];
            for(int i=0; i<n; i++) {
                if(childs.get(i).isEmpty()) {
                    a[i] = 0+1;
                } else {
                    a[i] = dept(childs.get(i)) + 1;
                }
            }
            Arrays.sort(a);
            return a[n-1];
        }
    }
    /**
     * 返回递i个子树
     * @param i
     * @return
     */
    public Tree getChild(int i) {
        return childs.get(i);
    }

    /**
     * 求第一个孩子 结点
     * @return
     */
    public Tree getFirstChild() {
        return childs.get(0);

    }

    /**
     * 求最后 一个孩子结点
     * @return
     */
    public Tree getLastChild() {
        return childs.get(childs.size()-1);
    }

    public List<Tree> getChilds() {
        return childs;
    }

    /**
     * 获得根结点的数据
     * @return
     */
    public Object getRootData() {
        return data;
    }

    /**
     * 判断是否为空树
     * @return 如果为空，返回true,否则返回false
     */
    public boolean isEmpty() {
        if(childs.isEmpty() && data == null)
            return true;
        return false;
    }

    /**
     * 判断是否为叶子结点
     * @return
     */
    public boolean isLeaf() {
        if(childs.isEmpty())
            return true;
        return false;
    }

    /**
     * 获得树根
     * @return 树的根
     */
    public Tree root() {
        return this;
    }

    /**
     * 设置根结点的数据
     */
    public void setRootData(Object data) {
        this.data = data;
    }

    /**
     * 求结点数
     * 这方法还有点问题，有待完善
     * @return 结点的个数
     */
    public int size() {
        return size(this);
    }
    /**
     * 求结点数
     * 这方法还有点问题，有待完善
     * @param tree
     * @return
     */
    private int size(Tree tree) {
        if(tree.isEmpty()) {
            return 0;
        }else if(tree.isLeaf()) {
            return 1;
        } else {
            int count = 1;
            int n = childs.size();
            for(int i=0; i<n; i++) {
                if(!childs.get(i).isEmpty()) {
                    count += size(childs.get(i));
                }
            }
            return count;
        }
    }
}
