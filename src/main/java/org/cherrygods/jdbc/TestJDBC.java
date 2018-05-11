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
//        insertStu("������","��",16);
        updateStu(9,"������","Ů",17);
        findAll();
    }
    /**
     * ��ѯ����ѧ����Ϣ
     */
    public static void findAll() {
        loadDriver();
        Connection connection = getConnection();
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
     * ����һ����ѧ��
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
            //������Ӱ�������
            int result = ps.executeUpdate();
            System.out.println("��Ӱ�������:"+result);
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
     * �޸�һ��ѧ���������Ϣ
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
            System.out.println("��Ӱ�������"+reuslt);
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
     * @return ����
     */
    public static Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/test";
        final String USERNAME = "root";
        final String PASSWORD = "CherryGods";
        try {
            Connection connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
