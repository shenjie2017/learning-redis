package com.blue;

import com.blue.boot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * @author shenjie
 * @version v1.0
 * @Description test list、set
 * @Date: Create in 13:08 2017/12/28
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestQueue extends BaseTestCase {
    /**
     * 测试list
     */
    @Test
    public void testList(){
        String key1 = "list_01";
        System.out.println(key1);
        for (int i = 0; i < 10; i++) {
            jedis.rpush(key1,""+i%5);
        }

        while(true){
            String value = jedis.lpop(key1);
            if(null==value){
                break;
            }
            System.out.println(value);
        }
        //由于已经pop完了对象，所以这里得到的是空
        List<String> list1 = jedis.lrange(key1,0,-1);
        System.out.println(list1);

        String key2 = "list_02";
        System.out.println(key2);
        for (int i = 0; i < 10; i++) {
            jedis.rpush(key2,""+i%5);
        }
        List<String> list2 = jedis.lrange(key2,0,-1);
        System.out.println(list2);
    }

    /**
     * 测试set
     */
    @Test
    public void testSet(){
        String key1 = "set_01";
        System.out.println(key1);
        for (int i = 0; i < 10; i++) {
            jedis.sadd(key1,""+i%5);
        }

        while(true){
            String value = jedis.spop(key1);
            if(null==value){
                break;
            }
            System.out.println(value);
        }
        //由于已经pop完了对象，所以这里得到的是空
        Set<String> set1 = jedis.smembers(key1);
        System.out.println(set1);

        String key2 = "set_02";
        System.out.println(key2);
        for (int i = 0; i < 10; i++) {
            jedis.sadd(key2,""+i%5);
        }
        Set<String> set = jedis.smembers(key2);
        System.out.println(set);
    }
}
