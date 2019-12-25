package hhl.lombok;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import model.ListNode;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static hhl.util.Utils.doMakeListNode;
import static linkedlist.LikedListSolution.reverseList;
import static linkedlist.LikedListSolution.swapPairs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@Slf4j
public class TestPersonAndFastJson {
    private static ListNode listNode;
    private static ListNode listNodeOld;

    @Before
    public void initListNode() {
        listNode = doMakeListNode(5);
        listNodeOld = reverseList(doMakeListNode(5));
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
        ListNode listNode2 = swapPairs(listNodeOld);
        assertEquals(listNode1.toString(),"ListNode(val=2, next=ListNode(val=1, next=ListNode(val=4, next=ListNode(val=3, next=ListNode(val=5, next=null)))))");
        assertEquals(listNode2.toString(),"ListNode(val=4, next=ListNode(val=5, next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=1, next=null)))))");
        log.info("new listNode1:{}",listNode1);
        log.info(" new listNode2:{}",listNode2);

    }
}
