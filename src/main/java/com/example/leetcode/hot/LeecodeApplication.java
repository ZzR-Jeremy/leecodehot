package com.example.leetcode.hot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LeecodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeecodeApplication.class, args);
        Scanner scanner=new Scanner(System.in);
        String[] nk=scanner.nextLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String strs=scanner.nextLine();
        if(strs.length()==n){
            String str1=strs.substring(0,k).toUpperCase();
            String str2=strs.substring(k,n).toLowerCase();
            System.out.println(str1+str2);
        }

    }

}
