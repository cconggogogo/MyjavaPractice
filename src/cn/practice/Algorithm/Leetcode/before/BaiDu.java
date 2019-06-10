package cn.practice.Algorithm.Leetcode.before;

import java.util.Scanner;

public class BaiDu {
    public static void main(String[] args) {

    }

    public static void maxPoint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("numNodes:");
        int numNodes = sc.nextInt(); // 4个结点
        int[] values = new int[numNodes+1]; // 数组长度为5
        for (int i = 1; i <= numNodes; i++) { // 存储范围：1-4
            values[i] = sc.nextInt();
        }
        int[][] edges = new int[numNodes-1][3]; // 4个结点，(4-1)个边
        for (int i = 0; i < numNodes-1; i++) { // 遍历所有的边
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < numNodes-1; i++) {
            boolean exits = true;
            for (int j = 0; j < numNodes-1; j++) {
                if(edges[j][0] == edges[i][1])
                {
                    exits = false;
                    break;
                }
            }
            if(exits)
                edges[i][2] = 1; // 当前结点有指向别人的边
        }

        int[] res = new int[numNodes+1];
        for (int i = numNodes; i >= 1; i--) {
            if(i == 1)
                res[1] = res[2] * res[3] * values[1];
            else {
                if(edges[i-2][2] == 1) // 指向别人了(不是叶子)
                {
                    res[i] = values[i];
                } else { // 当前的结点是叶子
                    int max = 0;
                    for (int j = 0; j < numNodes-1; j++) {
                        int cur = 0;
                        if(edges[j][0] == i)
                        {
                            cur = values[edges[j][1]] * values[i];
                            if(cur >= max)
                                max = cur;
                        }
                    }
                    res[i] = max;
                }
            }
        }
        System.out.println(res[1]);
    }
}
