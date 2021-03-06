package com.stark.utils;

/**
 * User: C.H.G
 * Date: 2021/8/11
 * Time: 下午4:07
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
        try{
            Properties properties = new Properties();

            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource);
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * 从数据库连接池中过去链接
     * @return 如果返回 null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection connection = conns.get();

        if(connection == null){
            try {
                connection  = dataSource.getConnection();
                conns.set(connection);
                connection.setAutoCommit(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void transCommit(){
        Connection connection = conns.get();

        if(connection != null){
            try{
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    public static void transRollback(){
        Connection connection = conns.get();

        if(connection != null){
            try{
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }


    /**
     * 关闭数据库连接
     * @param conn
     *
    public static void close(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    */
}
