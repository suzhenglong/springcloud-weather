package com.suzl.spring.cloud.weather.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.11.20 15:02
 */
public class StringUtil {
    /**
     * 处理 Gizp 压缩的数据.
     *
     * @param str
     * @return
     * @throws IOException
     */
    public static String conventFromGzip(String str) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in;
        GZIPInputStream gunzip = null;

        try {
            in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }
}

