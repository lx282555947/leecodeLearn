package com.learn.leecode.utils;

import com.alibaba.fastjson.JSON;
import com.learn.leecode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PrintUtil {

    public static void printLinkList(ListNode node) {
        ListNode curr = node;
        List<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        System.out.println(JSON.toJSONString(list));
    }
}
