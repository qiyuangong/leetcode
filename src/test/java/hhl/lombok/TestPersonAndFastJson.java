package hhl.lombok;

import com.alibaba.fastjson.JSON;
import model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPersonAndFastJson {
    @Test
    public void test_pf(){
        Person person = new Person(10,"小黄");
        assertNotNull(person);
        assertEquals(person.getAge(),10);
        assertEquals(person.getName(),"小黄");
        String personString = JSON.toJSONString(person);
        assertEquals(personString,"{\"age\":10,\"name\":\"小黄\"}");
        assertEquals(person,JSON.parseObject(personString,Person.class));
    }
}
