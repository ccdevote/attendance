package com.jianyu.attendance;

import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzy on 14-4-29.
 */
public class FileUtils {

    public void wirte(String path, String str) throws IOException {
        if (path == null || path.isEmpty())
            throw new IllegalArgumentException("please input valid path");
        File file = new File(path);
        if (!file.isFile())
            throw new IOException(String.format("your paht %s is not a regular file,please check it", path));
        if (str == null || str.isEmpty()) return;
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write((str + "\n").getBytes());
        } catch (IOException e) {
            throw new IOException("error in writting string to file");
        }finally {
            out.close();
        }
    }

    public List<String> read(String path) throws IOException {
        if (path == null || path.isEmpty())
            throw new IllegalArgumentException("please input valid path");
        File file = new File(path);
        if (!file.isFile())
            throw new IOException(String.format("your paht %s is not a regular file,please check it", path));
        List<String> list = new ArrayList<String>();
        InputStream in = new FileInputStream(file);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            throw new IOException("error in read file");
        } finally {
            in.close();
        }
    }
}
