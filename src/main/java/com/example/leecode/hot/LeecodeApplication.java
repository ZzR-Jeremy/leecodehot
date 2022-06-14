package com.example.leecode.hot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LeecodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeecodeApplication.class, args);
        ListNode list1=new ListNode(2);
        list1.next=new ListNode(3);
        list1.next.next=new ListNode(7);
        ListNode list2=new ListNode(4);
        list2.next=new ListNode(6);
        list2.next.next=new ListNode(9);
        SolutionTwelve sol=new SolutionTwelve();
        sol.mergeTwoLists(list1,list2);
    }

}
