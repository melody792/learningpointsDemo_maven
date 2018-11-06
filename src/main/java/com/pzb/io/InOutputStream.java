package com.pzb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class InOutputStream {
    public static void main(String[] args) throws IOException {
        //out();//向文件写入
        //in();//向文件写出
        IOUtils.zipToByte();
    }

    private static void in() {
        File file = new File("C:/0pzb/study/test/test.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            byte[] bytes = new byte[6];
            StringBuffer stringBuffer = new StringBuffer();
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes));
            }
            inputStream.close();
            System.out.println("输出打印内容:   "+stringBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void out() {
        File file = new File("C:/0pzb/study/test/test.txt");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            String info = "这是需要写入的字符串";
            outputStream.write(info.getBytes());
            outputStream.close();
            System.out.println("write success, 写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
