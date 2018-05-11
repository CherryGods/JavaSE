package org.cherrygods.utils;

import java.io.*;

/**
 * @author CherrGods
 * @since 2018-5-10 15:03:14
 */
public class FileUtil {
    public void copyFile(String srcPath, String destPath) throws IOException {
        copyFile(new File(srcPath), new File(destPath));
    }

    public void copyFile(File src, File dest) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);
        byte[] bytes = new byte[1024];
        int len = 0;
        while (-1 != (len = in.read(bytes))) {
            out.write(bytes, 0, len);
            out.flush();
            out.close();
        }
    }
}
