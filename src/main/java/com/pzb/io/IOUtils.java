package com.pzb.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipInputStream;

public class IOUtils {
    public static void zipToByte() throws IOException {
        String filePath = "test.txt";
        //BufferedInputStream in = new BufferedInputStream(JobUpdateIngestionServiceImplTest.class.getResourceAsStream(filePath));
        InputStream inputStream = IOUtils.class.getResourceAsStream(filePath);
        ZipInputStream zipIs = new ZipInputStream(inputStream, Charset.forName("utf-8"));
//        ZipEntry zipEntry;
//        while ((zipEntry = zipIs.getNextEntry()) != null){
//            System.out.println("file: "+zipEntry.getName());
//        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        //System.out.println("available : "+zipIs.available());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] jobFileBytes = byteArrayOutputStream.toByteArray();
    }
}
