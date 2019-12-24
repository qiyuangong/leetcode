package hhl.linkedlist;

import linkedlist.LikedListSolution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static model.Util.println;

/**
 * Copyright (C), 2019-2019
 * FileName: LikedListSolutionTest
 * Author:   s·D·bs
 * Date:     2019-12-24 18:04
 * Description: LikedListSolution 解决问题的测试
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2019-12-24 18:04          0.0.0
 */

public class LikedListSolutionTest {

    private static ListNode listNode;

    @Before
    public void creatLinkedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        listNode = listNode1;


        println("old listNode : " + listNode);
    }

    @Test
    public void reverseListTest() {
        ListNode listNode = LikedListSolution.reverseList(LikedListSolutionTest.listNode);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode5.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = null;

        println("now listNode: " + listNode + "now1 listNode: " + listNode5);
        Assert.assertEquals(listNode, listNode5);

    }

}

    
  