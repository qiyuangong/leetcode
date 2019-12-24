package hhl.lombok;

import com.alibaba.fastjson.JSON;
import model.ListNode;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static linkedlist.LikedListSolution.reverseList;
import static linkedlist.LikedListSolution.swapPairs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPersonAndFastJson {
    private static ListNode listNode;
    private static ListNode listNodeOld;

    @Before
    public void initListNode() {
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
        System.out.println("listNode = " + listNode);
    }

    @Before
    public void initListNode1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        listNodeOld = listNode1;
        System.out.println("listNode = " + listNodeOld);


    }

    @Test
    public void test_pf() {
        Person person = new Person(10, "小黄");
        assertNotNull(person);
        assertEquals(person.getAge(), 10);
        assertEquals(person.getName(), "小黄");
        String personString = JSON.toJSONString(person);
        assertEquals(personString, "{\"age\":10,\"name\":\"小黄\"}");
        assertEquals(person, JSON.parseObject(personString, Person.class));
    }


    @Test
    public void test_SwapPairs() {

        ListNode listNode1 = swapPairs(listNode);
        System.out.println("new listNode1 = " + listNode1);
        ListNode listNode2 = swapPairs(listNodeOld);
        System.out.println("new listNode2 = " + listNode2);
    }
}
