package com.blue;

import com.blue.boot.Application;
import com.blue.listener.JedisPubSubListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 13:50 2017/12/28
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
public class TestPsubscribe extends BaseTestCase {
    @Test
    public void testPsubscribe(){
        /**
         * 带通配符
         */
//        jedisCluster.psubscribe(new JedisPubSubListener(), "channel-01");
        jedis.subscribe(new JedisPubSubListener(), "channel-01");
    }
}
