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
//        insertStu("李天宇","男",16);
        updateStu(9,"马燕清","女",17);
        findAll();
    }
    /**
     * 查询所有学的信息
     */
    public static void findAll() {
        loadDriver();
        Connection connection = getConnection();
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
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 新增一个名学生
     * @param stuName
     * @param stuSex
     * @param stuAge
     */
    public static void insertStu(String stuName,String stuSex,int stuAge){
        loadDriver();
        Connection connection = getConnection();
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
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 修改一名学生的身份信息
     * @param id
     * @param stuName
     * @param stuSex
     * @param stuAge
     */
    public static void updateStu(int id,String stuName,String stuSex,int stuAge){
        loadDriver();
        Connection connection = getConnection();
        try {
            PreparedStatement ps= connection.prepareStatement("update stu set name=?,sex=?,age=? where id=?");
            ps.setString(1,stuName);
            ps.setString(2,stuSex);
            ps.setInt(3,stuAge);
            ps.setInt(4,id);
            int reuslt = ps.executeUpdate();
            System.out.println("受影响的行数"+reuslt);
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
     * @return 连接
     */
    public static Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/test";
        final String USERNAME = "root";
        final String PASSWORD = "CherryGods";
        try {
            Connection connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
