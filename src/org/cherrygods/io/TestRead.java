package org.cherrygods.io;

import java.io.*;

/**
 * 读取文本类容测试
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
            System.out.println("文件未找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取失败");
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
