package cn.practice.Interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // 处理器个数
        int n = scanner.nextInt(); // 作业个数
        int[] task = new int[n]; // 存放作业的数组
        int [] cpu = new int [m]; // 处理器容器
        for (int i = 0; i < n; i++) {
            task[i] = scanner.nextInt();
        }
        int current = 0; // 记录处理到了第几个任务
        int time = 0; // 所需要的时间
        Arrays.sort(task);
        // 一次就可以放的下，取最长时间即可
        if (n<=m) {
            time += task[task.length-1]; // 直接加上最大值即可
            System.out.println(time);
        } else {
            // 先把任务按照从小到大的顺序放进去处理器
            for (int i = 0; i < m; i++) {
                cpu[i] = task[current++];
            }
            // 还没有处理完
            while (current < n) {
                Arrays.sort(cpu);
                time += cpu[0];
                int e = cpu[0]; // 记录即将要被替换的元素的值
                for (int i = 0; i < m; i++) {
                    cpu[i] -= e;
                    if (cpu[i] == 0) {
                        if (current >= n) {
                            break;
                        }
                        cpu[i] = task[current++];
                    }

                }
            }
            // 最后一次直接去其中最大的即可
            Arrays.sort(cpu);
            System.out.println(time+cpu[cpu.length-1]); // 最后一次
        }
    }
}
