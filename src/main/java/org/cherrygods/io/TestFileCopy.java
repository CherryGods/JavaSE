package org.cherrygods.io;

import org.cherrygods.utils.FileUtil;

import java.io.*;

/**
 * @author CherrGods
 * @since 2018-5-10 14:18:21s
 */
public class TestFileCopy {
    public static void main(String[] args) throws IOException {
        FileUtil fileUtil = new FileUtil();
        fileUtil.copyFile("TestRead.txt","TestCopy.txt");
        fileUtil.copyFile(new File("TestCopy.txt"),new File("TestCopy1.txt"));
    }
}
