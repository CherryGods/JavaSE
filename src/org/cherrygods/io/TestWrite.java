package org.cherrygods.io;

import java.io.*;

/**
 * @author CherrGods
 * @since 2018-5-10 14:10:14
 */
public class TestWrite {
    public static void main(String[] args) {
        //������ϵ
        File dest = new File("TestWrite.txt");
        //���������
        OutputStream out = null;
        try {
            //����Ҫд�������
            String msg = "CherryGods is so goods!\r\n";
            //���ַ���תΪ�ֽ��� msg --> bytes
            byte[] bytes = msg.getBytes();
            //append����:trueΪ׷�ӣ�Ĭ��Ϊfalse(����)
            out = new FileOutputStream(dest,true);
            //д��
            out.write(bytes);
            //ǿ��д��ˢ��
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("�ļ�δ�ҵ���");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("�ļ�д��ʧ�ܣ�");
        }finally {
            //�ж�������Ƿ�ռ���ڴ�ռ�
            if(null!=out){
                try {
                    //�ر������
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("д�����ر�ʧ�ܣ�");
                }
            }
        }
    }
}
