package org.cherrygods.io;

import java.io.*;

/**
 * @author CherrGods
 * @since 2018-5-10 14:10:14
 */
public class TestWrite {
    public static void main(String[] args) {
        //建立关系
        File dest = new File("TestWrite.txt");
        //创建输出流
        OutputStream out = null;
        try {
            //建立要写入的数据
            String msg = "CherryGods is so goods!\r\n";
            //把字符流转为字节流 msg --> bytes
            byte[] bytes = msg.getBytes();
            //append参数:true为追加，默认为false(覆盖)
            out = new FileOutputStream(dest,true);
            //写入
            out.write(bytes);
            //强制写入刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败！");
        }finally {
            //判断输出流是否占用内存空间
            if(null!=out){
                try {
                    //关闭输出流
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("写出流关闭失败！");
                }
            }
        }
    }
}
