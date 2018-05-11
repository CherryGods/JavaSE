package org.cherrygods.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * jdbc编程6部曲
 * 1.注册驱动
 * 2.获取数据库连接
 * 3.获取数据库操作对象
 * 4.执行SQL语句
 * 5.处理查询结果集
 * 6.关闭资源
 * @author CherrGods
 * @since 2018-5-11 09:44:56
 */
public class TestJDBC {
    public static void main(String[] args) {
        //1.注册驱动
        //1.1获取驱动对象
        Driver driver;
        {
            try {
                driver = new  com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
