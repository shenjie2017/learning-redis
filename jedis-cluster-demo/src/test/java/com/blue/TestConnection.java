package com.blue;

import com.blue.boot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shenjie
 * @version v1.0
 * @Description 测试连接，set和get方法
 * @Date: Create in 12:40 2017/12/28
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
public class TestConnection extends BaseTestCase {
    /**
     * 设置永久值和带过期时间的值
     */
    @Test
    public void testSet(){
        //设置永不过期
        jedis.set("k1","v1");
        //设置过期时间为120秒
        jedis.setex("tmp_k1",120,"tmp_v1");
    }

    /**
     * 测试获取值
     */
    @Test
    public void testGet(){
        String value = jedis.get("k1");
        System.out.println(value);
    }


}
