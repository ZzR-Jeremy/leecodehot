package com.example.leetcode.zuo;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) nums.add(scanner.nextInt());
        resolve(nums);
        System.out.println(res);
    }
    private static void resolve(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 1) {
                if (nums.get(i) % 2 == 0) oddNum(nums.get(i));
                else {
                    res++;
                    oddNum(nums.get(i) - 1);
                }
            }
        }
    }
    private static void oddNum(int nums) {
        if (nums <= 1) return;
        if (nums == 2) {
            res += 1;
            return;
        }
        int a = 2, b = nums / 2;
        res += a;
        if (b % 2 == 0) oddNum(b);
        else {
            res++;
            oddNum(b - 1);
        }
    }
}
