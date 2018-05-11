package org.cherrygods.jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc���6����
 * 1.ע������
 * 2.��ȡ���ݿ�����
 * 3.��ȡ���ݿ��������
 * 4.ִ��SQL���
 * 5.�����ѯ�����
 * 6.�ر���Դ
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
        insertStu(connection,"������","��",16);
        findAll(connection);
    }

    /**
     * ��ѯ����ѧ����Ϣ
     * @param connection
     */
    public static void findAll(Connection connection) {
        try {
            //��ѯ����ѧ����Ϣ
            PreparedStatement ps = connection.prepareStatement("SELECT id,name,sex,age FROM stu");
            //ִ�в�ѯ���ҷ��ؽ����
            ResultSet rs = ps.executeQuery();
            //���������
            while (rs.next()) {
                System.out.print(rs.getInt("id")+"\t");
                System.out.print(rs.getString("name")+"\t");
                System.out.print(rs.getString("sex")+"\t");
                System.out.print(rs.getInt("age")+"\n");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("��ѯʧ��!");
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
            //������Ӱ�������
            int result = ps.executeUpdate();
            System.out.println("��Ӱ�������:"+result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }
    /**
     * ��������
     */
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ�����
     *
     * @param url      mysql����
     * @param username �û���
     * @param password ����
     * @return ����
     */
    public static Connection getConnection(String url, String username, String password) {
        try {
            Connection connection = (Connection) DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection���ӳɹ���");
                return connection;
            } else {
                System.out.println("Connection����ʧ�ܣ�");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
