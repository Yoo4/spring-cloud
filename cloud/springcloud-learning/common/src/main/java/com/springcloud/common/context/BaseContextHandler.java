package com.springcloud.common.context;


import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.util.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static void init() {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static String getUserId() {
        Object value = get(CommonConstants.CONTEXT_KEY_USERID);
        return StringHelper.getObjectValue(value);
    }

    public static String getUsername() {
        Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
        return StringHelper.getObjectValue(value);
    }

    public static String getName() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return StringHelper.getObjectValue(value);
    }

    public static void setUserId( String userID) {
        set(CommonConstants.CONTEXT_KEY_USERID, userID);
    }

    public static void setUsername(String username) {
        set(CommonConstants.CONTEXT_KEY_USERNAME, username);
    }

    public static void setName(String name) {
        set(CommonConstants.CONTEXT_KEY_USER_NAME,name);
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContext() throws InterruptedException {
            BaseContextHandler.set("test", "main thread");

            new Thread(() -> {
                BaseContextHandler.set("test", "thread one");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "thread one");
                logger.info("thread one done");
            }).start();

            new Thread(() -> {
                BaseContextHandler.set("test", "thread two");
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "thread two");
                logger.info("thread two done");
            }).start();

            Thread.currentThread().sleep(5000);
            assertEquals(BaseContextHandler.get("test"), "main thread");
            logger.info("main thread done");
        }

        @Test
        public void testSetUserInfo() {
            BaseContextHandler.setUserId("userId");
            assertEquals(BaseContextHandler.getUserId(),"userId");
            BaseContextHandler.setUsername("username");
            assertEquals(BaseContextHandler.getUsername(),"username");
        }

    }
}
