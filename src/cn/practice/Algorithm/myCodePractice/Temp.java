package cn.practice.Algorithm.myCodePractice;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.*;

public class Temp {
    public void insert(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void midInsert(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int low = 0;
            int high = i - 1;
            int temp = arr[i];
            while (low <= high){ // 记得有括号
                int mid = low + (high - low)/2;
                if (arr[mid] >= temp)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i - 1; j >= high + 1; j--){
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = temp;
        }
    }

    public void swapQuick(int[] arr, int low, int high){
        int i = low, j = high;
        if (low < high){
            int temp = arr[low];
            while (i < j){
                while (i < j && arr[j] > temp){
                    j--;
                }
                if (i < j){
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < temp){
                    i++;
                }
                if (i < j){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = temp;
            swapQuick(arr,low,i-1);
            swapQuick(arr,i+1,high);
        }
    }
    public void swapOldder(int[] arr){
        int i = 0, j = arr.length - 1;
        while (i < j){
            while (i < j && arr[j] % 2 == 1)
                j--;
            while (i < j && arr[i] % 2 == 0)
                i++;
            if (i < j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
    }
    public void colorMove(int[] arr){
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k){
            switch (arr[j]){
                case 0:
                    swap(arr,i++,j++);
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    swap(arr,j,k--);
                    break;
            }
        }
    }
    public void bubble(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public void bubbleTwo(int[] arr){
        int left = 0, right = arr.length - 1;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = left; i < right;i++){
                if (arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                    flag = true;
                }
            }
            right--;
            for (int j = right; j > left;j--){
                if (arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                    flag = true;
                }
            }
            left++;
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void select(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int k = i;
            for (int j = i + 1;j < arr.length;j++){
                if (arr[j] < arr[k])
                    k = j;
            }
            swap(arr,i,k);
        }
    }

    /**
     * 两个链表的交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode jiaodian(ListNode headA,ListNode headB){
        ListNode p = headA,q= headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public boolean hasCicycle2(ListNode head){
        ListNode p = head, q = head;
        while (q!= null && q.next != null){
            if (p == q)
                return true;
            p = p.next;
            q = q.next.next;
        }
        return false;
    }

    public ListNode getEntrance(ListNode head){
        ListNode p = head, q = head;
        while (q != null && q.next != null){
            if (p == q){
                break;
            }
            p = p.next;
            q = q.next.next;
        }
        if (q == null || q.next == null)
            return null;
        p = head;
        while (p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
    public ListNode reverseNode(ListNode head){
        ListNode p = head, pre = null;
        while (p!=null){
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return head;
    }

    public ListNode ReverseNode2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode newHead = ReverseNode2(head.next);
        newHead.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 先中后遍历
     * @param root
     */
    public void preTree(TreeNode root){
        if (root!=null){
            visit(root);
            preTree(root.left);
            preTree(root.right);
        }
    }
    public void visit(TreeNode root){
        System.out.println(root.val);
    }

    public void preTree2(TreeNode root){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode p = stack.pop();
                visit(p);
                if (p.right != null){
                    stack.push(p.right);
                }
                if (p.left != null){
                    stack.push(p.left);
                }
            }
        }
    }

    /**
     * 记住这个，两层的内容容易弄混掉
     * @param root
     */
    public void inTree(TreeNode root){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()){
                while (p!=null){
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()){
                    p = stack.pop();
                    visit(p);
                    p = p.right;
                }
            }
        }
    }

    public void postTree(TreeNode root){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack1 = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode p = stack.pop();
                stack1.push(p);
                if (p.left!=null){
                    stack.push(p.left);
                }
                if (p.right!=null){
                    stack.push(p.right);
                }
            }
            while (!stack1.isEmpty()){
                TreeNode p = stack1.pop();
                visit(p);
            }
        }
    }

    /**
     * 最大高度
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){
        if (root == null) return 0;
        else {
            int LD,RD;
            LD = getDepth(root.left);
            RD = getDepth(root.right);
            return LD > RD ? LD + 1 : RD + 1;
        }
    }
    public int getDepth2(TreeNode root){
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        TreeNode last = root;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.pop();
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            if (node == last){
                level++;
                last = queue.peekLast();
            }
        }
        return level;
    }
    /**
     * 最小高度
     */
    public int getDepthMin(TreeNode root){
        if (root == null) return 0;
        else if (root.left == null) return getDepthMin(root.right);
        else if (root.right == null) return getDepthMin(root.left);
        else {
            int LD,RD;
            LD = getDepth(root.left);
            RD = getDepth(root.right);
            return LD < RD ? LD + 1 : RD + 1;
        }
    }

    public HashMap<Integer,Integer> getWidth(TreeNode root){
        HashMap<Integer,Integer> hm = new HashMap<>();
        if (root == null)
            return new HashMap<>();
        else {
            hm.put(1,1);
            Deque<TreeNode> queue = new ArrayDeque<>();
            TreeNode last = root;
            int level = 1;
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.pop();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (node == last){
                    ++level;
                    hm.put(level,queue.size());
                    last = queue.peekLast();
                }
            }
            return hm;
        }
    }
    public int nodeCount(TreeNode root){
        if (root == null) return 0;
        else {
            return nodeCount(root.left) + nodeCount(root.right) + 1;
        }
    }
    public int singleNode(TreeNode root){
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 0;
        else if (root.left!=null && root.right!=null)
            return singleNode(root.left) + singleNode(root.right);
        else {
            return singleNode(root.left) + singleNode(root.right) + 1;
        }
    }
    public int leafNode(TreeNode root){
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else {
            return leafNode(root.left) + leafNode(root.right);
        }
    }
    public int twoNode(TreeNode root){
        if (root == null) return 0;
        else if (root.left != null && root.right !=null){
            return twoNode(root.left) + twoNode(root.right) + 1;
        } else {
            return twoNode(root.left) + twoNode(root.right);
        }
    }

    public TreeNode createBt(int[] pre,int[] in,int l1,int r1,int l2,int r2){
        if (l1 > r1)
            return null;
        TreeNode root = new TreeNode(pre[l1]);
        int i = l1;
        while (i<r1){
            if (in[i] == pre[l1]){
                break;
            }
        }
        root.left = createBt(pre,in,l1 + 1,i-l2+l1,l2+1,i-1);
        root.right = createBt(pre,in,l1+i-l2+1,r1,i+1,r2);
        return root;
    }

    public int midNumber(int[] arr){
        int n = 0;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            if (n % 2 == 0){
                queue1.add(arr[i]);
                queue2.add(queue1.poll());
            } else {
                queue2.add(arr[i]);
                queue1.add(queue2.poll());
            }
            n++;
        }
        if (n % 2 == 0){
            return (queue1.peek() + queue2.peek()) / 2;
        } else {
            return queue2.peek();
        }
    }

}
