package org.cherrygods.jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc编程6部曲
 * 1.注册驱动
 * 2.获取数据库连接
 * 3.获取数据库操作对象
 * 4.执行SQL语句
 * 5.处理查询结果集
 * 6.关闭资源
 *
 * @author CherrGods
 * @since 2018-5-11 09:44:56
 */
public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/test";
        final String USERNAME = "root";
        final String PASSWORD = "CherryGods";
        loadDriver();
        Connection connection = getConnection(URL, USERNAME, PASSWORD);
        insertStu(connection,"李天宇","男",16);
        findAll(connection);
    }

    /**
     * 查询所有学生信息
     * @param connection
     */
    public static void findAll(Connection connection) {
        try {
            //查询所有学生信息
            PreparedStatement ps = connection.prepareStatement("SELECT id,name,sex,age FROM stu");
            //执行查询并且返回结果集
            ResultSet rs = ps.executeQuery();
            //遍历结果集
            while (rs.next()) {
                System.out.print(rs.getInt("id")+"\t");
                System.out.print(rs.getString("name")+"\t");
                System.out.print(rs.getString("sex")+"\t");
                System.out.print(rs.getInt("age")+"\n");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("查询失败!");
            e.printStackTrace();
        }finally {

        }
    }
    public static void insertStu(Connection connection,String stuName,String stuSex,int stuAge){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO stu(name, sex, age) values (?,?,?)");
            ps.setString(1,stuName);
            ps.setString(2,stuSex);
            ps.setInt(3,stuAge);
            //返回收影响的行数
            int result = ps.executeUpdate();
            System.out.println("受影响的行数:"+result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }
    /**
     * 加载驱动
     */
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @param url      mysql连接
     * @param username 用户名
     * @param password 密码
     * @return 连接
     */
    public static Connection getConnection(String url, String username, String password) {
        try {
            Connection connection = (Connection) DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection连接成功！");
                return connection;
            } else {
                System.out.println("Connection连接失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
