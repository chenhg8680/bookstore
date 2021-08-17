package com.stark.test;

import com.stark.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * User: C.H.G
 * Date: 2021/8/11
 * Time: 下午4:33
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++)
        {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            //JdbcUtils.close(connection);
        }
    }
}
