package org.cherrygods.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * jdbc���6����
 * 1.ע������
 * 2.��ȡ���ݿ�����
 * 3.��ȡ���ݿ��������
 * 4.ִ��SQL���
 * 5.�����ѯ�����
 * 6.�ر���Դ
 * @author CherrGods
 * @since 2018-5-11 09:44:56
 */
public class TestJDBC {
    public static void main(String[] args) {
        //1.ע������
        //1.1��ȡ��������
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
