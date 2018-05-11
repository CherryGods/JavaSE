package org.cherrygods.io;

import java.io.*;

/**
 * ��ȡ�ı����ݲ���
 */
public class TestRead {
    public static void main(String[] args) {
        File file = new File("TestRead.txt");
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            byte[] tool = new byte[1024];
            int len = 0;
            while((len=input.read(tool))!=-1){
                String msg = new String(tool,0,len);
                System.out.println(msg);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("�ļ�δ�ҵ���");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("��ȡʧ��");
        }finally {
            if(null!=input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
