package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

/**
 * 贪心算法：保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 1. 分配饼干
 *
 * Input: [1,2], [1,2,3]
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 *
 * 题目描述：每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 *
 * 给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易得到满足，所以先满足最小的孩子。
 *
 * 证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。假设存在一种最优策略，给该孩子分配第 n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
 */
public class _01_findContentChildren {
    @Test
    public void test(){
        int[] g = {4,5,6,7,8};
        int[] s = {1,6,7,10};
        System.out.println(findContentChildren(g,s));
    }
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        /**
         * 从小的孩子开始遍历，只有当前的孩子得到了
         * 满足，才考虑满足下一个孩子
         */
        while (gi < g.length && si < s.length){
            if (g[gi] <= s[si])
                gi++;
            si++;
        }
        return gi;
    }
}
